//Sum of subset matching a specified value
//T(n) = O(n^2)

import java.lang.Math.*;
import java.util.*;

public class EX23_3
{
 public static void main(String args[])
  {
   //測試陣列
   int[] a1 = {3,1,3,8,30,78,4};
   int[] a2 = {12,1,8,9};

   //要找的和
   int n1 = 6;

   int n2 = 24;

   //結果輸出
   System.out.println(Arrays.toString(a1)+" "+n1+" "+subsetSum(a1,n1));
   System.out.println(Arrays.toString(a2)+" "+n2+" "+subsetSum(a2,n2));
  }

 //找出是否有能夠組成數的subset的method
 //不要窮舉
 public static boolean subsetSum(int[] a,int N)
  {
   List<Integer> list = new ArrayList<Integer>();//儲存的list

   //迴圈   
   for(int i=0;i<a.length;i++)
    {
     int num = a[i];//目前的index
    
     if(num == N)//如果本身就是要找的數 true
      return true;
     else if(num<N)//若小於 
      {
       int length = list.size();//list目前長度
       for(int j=0;j<length;j++)
        {
         int n = num+list.get(j);//將list中數加入新數
         if(n==N)//若符合 true
          return true;
         else if(n<N)//若小於 加入
          list.add(n);
        }
       //大於的數不需繼續計算
       list.add(num);//將目前數加入
      }
    }
   
   return false;//若找不到 false
  }      
}