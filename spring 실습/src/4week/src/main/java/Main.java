import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

        Animal a1 = ctx.getBean("animal",Animal.class);
        Animal a2 = ctx.getBean("animal",Animal.class);
        a1.setStr("토끼");
        String msg1 = a1.animal();
        String msg2 = a1.animal();
        System.out.println(msg1);
        System.out.println(msg2);

        ctx.close();
    }
}
