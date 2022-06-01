public abstract class Food {
    public long kcal;
    public String name;

    //메서드
    public void printKcal(){
        System.out.println(kcal+" 칼로리 섭취");
    }

    //추상 메서드
    public abstract void eat();
}
