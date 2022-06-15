package controller;

import Spring.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisterController {

    private MemberService memberService;

    public void setMemberRegisterService(
            MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        System.out.println("model ");

        return "register";
    }

    @GetMapping("/registerResult")
    public String register() {
        return "registerResult";
    }

    @PostMapping("/registerResult")
    public String register(@Valid RegisterRequest request, Errors errors) {
        if (errors.hasErrors())
            return "register";
        try {
            memberService.regist(request);
            return "registerResult";
        } catch (DuplicateEmailException ex) {
            errors.rejectValue("email", "duplicate");
            return "register";
        } catch (DuplicateIdException ex) {
            errors.rejectValue("id", "duplicate");
            return "register";
        } catch (DuplicateHpException ex) {
            errors.rejectValue("hp", "duplicate");
            return "register";
        }
    }

}
