public class Loan implements java.io.Serializable
{
 private double annualInterestRate;//年利率
 private int numberOfYears; //年數
 private double loanAmount; //借貸
 private java.util.Date loanDate; //借貸時間

 //建構子
 public Loan()
  {
   this(2.5,1,1000);
  }

 public Loan(double annualInterestRate,int numberOfYears,double loanAmount)
  {
   this.annualInterestRate = annualInterestRate;
   this.numberOfYears = numberOfYears;
   this.loanAmount = loanAmount;
   loanDate = new java.util.Date();
  }

 //取得年利率
 public double getAnnuaInterestRate()
  {
   return annualInterestRate;
  }

 //設定年利率
 public void setAnnualInterestRate(double annualInterestRate)
  {
   this.annualInterestRate = annualInterestRate;
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
  }

 //取得借貸
 public double getLoanAmount()
  {
   return loanAmount;
  }

 //設定借貸
 public void setLoanAmount(double loanAmount)
  {
   this.loanAmount = loanAmount;
  }

 //取得月利息
 public double getMonthlyPayment()
  {
   double monthlyInterestRate = annualInterestRate / 1200;
   double monthlyPayment = loanAmount * monthlyInterestRate / ( 1- 
          (Math.pow(1/(1+monthlyInterestRate),numberOfYears * 12)));
   return monthlyPayment;
  }

 //取得總利息
 public double getTotalPayment()
  {
   double totalPayment = getMonthlyPayment() * numberOfYears * 12;
   return totalPayment;
  }

 //取得日期
 public java.util.Date getLoaenDate()
  {
   return loanDate;
  }
}