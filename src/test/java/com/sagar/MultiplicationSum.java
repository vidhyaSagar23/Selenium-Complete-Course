package com.sagar;

import java.util.ArrayList;
import java.util.List;

 class MultiplicationSum {
    public static void main(String[] args) {
        List<Integer> four = new ArrayList<>();
        List<Integer> five = new ArrayList<>();
        for(int i = 1; i <= 10 ;i++){
            four.add(i*4);
        }
        for(int i = 1; i <= 10 ;i++){
            five.add(i*5);
        }

        int sum =0;

        for(Integer i: four){
            if (five.contains(i)){
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }
}
