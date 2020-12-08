//using ArrayList

import java.util.*;
import javax.swing.*;

public class EX10_6
{
 public static void main(String args[])
  {
   java.util.ArrayList list = new java.util.ArrayList();//宣告一個Array List
   
   //放入物件
   list.add(new Loan());
   list.add(new Date());
   list.add(new JFrame());
   list.add(new Circle());
   
   //依序顯示
   for(int i=0;i<list.size();i++)
    System.out.println(list.get(i).toString()+" ");
  }
}

//借貸class
class Loan
{
 private double annualInterestRate; //年利率
 private int numberOfYears; //年數
 private double loanAmount; //貸款額度

 //建構子
 public Loan()
  {
   this(0.5,1,1000);
  }
 
 public Loan(double annualInterestRate,int numberOfYears,double loanAmount)
  {
   this.annualInterestRate = annualInterestRate;
   this.numberOfYears = numberOfYears;
   this.loanAmount = loanAmount;
  }

 //顯示內容
 public String toString()
  {
   return "Loan "+annualInterestRate +" " + numberOfYears +" "+loanAmount ;
  }
}

//圓的class
class Circle
{
 private double radius;//半徑
 
 //建構子
 public Circle()
  {
   this(1.0);
  }

  public Circle(double radius)
  {
   this.radius = radius;
  }

 //顯示
 public String toString()
  {
   return "Circle "+radius;
  }
}