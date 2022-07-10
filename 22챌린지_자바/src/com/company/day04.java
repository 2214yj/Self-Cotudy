package com.company;

import java.util.Scanner;

/*
4일차 푼 문제들: 1008, 1330, 2753, 9498, 2438, 2439, 2739.py, 2741, 2742, 2884, 10818

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
BufferedReader도 카찬가지로 inputStream을 통해 바이트 단위로 데이터 입력을 받고 입력 데이터를 char 형태로 처리하기 위해 중개자 역할인 문자스트림 InputStreamReader로 감싸준다.
그러면 BufferedReader는 왜 필요할까?
InputStreamReader는 '문자'를 처리하기 때문에 Scanner의 경우, 내부에서 임시 배열을 두어 문자열처럼 사용하고 있다.
이 때문에 문자열을 입력하고 싶다면 매번 배열을 선언해야 하고 입력받을 문자열의 길이가 가변적이라면 더욱 불편하다.
그래서 쓰는 것이 Buffer를 통해 입력받은 문자를 쌓아둔 뒤 한 번에 문자열처럼 보내버리는 것이다.
BufferedReader를 사용할 때 우리는 입력 메소드로 readLine()을 많이 쓴다. 이 메소드는 한 줄 전체(공백 포함)를 읽기 때문에 char 배열을 하나하나 생성할 필요 없이 String으로 리턴하여 바로 받을 수 있다는 장점이 있다.

따라서, 다음과 같이 볼 수 있다.
Byte Type = InputStream
Char Type InputStreamReader
Char Type의 직렬화 = BufferedReader

BufferedReader의 특징은 다음과 같다.
1. 버퍼가 있는 스트림이다.
2. 별다른 정규식을 검사하지 않는다.
즉, 이 두개의 특징 덕분에 Scanner에 비해 성능이 우수할 수 밖에 없다.

결론 마무리.
1. InputStream 은 바이트 단위로 데이터를 처리한다. 또한 System.in 의 타입도 InputStream 이다.
2. InputStreamReader 은 문자(character) 단위로 데이터를 처리할 수 있도록 돕는다. InputStream 의 데이터를 문자로 변환하는 중개 역할을 한다.
3 BufferedReader 은 스트림에 버퍼를 두어 문자를 버퍼에 일정 정도 저장해둔 뒤 한 번에 보낸다.

=> 자바 알고리즘에서 Scanner를 굳이 써야 할 의미가 없다.(input이 대부분 주어지는 조건에 맞는 입력만 주어지기 때문에)
BufferedReader을 통해 문자열을 받아온 뒤, Ingeger.parseInt90 같은 파싱 함수들을 통해 타입을 변환해주는 것이 성능 경쟁 알고리즘에서는 훨씬 선호될 수 밖에 없다.

2. Arrays 클래스
http://www.tcpschool.com/java/java_api_arrays

Arrays 클래스는 배열을 다루기 위한 다양한 메소드가 포함되어 있다. Arrays 클래스의 모든 메소드는 클래스 메소드(static method)이므로, 객체를 생성하지 않고도 바로 사용할 수 있다.

1. binarySearch()   //전달받은 배열에서 특정 객체의 위치를 이진 검색 알고리즘을 이용하여 검색한 후, 해당 위치를 반환
ex) Arrays.binarySearch(arr, 437)

2. copyOf() //전달받은 배열의 특정 길이만큼 새로운 배열로 복사하여 반환
ex) Arrays.copyOf(arr1, 3)

3. copyOfRange()    //전달받은 배열의 특정 범위에 해당하는 요소만을 새로운 배열로 복사하여 반환.
ex) Arrays.copyOfRange(arr1, 2, 4)  //arr1의 2~3번 인덱스만 복사됨.

4. fill()   //전달받은 배열의 모든 요소를 특정값으로 초기화
ex) Arrays.fill(arr, 7) //arr배열 값을 모두 7로 초기화

5. sort()   //전달받은 배열의 모든 요소를 오름차순으로 정렬
ex) Arrays.sort(arr)    //arr 배열의 모든 요소를 오름차순으로 정렬

이 외에도 Arrays의 대표적인 메소드는
asList(전달받은 배열을 고정 크기의 리스트로 변환하여 반환)
equals(전달받은 두 배열이 같은지를 확인)
등이 있다.

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
