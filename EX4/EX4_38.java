//Decimal to Hex

import java.util.Scanner;

public class EX4_38
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //块
   
   System.out.print("Enter a number: ");
   int num = input.nextInt(); //块璶锣传计
   
   String s = "";
  
   System.out.print("The number of binary is: ");
   
   //锣传16秈
   while(true)
    {
     //秈 盢緇计玡
     int d = num % 16;

     //10计璶锣传Θダ
     if(d >= 10)
      s = (char)('A'+(d-10)) + s;
     else
      s = d + s;
    
     if(num < 16)
      break;
     num = (int)(num/16);
    }
   System.out.print(s);
  }
}