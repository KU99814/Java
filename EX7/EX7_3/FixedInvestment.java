//固定資產投資 class

public class FixedInvestment
{
 double depositAmount; //存款金額
 double annualInterestRate; //年利率
 int numberOfYears; //年數
 
 FixedInvestment() //初始宣告
  {
   depositAmount = 1000;
   annualInterestRate = 0.05;
   numberOfYears = 1;
  }

 //帶入變數宣告
 FixedInvestment(double newDepositAmount,double newAnnualInterestRate,int newNumberOfYears)
  {
   depositAmount = newDepositAmount;
   annualInterestRate = newAnnualInterestRate;
   numberOfYears = newNumberOfYears;
  }

 //回傳存款金額
 double getDepositAmount()
  {
   return depositAmount;
  }

 //回傳年利率
 double getAnnualInterestRate()
  {
   return annualInterestRate;
  }

 //回傳年數
 int getNumberOfYears()
  {
   return numberOfYears;
  }

 double getTotalReturn() //算式
  {
   double totalReturn = depositAmount*(Math.pow((1+annualInterestRate/1200),numberOfYears*12));
   return totalReturn;
  }
}