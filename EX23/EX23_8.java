//Number of prime numbers

import java.io.*;
import java.math.*;
import java.util.*;

public class EX23_8
{
 public static void main(String args[]) throws IOException
  {
   RandomAccessFile inout = new RandomAccessFile("EX23_8.dat","rw");//取得檔案

   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter number:");
   long num = input.nextLong();//輸入找尋範圍

   printPrime(inout,num);//輸出質數到檔案
   
   inout.seek(0);//重設指針
   int count = 0;//記數
   while(inout.getFilePointer()!=inout.length())//判斷檔案是否到頭
    {
     Long now = inout.readLong();//輸出
     if(now > num)
      break;
     count++;
    }

   System.out.println("The number of Prime less than "+num+" is "+count);//顯示個數
   
   inout.close();//關閉
  }

 //找出質數輸出到檔案
 public static void printPrime(RandomAccessFile inout,long num) throws IOException
  {
   long nowNum = 2;//初始數
   if(inout.length()!=0)//若檔案非空
    {
     inout.seek(inout.length()-4*2);//照出最末位數
     nowNum = inout.readLong();
     if(nowNum>=num)//若大於目標數 不需再找
      return;
    }
   else//若空
    inout.writeLong(nowNum);//先輸入1數
   List<Long> list = findPrime(inout,num,nowNum);//輸出新數列到list
   
   for(long newNum: list)
    {
     inout.writeLong(newNum);//將新數輸進檔案
    }
  }

 //輸出質數
 public static List<Long> findPrime(RandomAccessFile inout,long n,long number) throws IOException
  {
   java.util.List<Long> list = new java.util.ArrayList<Long>();//儲存質數list 比較用
   java.util.List<Long> relist = new java.util.ArrayList<Long>();//儲存新質數list 回傳用

   inout.seek(0);//重設指針
   while(inout.getFilePointer()!=inout.length())
    {
     list.add(inout.readLong());//將檔案內容加入陣列
    }
   
   number++;

   while(number <= n)
    {
     boolean isPrime = true;//判斷質數

     long squareRoot = (long)(Math.sqrt(number));

     //迴圈 若list內的數小於squareRoot 判斷是否除數
     for(int k = 0;k < list.size() && list.get(k) <= squareRoot;k++)
      {
       if(number % list.get(k) == 0)
        {
         isPrime = false;
         break;
        }
      }

     if(isPrime)//若是質數 加入list
      {
       list.add(number);
       relist.add(number);
      }

     number++;
    }
   
   return relist;//回傳
  }
}