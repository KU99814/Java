public class Loan
{
 private double annualInterestRate;//�~��Q��
 private int numberOfYears;//�~��
 private double loanAmount; //�ɶU���B
 private java.util.Date loanDate; //�ɶU�ɶ�

 public static int count = 0; //�p�ƭɶU��

 //�غc�l
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

 //�^�Ǧ~�W�Q��
 public double getAnnualInterestRate()
  {
   return annualInterestRate;
  }

 //�]�w�~�W�Q��
 public void setAnnualInterestRate(double annualInterestRate)
  {
   this.annualInterestRate = annualInterestRate;
  }

 //�^�Ǧ~��
 public int getNumberOfYears()
  {
   return numberOfYears;
  }

 //�]�w�~��
 public void setNumberOfYears(int numberOfYears)
  {
   this.numberOfYears = numberOfYears;
  }

 //�^�ǭɶU
 public double getLoanAmount()
  {
   return loanAmount;
  }

 //�]�w�ɶU
 public void setLoanAmount(double loanAmount)
  {
   this.loanAmount = loanAmount;
  }

 //�^�Ǥ�Q��
 public double getMonthlyPayment()
  {
   double monthlyInterestRate = annualInterestRate / 1200;
   double monthlyPayment = loanAmount * monthlyInterestRate 
                           /(1-(Math.pow(1/(1+monthlyInterestRate),numberOfYears*12)));
   return monthlyPayment;
  }

 //�^���`��I
 public double getTotalPayment()
  {
   double totalPayment = getMonthlyPayment() * numberOfYears * 12;
   return totalPayment;
  }

 //�^�ǭɶU�ɶ�
 public java.util.Date getLoanDate()
  {
   return loanDate;
  }
}