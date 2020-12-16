//Pattern mathching
//T(n) = O(n^2)

import java.util.*;

public class EX23_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //系統輸入

   System.out.print("Enter a text: ");//輸入查找文章
   String text = input.nextLine();
   
   System.out.print("Enter a string: ");//輸入查找字串
   String s = input.next();
   
   int index = match(text,s);//查找

   //按結果顯示
   if(index<0)//若無
    System.out.println("no match");
   else//若有
    System.out.println("match in "+index);
  }

 //匹配字串
 public static int match(String text,String s)
  {
   for(int i=0;i<text.length();i++)
    {
     int k=0;//找到符合字的長度
     for(int j = i;j<text.length();j++)
      {
       if(text.charAt(j)==s.charAt(k))//若字元符合
        k++;//長度+1
       else//若不符 跳出
        break;
       if(k == s.length())//若已達長度 也跳出
        break;
      }
     
     if(k == s.length())//若長度符合 回傳起始index
      return i;
    }
 
   return -1;//若沒有符合 -1
  }
}