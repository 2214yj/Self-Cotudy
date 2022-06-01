//자동차 클래스를 상속받는 바퀴 클래스
public class Wheel extends Car{
    private Tire tire;
    private SubWheel subWheel;

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public void setSubWheel(SubWheel subWheel) {
        this.subWheel = subWheel;
    }
}
