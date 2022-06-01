
public class week2 {

    public static void main(String args[]) {

        //1. 객체 프로그래밍의 시작
        Person p1 = new Person(1, "김예지", 12, 'g', true, 0); //인스턴스 생성
        p1.age = 23;    //필드 접근
        if (p1.getMarried() == true) {  //getter 사용
            p1.setMarried(false);   //setter 사용
        }
        p1.printPersonInfo(p1); //메소드

        Person p2 = new Person(2,"유재석",3,'b',true,1000000);
        p2.printPersonInfo(p2);


        //2. 클래스의 상속관계 이해
        System.out.println("");
        Student s1 = new Student(p2);   //자식 클래스의 인스턴스 생성
        s1.studentId = 213; //protected 필드 접근
        s1.printPersonInfo(s1); //부모 클래스의 메소드를 오버라이딩한 메소드

        Programmer g1 = new Programmer(p1); //자식 클래스의 인스턴스 생성
        g1.printPersonInfo(g1); //부모 클래스의 메소드를 오버 라이딩한 메소드
        g1.setJoinYear(2018);   //setter 사용
        if(g1.getLeaveYear()==0){   //getter 사용
            g1.setLeaveYear(2022);  //setter 사용
        }
        g1.printWorkingDuration();  //자식 클래스의 메소드

        Person p3 = g1; //부모 클래스 변수에 자식 클래스의 인스턴스를 대입
        System.out.println(p3.name);

        //3. 추상 클래스 사용
        System.out.println("");
        Beverage coke = new Beverage(); //추상 클래스 Food를 상속하는 자식 클래스 Beverage
        coke.eat(); //추상 메소드를 오버라이딩한 메소드 호출

        Food baguette = new Bread(150); //추상 클래스 Food를 상속하는 자식 클래스 Bread. 부모 클래스 변수에 자식 클래스의 인스턴스 대입 사용(다형성)
        baguette.eat(); //추상 메소드를 오버라이딩한 메소드 호출
        baguette.printKcal();   //부모 클래스인 Food 추상 클래스의 메소드 호출


        //4. 인터페이스 사용
        System.out.println("");
        Woori woori = new Woori();  //Bank 인터페이스를 구현하는 Woori 클래스
        woori.withDraw(1000000000); //오버라이딩한 메소드 호출
        woori.deposit(10); //오버라이딩한 메소드 호출
        Bank.printMax();    //Bank 인터페이스의 정적 메소드 호출


        //5. 정적 필드와 정적 메소드의 사용
        System.out.println("");
        System.out.println(Programmer.companyName); //정적 필드 사용
        Programmer.setCompanyName("네카라쿠배"); //정적 메소드 사용
        System.out.println(Programmer.companyName); //정적 필드 사용
    }
}
