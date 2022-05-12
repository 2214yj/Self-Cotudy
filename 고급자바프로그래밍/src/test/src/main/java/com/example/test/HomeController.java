package com.example.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;


@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Locale locale, Model model){
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(DBConfig.class);

        DBQuery query = ctx.getBean(DBQuery.class);

        model.addAttribute("customerCount", query.count("CUSTOMER"));
        model.addAttribute("bookCount",query.count("BOOK"));

        return "/WEB-INF/home.jsp";
    }

    @RequestMapping(value = "/search/book", method = RequestMethod.GET)
    public String bookSearch(Locale locale, Model model){
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(DBConfig.class);

        DBQuery query = ctx.getBean(DBQuery.class);
        model.addAttribute("bookList",query.searchBook());
        model.addAttribute("bestBook",query.bookRank());
        return "/WEB-INF/book.jsp";
    }

    @RequestMapping(value = "/search/customer", method = RequestMethod.GET)
    public String customerSearch(Locale locale, Model model){
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(DBConfig.class);

        DBQuery query = ctx.getBean(DBQuery.class);
        model.addAttribute("customerList",query.searchCustomer());
        model.addAttribute("bestCustomer",query.customerRank());
        return "/WEB-INF/customer.jsp";
    }
}
