public class Bread extends Food{

    public Bread(long kcal){
        this.kcal = kcal;
    }
    @Override
    public void eat() {
        System.out.println("빵을 먹는 중입니다.");
    }
}
