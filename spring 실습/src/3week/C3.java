//1. 인터페이스 설계
//(2) 클래스 구현
public class C3 implements Human{
    @Override
    public void wakeUp() {
        System.out.println(name + " wake up");
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating");
    }

    @Override
    public void walk() {
        System.out.println(name + " is walking");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    String name = "김예지";

    @Override
    public void introduce() {
        System.out.println("Hello, I'm " + name);
    }
}
