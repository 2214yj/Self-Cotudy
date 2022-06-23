package spring;

import org.hibernate.validator.constraints.NotBlank;

public class SearchInfo {
    @NotBlank
    private String keyword;


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public SearchInfo(){}

}
