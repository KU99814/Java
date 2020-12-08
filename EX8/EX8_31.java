//checking ISBN
//test 013605966-X

import java.util.Scanner;

public class EX8_31
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter an ISBN: "); //輸入ISBN
   String isbn = input.next();
   
   int d10 = 0;
   for(int i=0;i<isbn.length();i++)
    d10 += (i+1)*Integer.parseInt(String.valueOf(isbn.charAt(i)));//轉為int運算
   
   d10%=11;

   //算出d10
   if(d10 == 10)
    {
     isbn += "X";
    }
   else
    isbn += String.valueOf(d10);
   //顯示
   System.out.print("The ISBN is "+isbn);
  }
}