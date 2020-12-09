public class Loan
{
 private double annualInterestRate;//�~�Q�v
 private int numberOfYears;//�~��
 private double loanAmount;//�ɴ�
 private java.util.Date loanDate;//�ɴڮɶ�

 //�غc�l
 public Loan()
  {
   this(2.5,1,1000);
   loanDate = new java.util.Date();
  }
 
 //�p�G���b�d�� throw
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

 //���o�~�Q�v
 public double getAnnualInterestRate()
  {
   return annualInterestRate;
  }

 //�]�w�~�Q�v
 public void setAnnualInterestRate(double annualInterestRate)
  {
   this.annualInterestRate = annualInterestRate;
   if(annualInterestRate<=0)
    throw new IllegalArgumentException();
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
   if(numberOfYears<=0)
    throw new IllegalArgumentException();
  }

 //���o�U��
 public double getLoanAmount()
  {
   return loanAmount;
  }

 //�]�w�U��
 public void setLoanAmount(double loanAmount)
  {
   this.loanAmount = loanAmount;
   if(loanAmount<=0)
    throw new IllegalArgumentException();
  }

 //���o��Q��
 public double getMonthlyPayment()
  {
   double monthlyInterestRate = annualInterestRate / 1200;
   double monthlyPayment = loanAmount * monthlyInterestRate /(1-(Math.pow(1/(1+monthlyInterestRate),numberOfYears*12)));
   return monthlyPayment;
  }

 //���o�`�Q��
 public double getTotalPayment()
  {
   double totalPayment = getMonthlyPayment() * numberOfYears * 12;
   return totalPayment;
  }

 //���o�ɴڮɶ�
 public java.util.Date getLoanDate()
  {
   return loanDate;
  }
}