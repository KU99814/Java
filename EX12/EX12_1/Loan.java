public class Loan
{
 private double annualInterestRate;//年資利息
 private int numberOfYears;//年數
 private double loanAmount; //借貸金額
 private java.util.Date loanDate; //借貸時間

 public static int count = 0; //計數借貸數

 //建構子
 public Loan()
  {
   this(2.5,1,1000);
  }

 public Loan(double annualInterestRate,int numberOfYears,
             double loanAmount)
  {
   this.annualInterestRate = annualInterestRate;
   this.numberOfYears = numberOfYears;
   this.loanAmount = loanAmount;
   count++;
  }

 //回傳年增利息
 public double getAnnualInterestRate()
  {
   return annualInterestRate;
  }

 //設定年增利息
 public void setAnnualInterestRate(double annualInterestRate)
  {
   this.annualInterestRate = annualInterestRate;
  }

 //回傳年數
 public int getNumberOfYears()
  {
   return numberOfYears;
  }

 //設定年數
 public void setNumberOfYears(int numberOfYears)
  {
   this.numberOfYears = numberOfYears;
  }

 //回傳借貸
 public double getLoanAmount()
  {
   return loanAmount;
  }

 //設定借貸
 public void setLoanAmount(double loanAmount)
  {
   this.loanAmount = loanAmount;
  }

 //回傳月利息
 public double getMonthlyPayment()
  {
   double monthlyInterestRate = annualInterestRate / 1200;
   double monthlyPayment = loanAmount * monthlyInterestRate 
                           /(1-(Math.pow(1/(1+monthlyInterestRate),numberOfYears*12)));
   return monthlyPayment;
  }

 //回傳總支付
 public double getTotalPayment()
  {
   double totalPayment = getMonthlyPayment() * numberOfYears * 12;
   return totalPayment;
  }

 //回傳借貸時間
 public java.util.Date getLoanDate()
  {
   return loanDate;
  }
}