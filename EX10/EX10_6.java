//using ArrayList

import java.util.*;
import javax.swing.*;

public class EX10_6
{
 public static void main(String args[])
  {
   java.util.ArrayList list = new java.util.ArrayList();//�ŧi�@��Array List
   
   //��J����
   list.add(new Loan());
   list.add(new Date());
   list.add(new JFrame());
   list.add(new Circle());
   
   //�̧����
   for(int i=0;i<list.size();i++)
    System.out.println(list.get(i).toString()+" ");
  }
}

//�ɶUclass
class Loan
{
 private double annualInterestRate; //�~�Q�v
 private int numberOfYears; //�~��
 private double loanAmount; //�U���B��

 //�غc�l
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

 //��ܤ��e
 public String toString()
  {
   return "Loan "+annualInterestRate +" " + numberOfYears +" "+loanAmount ;
  }
}

//�ꪺclass
class Circle
{
 private double radius;//�b�|
 
 //�غc�l
 public Circle()
  {
   this(1.0);
  }

  public Circle(double radius)
  {
   this.radius = radius;
  }

 //���
 public String toString()
  {
   return "Circle "+radius;
  }
}