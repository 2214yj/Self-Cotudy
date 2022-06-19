package spring;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Info {

    @NotBlank
    private String addr;
    @NotEmpty
    @Email
    private String email;
    @NotBlank
    private String tel;
    @DateTimeFormat(pattern = "yyyyMMdd")
    private String birthday;

    public Info(){};


    public String getAddr() {
        return addr;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getBirthday() {
        return birthday;
    }



    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
