//Counting positive and negative numbers and computing the average of numbers

import java.util.Scanner;

public class EX4_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   int num; //��J���Ʀr
   int sum = 0; //�`�M
   int positive = 0; //���ƪ��Ӽ�
   int negative = 0; //�t�ƪ��Ӽ�

   //��J�Ʀr�����J0
   while(true)
    {
     System.out.print("Enter a number: ");
     num = input.nextInt();
   
     if(num > 0) //�Y������
      positive++;
     else if(num < 0) //�Y���t 
      negative++;
     else if(num == 0)
      break;
   
     sum += num; //�[�`
    }
   double average = 0; //������
   if(positive+negative == 0) //�Y�S����J
    average = 0;
   else //�Y�� �p�⥭��
    average = sum / (positive+negative);

   //��X���G
   System.out.print("\nThe positive number hae been read "+positive);
   System.out.print("\nThe negativ number hae been read "+negative);
   System.out.print("\nThe total are "+ sum);
   System.out.print("\nThe average are "+ average);
  }
}             