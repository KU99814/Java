//Number format exception

import java.util.Scanner;

public class EX18_1
{
 public static void main(String args[])
  {
   //�bcmd��J�⦡
   try{
    int num1 = Integer.parseInt(args[0]);//����
    char op = args[1].charAt(0);//�B��l
    int num2 = Integer.parseInt(args[2]);//�k��
    
    int number = 0;//���G
 
    //���[����B��
    switch(op){
     case '+': number = num1 + num2;
               break;
     case '-': number = num1 - num2;
               break;
     case '*': number = num1 * num2;
               break;
     case '/': number = num1 / num2;
               break;
    }
   
    System.out.println(num1 +""+op+""+num2 +" = "+number);//��ܺ⦡�P���G
   }
  catch(ArrayIndexOutOfBoundsException ex)//��J���~�ҥ~
   {
    System.out.println("please use java operand1 operator operand2");
   }
  catch(NumberFormatException ex)//�榡���Ũҥ~
   {
    System.out.print("Wrong Input, "+ex.getMessage());//��ܿ��~�r��
   }
 }
}