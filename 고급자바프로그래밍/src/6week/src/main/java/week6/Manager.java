package week6;

public class Manager {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager(String name) {
        this.name = name;
        System.out.println("감독 객체가 생성되었습니다.");
    }

    public void info() {
        System.out.println("Manager 객체의 이름을 출력합니다.");
        System.out.println(name);
    }
}
