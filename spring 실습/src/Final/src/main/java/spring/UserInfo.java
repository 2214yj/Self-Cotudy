package spring;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserInfo {
    @NotBlank
    private String userid;

    @NotBlank
    private String pwd;


    @NotBlank
    private String addr;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String tel;
    @DateTimeFormat(pattern = "yyyyMMdd")
    private String birthday;

    public UserInfo(){}

    public UserInfo(UserInfo user_info) {
        this.userid = user_info.getUserid();
        this.pwd = user_info.getPwd();
        this.addr = user_info.getAddr();
        this.email = user_info.getEmail();
        this.birthday = user_info.getBirthday();
        this.tel = user_info.getTel();
    }

    public UserInfo(String userid, String pwd, String addr, String email, String tel, String birthday) {
        this.userid = userid;
        this.pwd = pwd;
        this.addr = addr;
        this.email = email;
        this.tel = tel;
        this.birthday = birthday;
    }



    public String getUserid() {
        return userid;
    }

    public String getPwd() {
        return pwd;
    }

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

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
