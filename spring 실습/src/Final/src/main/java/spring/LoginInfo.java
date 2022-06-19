package spring;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginInfo {

    @NotBlank
    private String userid;

    @NotBlank
    private String pwd;

    private Boolean rememberid;


    public String getUserid() {
        return userid;
    }

    public String getPwd() {
        return pwd;
    }

    public Boolean getRememberid() {
        return rememberid;
    }


    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setRememberid(Boolean rememberid) {
        this.rememberid = rememberid;
    }

}
