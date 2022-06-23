package service;

import dao.MemberDao;
import spring.*;

public class MemberService {
    private MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    public UserInfo search(String userId) {
        try {
            return memberDao.selectById(userId);
        }catch (Exception e){
            e.printStackTrace();
            throw new DatabaseException("데이터베이스 에러 발생");
        }
    }

    public void remove(LoginInfo loginInfo) {
        int result = memberDao.delete(loginInfo);
        if (result == 0){
            throw new DatabaseException("삭제 실패");
        }
    }

    public void modify(String userid, Info info) {
        int result = memberDao.modify(userid, info);
        if(result == 0){
            throw new DatabaseException("수정 실패");
        }
    }

    public UserInfo searchMember(String userid) {
        try{
            UserInfo result = memberDao.selectById(userid);
            if(result == null){
                throw new MemberNotFoundException();
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            throw new DatabaseException("데이터베이스 에러 발생");
        }
    }

    public void register(UserInfo userInfo) {
        int result = memberDao.insert(userInfo);
        if(result == 0){
            throw new DatabaseException("저장 실패");
        }
    }
}
