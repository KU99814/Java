import java.util.Scanner;

public class EX3_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
 
   //�H�����ͤT�Ʀr
   int number1 = (int)(Math.random()*50);
   int number2 = (int)(Math.random()*50);
   int number3 = (int)(Math.random()*50);

   System.out.print("What is "+number1+" + "+number2 + " + "+number3+" =? ");
   int answer = input.nextInt(); //��J����

   //���T��ܵ���
   if(number1 + number2 + number3 == answer)
     System.out.println("You are corrent!");
   else //���~��ܥ��T����
     System.out.println("Your answer is wrong.\n" + number1 + " + "
               + number2 + " + "+ number3+" should be "+ (number1 + number2 + number3));
  }
}