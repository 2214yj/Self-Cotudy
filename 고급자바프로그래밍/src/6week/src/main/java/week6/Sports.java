package week6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sports")
public class Sports {

    private Team team1;

    private Team team2;

    private Team team3;

    private Match match;

    private String name;

    @Autowired(required = false)
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    @Autowired
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    @Autowired
    public void setTeam3(Team team3) {
        this.team3 = team3;
    }

    @Autowired
    public void setMatch(Match match) {
        this.match = match;
        this.match.setName("match");
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Sports() {
        System.out.println("스포츠 객체가 생성되었습니다.");
    }

    void info(){
        System.out.println("Sports 객체의 이름을 출력합니다.");
        System.out.println(name);
        team1.info();
        team2.info();
        team3.info();
        match.info();
    }
}
