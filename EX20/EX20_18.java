//Tower of Hanoi count

import java.util.Scanner;

public class EX20_18
{
 static int count = 0;//method call�p��
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter number of disks: ");
   int n = input.nextInt();//��J�м�

   System.out.println("The moves are: ");
   moveDisks(n,'A','B','C');//���ʪe����
   System.out.print("The number of move is "+count);//�p�Ⲿ�ʦ���
  }

 //�e���𲾰�
 public static void moveDisks(int n,char fromTower,char toTower,char auxTower)
  {
   count++;//�p��+1
   if(n==1)//base case
    {
     System.out.println("Move disk "+n+" from "+fromTower+" to "+toTower);//���
    }
   else
    {
     moveDisks(n-1,fromTower,auxTower,toTower);
     System.out.println("Move disk "+n+" from "+fromTower+" to "+toTower);//���
     moveDisks(n-1,auxTower,toTower,fromTower);
    }
  }
}