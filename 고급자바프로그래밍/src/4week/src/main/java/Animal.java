public class Animal {
    private String type;
    private String str;

    public String animal() {
        return String.format(type, str);
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
