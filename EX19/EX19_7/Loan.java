public class Loan implements java.io.Serializable
{
 private double annualInterestRate;//�~�Q�v
 private int numberOfYears; //�~��
 private double loanAmount; //�ɶU
 private java.util.Date loanDate; //�ɶU�ɶ�

 //�غc�l
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

 //���o�~�Q�v
 public double getAnnuaInterestRate()
  {
   return annualInterestRate;
  }

 //�]�w�~�Q�v
 public void setAnnualInterestRate(double annualInterestRate)
  {
   this.annualInterestRate = annualInterestRate;
  }

 //���o�~��
 public int getNumberOfYears()
  {
   return numberOfYears;
  }

 //�]�w�~�� 
 public void setNumberOfYears(int numberOfYears)
  {
   this.numberOfYears = numberOfYears;
  }

 //���o�ɶU
 public double getLoanAmount()
  {
   return loanAmount;
  }

 //�]�w�ɶU
 public void setLoanAmount(double loanAmount)
  {
   this.loanAmount = loanAmount;
  }

 //���o��Q��
 public double getMonthlyPayment()
  {
   double monthlyInterestRate = annualInterestRate / 1200;
   double monthlyPayment = loanAmount * monthlyInterestRate / ( 1- 
          (Math.pow(1/(1+monthlyInterestRate),numberOfYears * 12)));
   return monthlyPayment;
  }

 //���o�`�Q��
 public double getTotalPayment()
  {
   double totalPayment = getMonthlyPayment() * numberOfYears * 12;
   return totalPayment;
  }

 //���o���
 public java.util.Date getLoaenDate()
  {
   return loanDate;
  }
}