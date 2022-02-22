package com.company;

import java.util.Scanner;

//1일차 푼 문제: 1000, 1001, 10998
public class day01 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            System.out.println(num1 + num2);
            System.out.println(num1 - num2);
            System.out.println(num1 * num2);
            System.out.println(num1 / num2);
        }

    }
}
