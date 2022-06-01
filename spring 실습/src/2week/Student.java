public class Student extends Person{
    //다양한 타입과 접근 제한자를 사용한 필드
    protected long studentId;
    private float score;    //학점
    private int grade;

    //생성자
    public Student(Person p1) {
        super(p1.personId,p1.name,p1.age,p1.gender,p1.getMarried(),p1.getSalary());
    }

    //부모 클래스의 메소드를 오버라이딩
    public void printPersonInfo(Person person) {
        System.out.println("Student 정보를 출력합니다.");
        System.out.println("이름은 " + name + " 나이는 " + age + " 성별은 " + gender + "입니다.");
    }

}
