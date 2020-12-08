//Multiple Loans with static counters

import java.util.Scanner;

public class EX12_1
{
 static Borrower[] borrower = new Borrower[0]; //�ɶU�̪��}�C

 static Scanner input = new Scanner(System.in); // ��J�ŧi

 public static void main(String args[])
  {
   while(true) //�i�J����j��
    {
     System.out.println("Enter the choose: ");
     System.out.println("1.Loan");
     System.out.println("2.clear loan");
     System.out.println("3.print all loan");
     System.out.println("4.exit");
     
     int choose = input.nextInt(); //��J���涵��

     if(choose == 1) //����ɶU
      {
       Name name = createName(); //��J�m�W
       Address address = createAddress(); //��J�a�}

       System.out.println("Enter the loan:");
       
       System.out.print("annual interest rate:");
       double annualInterestRate = input.nextDouble();//��J�~�Q�v
 
       System.out.print("number Of Years:");
       int numberOfYears = input.nextInt();//��J�~��
       
       System.out.print("loan Amount:");
       double loanAmount = input.nextDouble();//��J�ɶU���B

       Loan loan = new Loan(annualInterestRate,numberOfYears,loanAmount);//�ЭɶU

       addLoan(name,address,loan);//�[�J
      }
     else if(choose == 2)//��֭ɶU
      {
       Name name = createName(); //��J�m�W
       Address address = createAddress(); //��J�a�}

       remove(name,address); //�����ɶU
      }
     else if(choose == 3)//��ܭɶU
      printLoan();
     else if(choose == 4)//���}
      break;
    }
  }

 //��J�ëŧiName
 public static Name createName()
  {
   System.out.println("Enter person's name:");
       
   System.out.print("first name:");
   String firstName = input.next();//��J�W

   System.out.print("mi:");
   String mi = input.next(); //��J�����W

   System.out.print("last name:");
   String lastName = input.next(); //��J�m

   return new Name(firstName,mi,lastName); //�^��Name
  }

 //��J�ëŧiaddress
 public static Address createAddress()
  {
   System.out.println("Enter the address: ");

   System.out.print("Street:");
   String street = input.next();//��J��

   System.out.print("city:");
   String city = input.next();//��J����

   System.out.print("state:");
   String state = input.next();//��J��
       
   System.out.print("zip:");
   String zip = input.next();//��J�l���ϸ�

   return new Address(street,city,state,zip); //�^��Address
  }

 //�W�[�ɶU
 public static void addLoan(Name name,Address address,Loan loan)
  {
   Borrower[] newBorrower = new Borrower[Loan.count];//�ŧi�@�Ȧs�}�C
   
   for(int i=0;i<Loan.count-1;i++)//�N�H�e����Ʃ�J
    newBorrower[i] = borrower[i];

   newBorrower[Loan.count-1] = new Borrower(name,address); //�N�̷s��Ʃ�J
   
   newBorrower[Loan.count-1].setLoan(loan);

   borrower = new Borrower[Loan.count];//���s�ŧi�s�}�C
   for(int i=0;i<Loan.count;i++) //�N������Ʃ�J�s�}�C
    borrower[i] = newBorrower[i];
  }

 //�����ɶU
 public static void remove(Name name,Address address)
  {
   int count = 0;//�ؼ�
   boolean find = false;//�O�_���
   //�M��
   for(int i=0;i<Loan.count;i++)
    {
     //��X�ؼ�
     if(equalsName(borrower[i].getName(),name) && equalsAddress(borrower[i].getAddress(),address))
      {
       count = i;
       find = true;
       break;
      }
    }

   //�p�G���s�b
   if(!find)
    {
     System.out.println("No this man.");
     return;
    }
   
   Loan.count--;//�`��-1

   for(int i=count;i<Loan.count;i++)//�N�᭱��Ʃ��e��
    borrower[i] = borrower[i+1];

   Borrower[] newBorrower = new Borrower[Loan.count];//�Ȧs�}�C

   for(int i=0;i<Loan.count;i++)//�Ȯɩ�J
    newBorrower[i] = borrower[i];

   borrower = new Borrower[Loan.count];//�ŧi�s�}�C

   for(int i=0;i<Loan.count;i++)//��^
    borrower[i] = newBorrower[i];

   System.out.println("Remove the loan. now has "+Loan.count+" Loan");
  }

 public static void printLoan()
  {
   for(int i=0;i<Loan.count;i++)
    System.out.println(borrower[i]);
  }

 public static boolean equalsName(Name n1,Name n2)
  {
   if(n1.getFullName().equals(n2.getFullName()))
    return true;
   else
    return false;
  }
 
 public static boolean equalsAddress(Address a1,Address a2)
  {
   if(a1.getFullAddress().equals(a2.getFullAddress()))
    return true;
   else
    return false;
  }
}