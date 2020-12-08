//Guessing month

import java.util.Scanner;

public class EX3_15
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   //猜測月份集
   String set1 = "1  3  5  7"+"\n9  11";
   String set2 = "2  3  6  7"+"\n10  11";
   String set3 = "4  5  6  7"+"\n12";
   String set4 = "8  9  10  11"+"\n12";

   int num = 0;//計算月份結果

   //依據回答來決定num加得數
   System.out.println("Is your birth month in set1? \n"+set1);
   System.out.print("Enter 0 for No and 1 for Yes: ");
   int ch1 = input.nextInt();
   
   if(ch1 == 1)
    num += 1;

   System.out.println("Is your birth month in set2? \n"+set2);
   System.out.print("Enter 0 for No and 1 for Yes: ");
   int ch2 = input.nextInt();
   
   if(ch2 == 1)
    num += 2;
   
   System.out.println("Is your birth month in set3? \n"+set3);
   System.out.print("Enter 0 for No and 1 for Yes: ");
   int ch3 = input.nextInt();
   
   if(ch3 == 1)
    num += 4;

   System.out.println("Is your birth month in set4? \n"+set4);
   System.out.print("Enter 0 for No and 1 for Yes: ");
   int ch4 = input.nextInt();
   
   if(ch4 == 1)
    num += 8;
  
   //最後結果就是生日月分
   System.out.print("Your birth month is "+num+"!");
  }
}
