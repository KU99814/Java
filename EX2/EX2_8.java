import java.util.Scanner;

public class EX2_8
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter a number of ASCll:");
   int asc = input.nextInt(); //輸入ASCII碼

   char ASCll = (char)asc; //轉換成字元
  
   System.out.print("The ASCll code is "+ASCll); //輸出
  }
}