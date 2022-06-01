package week6;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Sports.class)
public class AppCxt {

    @Bean
    @Qualifier("judge1")
    Judge judge1() {
        return new Judge("judge1");
    }

    @Bean
    @Qualifier("judge2")
    Judge judge2() {
        return new Judge("judge2");
    }


    @Bean
    Team team1(Owner owner1, Manager manager1, Coach coach1, Player player1, Player player2, Player player3) {
        return new Team(owner1, manager1, coach1, player1, player2, player3,"team1");
    }

    @Bean
    Team team2(Owner owner2, Manager manager2, Coach coach2, Player player4, Player player5, Player player6) {
        return new Team(owner2, manager2, coach2, player4, player5, player6,"team2");
    }

    @Bean
    Team team3(Owner owner3, Manager manager3, Coach coach3, Player player7, Player player8, Player player9) {
        return new Team(owner3, manager3, coach3, player7, player8, player9,"team3");
    }

    @Bean
    Owner owner1() {
        return new Owner("owner1");
    }

    @Bean
    Owner owner2() {
        return new Owner("owner2");
    }

    @Bean
    Owner owner3() {
        return new Owner("owner3");
    }

    @Bean
    Manager manager1() {
        return new Manager("manager1");
    }

    @Bean
    Manager manager2() {
        return new Manager("manager2");
    }

    @Bean
    Manager manager3() {
        return new Manager("manager3");
    }

    @Bean
    Coach coach1() {
        return new Coach("coach1");
    }

    @Bean
    Coach coach2() {
        return new Coach("coach2");
    }

    @Bean
    Coach coach3() {
        return new Coach("coach3");
    }

    @Bean
    Player player1() {
        return new Player("player1");
    }

    @Bean
    Player player2() {
        return new Player("player2");
    }

    @Bean
    Player player3() {
        return new Player("player3");
    }

    @Bean
    Player player4() {
        return new Player("player4");
    }

    @Bean
    Player player5() {
        return new Player("player5");
    }

    @Bean
    Player player6() {
        return new Player("player6");
    }

    @Bean
    Player player7() {
        return new Player("player7");
    }

    @Bean
    Player player8() {
        return new Player("player8");
    }

    @Bean
    Player player9() {
        return new Player("player9");
    }

}
