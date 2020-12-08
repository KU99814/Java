//Summing integer use Command Line by ""

public class EX8_14b
{
 public static void main(String args[])
  {
   int sum = 0;

   String[] token = args[0].split(" ");//以空格分隔成數個String的陣列

   for(int i=0;i<token.length;i++)//接著一個個轉為int
    sum += Integer.parseInt(token[i]);
   
   System.out.print("The total is "+sum); //顯示
  }
}