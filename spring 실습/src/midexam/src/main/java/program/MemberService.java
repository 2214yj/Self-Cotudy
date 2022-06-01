package program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MemberService {

    private MemberDao memberDao;

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void register(RegisterRequest req) {   //회원 가입 메소드
        Member member = memberDao.selectById(req.getId());
        if (member != null) {
            throw new DuplicateMemberException("duplicated Id: " + req.getId());
        }
        Member newMember = new Member(req.getName(), req.getHp(), req.getEmail(), req.getId(), req.getPassword());
        memberDao.insert(newMember);
    }

    public void login(String id, String password) {
        Member member = memberDao.selectById(id);
        if (member == null) {
            System.out.println("일치하는 id가 없습니다.");
            throw new MemberNotFoundException("일치하는 id가 없습니다.");
        }
        if (!password.equals(member.getPassword())) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            throw new WrongIdPasswordException("비밀번호가 일치하지 않습니다.");
        }
        memberDao.setLoggedInId(id);
    }

    public String getLoggedInId() {
        return memberDao.getLoggedInId();
    }

    public String resetPassword(String id, String name, String email) {  //암호 재설정 메소드(암호를 변경하기 위해 사용자가 맞는지 정보 확인)
        Member member = memberDao.selectById(id);
        if (member == null) {
            throw new MemberNotFoundException("일치하는 id가 없습니다.");
        }
        if (!name.equals(member.getName())) {
            throw new MemberNotFoundException("이름이 일치하지 않습니다.");
        }
        if (!email.equals(member.getEmail())) {
            throw new MemberNotFoundException("이메일이 일치하지 않습니다.");
        }
        return member.getPassword();
    }

    public void changePassword(String id, String oldPassword, String newPassword) throws MemberNotFoundException{    //암호 변경 메소드
        Member member = memberDao.selectById(id);
        if (member == null) {
            throw new MemberNotFoundException("일치하는 id가 없습니다.");
        }
        member.changePassword(oldPassword, newPassword);
        memberDao.update(member);
    }

    public void changeMemberInfo(RegisterRequest registerRequest) {
        Member member = memberDao.selectById(registerRequest.getId());
        if (member == null) {
            throw new MemberNotFoundException("일치하는 id가 없습니다.");
        }
        member.changeMemberInfo(registerRequest);
        memberDao.update(member);
    }

    public void deleteMemberInfo(String id) {
        Member member = memberDao.selectById(id);
        if (member == null) {
            throw new MemberNotFoundException("일치하는 id가 없습니다.");
        }
        memberDao.delete(member);
    }

}
