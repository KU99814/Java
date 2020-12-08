//Game:ATM machine

import java.util.Scanner;

public class EX9_7
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   Account[] account = new Account[10]; //�]�b���}�C
   
   for(int i=0;i<10;i++) 
    account[i] = new Account();

   while(true) //�}�l����
    {
     System.out.print("Enter an id: "); //��J�b��ID
     int id = input.nextInt();

     if(id>9 || id < 0) //�p���A�d��
      {
       System.out.println("Please enter correct id.");
       continue;
      }
     while(true)
      {
       System.out.println("Main menu");
       System.out.println("1: check balance");//�T�{�l�B
       System.out.println("2: withdraw"); //����
       System.out.println("3: deposit"); //�s��
       System.out.println("4: exit"); //���}
       System.out.print("Enter a choice: ");//��J�Q�n����ʧ@
       int choice = input.nextInt();
     
       if(choice==1) //��ܾl�B
        System.out.println("The balance is "+account[id].getBalance());
       else if(choice == 2) //����
        { 
         System.out.print("Enter an amount to withdraw: ");
         double w = input.nextDouble();
         account[id].withdraw(w);
        }
       else if(choice == 3) //�s��
        { 
         System.out.print("Enter an amount to deposit: ");
         double w = input.nextDouble();
         account[id].deposit(w);
        }
       else if(choice==4) //���}
        break;
       else
        System.out.println("Pleaxe Enter a correct choice");
       System.out.println();
      }
    }
  }
}

//�b��class
class Account
{
 private double balance; //�᤺���B
 
 public Account()
  {
   balance = 100;
  }

 public double getBalance() //���B
  {
   return balance;
  }

 public void withdraw(double w) //����
  {
   balance -= w;
  }

 public void deposit(double d)//�s��
  {
   balance += d;
  }
}