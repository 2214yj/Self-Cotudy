package week6;

import org.springframework.beans.factory.annotation.Autowired;

public class Coach {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coach(String name) {
        this.name = name;
        System.out.println("코치 객체가 생성되었습니다.");
    }

    public void info() {
        System.out.println("Coach 객체의 이름을 출력합니다.");
        System.out.println(name);
    }
}
