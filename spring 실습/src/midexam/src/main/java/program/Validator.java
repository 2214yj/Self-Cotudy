package program;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class Validator {

    public Boolean validateId(String id) {   //id 유효성 검증. id는 4~8 자리, 영어와 숫자 및 특수기호(._!@#$%^&*())만 사용 가능
        if (id.length() < 4 || id.length() > 8) {
            System.out.println("길이");
            return false;
        }
        return Pattern.matches("^[a-z0-9A-Z._!@#$%^&*()]*$", id);
    }

    public Boolean validateHP(String hp) {   //hp 유효성 검증. hp는 xxx-xxxx-xxxx 형태여야 함
        return Pattern.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$", hp);
    }

    public Boolean validateEmail(String email) { //email 유효성 검증. email은 ~@~.~ 형태여야 함
        return Pattern.matches("^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$", email);
    }
}
