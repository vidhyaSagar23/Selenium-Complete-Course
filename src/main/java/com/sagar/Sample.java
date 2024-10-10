package com.sagar;

public class Sample {

    public String name;
    public int age;

    public Sample(String name, int age){
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Sample s1 = new Sample("stephin", 24);
        System.out.println(s1);

        Sample s2 = new Sample("sagar", 23);
        System.out.println(s2);
        System.out.println(s1);

        System.out.println(s1);
    }

    @Override
    public String toString(){
        return name + " " + age;
    }
}
