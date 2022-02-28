package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
/*
7일차 푼 문제들: 13297, 16316, 16408, 21553, 23343, 1008, 9498, 1330,  2753, 14681, 10797, 10162

BufferWriter로 int형 출력하기 위해서는 String으로 형변환을 해줘야 한다. int형을 그대로 write메소드의 인자값으로 전달하면 write 메소드 내에서 입력받은 인자값을 char형으로 바꾸기 때문에 의도하지 않은 문자가 출력된다.
Ex) bw.write(String.valueOf(array[i]));

 */
public class day07 {

    public static void main(String args[]) throws IOException {
       Scanner sc = new Scanner(System.in);
       int A = sc.nextInt();
       int k = A%10;
       if(k !=0){
           System.out.println("-1");
       }else{
           System.out.println(A/300+" "+ (A%300)/60+" "+((A%300)%60)/10);
       }

    }
}
