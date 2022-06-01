package week6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static ApplicationContext ctx = null;

    public static void main(String[] args){

        ctx = new AnnotationConfigApplicationContext(AppCxt.class);

        Sports s = ctx.getBean("sports",Sports.class);
        s.setName("sports");
        System.out.println("");
        s.info();

        System.out.println("");
        Match m = ctx.getBean("match",Match.class);
        m.info();

        System.out.println("");
        Team t = ctx.getBean("team1",Team.class);
        t.info();

        System.out.println(m.getTeam1());
    }
}
