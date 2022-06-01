public class Greeter {
//    private String format;
//
//    public String greet(String guest) {
//        return String.format(format, guest);
//    }
//
//    public void setFormat(String format) {
//        this.format = format;
//    }

    private String format;
    private String guest;

    public String greet() {
        return String.format(format, guest);
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

}
