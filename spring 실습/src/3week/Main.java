import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){

        //1. 인터페이스 설계
//        Human human;
//        C1 class1 = new C1();
//        C2 class2 = new C2();
//        C3 class3 = new C3();
//
//        human = class1;
//        human.wakeUp();
//        human.introduce();
//        human.eat();
//        human.walk();
//        human.sleep();
//
//        human = class2;
//        human.wakeUp();
//        human.introduce();
//        human.eat();
//        human.walk();
//        human.sleep();
//
//        human = class3;
//        human.wakeUp();
//        human.introduce();
//        human.eat();
//        human.walk();
//        human.sleep();

        //2. 소스 프로그램 수정 없이 구현 클래스 교체
        try{
            FileInputStream in = new FileInputStream("src/3week/class_setting.txt");
            Scanner aScan = new Scanner(in);
            String className = aScan.nextLine();
            System.out.println(className);
            aScan.close();
            in.close();
            Class<?> aClass = Class.forName(className);
            Human h = (Human) aClass.getDeclaredConstructor().newInstance();
            h.introduce();
            h.eat();
            h.sleep();
            h.wakeUp();
            h.walk();

        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
