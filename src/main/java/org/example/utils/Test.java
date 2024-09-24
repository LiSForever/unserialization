package org.example.utils;


public class Test {
    static {System.out.println("Test static{}");}
    {System.out.println("Test{}");}
    public Test(){
        System.out.println("Test()");
    }
    public static void main(String[] args) {
        System.out.println("main()");
    }
}
