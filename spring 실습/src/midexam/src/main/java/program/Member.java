package program;

public class Member {
    //단, 최소한 사용자 이름, 연락처, 이메일은 반드시 포함되어야 한다.
    private String name;
    private String hp;
    private String email;
    private String id;
    private String password;

    public Member(String name, String hp, String email, String id, String password) {
        this.name = name;
        this.hp = hp;
        this.email = email;
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getHp() {
        return hp;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (!password.equals(oldPassword)) {
            throw new WrongIdPasswordException("비밀번호가 일치하지 않습니다. 비밀번호 변경에 실패했습니다.");
        }
        this.password = newPassword;
    }

    public void changeMemberInfo(RegisterRequest registerRequest) {
        if (!registerRequest.getId().isBlank()) {
            this.id = registerRequest.getId();
        }
        if (!registerRequest.getName().isBlank()) {
            this.name = registerRequest.getName();
        }
        if (!registerRequest.getHp().isBlank()) {
            this.hp = registerRequest.getHp();
        }
        if (!registerRequest.getEmail().isBlank()) {
            this.email = registerRequest.getEmail();
        }
    }
}
