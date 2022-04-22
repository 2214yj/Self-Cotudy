package week6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("match")
public class Match {

    private Team team1;

    private Team team2;

    private Judge judge1;

    private Judge judge2;

    private String name;

    public Team getTeam1(){
        return team1;
    }

    @Autowired(required = false)
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    @Autowired
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    @Autowired(required = false)
    public void setJudge1(Judge judge1) {
        this.judge1 = judge1;
    }

    @Autowired
    public void setJudge2(Judge judge2) {
        this.judge2 = judge2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Match() {
        System.out.println("경기 객체가 생성되었습니다.");
    }

    public void info() {
        System.out.println("Match 객체의 이름을 출력합니다.");
        System.out.println(name);
        team1.info();
        team2.info();
        judge1.info();
        judge2.info();
    }
}
