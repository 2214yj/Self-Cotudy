package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
5일차 푼 문제: 2752, 2959, 13771, 2309, 5576, 9076, 16770, 20650, 13771, 19604
1. 문자열 자르기 split과 substring 그리고 StringTokenizer
- split과 substring 누가 더 빠를까?
split의 경우, Pattern.compile 객체를 new로 생성하여 문자열을 자른다. 또한 결과값을 String[] 배열에 받아오기 때문에, String 배열 또한 생성해야 함으로 더 느려진다.
substring은 String의 value[]라는 배열을 참도하여, offset(순번)과 count(총 개수)만을 가지고 있기 때문에 split보다 빠르다.

- split과 StringTokenizer 누가 더 빠를까?
경우에 따라 다르다. 구분자, 유니코드 여부, 해당 클래스의 메소드 호출 횟수 등에 따라 다르다.
그러나 공식 문서에 따르면 StringTokenizer는 레거시 클래스라고 한다. 따라서, 이왕이면 split을 사용하는 게 좋아보인다.

- 추가로 split과 StringTokenizer의 차이점
split은 String 클래스에 속해있고 StringTokenizer는 java.util에 포함되어 있다.
split은 정규 표현식으로 구분하고 StringTokenizer는 문자로 구분한다.
split은 빈문자열을 토큰으로 인식하는 반면 StringTokenizer는 빈 문자열을 토큰으로 인식하지 않는 차이점이 있다.
split의 결과값은 문자열 배열이지만 StringTokenizer는 문자열이다.
https://jhnyang.tistory.com/336

2. sort 배열 정렬에서 conparator, comparable 이용하기
- Interface Comparable
기본 정렬기준을 구현하는 데 사용.
정렬 수행 시 기본적으로 적용되는 정렬 기준이 되는 메서드를 정의하는 인터페이스이다.
Java에서 제공되는 정렬이 가능한 클래스들은 모두 Comparable 인터페이스를 구현하고 있다. (Ex) Integer 클래스 => 오름차순 정렬, String 클래스 => 사전순 정렬)
구현 방법:
정렬할 객체에 Comparable interface를 inplements한 후, compareTo() 메서드를 오버라이드하여 구현한다.
compareTo() 메서드 작성법:
    현재 객체 < 파라미터로 넘어온 객체: 음수 리턴
    현재 객체 == 파라미터로 넘어온 객체: 0 리턴
    현재 객체 > 파라미터로 넘어온 객체: 양수 리턴
    음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.

- Interface Comparator
기본 정렬 기준 외에 다른 기준으로 정렬하고자할 때 사용.
정렬 가능한 클래스들의 기본 정렬 기준과 다르게 정렬하고 싶을 때 사용하는 인터페이스. 보통 내림차순으로 정렬할 때 많이 사용한다.
구현 방법:
Comparator Interface를 implements 후 compare() 메서드를 오버라이드한 myComparator class를 작성한다.
Compare() 메서드 작성법:
    첫번째 파라미터로 넘어온 객체 < 두번째 파라미터로 넘어온 객체: 음수 리턴
    첫번째 파라미터로 넘어온 객체 == 두번째 파라미터로 넘어온 객체: 0 리턴
    첫번째 파라미터로 넘어온 객체 > 두번째 파라미터로 넘어온 객체: 양수 리턴
    음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 변경된다.
Comparator 객체는 메서드가 하나뿐인 함수형 인터페이스를 구현하기 때문에 람다 함수로 대체가 가능하다.

- 번외. Arrays.sort()와 Collections.sort()
Arrays.sort()는 배열 정렬의 경우에 사용. Collctions.sort()는 List Collection(ArrayList, LinkedList, Vector 등) 정렬의 경우에 사용.
Wrapper 타입의 내림차순 배열의 경우 Collections.reverseOrder() 옵션을 줘서 구현 가능.

3. BufferedReader,BufferWriter 사용하기
- BufferReader
BufferedReader는 버퍼를 이용하여 한번에 데이터를 입력하기 때문에 메모리 관리가 더욱 용이하다.
따라서, 입력받는 값이 많고 테스트 케이스가 많은 경우 Scanner보단 BufferedReader를 활용하는 것이 좋다.
(   Stream으로 끝나는 클래스 : 바이트 단위로 입출력을 수행하는 클래스
    Reader / Writer로 끝나는 클래스 : 캐릭터 단위로 입출력을 수행하는 클래스
    File로 시작하는 클래스 : 하드디스크의 파일을 사용하는 클래스
    Data로 시작하는 클래스 : 자바의 원시 자료형을 출력하기 위한 클래스
    Buffered로 시작하는 클래스 : 시스템의 버퍼를 사용하는 클래스 )

주요 메소드:
read()  //스트림으로부터 한 문자를 읽어서 int 형으로 리턴
read(char[] buf)    //스트림으로부터 buf의 크기만큼 문자를 읽음. 문자 수 리턴.
read(char[] buf, int offset, int length)    //스트림으로부터 buf의 offset 위치에서부터 length 길이만큼 문자를 읽어들임.

readLine()  //스트림으로부터 한 줄을 읽어 문자열로 리턴. 만약 stream의 끝에 다다르면 (EOF)null값을 반환한다.
mark()  //스트림의 현재위치를 마킹, 차후 reset()을 이용하여 마킹위치부터 시작.
reset() //마킹이 있으면 그 위치부터, 없으면 처음부터 다시 시작.
skip(int n) //n개의 문자를 건너 뜀.

사용 예시:
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String str - br.readLine();

- BufferWriter
이 역시 많은 양의 출력에서 효율적일 수 있다.
사용 예시:
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

주요 메소드:
writer(str)  //출력
newLine()   //개행
flush()    //남아 있는 데이터 모두 출력
close() //스트림 닫기

4. java.util.Scanner 클래스의 useDelimiter 메서드
Scanner는 정규식 표현을 이용한 라인단위의 검색을 지원하며 구분자(delimiter)에도 정규식을 표현할 수 있어서 복잡한 형태의 구분자도 처리 가능하다.
Ex) new Scanner(System.in).useDelimiter("구분자")
 */

public class day05 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[][] = new int[2][n];
        for(int i = 0; i<n; i++){
            String s = sc.next();
            input[0][i] = Integer.parseInt(s.substring(0,2));
            input[1][i] = Integer.parseInt(s.substring(3,5));

        }
        Arrays.sort(input[0]);
        Arrays.sort(input[1]);
        System.out.println((input[0][0]-1)+","+(input[1][0]-1));
        System.out.println((input[0][n-1]+1)+","+(input[1][n-1]+1));

    }
}
