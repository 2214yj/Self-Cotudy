import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

    @Bean
    public Car car(Wheel wheel1, Wheel wheel2, Wheel wheel3, Wheel wheel4, Body b) {
        return new Car(wheel1, wheel2, wheel3, wheel4, b);
    }

    @Bean
    public Body body() {
        return new Body();
    }

    @Bean
    public Wheel wheel1(Tire tire1, WheelFrame wheelFrame1) {
        return new Wheel(tire1, wheelFrame1);
    }

    @Bean
    public Wheel wheel2(Tire tire2, WheelFrame wheelFrame2) {
        return new Wheel(tire2, wheelFrame2);
    }

    @Bean
    public Wheel wheel3(Tire tire3, WheelFrame wheelFrame3) {
        return new Wheel(tire3, wheelFrame3);
    }

    @Bean
    public Wheel wheel4(Tire tire4, WheelFrame wheelFrame4) {
        return new Wheel(tire4, wheelFrame4);
    }

    @Bean
    public Tire tire1(Tube tube1) {
        return new Tire(tube1);
    }

    @Bean
    public Tire tire2(Tube tube2) {
        return new Tire(tube2);
    }

    @Bean
    public Tire tire3(Tube tube3) {
        return new Tire(tube3);
    }

    @Bean
    public Tire tire4(Tube tube4) {
        return new Tire(tube4);
    }

    @Bean
    public WheelFrame wheelFrame1() {
        return new WheelFrame();
    }

    @Bean
    public WheelFrame wheelFrame2() {
        return new WheelFrame();
    }

    @Bean
    public WheelFrame wheelFrame3() {
        return new WheelFrame();
    }

    @Bean
    public WheelFrame wheelFrame4() {
        return new WheelFrame();
    }

    @Bean
    public Tube tube1() {
        return new Tube();
    }

    @Bean
    public Tube tube2() {
        return new Tube();
    }

    @Bean
    public Tube tube3() {
        return new Tube();
    }

    @Bean
    public Tube tube4() {
        return new Tube();
    }

}
