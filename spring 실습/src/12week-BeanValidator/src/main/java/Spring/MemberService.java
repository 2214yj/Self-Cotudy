package Spring;

import controller.RegisterRequest;
import controller.SearchRequest;

public class MemberService {
    private MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public String regist(RegisterRequest req) {
        Member member = memberDao.selectByEmail(req.getEmail());
        if (member != null) {
            throw new DuplicateEmailException("dup email " + req.getEmail());
        }else{
            member = memberDao.selectById(req.getId());
        }
        if (member != null) {
            throw new DuplicateIdException("dup ID " + req.getId());

        }else{
            member = memberDao.selectByHp(req.getHp());
        }
        if (member != null) {
            throw new DuplicateHpException("dup HP " + req.getId());

        }

        Member newMember = new Member(
                req.getId(), req.getName(), req.getEmail(), req.getAddress(), req.getHp());
        memberDao.insert(newMember);
        return newMember.getId();
    }

    public Member search(SearchRequest request) {
        Member member = memberDao.selectByRequest(request);
        if(member == null){
            throw new NotExistException(request.getKeyword()+" doesn't exist!");
        }
        return member;
    }

}
