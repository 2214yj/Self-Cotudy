package program;

public class MemberSummaryPrinter extends MemberPrinter {

    @Override
    public void print(Member member) {
        System.out.printf("회원 정보: { name : %s ,email : %s }\n",
                member.getName(), member.getEmail());
    }

}
