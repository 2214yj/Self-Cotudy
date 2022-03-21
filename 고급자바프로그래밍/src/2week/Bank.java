public interface Bank {

    //상수
    public int MAX = 99999;

    //추상 메소드
    void withDraw(int price);   //인출

    void deposit(int price);    //입금

    //정적 메소드
    static void printMax(){
        System.out.println("고객이 인출 가능한 최대 금액은 "+MAX);
    }

}
