//�Q�i����G�i��

import java.util.Scanner;

public class EX5_11
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter an integer: ");   //��J�Q�i���
   int decimal = input.nextInt();

   System.out.print("It's Binary number is:"+toBinary(decimal));  //��ܤG�i���
  }

 //�Q�i����G�i�method
 public static String toBinary(int decimal)
  {
   String binary = ""; //�^�Ǫ��r��

   while(true)//�B��
    {
     binary = (decimal%2)+binary; //�N�l�ƥ[��r��
     if(decimal==1 || decimal == 0)
      break;
     decimal/=2; //���H2
    }
   return binary;
  }
}
 