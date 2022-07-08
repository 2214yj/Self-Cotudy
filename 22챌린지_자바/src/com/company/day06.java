package com.company;

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/*
6일차 푼 문제: 11718, 1212, 2935, 2754, 3028, 3029, 13984, 17863, 20540, 20944

1. 2진수,8진수,16진수 <-> 10진수 변환하는 법

- 2진수,8진수,16진수 to 10진수
Integer.parseInt(String s, int radix) //문자열 s를 변환할 진수 radix로 읽어서 int로 반환한다.

- 10진수 to 2진수,8진수,16진수 문자열
Integer.toBinaryString(decimal) //10진수를 2진수로 변환
Integer.toOctalString(decimal)  //10진수를 8진수로 변환
Integer.toHexString(decimal)    //10진수를 16진수로 변환

2. DATE 자료형과 format.parse
=> 시간 계산 문제에서 Date 등의 시간 자료형을 사용해서 계산하면 코드를 단축시킬 수 있음
- String To Date
Ex)
String from = "2018-09.06 11:11:11";
SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date to = fm.parse(from);

- Date To String
Ex)
Date from = new Date();
SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String to = fm.format(from);
 */
public class day06 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String mbti = br.readLine();
        if (mbti.charAt(0) == 'I') bw.write('E');
        else bw.write('I');
        if (mbti.charAt(1) == 'S') bw.write('N');
        else bw.write('S');
        if (mbti.charAt(2) == 'F') bw.write('T');
        else bw.write('F');
        if (mbti.charAt(3) == 'J') bw.write('P');
        else bw.write('J');

        bw.flush();
        bw.close();
        br.close();
    }

}
