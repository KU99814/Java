//��X�̤j�ȻP��̤j�ȬۦP���ƪ��Ӽ�

import java.util.Scanner;

public class EX6_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   final int TOTAL_NUMBERS = 6; //��J����
   int[] numbers = new int[TOTAL_NUMBERS]; //�s��Ʀr���}�C

   for(int i=0;i<numbers.length;i++)//��J����
    {
     System.out.print("Enter a number: ");
     numbers[i] = input.nextInt();
    }
 
   int max = numbers[0]; //���N�̤j�ȳ]���Ĥ@�Ӽ�
   int count = 1;
   for(int i=1;i<numbers.length;i++) //��� 
    {
     if(max < numbers[i]) //�p�G���s���̤j��
      {
       max = numbers[i];
       count=1; //count�^�k1
      }
     else if(max == numbers[i]) //�p�G���ۦP���� �N�[1
      count++;
    }
   
   //��ܰ}�C
   String output = "The array is ";
   for(int i=0;i<numbers.length;i++)
    {
     output+=numbers[i];
    }
   output += "\nThe largest number is "+max;
   output += "\nThe occurrence count of the largest number "+"is "+count;
   System.out.print(output); //���
  }
}