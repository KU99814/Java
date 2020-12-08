public class Borrower extends Person
{
 private Loan loan; //借貸

 //建構子
 public Borrower()
  {
   super();
  }

 public Borrower(Name name,Address address)
  {
   super(name,address);
  }

 //回傳借貸
 public Loan getLoan()
  {
   return loan;
  }

 //設定借貸
 public void setLoan(Loan loan)
  {
   this.loan = loan;
  }

 //取得姓名
 public Name getName()
  {
   return super.getName();
  }

 //取得地址
 public Address getAddress()
  {
   return super.getAddress();
  }

 //回傳資訊
 public String toString()
  {
   return super.toString() + "Monthly payment is "+loan.getMonthlyPayment() + "\n"+
          "Total payment is "+loan.getTotalPayment();
  }
}