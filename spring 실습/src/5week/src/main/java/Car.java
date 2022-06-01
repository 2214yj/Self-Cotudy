public class Car {
    private Wheel wheel1;
    private Wheel wheel2;
    private Wheel wheel3;
    private Wheel wheel4;

    private Body body;

    public Car(Wheel wheel1, Wheel wheel2, Wheel wheel3, Wheel wheel4, Body body) {
        this.wheel1 = wheel1;
        this.wheel2 = wheel2;
        this.wheel3 = wheel3;
        this.wheel4 = wheel4;
        this.body = body;
        System.out.println("자동차 객체가 생성되었습니다.");
    }
}
