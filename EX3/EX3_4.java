//learning addition

import java.util.Scanner;

public class EX3_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   //�H�{�b�ɶ����ͨ�Ӥp��100�o��
   int number1 = (int)(System.currentTimeMillis()%100);
   int number2 = (int)(System.currentTimeMillis() *7 % 100);

   System.out.print("What is " + number1+" + "+number2 +"? ");
   int answer = input.nextInt(); //��J����

   //��ܵ��G
   System.out.println(number1 + " + "+ number2 + " = "+ answer + " is "+(number1+number2==answer));
  }
}