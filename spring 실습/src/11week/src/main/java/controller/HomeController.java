package controller;

import config.DBConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;


@Controller
public class HomeController {

    @GetMapping(value = "/result")
    public  String getResult(){
        return "result";
    }
//
    @GetMapping(value = "/order")
    public  String getOrder(){
        return "order";
    }

    @GetMapping(value = "/book")
    public  String getBook(){
        return "book";
    }

    @GetMapping(value = "/customer")
    public  String getCustomer(){
        return "customer";
    }

    @PostMapping(value = "/book")
    public String bookSearch(HttpServletRequest req, BookInfo bookInfo){
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(DBConfig.class);
        DBQuery query = ctx.getBean(DBQuery.class);
        try {
            bookInfo.setName(req.getParameter("name"));
            bookInfo.setPrice(Long.parseLong(req.getParameter("price")));
            bookInfo.setPublisher(req.getParameter("publisher"));
            query.insertBook(bookInfo);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("예외 발생");
        }
        return "bookResult";
    }

   @PostMapping(value = "/customer")
    public String customerSearch(HttpServletRequest req,CustomerInfo customerInfo){
       AnnotationConfigApplicationContext ctx =
               new AnnotationConfigApplicationContext(DBConfig.class);
       DBQuery query = ctx.getBean(DBQuery.class);
        try{
            customerInfo.setName(req.getParameter("name"));
            customerInfo.setAddress(req.getParameter("address"));
            customerInfo.setPhone(req.getParameter("phone"));
            query.insertCustomer(customerInfo);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("예외 발생");
        }
        return "customerResult";
    }

    @PostMapping(value = "/order")
    public String orderSearch(HttpServletRequest req, Model model){
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(DBConfig.class);
        DBQuery query = ctx.getBean(DBQuery.class);
        try{
            System.out.println("a");
           String custName = req.getParameter("customerName");
           String bookName = req.getParameter("bookName");

           System.out.println("b");
           int custId = query.getCustId(custName);
           int bookId = query.getBookId(bookName);
           System.out.println("id: "+custName);
            System.out.println("id: "+bookName);
           model.addAttribute("custId",custId);
           model.addAttribute("bookId",bookId);
           System.out.println("c");
           model.addAttribute("price",Integer.parseInt(req.getParameter("price")));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c1 = Calendar.getInstance();
            c1.add(Calendar.DATE, -1); // 오늘날짜로부터 -1
            String yesterday = sdf.format(c1.getTime());
           model.addAttribute("date",yesterday);
           OrderInfo orderInfo = new OrderInfo(custId,bookId,Integer.parseInt(req.getParameter("price")),yesterday);
           System.out.println(orderInfo);
           query.insertOrder(orderInfo);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("예외 발생");
        }

        return "orderResult";
    }
}
