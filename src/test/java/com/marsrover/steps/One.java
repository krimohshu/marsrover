package com.marsrover.steps;

class One
{ 
  void m1() 
  { 
     System.out.println("m1 method in class One"); 
   } 
 } 
class Two extends One
{ 
  void m2() 
  { 
     System.out.println("m2 method in class Two"); 
   } 
 } 
class Test
{ 
  public static void main(String[] args) 
  { 
     Two o = new Two();
       o.m1(); 
       o.m2();  
   } 
 }