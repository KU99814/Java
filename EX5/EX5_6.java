//�Ʀ��T����

import java.util.Scanner;

public class EX5_6
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter a number of lines: "); //��J���
   int number = input.nextInt();

   displzyPattern(number);  //���
  }

 //��ܪ��r��method
 /*
           1
         2 1
       3 2 1
   ...
  */
 public static void displzyPattern(int n)
  {
   //r = row c = cloumn
   for(int r = 1;r<=n;r++)  //�ե�
    {
     for(int c=n;c>=1;c--)
      {
       if(c-r>0) //��ܪŮ�
        {
         if(c>=10)
          System.out.print("  ");
         else
          System.out.print(" ");
        }
       else //��ƻP��ܼƦr�ۦP�ɶ}�l��ܼƦr
        System.out.print(c);
       
       System.out.print(" ");
      }
     System.out.println();
    }
  }
}