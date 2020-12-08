//讀取檔案 存入陣列排列

import java.util.Scanner;

public class EX6_7
{
 public static void main(String args[]) throws Exception
  {
   java.io.File file = new java.io.File("EX6_7.txt");//要讀取的檔案

   Scanner input = new Scanner(file); //讀檔

   int[] num = new int[100];

   for(int i=0;input.hasNext();i++) //寫入陣列
    num[i] = input.nextInt();
   
   for(int i=0;i<100;i++) //隨機排列
    {
     int ran1 = (int)(Math.random()*100);
     int ran2 = (int)(Math.random()*100);
     int temp = num[ran1];
     num[ran1] = num[ran2];
     num[ran2] = temp;
    }

   input.close();   

   java.io.PrintWriter output = new java.io.PrintWriter(file); //輸出檔案

   for(int i=0;i<100;i++)
    output.println(num[i]);

   output.close();
  }
}    