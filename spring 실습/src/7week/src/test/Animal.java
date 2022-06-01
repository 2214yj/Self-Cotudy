package test;

public class Animal {
    private String type;
    private String className;

    public Animal(String type, String className) {
        this.type = type;
        this.className = className;
    }

    public String getType() {
        return type;
    }

    public String getClassName() {
        return className;
    }
}
