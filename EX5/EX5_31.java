//Financial: credit card number validation

import java.util.Scanner;

public class EX5_31
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//块

   System.out.print("Enter your credit card number: ");
   long number = input.nextLong(); //块腹 4388576018402625 invalid 4388576018410707 valid

   //浪琩琌Τ
   System.out.print("This number is "+isValid(number));
  }

 //浪琩琌Τmethod
 public static boolean isValid(long number)
  {
   long num = number;
   while(true)//浪琩秨繷琌猭 腹计ぃ㏕﹚ 癹伴ъ繷
    {
     num /=10;
     if(num==37 || num == 4 || num == 5 || num == 6)
      break;
     if(num==0)
      return false;
    }
   int sum = sumOfEvenPlace(number) + sumOfOddPlace(number);//盢计籔案计挡狦
   
   if(sum%10 == 0)//浪琩挡狦
    return true;
   else
    return false;
  }

 //案计
 public static int sumOfEvenPlace(long number)
  {
   int even = 0;

   number/=10;
   while(number!=0)
    {
     int num =(int)(number%10);
     num *= 2;//案计2

     if(num>=10) //10计
      num = getDigit(num);
     even += num;
     number /= 100;
    }
   
   return even;
  }

 //ㄢ
 public static int getDigit(int number)
  {
   int num = number/10 + number%10;
   return num;
  }

 //计
 public static int sumOfOddPlace(long number)
  {
   int odd = 0;

   while(number!=0)
    {
     int num = (int)(number%10);
     odd += num;
     number /= 100;
    }

   return odd;
  }
}     