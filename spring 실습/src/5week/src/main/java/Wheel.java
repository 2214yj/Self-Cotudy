public class Wheel {
    private Tire tire;
    private WheelFrame wheelFrame;

    public Wheel(Tire tire, WheelFrame wheelFrame) {
        this.tire = tire;
        this.wheelFrame = wheelFrame;
        System.out.println("바퀴 객체가 생성되었습니다.");
    }
}
