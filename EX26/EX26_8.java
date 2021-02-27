//Execution time for external sort

import java.io.*;

public class EX26_8
{
 public static final int MAX_ARRAY_SIZE = 100000;//輸出檔案最大尺寸陣列
 public static final int BUFFER_SIZE = 100000;//IO stream buffer size

 public static void main(String args[]) throws Exception
  {
   //呼叫測試用method
   testSort(5000000);
   testSort(10000000);
   testSort(15000000);
   testSort(20000000);
   testSort(25000000);
   testSort(30000000);
   
  }

 //顯示排序時間
 public static void testSort(int number) throws Exception
  {
   long startTime = System.currentTimeMillis();//開始時間
   externalSort(number);//external sort
   long endTime = System.currentTimeMillis();//結束時間
   long exTime = endTime - startTime;//執行時間

   System.out.println("Size: "+number+" Time: "+exTime);

   //排序過程產生的檔案
   File largedataFile = new File("largedata.dat");//原始資料
   File f1File = new File("f1.dat");//過程檔案1
   File sortedFile = new File("sortedlargedata.dat");//排序結果
   File f3File = new File("f3.dat");//過程檔案2
   File f2File = new File("f2.dat");//過程檔案3

   //將產生檔案刪除
   largedataFile.delete();
   f1File.delete();
   sortedFile.delete();
   f3File.delete();
   f2File.delete();
  }

 //external sort
 public static void externalSort(int number) throws Exception
  {
   DataOutputStream output = new DataOutputStream(new BufferedOutputStream(
                              new FileOutputStream("largedata.dat")));//輸出檔案 原始資料
   //輸出隨機產生數字
   for(int i=0;i<number;i++)
    output.writeInt((int)(Math.random()*number));

   output.close();//檔案關閉

   //進行第一階段排序 得到資料分段數
   int numberOfSegments = initializeSegments(MAX_ARRAY_SIZE,"largedata.dat","f1.dat");

   //進行第二階段
   merge(numberOfSegments,MAX_ARRAY_SIZE,"f1.dat","f2.dat","f3.dat");
  }

 //第一階段排序
 private static int initializeSegments
    (int segmentSize,String originalFile,String f1) throws Exception
  {
   int[] list = new int[segmentSize];//一次進行排序的陣列

   DataInputStream input = new DataInputStream(new BufferedInputStream(
                              new FileInputStream(originalFile)));//輸入的原始檔案
   DataOutputStream output = new DataOutputStream(new BufferedOutputStream(
                              new FileOutputStream(f1)));//輸出的排序檔案

   int numberOfSegments = 0;//分段數

   //迴圈到資料輸入完
   while(input.available()>0)
    {
     numberOfSegments++;//分段數+1
     int i = 0;
     //輸入到最大尺寸或資料取完
     for(;input.available()>0 && i < segmentSize;i++)
      list[i] = input.readInt();

     java.util.Arrays.sort(list,0,i);//排序

     //輸出檔案
     for(int j=0;j<i;j++)
      output.writeInt(list[j]);
    }
   
   input.close();//關閉輸入
   
   output.close();//關閉輸出

   return numberOfSegments;//回傳
  }

 //第二階段排序
 private static void merge(int numberOfSegments,int segmentSize,String f1,String f2,String f3) 
                           throws Exception
  {
   //若有多於一個片段 merge sort
   if(numberOfSegments > 1)
    {
     mergeOneStep(numberOfSegments,segmentSize,f1,f2,f3);//整合並排序資料
     merge((numberOfSegments+1)/2,segmentSize*2,f3,f1,f2);//遞迴
    }
   else//只有一個片段 直接結束
    {
     File sortedFile = new File("sortedlargedata.dat");
     if(sortedFile.exists())
      sortedFile.delete();
     new File(f1).renameTo(sortedFile);
    }
  }

 //整合並輸出檔案
 private static void mergeOneStep(int numberOfSegments,int segmentSize,String f1,String f2,String f3) 
                           throws Exception
  {
   DataInputStream f1Input = new DataInputStream(new BufferedInputStream(
                              new FileInputStream(f1),BUFFER_SIZE));
   DataOutputStream f2Output = new DataOutputStream(new BufferedOutputStream(
                              new FileOutputStream(f2),BUFFER_SIZE));

   copyHalfToF2(numberOfSegments,segmentSize,f1Input,f2Output);//f1複製
   f2Output.close();//關閉輸入檔案
   
   DataInputStream f2Input = new DataInputStream(new BufferedInputStream(
                              new FileInputStream(f2),BUFFER_SIZE));//輸出檔案
   DataOutputStream f3Output = new DataOutputStream(new BufferedOutputStream(
                              new FileOutputStream(f3),BUFFER_SIZE));//輸入檔案
   mergeSegments(numberOfSegments/2,segmentSize,f1Input,f2Input,f3Output);//將f1下半部檔案與f2整合輸入f3
   
   //關閉檔案讀取
   f1Input.close();
   f2Input.close();
   f3Output.close();
  }

 //複製一半的片段
 private static void copyHalfToF2(int numberOfSegments,int segmentSize,
                               DataInputStream f1,DataOutputStream f2) throws Exception
  {
   //將一半片段數量的檔案輸出
   for(int i=0;i<(numberOfSegments/2)*segmentSize;i++)
    f2.writeInt(f1.readInt());
  }

 //合併片段
 private static void mergeSegments(int numberOfSegments,int segmentSize,
                           DataInputStream f1,DataInputStream f2,DataOutputStream f3) throws Exception
  {
   
   for(int i=0;i<numberOfSegments;i++)
    mergeTwoSegments(segmentSize,f1,f2,f3);//將片段兩兩合併
   while(f1.available()>0)
    f3.writeInt(f1.readInt());//輸出資料
  }

 //合併兩片段
 private static void mergeTwoSegments(int segmentSize,DataInputStream f1,
                             DataInputStream f2,DataOutputStream f3) throws Exception
  {
   int intFromF1 = f1.readInt();//f1取出的資料
   int intFromF2 = f2.readInt();//f2取出的資料
   int f1Count = 1;//f1取出資料個數
   int f2Count = 1;//f2取出資料個數

   //比較大小 將較小的資料先輸出檔案
   //若其中一邊先輸入結束 跳出迴圈
   while(true)
    {
     if(intFromF1 < intFromF2)
      {
       f3.writeInt(intFromF1);//輸入檔案
       if(f1.available()==0 || f1Count++>=segmentSize)
        {
         //結束前將另一個輸入檔案
         f3.writeInt(intFromF2);
         break;
        }
       else
        intFromF1 = f1.readInt();//沒結束 繼續下一筆資料
      }
     else
      {
       f3.writeInt(intFromF2);//輸入檔案
       if(f2.available()==0 || f2Count++>=segmentSize)
        {
         //結束前將另一個輸入檔案
         f3.writeInt(intFromF1);
         break;
        }
       else
        intFromF2 = f2.readInt();//沒結束 繼續下一筆資料
      }
    }
    
   //將剩下沒有輸入的資料放入檔案
   while(f1.available()>0 && f1Count++ < segmentSize)
    f3.writeInt(f1.readInt());
   
   while(f2.available()>0 && f2Count++ < segmentSize)
    f3.writeInt(f2.readInt());
  }
}