package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;


@Controller
public class HomeController {


    @GetMapping(value = "./order")
    public  String getOrder(){
        System.out.println("order");
        return "order.jsp";
    }

    @GetMapping(value = "/book")
    public  String getBook(){
        System.out.println("return book.jsp");

        return "../book.jsp";
    }

    @GetMapping(value = "/customer")
    public  String getCustomer(){
        return "customer";
    }

   @PostMapping(value = "/order")
    public String order(Locale locale, Model model){
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(DBConfig.class);

        DBQuery query = ctx.getBean(DBQuery.class);

        model.addAttribute("customerCount", query.count("CUSTOMER"));
        model.addAttribute("bookCount",query.count("BOOK"));

        return "/WEB-INF/result";
    }

    @PostMapping(value = "/book")
    public String bookSearch(Locale locale, Model model){
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(DBConfig.class);

        DBQuery query = ctx.getBean(DBQuery.class);
        model.addAttribute("bookList",query.searchBook());
        model.addAttribute("bestBook",query.bookRank());
        return "/WEB-INF/result.jsp";
    }

   @PostMapping(value = "/customer")
    public String customerSearch(Locale locale, Model model){
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(DBConfig.class);

        DBQuery query = ctx.getBean(DBQuery.class);
        model.addAttribute("customerList",query.searchCustomer());
        model.addAttribute("bestCustomer",query.customerRank());
        return "/WEB-INF/result.jsp";
    }
}
