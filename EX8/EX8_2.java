//check substring use own indexOf function

import java.util.Scanner;

public class EX8_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter first string: "); //輸入字串1
   String s1 = input.nextLine();

   System.out.print("Enter second string: "); //輸入字串2
   String s2 = input.nextLine();

   if(newIndexOf(s1,s2) == -1) //檢測1是否是2的substring
    System.out.print("The first string is not substring");
   else
    System.out.print("The first string is second string's substring");
  }

 public static int newIndexOf(String s1,String s2)
  {
   //兩個字串長度
   int s1len = s1.length();
   int s2len = s2.length();

   if(s1len>s2len) //如果字串1比字串2短 回傳錯誤
    return -1;

   char c1 = s1.charAt(0);//先找與字串2開頭相同的字 
   for(int i=0;i+s1len-1<s2len;i++)//從頭開始找 若長度不夠即跳出
    {
     if(s2.charAt(i)==c1)//找到後接下來依序對照
      {
       boolean isSubstring = true;
     
       for(int j=0;j<s1len;j++)
        { 
         if(s2.charAt(i+j)!=s1.charAt(j)) //如果中間不符也跳出
          {
           isSubstring = false;
           break;
          }
        }
       
       if(isSubstring)//相符的話回傳開始index
        return i;
      }
    }

   return -1; //都沒有回傳-1
  }
}      