//Summing integers use Command Line

public class EX8_14a
{
 public static void main(String args[])
  {
   int sum = 0;
   for(int i=0;i<args.length;i++)
    sum += Integer.parseInt(args[i]); //從命令列提取 轉為int後加總
   
   //顯示
   System.out.print("The total is "+sum);
  }
}
   