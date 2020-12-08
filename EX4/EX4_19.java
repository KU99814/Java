//Displaying numbers in a pyramid pattern

import java.util.Scanner;

public class EX4_19
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
  
   System.out.print("Enter the number of lines: ");
   int numberOfLines = input.nextInt(); //��J�n��ܦ�� �q1��10

   if(numberOfLines<1 || numberOfLines>10)
    {
     System.out.println("You must enter a number from 1 to 10: ");
     System.exit(0);
    }

   int count = 1; //�p��Ӽ� �P��ƬۦP�Y����
   int num = 1; //��X���Ʀr

   for(int row = 1;row <= numberOfLines;row++)
    {
     for(int column = 1;column <= numberOfLines - row; column++)
       System.out.print("   "); //���X�Ʀr����Ů�

     while(num <= Math.pow(count,2)) //�Ӧ�̫�@�ƥ������ƥ��� 
      {
       System.out.print((num >= 10) ? " " + num : "  "+num);
       num++;
      }
     count++;

     System.out.println();
    }
  }
}  