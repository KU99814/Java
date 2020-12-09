public class Loan
{
 private double annualInterestRate;//年利率
 private int numberOfYears;//年數
 private double loanAmount;//借款
 private java.util.Date loanDate;//借款時間

 //建構子
 public Loan()
  {
   this(2.5,1,1000);
   loanDate = new java.util.Date();
  }
 
 //如果不在範圍 throw
 public Loan(double annualInterestRate,int numberOfYears,double loanAmount)
  {
   this.annualInterestRate = annualInterestRate;

   if(annualInterestRate<=0)
    throw new IllegalArgumentException();

   this.numberOfYears = numberOfYears;

   if(numberOfYears<=0)
    throw new IllegalArgumentException();

   this.loanAmount = loanAmount;

   if(loanAmount<=0)
    throw new IllegalArgumentException();

   loanDate = new java.util.Date();
  }

 //取得年利率
 public double getAnnualInterestRate()
  {
   return annualInterestRate;
  }

 //設定年利率
 public void setAnnualInterestRate(double annualInterestRate)
  {
   this.annualInterestRate = annualInterestRate;
   if(annualInterestRate<=0)
    throw new IllegalArgumentException();
  }

 //取得年數
 public int getNumberOfYears()
  {
   return numberOfYears;
  }

 //設定年數
 public void setNumberOfYears(int numberOfYears)
  {
   this.numberOfYears = numberOfYears;
   if(numberOfYears<=0)
    throw new IllegalArgumentException();
  }

 //取得貸款
 public double getLoanAmount()
  {
   return loanAmount;
  }

 //設定貸款
 public void setLoanAmount(double loanAmount)
  {
   this.loanAmount = loanAmount;
   if(loanAmount<=0)
    throw new IllegalArgumentException();
  }

 //取得月利息
 public double getMonthlyPayment()
  {
   double monthlyInterestRate = annualInterestRate / 1200;
   double monthlyPayment = loanAmount * monthlyInterestRate /(1-(Math.pow(1/(1+monthlyInterestRate),numberOfYears*12)));
   return monthlyPayment;
  }

 //取得總利息
 public double getTotalPayment()
  {
   double totalPayment = getMonthlyPayment() * numberOfYears * 12;
   return totalPayment;
  }

 //取得借款時間
 public java.util.Date getLoanDate()
  {
   return loanDate;
  }
}