//Ū���ɮ� �s�J�}�C�ƦC

import java.util.Scanner;

public class EX6_7
{
 public static void main(String args[]) throws Exception
  {
   java.io.File file = new java.io.File("EX6_7.txt");//�nŪ�����ɮ�

   Scanner input = new Scanner(file); //Ū��

   int[] num = new int[100];

   for(int i=0;input.hasNext();i++) //�g�J�}�C
    num[i] = input.nextInt();
   
   for(int i=0;i<100;i++) //�H���ƦC
    {
     int ran1 = (int)(Math.random()*100);
     int ran2 = (int)(Math.random()*100);
     int temp = num[ran1];
     num[ran1] = num[ran2];
     num[ran2] = temp;
    }

   input.close();   

   java.io.PrintWriter output = new java.io.PrintWriter(file); //��X�ɮ�

   for(int i=0;i<100;i++)
    output.println(num[i]);

   output.close();
  }
}    