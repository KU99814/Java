//�T�w�겣��� class

public class FixedInvestment
{
 double depositAmount; //�s�ڪ��B
 double annualInterestRate; //�~�Q�v
 int numberOfYears; //�~��
 
 FixedInvestment() //��l�ŧi
  {
   depositAmount = 1000;
   annualInterestRate = 0.05;
   numberOfYears = 1;
  }

 //�a�J�ܼƫŧi
 FixedInvestment(double newDepositAmount,double newAnnualInterestRate,int newNumberOfYears)
  {
   depositAmount = newDepositAmount;
   annualInterestRate = newAnnualInterestRate;
   numberOfYears = newNumberOfYears;
  }

 //�^�Ǧs�ڪ��B
 double getDepositAmount()
  {
   return depositAmount;
  }

 //�^�Ǧ~�Q�v
 double getAnnualInterestRate()
  {
   return annualInterestRate;
  }

 //�^�Ǧ~��
 int getNumberOfYears()
  {
   return numberOfYears;
  }

 double getTotalReturn() //�⦡
  {
   double totalReturn = depositAmount*(Math.pow((1+annualInterestRate/1200),numberOfYears*12));
   return totalReturn;
  }
}