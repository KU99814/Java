//Game:multiply three numbers

import java.util.Scanner;

public class EX3_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
   
   //�H�{�b�ɶ����ͤT�Ӽ�
   int number1 = (int)(System.currentTimeMillis() % 10);
   int number2 = (int)(System.currentTimeMillis() *7 % 10);
   int number3 = (int)(System.currentTimeMillis() *9 % 10);
  
   System.out.print("What is " + number1 + " * " + number2 + " * " +number3+" = " +" ? ");
   int answer = input.nextInt(); //��J�T�Ƭۭ�����

   //��ܵ��׬O�_���T
   System.out.println(number1 + " * " + number2 + " * " + number3 + " = " + answer +
                      " is " +(number1*number2*number3==answer));
  }
}