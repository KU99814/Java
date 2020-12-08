//Funancial: credit card number validation

import java.util.Scanner;

public class EX8_30
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter your credit card number: ");//輸入卡號
   String number = input.next();

   System.out.print("This number is "+isValid(number));//驗證
  }

 //檢查信用卡是否合法
 public static boolean isValid(String number)
  {
   //檢查開頭
   char head = number.charAt(0);
   System.out.println(head);
   if(head != '4' && head!='5' && head !='6' 
       &&!number.substring(0,2).equals("37"))
     return false;

   int sum = sumOfEvenPlace(number) + sumOfOddPlace(number);//進行運算
   //運算檢查是否合法
   if(sum%10 == 0)
    return true;
   else
    return false;
  }

 //偶位數相加
 public static int sumOfEvenPlace(String number)
  {
   int even = 0;
   int count = number.length()-1;

   count--;//從十位數開始 故先減一
   while(count >= 0)
    {
     int num =Integer.parseInt(String.valueOf(number.charAt(count))); //轉為int
     num *= 2;

     //運算
     if(num>=10)
      num = getDigit(num);
     even += num;
     count -= 2;
    }
   
   return even;
  }

 //兩位相加
 public static int getDigit(int number)
  {
   int num = number/10 + number%10;
   return num;
  }

 //奇位數相加
 public static int sumOfOddPlace(String number)
  {
   int odd = 0;
   int count = number.length()-1;

   while(count >= 0)
    {
     int num = Integer.parseInt(String.valueOf(number.charAt(count)));//取得數字
     odd += num;
     count -= 2;
    }

   return odd;
  }
}     