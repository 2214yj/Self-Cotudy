package com.company;


import java.math.BigInteger;
import java.util.Scanner;

/* 2일차 푼 문제: 2914,1550, 2845, 3003, 5554, 5522, 1271, 16394, 15894, 2338, 16430
1.  Integer.parseInt(String s)   //해당 값을 10진수의 Integer형으로 반환
    Integer.parseInt(String s,[8,10,16])    //해당 값을 [8,10,16]진수 Integer형으로 반환

2. BigInteger
    int의 범위: -2,147,483,648 ~ 2,147,483,647
    long의 범위: -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
    BigInteger은 문자열 형태로 이루어져 있어 숫자의 범위가 무한하기에 어떤 숫자든지 담을 수 있다.

    BigInteger 사용법
    BigInteger bigNum = new BigInteger("1000000000");   //선언
    BigInteger.add(m) ,subtract(m) ,multiply(m) ,divide(m) ,remainder(M)    //사칙연산
    BigInteger.intValue() ,longValue(), floatValue() ,doubleValue() ,toString() //형 변환

    BigInteger 두 수 비교
    BigInteger.compareTo(m) //맞으면 0 반환, 틀리면 -1 반환

 */
public class day02 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.print(B - A);
        System.out.println(" " + B);

    }
}

