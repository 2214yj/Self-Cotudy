package com.company;

import java.util.Scanner;

/*
4일차 푼 문제들: 1008, 1330, 2753, 9498, 2438, 2439, 2739, 2741, 2742, 2884, 10818

1. 자바 입력 복습 - Scanner, InputStream, BufferedReader
https://st-lab.tistory.com/41
- InputStream과 System.in
스트림이란? 출발지와 도착지를 이어주는 빨대. 데이터의 흐름. 스트림은 단방향이기 때문에 입력과 출ㄹ력이 동시에 발생할 수 없다.
그렇기 때문에 용도에 따라 입력스트림, 출력스트림이 나뉜다. 그리고 자바에서 가장 기본이 되는 입력 스트림은 InputStream
System 클래스의 in이라는 필드는 InputStream의 정적 필드이다. => Scanner(System.in)은 입력 바이트 스트림인 InputStream을 통해 표준 입력을 받으려는 것을 알 수 있다.
(주의사항. Scanner나 System.out.print 메소드 등의 경우, 해당 메소드 안에서 자체적으로 예외처리를 해주기 때문에 별도의 예외처리를 하지 않아도 된다.
반면에, java.io 입출력 패키지는 IOException 예외를 던지기 때문에 이에 대한 예외 처리를 해주어야 정상적으로 컴파일된다.)

- Scanner(System.in)과 InputStreamReader()
InputStremReader란 무엇일까? 위의 InputStream의 경우, 입력받은 데이터는 int형으로 저장되고 이는 10진수의 UTF-16값으로 저장되며 1byte만 읽는다.
따라서 InputStream.read()를 통해 입력을 받으려고 해도 1byte만 인식하기 때문에 한글 등의 문자를 온전히 읽어들일 수 없다.
InputStreamReader()는 문자를 온전히 읽어들이기 위해 확장시킨 것이다. InputStream의 바이트 단위로 읽어 들이는 형식을 문자단위 데이터로 변환시키는 중개자 역할을 한다.
따라서 InputStreamReader을 문자스트림이라고 한다.
즉, InputStream의 특징은 다음과 같다.
1. 바이트 단위 데이터를 문자(character) 단위 데이터로 처리할 수 있도록 변환해준다.
2. char 배열로 데이터를 받을 수 있다.

Scanner의 코드를 뜯어보면 정규식을 과도하게 많이 검사한다. 덕분에 타입 변환의 안정성이 매우 뛰어나지만 속도가 느리다)
그동안 Scanner의 생성자와 메소드 nextInt() 의 과정을 보면 아래와 같이 해석할 수 있다.
1. InputStream (바이트스트림) 을 통해 입력 받음
2. 문자로 온전하게 받기 위해 중개자 역할을 하는 InputStreamReader(문자스트림) 을 통해 char 타입으로 데이터를 처리함
3. 입력받은 문자는 입력 메소드( next(), nextInt() 등등.. ) 의 타입에 맞게 정규식을 검사함
4. 정규식 문자열을 Pattern.compile() 이라는 메소드를 통해 Pattern 타입으로 변환함
5. 반환된 Pattern 타입을 String으로 변환함
6. String 은 입력 메소드의 타입에 맞게 반환함 ( nextInt() - Integer.parseInt() / nextDouble() - Double.parseDouble() 등등.. )

- BufferedReader()

2. Arrays.sort
 */
public class day04 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        int min = 1000001;
        int max = -1000001;
        for(int i = 0; i<input.length; i++){
            input[i] = sc.nextInt();
            if(input[i] <min){
                min = input[i];
            }
            if(input[i] > max){
                max = input[i];
            }
        }
        System.out.println(min+ " "+ max);




    }
}
