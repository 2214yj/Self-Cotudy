package week6;

public class Team {
    private Owner owner;
    private Manager manager;
    private Coach coach;
    private Player player1;
    private Player player2;
    private Player player3;
    private String name;

    public Team(Owner owner, Manager manager, Coach coach, Player player1, Player player2, Player player3,String name) {
        this.owner = owner;
        this.manager = manager;
        this.coach = coach;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.name = name;
        System.out.println("팀 객체가 생성되었습니다.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println("Team 객체의 이름을 출력합니다.");
        System.out.println(name);
        owner.info();
        manager.info();
        coach.info();
        player1.info();
        player2.info();
        player3.info();
    }
}
