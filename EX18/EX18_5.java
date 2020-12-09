//ArraySizeException

import java.util.Scanner;

public class EX18_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   //輸入陣列長度
   System.out.print("Enter two array's size: ");   
   int num1 = input.nextInt();
   int num2 = input.nextInt();


   //宣告陣列
   int[] a1 = new int[num1];
   int[] a2 = new int[num2];

   //如果長度不一樣 throw
   if(a1.length != a2.length)
    throw new ArraySizeException(a1.length,a2.length);
   
   //加總
   int sum = 0;
   for(int i=0;i<num1;i++)
    {
     //設定數字
     a1[i] = i;
     a2[i] = 2*i;
     
     sum += a1[i]+a2[i];
    }

   //顯示
   System.out.print("The sum of two size is "+sum);
  }
}

class ArraySizeException extends NegativeArraySizeException{
  
   int size1;
   int size2;
   public ArraySizeException(int size1,int size2){
    super("您傳遞類非法的數組長度"+size1+" 和 "+size2);
    this.size1 = size1;
    this.size2 = size2;
    //System.out.println("您傳遞類非法的數組長度!");
   }
  
   public ArraySizeException(String message){
    System.out.println(message);
   }  
}