//��X���S�w�Ӽƪ�����

import java.util.Scanner;

public class EX6_13
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter a number of amount: "); //��J�Ӽ�
   int amount = input.nextInt();

   if(amount == 0) //�p�G�ӼƬ��s�ɪ����p
     System.out.print("There is no number");  
   else
    {
     int[] num = new int[amount];

     System.out.print("Enter "+amount+" numbers: "); //��J��
     for(int i =0;i<num.length;i++)
      num[i] = input.nextInt(); 
   
     System.out.print("The average is "+average(num)); //��ܥ���
    }
  }

 //������method
 public static double average(int... number)
  {
   double average = 0;
   
   for(int i=0;i<number.length;i++) //�B��[�`
    average+=number[i];
   average/=number.length;

   return average;
  }
}   
   