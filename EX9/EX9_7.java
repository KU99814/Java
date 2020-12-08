//Game:ATM machine

import java.util.Scanner;

public class EX9_7
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   Account[] account = new Account[10]; //設帳號陣列
   
   for(int i=0;i<10;i++) 
    account[i] = new Account();

   while(true) //開始執行
    {
     System.out.print("Enter an id: "); //輸入帳號ID
     int id = input.nextInt();

     if(id>9 || id < 0) //如不再範圍內
      {
       System.out.println("Please enter correct id.");
       continue;
      }
     while(true)
      {
       System.out.println("Main menu");
       System.out.println("1: check balance");//確認餘額
       System.out.println("2: withdraw"); //提款
       System.out.println("3: deposit"); //存款
       System.out.println("4: exit"); //離開
       System.out.print("Enter a choice: ");//輸入想要執行動作
       int choice = input.nextInt();
     
       if(choice==1) //顯示餘額
        System.out.println("The balance is "+account[id].getBalance());
       else if(choice == 2) //提款
        { 
         System.out.print("Enter an amount to withdraw: ");
         double w = input.nextDouble();
         account[id].withdraw(w);
        }
       else if(choice == 3) //存款
        { 
         System.out.print("Enter an amount to deposit: ");
         double w = input.nextDouble();
         account[id].deposit(w);
        }
       else if(choice==4) //離開
        break;
       else
        System.out.println("Pleaxe Enter a correct choice");
       System.out.println();
      }
    }
  }
}

//帳號class
class Account
{
 private double balance; //戶內金額
 
 public Account()
  {
   balance = 100;
  }

 public double getBalance() //金額
  {
   return balance;
  }

 public void withdraw(double w) //取錢
  {
   balance -= w;
  }

 public void deposit(double d)//存錢
  {
   balance += d;
  }
}