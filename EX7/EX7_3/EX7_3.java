//use FixedInvestment class

public class EX7_3
{
 public static void main(String args[])
  {
   FixedInvestment FixedInvestment1 = new FixedInvestment(10000,0.045,3); //宣告class

   //顯示總額
   System.out.print("The total return is " + FixedInvestment1.getTotalReturn());
  }
}