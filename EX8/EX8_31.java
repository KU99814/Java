//checking ISBN
//test 013605966-X

import java.util.Scanner;

public class EX8_31
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter an ISBN: "); //��JISBN
   String isbn = input.next();
   
   int d10 = 0;
   for(int i=0;i<isbn.length();i++)
    d10 += (i+1)*Integer.parseInt(String.valueOf(isbn.charAt(i)));//�ରint�B��
   
   d10%=11;

   //��Xd10
   if(d10 == 10)
    {
     isbn += "X";
    }
   else
    isbn += String.valueOf(d10);
   //���
   System.out.print("The ISBN is "+isbn);
  }
}