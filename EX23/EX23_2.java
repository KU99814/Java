//Maximum sorted subsequence
//T(n) = O(n^2)

import java.util.*;

public class EX23_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   //輸入字串
   System.out.print("Enter a string:");
   String s = input.next();

   int length = s.length();//字串長度

   List<String> lStr = new ArrayList<String>();//儲存所有子序列

   int max = 0;//最大長度

   //迴圈找出所有依序子字串
   for(int i= 0;i<length;i++)
    {
     char c = s.charAt(i);//取出一個字
     for(int j= 0;j<lStr.size();j++)//依序尋訪子序列
      {
       String as = lStr.get(j);//取出子序列
       if(as.charAt(as.length()-1)<c) //若符合順序 加入尾部
        {
         String newS = as + c;
         lStr.add(newS);
         if(newS.length()>max)//計算長度是否最大
          max = newS.length();
        }
       }
      lStr.add(c+"");//將字母加入成新序列
     }
   
   //顯示
   for(int i=0;i<lStr.size();i++)
    {
     if(lStr.get(i).length()==max)//找出最長序列後跳出
      {
       System.out.println(lStr.get(i));
       break;
      }
    }
  }
}