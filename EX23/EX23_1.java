//Maximum consecutive sorted substring
//T(n) = O(n)

import java.util.*;

public class EX23_1
{
 public static void main(String ars[])
  {
   Scanner input = new Scanner(System.in); //輸入宣告

   System.out.print("Enter a string:");
   String s = input.next();//ex:"abacdefkabfh" 

   String ss = ""+s.charAt(0);//尋找用字串
   String max = "";//最大字串
   
   for(int i=1;i<s.length();i++)
    {
     char c = s.charAt(i);//從原字串取出一字
     //跟ss最後一字比大小
     if(ss.charAt(ss.length()-1)>c)//若比這一字大 
      {
       if(max.length()<ss.length())//比較目前最大字串 若更長 取代
        max = ss;
       ss = ""+c;//從這一字開始重找
      }
     else//若比較小
      {
       ss+=c;//加在後面
      }  
    }

   if(max.length()<ss.length())//迴圈完後再比較一次
    max = ss;

   System.out.print(max);//顯示
  }
}