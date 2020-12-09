//Number format exception

import java.util.Scanner;

public class EX18_1
{
 public static void main(String args[])
  {
   //在cmd輸入算式
   try{
    int num1 = Integer.parseInt(args[0]);//左值
    char op = args[1].charAt(0);//運算子
    int num2 = Integer.parseInt(args[2]);//右值
    
    int number = 0;//結果
 
    //按加減乘除運算
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
   
    System.out.println(num1 +""+op+""+num2 +" = "+number);//顯示算式與結果
   }
  catch(ArrayIndexOutOfBoundsException ex)//輸入錯誤例外
   {
    System.out.println("please use java operand1 operator operand2");
   }
  catch(NumberFormatException ex)//格式不符例外
   {
    System.out.print("Wrong Input, "+ex.getMessage());//顯示錯誤字符
   }
 }
}