//����Ʀr

import java.util.Scanner;

public class EX5_1
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter a number: ");
   int number = input.nextInt();//��J�Ʀr
   
   reverse(number);//����
  }

 //���઺method
 public static void reverse(int number)
  {
   while(true)
    {
     System.out.print(number%10); //��̫ܳ�@�Ӽ�
     number /= 10; // �Ʀr�k��
     
     if(number == 0)  //�p�G0����
      break;
    }
  }
}