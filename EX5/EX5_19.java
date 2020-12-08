//求ISBN

import java.util.Scanner;

public class EX5_19
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
   
   System.out.print("Enter a ISBN number: "); //輸入ISBN碼首九位
   int ISBN = input.nextInt();

   System.out.print("The ISBN is: "+getISBN(ISBN));//顯示
  }

 public static String getISBN(int isbnFirstNineDigits)
  {
   String ISBN = "";
   int sum = 0;

   if(isbnFirstNineDigits /(int)(Math.pow(10,8)) == 0) //如果最前面是零 就先加零
    {
     ISBN += "0";
     ISBN += isbnFirstNineDigits;
    }
   else //否則直接加
    {
     ISBN += isbnFirstNineDigits;
    }
 
   for(int i = 9;i>=1;i--) //運算
    {
     sum += (isbnFirstNineDigits % 10)*i;
     isbnFirstNineDigits /= 10;
    }

   sum %= 11;

   if(sum == 10) //如果餘數是十 加X
    ISBN += 'X';
   else
    ISBN += sum;

   return ISBN;
  }
}