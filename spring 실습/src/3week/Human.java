//1. 인터페이스 설계
//(1) 인터페이스 구현
public interface Human {
    String str = "포유류";

    void wakeUp();
    void eat();
    void walk();
    void sleep();

    default void introduce(){
        System.out.println("Hello, I'm human");
    }
}
