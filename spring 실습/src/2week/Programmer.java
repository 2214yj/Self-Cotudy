public class Programmer extends Person{
    //다양한 타입과 접근 제한자를 사용한 필드
    static String companyName = "무한 상사";    //정적 필드
    String departmentName;
    private int joinYear;
    private int leaveYear;

    //private field에 접근하기 위한 getter와 setter
    protected void setJoinYear(int year){
        this.joinYear = year;
    }

    protected int getLeaveYear(){
        return this.leaveYear;
    }

    protected void setLeaveYear(int year){
        this.leaveYear = year;
    }

    //정적 메소드
    static void setCompanyName(String name){
        companyName = name;
    }

    //메소드
    public void printWorkingDuration(){
        System.out.println(Programmer.companyName+"의 일한 기간 계산 프로그램 입니다.");  //static 필드 접근
        if(leaveYear != 0){
            System.out.println("일한 기간은 "+(this.leaveYear-this.joinYear)+"년 입니다.");
        }else{
            System.out.println("아직 퇴사하지 않은 프로그래머입니다.");
        }
    }

    //부모 클래스의 메소드를 오버라이딩
    public void printPersonInfo(Person person) {
        System.out.println("programmer 정보를 출력합니다.");
        System.out.println("이름은 " + name + " 나이는 " + age + " 성별은 " + gender + "입니다.");
    }

    //생성자
    public Programmer(Person p1) {
        super(p1.personId,p1.name,p1.age,p1.gender,p1.getMarried(),p1.getSalary());
    }
}
