//Multiple Loans with static counters

import java.util.Scanner;

public class EX12_1
{
 static Borrower[] borrower = new Borrower[0]; //借貸者的陣列

 static Scanner input = new Scanner(System.in); // 輸入宣告

 public static void main(String args[])
  {
   while(true) //進入執行迴圈
    {
     System.out.println("Enter the choose: ");
     System.out.println("1.Loan");
     System.out.println("2.clear loan");
     System.out.println("3.print all loan");
     System.out.println("4.exit");
     
     int choose = input.nextInt(); //輸入執行項目

     if(choose == 1) //執行借貸
      {
       Name name = createName(); //輸入姓名
       Address address = createAddress(); //輸入地址

       System.out.println("Enter the loan:");
       
       System.out.print("annual interest rate:");
       double annualInterestRate = input.nextDouble();//輸入年利率
 
       System.out.print("number Of Years:");
       int numberOfYears = input.nextInt();//輸入年數
       
       System.out.print("loan Amount:");
       double loanAmount = input.nextDouble();//輸入借貸金額

       Loan loan = new Loan(annualInterestRate,numberOfYears,loanAmount);//創借貸

       addLoan(name,address,loan);//加入
      }
     else if(choose == 2)//減少借貸
      {
       Name name = createName(); //輸入姓名
       Address address = createAddress(); //輸入地址

       remove(name,address); //移除借貸
      }
     else if(choose == 3)//顯示借貸
      printLoan();
     else if(choose == 4)//離開
      break;
    }
  }

 //輸入並宣告Name
 public static Name createName()
  {
   System.out.println("Enter person's name:");
       
   System.out.print("first name:");
   String firstName = input.next();//輸入名

   System.out.print("mi:");
   String mi = input.next(); //輸入中間名

   System.out.print("last name:");
   String lastName = input.next(); //輸入姓

   return new Name(firstName,mi,lastName); //回傳Name
  }

 //輸入並宣告address
 public static Address createAddress()
  {
   System.out.println("Enter the address: ");

   System.out.print("Street:");
   String street = input.next();//輸入街

   System.out.print("city:");
   String city = input.next();//輸入城市

   System.out.print("state:");
   String state = input.next();//輸入區
       
   System.out.print("zip:");
   String zip = input.next();//輸入郵遞區號

   return new Address(street,city,state,zip); //回傳Address
  }

 //增加借貸
 public static void addLoan(Name name,Address address,Loan loan)
  {
   Borrower[] newBorrower = new Borrower[Loan.count];//宣告一暫存陣列
   
   for(int i=0;i<Loan.count-1;i++)//將以前的資料放入
    newBorrower[i] = borrower[i];

   newBorrower[Loan.count-1] = new Borrower(name,address); //將最新資料放入
   
   newBorrower[Loan.count-1].setLoan(loan);

   borrower = new Borrower[Loan.count];//重新宣告新陣列
   for(int i=0;i<Loan.count;i++) //將全部資料放入新陣列
    borrower[i] = newBorrower[i];
  }

 //移除借貸
 public static void remove(Name name,Address address)
  {
   int count = 0;//目標
   boolean find = false;//是否找到
   //尋找
   for(int i=0;i<Loan.count;i++)
    {
     //找出目標
     if(equalsName(borrower[i].getName(),name) && equalsAddress(borrower[i].getAddress(),address))
      {
       count = i;
       find = true;
       break;
      }
    }

   //如果不存在
   if(!find)
    {
     System.out.println("No this man.");
     return;
    }
   
   Loan.count--;//總數-1

   for(int i=count;i<Loan.count;i++)//將後面資料往前挪
    borrower[i] = borrower[i+1];

   Borrower[] newBorrower = new Borrower[Loan.count];//暫存陣列

   for(int i=0;i<Loan.count;i++)//暫時放入
    newBorrower[i] = borrower[i];

   borrower = new Borrower[Loan.count];//宣告新陣列

   for(int i=0;i<Loan.count;i++)//放回
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