//Finding the factors of an integer

import java.util.Scanner;

public class EX4_16
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter a number: "); 
   int num = input.nextInt(); //��J�@�ӼƦr
  
   int i = 2;//��l��]��

   System.out.print("The factors of this number is ");
   
   while(true)
    {
     //�p�G����㰣 ���줣��㰣����
     if(num%i == 0)
      {
       System.out.print(i+" ");
       num /= i;
      }
     else if(num%i != 0)
      i++;
     if(num == 1)
      break;
    }
  }
}