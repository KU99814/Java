//processing scores in a text file

import java.util.Scanner;

public class EX8_18
{
 public static void main(String args[]) throws Exception
  {
   java.io.File file = new java.io.File(args[0]); //�bcmd��J�ɦW

   Scanner input = new Scanner(file); //�ŧi��J
  
   int total = 0; //�`��
   int count = 0; //�p��Ӽ�

   while(input.hasNext())//�q�ɮ׿�X
    {
     int num = input.nextInt();

     total += num;
     count++;
    }     
   
   double average;
   if(count>0)
    average = total/count;//����
   else
    average = 0;
   
   System.out.println("The total score is "+total);
   System.out.print("The average is "+average);
  }
}