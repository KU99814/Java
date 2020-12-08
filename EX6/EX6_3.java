//璸衡Τぶ计キА

import java.util.Scanner;

public class EX6_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //块
   double[] num = new double[11]; //计皚
   double average = 0; //キА

   for(int i=0;i<11;i++) //块计 11Ω
    {
     System.out.print("Enter numbers: ");
     num[i] = input.nextDouble();
     average+=num[i];//盢计羆
    }
   average/=11; //璸衡キА
   
   int count = 0;
   String output = "The number below average has ";
   for(int i=0;i<11;i++) //тキА计
    {
     if(num[i]<average)
      count++;
    }
   
   output+=count;
   System.out.print(output);
  }
}