//��X���S�w�Ӽƪ��ƪ��̤j���]��

import java.util.Scanner;

public class EX6_14
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a number of amount: "); //�M�w�ƶq
   int amount = input.nextInt();
   
   if(amount == 0) //�p�G�O�s
    System.out.print("No number");
   else
    {
     int[] num = new int[amount]; //��J��

     System.out.print("Enter "+amount+" numbers: ");
     for(int i=0;i<num.length;i++)
      num[i] = input.nextInt();

     int GCD = gcd(num);

     if(GCD>0)     
      System.out.print("The GCD is "+GCD); //���
     else
      System.out.print("The GCD is no exist");//
    }
  }

 public static int gcd(int... number)
  {
   int min = number[0]; //��X�̤p��
   for(int i=1;i<number.length;i++)
    if(number[i]<min)
     min=number[i];

   //�q�̤p�ƶ}�l��GCD
   while(0 < min)
    {
     boolean de = true;

     for(int i=0;i<number.length;i++) //�B��
      {
       if(number[i]%min!=0) //�p�G������ ���X
        {
         de = false;
         break;
        }
      }

     if(de) //�p�G�ҥi���� �a�J
      return min;
     min--;//�䤣��N-1�~��
    }

   return -1;
  }
}