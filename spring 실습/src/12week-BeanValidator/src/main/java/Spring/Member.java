package Spring;

public class Member {
    private String id;
    private String name;
    private String email;
    private String address;
    private String hp;

    public Member(String id, String name, String email, String address, String hp) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.hp = hp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }
}
