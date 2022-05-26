package controller;

import Spring.MemberService;
import Spring.NotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    private MemberService memberService;

    public void setMemberRegisterService(
            MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "key", defaultValue = "default") String key, Model model) {
        System.out.println("key: " + key);
        String s = "";
        model.addAttribute("searchRequest", new SearchRequest());
        switch (key) {
            case "email":
            case "id":
            case "hp":
                return "searchPage";
            default:
                return "search";
        }
    }

    @PostMapping("/search")
    public String search(SearchRequest request, Model model, Errors errors) {
        System.out.println(request.getKey());
        System.out.println(request.getKeyword());
        try {
            model.addAttribute("result", memberService.search(request));
        } catch (NotExistException e) {
            errors.rejectValue("keyword", "notExist");
            return "searchPage";
        }
        return "searchResult";
    }

}
