package com.marsrover.steps;



class Main
{
    public static void main(String[] args)
    {
        Base b =  new Derived();
        b.show();
        System.out.println();
    }
}