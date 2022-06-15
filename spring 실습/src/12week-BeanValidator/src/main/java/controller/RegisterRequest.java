package controller;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class RegisterRequest {
    @NotBlank(message = "공백 문자는 허용하지 않습니다.")
    private String id;
    @NotBlank(message = "공백 문자는 허용하지 않습니다.")
    private String name;
    @NotBlank(message = "공백 문자는 허용하지 않습니다.")
    @Email(message = "이메일 형식을 지켜주세요.")
    private String email;
    @NotBlank(message = "공백 문자는 허용하지 않습니다.")
    private String address;
    @NotBlank(message = "공백 문자는 허용하지 않습니다.")
    private String hp;

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
