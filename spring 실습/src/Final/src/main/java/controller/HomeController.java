package controller;

import org.springframework.web.bind.annotation.*;
import spring.Info;
import spring.LoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import service.MemberService;
import spring.SearchInfo;
import spring.UserInfo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private MemberService memberService;

    public void setMemberRegisterService(
            MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")    //메인 화면(대문 화면)
    public String home(SearchInfo searchInfo) {
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)   //로그인 화면
    public String getLogin(LoginInfo loginInfo, Model model, HttpSession session, @CookieValue(value = "REMEMBERID", required = false) Cookie rCookie) {
        if (session == null || session.getAttribute("authInfo") == null) {
            if (rCookie != null) {
                loginInfo.setUserid(rCookie.getValue());
                loginInfo.setRememberid(true);
            }
        }
        return "home";
    }

    @PostMapping("/submit") //로그인 제출
    public String postLogin(@Valid LoginInfo loginInfo, Errors errors, HttpSession session, HttpServletResponse response) {
        if (errors.hasErrors()) {
            return "home";
        }
        UserInfo user = memberService.search(loginInfo.getUserid());    //로그인한 아이디가 존재하는지 확인
        if (user == null) { //로그인한 아이디 값이 회원 정보 리스트에 있는지 확인
            errors.rejectValue("userid", "no");
            return "home";
        } else { //있다면 입력한 비밀번호와 일치하는지 확인
            System.out.println("찾은 아이디와 패스워드는 " + user.getUserid() + " / " + user.getPwd());
            if (!loginInfo.getPwd().equals(user.getPwd())) {
                errors.rejectValue("pwd", "no");
                return "home";
            }
        }
        session.setAttribute("authInfo", loginInfo);
        Cookie rememberCookie = new Cookie("REMEMBERID", loginInfo.getUserid());
        rememberCookie.setPath("/");
        if (loginInfo.getRememberid()) {
            rememberCookie.setMaxAge(60 * 60 * 24 * 30);
        } else {
            rememberCookie.setMaxAge(0);
        }
        response.addCookie(rememberCookie);
        return "login_result";
    }

    @GetMapping("/submit")  //로그인 성공 시 리다이렉트
    public String loginRedirect() {
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(SearchInfo searchInfo, HttpSession session) {
        if (session != null) session.invalidate();
        return "logout";
    }

    @RequestMapping("/remove")
    public String remove(SearchInfo searchInfo,HttpSession session) {
        if (session != null) {
            LoginInfo loginInfo = (LoginInfo) session.getAttribute("authInfo");
            memberService.remove(loginInfo);
            System.out.println(loginInfo.getUserid() + " 회원이 탈퇴합니다. ");
            session.invalidate();
        }
        return "remove";
    }


    @RequestMapping("/modifyUserInfo/{id}")
    public String modiyUserInfo(@PathVariable("id") String userid, Info info) {
        return "modifyuserinfo";
    }

    @PostMapping("/modifyUserInfo/{id}")
    public String modifyUserInfoResult(@PathVariable("id") String userid, @Valid Info info, Errors errors) {
        if (errors.hasErrors()) {
            return "modifyuserinfo";
        }
        memberService.modify(userid, info);
        return "userinfo";
    }

    @RequestMapping("/userInfo/{id}")
    public String getUserInfo(@PathVariable("id") String userId, Info info) {
        UserInfo userInfo = memberService.searchMember(userId);
        info.setAddr(userInfo.getAddr());
        info.setBirthday(userInfo.getBirthday());
        info.setTel(userInfo.getTel());
        info.setEmail(userInfo.getEmail());

        return "userinfo";
    }

    //회원가입 페이지
    @RequestMapping("/register")
    public String register(UserInfo userInfo) {
        return "register";
    }

    //회원가입 제출 페이지
    @PostMapping("/registerUserInfo")
    public String registerUserInfoResult(@Valid UserInfo userInfo, Errors errors) {
        if (errors.hasErrors()) {
            return "register";
        }

        UserInfo user = memberService.search(userInfo.getUserid());    //로그인한 아이디가 존재하는지 확인
        if (user != null) { //로그인한 아이디 값이 회원 정보 리스트에 있는지 확인
            errors.rejectValue("userid", "duplicate");
            return "register";
        }
        memberService.register(userInfo);

        return "redirect:login";
    }
}
