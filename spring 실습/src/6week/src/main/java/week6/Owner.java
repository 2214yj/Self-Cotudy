package week6;

public class Owner {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner(String name) {
        this.name = name;
        System.out.println("구단 객체가 생성되었습니다.");
    }

    public void info() {
        System.out.println("Owner 객체의 이름을 출력합니다.");
        System.out.println(name);
    }
}
