//�ഫ�@����:��:��

import java.util.Scanner;

public class EX5_25
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter a milliseconds: "); //��J
   long millis = input.nextLong();
   
   System.out.print("The time is "+convertMillis(millis)); //���
  }

 //�N�@���ഫ���ɤ���method
 public static String convertMillis(long millis)
  {
   String time = null;

   int totalseconds = (int)(millis/1000); //�@���ഫ����

   int second = totalseconds%60; //�ഫ��
   
   totalseconds/=60;
   int minute = totalseconds%60; //�ഫ��

   int hours = totalseconds/=60; //�ഫ�p��
 
   time = hours+":"+minute+":"+second;

   return time;
  }
}