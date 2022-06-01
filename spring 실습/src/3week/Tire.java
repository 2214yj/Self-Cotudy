//바퀴 클래스를 상속받는 타이어 클래스
public class Tire extends Wheel{
    private Tube tube;

    public Tire(Tube tube){
        this.tube = tube;
    }
}
