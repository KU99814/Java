//��J��r�� ��ܤ������r��

import java.util.Scanner;

public class EX5_12
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter first char: "); //��J�Ĥ@�Ӧr��
   String c1 = input.next();
   char ch1 = c1.charAt(0);   //�ഫ
 
   System.out.print("Enter second char: "); //��J�ĤG�Ӧr��
   String c2 = input.next();
   char ch2 = c2.charAt(0);  //�ഫ
 
   printChars(ch1,ch2,10);  //��X
  }
 
 //�̧ǿ�X�r����method
 public static void printChars(char ch1,char ch2,int numberPerLine)
  {
   int c1 = (int)ch1;  //����r���ഫ���Ʀr
   int c2 = (int)ch2;
   int count = 1;  //����
   
   for(int i = c1;i<=c2;i++) //�qC1��C2�̧ǿ�X
    {
     if(count%numberPerLine==0)
      System.out.println((char)(i));
     else
      System.out.print((char)(i));
     count++;
    }
  }
}