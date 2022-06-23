package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.MemberService;
import service.SearchService;
import spring.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class SearchController {

    private SearchService searchService;

    public void setSearchRegisterService(
            SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public String searchKeyword(@RequestParam(value = "keyword") String keyword,
                                @RequestParam(value = "searchType", required = false, defaultValue = "최신순") String searchType,
                                Model model) {
        List<SearchProductDto> result;
        switch (searchType) {
            case "오래된순":
                result = searchService.searchProduct(keyword, "asc", "reg_time");
                break;
            case "인기순": //구매 수가 많은 순서
                result = searchService.searchProduct(keyword, "desc", "buying_count");
                break;
            case "비싼순":
                result = searchService.searchProduct(keyword, "desc", "price");
                break;
            case "저렴한순":
                result = searchService.searchProduct(keyword, "asc", "price");
                break;
            default:    //최신순
                result = searchService.searchProduct(keyword, "desc", "reg_time");
        }
        model.addAttribute("keyword", keyword);
        model.addAttribute("searchResult", result);
        return "search_result";
    }

    @GetMapping("/search/{id}")
    public String searchDetailProduct(@PathVariable int id, Model model) {
        DetailProduct result = searchService.searchDetailProduct(id);
        model.addAttribute("searchDetailResult", result);
        return "search_detail";
    }

    @PostMapping("/search/{id}/buy")    //상품 구매
    public String buyProduct(@PathVariable int id, HttpSession session) {
        if (session == null) throw new NotValidatedException(); //로그인되지 않은 상태이므로 에러 발생
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("authInfo");
        searchService.buyProduct(id, loginInfo.getUserid());
        return "redirect:/search/{id}";
    }

    @GetMapping("/search/all")   //전체 상품 조회
    public String buyProduct(@RequestParam(value = "searchType", required = false, defaultValue = "최신순") String searchType,
                             Model model) {
        List<SearchProductDto> result;
        switch (searchType) {
            case "오래된순":
                result = searchService.searchAllProduct("asc", "reg_time");
                break;
            case "인기순": //구매 수가 많은 순서
                result = searchService.searchAllProduct("desc", "buying_count");
                break;
            case "비싼순":
                result = searchService.searchAllProduct("desc", "price");
                break;
            case "저렴한순":
                result = searchService.searchAllProduct("asc", "price");
                break;
            default:    //최신순
                result = searchService.searchAllProduct("desc", "reg_time");
        }
        model.addAttribute("searchResult", result);
        return "search_result_all";
    }

    @GetMapping("search/buy")
    public String searchBuy(SearchBuyInfo searchBuyInfo) {
        return "search_buy";
    }

    @GetMapping("/search/buy/{id}/list")
    public String searchBuyList(@PathVariable("id") String userid,
                                @RequestParam(value = "keyword", required = false) String keyword,
                                @RequestParam(value = "startDate", required = false) String startDate,
                                @RequestParam(value = "endDate", required = false) String endDate,
                                @RequestParam(value = "searchType", required = false, defaultValue = "최신순") String searchType,
                                SearchBuyInfo searchBuyInfo,
                                Errors errors, Model model) {


        List<SearchBuyingProductDto> result;
        try {
            if (!Objects.equals(startDate, "")) {
                SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-mm-dd");
                Date start = dateParser.parse(startDate);
                Date end = dateParser.parse(endDate);
                if (start.after(end)) {
                    errors.rejectValue("startDate", "error");
                    errors.rejectValue("endDate", "error");
                    return "search_buy";
                }
            }
            switch (searchType) {
                case "오래된순":
                    result = searchService.searchBuyList(keyword, "asc", "mp.reg_time", startDate, endDate, userid);
                    break;
                case "인기순": //구매 수가 많은 순서
                    result = searchService.searchBuyList(keyword, "desc", "p.buying_count", startDate, endDate, userid);
                    break;
                case "비싼순":
                    result = searchService.searchBuyList(keyword, "desc", "p.price", startDate, endDate, userid);
                    break;
                case "저렴한순":
                    result = searchService.searchBuyList(keyword, "asc", "p.price", startDate, endDate, userid);
                    break;
                default:    //최신순
                    result = searchService.searchBuyList(keyword, "desc", "mp.reg_time", startDate, endDate, userid);
            }
            model.addAttribute("searchBuyingResult", result);

        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("구매이력 조회 오류");
        }
        return "search_buy_list";
    }
}
