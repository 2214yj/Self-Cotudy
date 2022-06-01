public class week1 {
    public static void main(String args[]) {
        //상수 선언
        final float con1 = 1.3F;
        final char con2 = 'C';
        final double con3 = 1.3456789;

        //변수 선언
        int var1 = 3;
        String var2 = "hi";
        boolean var3 = true;

        //출력문
        System.out.printf("con1의 값은 %f\n", con1);
        System.out.print("var2의 값은 " + var2 + "\n");
        System.out.println("con3의 값은 " + con3);

        //for 반복문
        System.out.println(var1 + "만큼 반복해서 var2를 출력합니다.");
        for (int i = 0; i < var1; i++) {
            System.out.println(i + "번째 var2 출력: " + var2);
        }

        //while 반복문
        while (var3) {
            if (var1++ == 6)
                break;
            System.out.println("var1의 현재값은 " + var1);
        }

        //if문
        if (con2 == 'A') {
            System.out.println("con2의 값은 A");
        } else if (con2 == 'B') {
            System.out.println("con2의 값은 B");
        } else if (con2 == 'C') {
            System.out.println("con2의 값은 C");
        } else {
            System.out.println("con2의 값은 A,B,C가 아닙니다.");
        }

        //switch 문
        switch (con2) {
            case 'A':
                System.out.println("con2의 값은 A");
                break;
            case 'B':
                System.out.println("con2의 값은 B");
                break;
            case 'C':
                System.out.println("con2의 값은 C");
                break;
            default:
                System.out.println("con2의 값은 A,B,C가 아닙니다.");
        }

        //예외 처리(try-catch 문)
        try {
            String str1 = null;
            System.out.println(str1.toString());
        } catch (Exception e) {
            System.out.println("예외 발생");
        }

    }
}
