package com.hw;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class StringUse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] comData = Arrays.stream(sc.nextLine().split("")).map(String::toLowerCase).toArray(String[]::new);
        String data=sc.nextLine().toLowerCase();
        int length=0;
        for(String s:comData){
            if(s.equals(data)){
                length++;
            }
        }
        System.out.println(length);
    }
}
