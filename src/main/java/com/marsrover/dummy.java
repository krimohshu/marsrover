package com.marsrover;

public class dummy {
    public static void main(String... args) {
        Child a = new Child(10);
        System.out.println(a.input); }
}
class Parent {
    int input = 1;
    public Parent(int input) { input = input;
    } }
class Child extends Parent {

    public Child(int input) {

    super(input); }
}