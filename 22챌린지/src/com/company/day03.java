package com.company;

import java.math.BigInteger;
import java.util.*;

/* 3일차 푼 문제: 15740, 15964, 2475, 2920, 2908, 1157, 2675, 3052, 10809, 1152
1. 다양한 입력 방법
-Scanner
.next() => 공백 전까지 문자열로 읽음
.nextLine() => '\n'을 포함하는 한 줄을 앍고 '\n'을 버린 나머지 문자열 리턴

-BufferReader
Scanner보다 실행 속도가 빠르다. 따라서 알고리즘에서 자주 사용됨.


2. String, StringBuffer, StringBuilder
- String => 불변! String 클래스는 불변하기 때문에 문자열을 수정하는 시점에 새로운 String 인스턴스가 생성된다.
기존 String을 수정하면 String이 새로운 메모리 영역을 가리키게 변경되고 처음 선언했던 값이 할당되어 있던 메모리 영역은 가비지로 남아있다가 가비지 콜렉션에 의해 사라지게 된다.
따라서, 불변하는 문자열을 자주 읽어들이는 경우 String을 사용하는 게 좋다.
문자열 추가, 수정, 삭제 등의 연산이 빈번하게 발생하는 알고리즘에 String 클래스를 사용하면 힙 메모리에 많은 임시 가비지가 생성되어 힙메모리 부족으로 어플리케이션 성능에 치명적인 영향을 끼치게 된다.


- 이를 해결하기 위해 Java는 가변성을 가지는 StringBuffer, StringBuilder 클래스를 도입했다.
가변성을 가지기 때문에 append() ,delete() 등의 API를 이용하여 동일 객체 내에서 문자열을 변경하는 것이 가능하다.
따라서 문자열의 추가,수정,삭제가 빈번하게 발생하는 경우라면 StringBuffer/StringBuilder를 사용하는 것이 좋다.

- StringBuffer와 StringBuilder의 차이점은 동기화의 유무이다.
StringBuffer는 동기화 키워드를 지원하여 멀티쓰레드 환경에서 안정하다. (String도 불변성을 가지기 때문에 멀티쓰레드 환경에서 안정하다)
반대로 StringBuilder는 동기화를 지원하지 않기 때문에 멀티쓰레드 환경에서 사용하는 것은 적합하지 않지만 동기화를 고려하지 않는 만큼 단일 쓰레드에서의 성능은 StringBuffer보다 뛰어나다.

결론
String : 문자열 연산이 적고 멀티쓰레드 환경일 경우
StringBuffer : 문자열 연산이 많고 멀티쓰레드 환경이 경우
StringBuilder 문자열 연산이 많고 단일쓰레드이거나 동기화를 고려하지 않아도 되는 경우

3. split 주의 사항
split(String regex);
 -> 구분자를 바탕으로 배열 형식으로 문자열을 잘라줍니다
split(String regex, int limit);
 -> 위와 마찬가지로 구분자를 바탕으로 배열 형식으로 문자열을 자르지만 limit 수만큼 잘라줍니다

출처: https://crazykim2.tistory.com/549 [잡다한 프로그래밍]
매칭되는 정규식이 없을 경우 자기 자신을 반환
https://st-lab.tistory.com/65

4. String Tokenizer
토큰은 분리된 문자열 조각으로, 하나의 문자열으 여러 개의 토큰으로 분리하는 클래스

사용법
StringTokenizer st = new StringTokenizer(문자열);  //띄워쓰기 기준으로 문자열을 분리
StringTokenizer st = new StringTokenizer(문자열,구분자);  //구분자를 기준으로 문자열을 분리
StringTokenizer st = new StringTokenizer(문자열,구분자,true/false);   //구분자를 기준으로 문자열을 분리할 때 구분자도 토큰애 포함시킬지(true), 안포함시킬지(false)
st.nextToken()  //분리된 토큰을 불러오는 함수
st.hasMoreTokens()  //남아있는 토큰이 있으면 true, 더이상 토큰이 없으면 false 리턴
st.countTokens()    //총 토큰의 개수를 리턴

- StringTokenizer와 Split의 차이
StringTokenizer는 java.util에 포함되어 있는 클래스, split은 String 클래스에 속해 있는 메소드이다.
StringTokenizer는 문자 또는 문자열로 문자열을 구분한다면, split은 정규 표현식으로 구분한다.
StringTokenizer는 빈 문자열을 토큰으로 인식하지 않지만 split은 빈 문자열을 토큰으로 인식한다.
StringTokenizer는 결과값이 문자열이라면 split은 결과값이 문자열 배열이다. 따라서 StringTokenizer를 사용할 경우, 전체 토큰을 보기 위해 반복문을 이용해서 하나하나 뽑을 수 밖에 없다.
split은 배열에 담아 반환해주기 때문에 데이터를 바로바로 잘라서 반환해주는 stringtokenizer보다 성능이 약간 뒤쳐진다.
 */
public class day03 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] split = str.split(" ");

        if(str.equals(" ")){
            System.out.println("0");
        } else if((str.charAt(0) == ' ')){
            System.out.println(split.length-1);
        }else if(split[0].equals(str)){
            System.out.println("1");
        }else{
            System.out.println(split.length);
        }
    }



}
