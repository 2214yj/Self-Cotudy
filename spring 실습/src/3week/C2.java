//1. 인터페이스 설계
//(2) 클래스 구현
public class C2 implements Human {
    @Override
    public void wakeUp() {
        System.out.println("I wake up");
    }

    @Override
    public void eat() {
        System.out.println("I'm eating");
    }

    @Override
    public void walk() {
        System.out.println("I'm walking");
    }

    @Override
    public void sleep() {
        System.out.println("I'm sleeping");
    }

    String name = "김예지";

    @Override
    public void introduce() {
        System.out.println("Hello, I'm " + name);
    }
}
