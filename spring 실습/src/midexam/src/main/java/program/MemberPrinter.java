package program;

public class MemberPrinter {

    public void print(Member member) {
        System.out.printf("회원 정보: { id : %s , name : %s ,email : %s , hp : %s }\n",
                member.getId(), member.getName(), member.getEmail(), member.getHp());
    }

}
