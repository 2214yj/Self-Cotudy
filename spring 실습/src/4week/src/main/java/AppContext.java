import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

    @Bean
    public Greeter greeter(){
        Greeter g = new Greeter();
        g.setFormat("%s, 안녕하세요!");
        return g;
    }

    @Bean
    public Student student(){
        Student s = new Student();
        s.setName("학생의 이름은 %s 입니다.");
        return s;
    }

    @Bean
    public Animal animal(){
        Animal a = new Animal();
        a.setType("동물의 종류는 %s 입니다.");
        return a;
    }
}
