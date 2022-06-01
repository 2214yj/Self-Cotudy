public class Woori implements Bank{

    @Override
    public void withDraw(int price) {
        System.out.println("우리 은행 인출 시작");
        if(price < Bank.MAX)
            System.out.println("인출 성공");
        else
            System.out.println("최대 인출 금액 제한, 인출 실패");
    }

    @Override
    public void deposit(int price) {
        System.out.println("우리 은행 입금 시작");
        System.out.println(price +"만큼 입금 완료");
    }
}
