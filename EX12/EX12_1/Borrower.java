public class Borrower extends Person
{
 private Loan loan; //�ɶU

 //�غc�l
 public Borrower()
  {
   super();
  }

 public Borrower(Name name,Address address)
  {
   super(name,address);
  }

 //�^�ǭɶU
 public Loan getLoan()
  {
   return loan;
  }

 //�]�w�ɶU
 public void setLoan(Loan loan)
  {
   this.loan = loan;
  }

 //���o�m�W
 public Name getName()
  {
   return super.getName();
  }

 //���o�a�}
 public Address getAddress()
  {
   return super.getAddress();
  }

 //�^�Ǹ�T
 public String toString()
  {
   return super.toString() + "Monthly payment is "+loan.getMonthlyPayment() + "\n"+
          "Total payment is "+loan.getTotalPayment();
  }
}