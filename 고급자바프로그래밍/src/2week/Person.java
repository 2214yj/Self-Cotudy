//1. 객체 프로그래밍의 시작
//필드와 메소드 구현, 그 중 일부는 접근자 및 게터 세터를 사용해보기
public class Person {
    //다양한 타입과 접근 제한자를 사용한 필드
    long personId;
    String name;
    int age;
    char gender;
    private boolean isMarried;
    private long salary;

    //private field에 접근하기 위한 getter와 setter
    public long getSalary() {
        return salary;
    }

    public boolean getMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    //메소드
    public void printPersonInfo(Person person) {
        System.out.println("정보를 출력합니다.");
        System.out.println("이름은 " + name + " 나이는 " + age + " 성별은 " + gender + "입니다.");
    }

    //생성자
    public Person(long personId, String name, int age, char gender, boolean isMarried, long salary) {
        this.personId = personId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isMarried = isMarried;
        this.salary = salary;
    }
}
