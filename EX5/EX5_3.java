//大小寫轉換

import java.util.Scanner;

public class EX5_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter a lowercase letter: ");
   String s =  input.nextLine(); //先以字串方式輸入
   char ch = (char)(s.charAt(0)); //轉換char

   System.out.print("The uppercase letter is "+lowerCaseToUpperCase(ch));
  }
 
 //將小寫轉換成大寫
 public static char lowerCaseToUpperCase(char ch)
  {
   int c = (int)ch;  
   int offset = 'a' - 'A';

   char uppercase = (char)(c - offset);//轉換成大寫
   
   return uppercase;//回傳
  }
}
   