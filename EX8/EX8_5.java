//Counting digits in a string

import java.util.Scanner;

public class EX8_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter a string: "); //輸入字串
   String s = input.nextLine();
   
   boolean digit = (countDigits(s)>1);//判斷是否大於1 決定是否復數型
   String ss =digit ? "s":"";
   System.out.print("The string has "+countDigits(s)+" digit" + ss); //回傳有幾個數字
  }
  
 public static int countDigits(String s) //計算有幾個數字
  {
   int count = 0; //回傳值

   for(int i = 0;i<s.length();i++)//逐字檢查
    {
     if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
      count++;
    }
   
   return count; //回傳
  }
}

 