//�p�⦳�h�ּƧC�󥭧���

import java.util.Scanner;

public class EX6_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   double[] num = new double[11]; //�s��Ʀr���}�C
   double average = 0; //������

   for(int i=0;i<11;i++) //��J�Ʀr 11��
    {
     System.out.print("Enter numbers: ");
     num[i] = input.nextDouble();
     average+=num[i];//�N�Ʀr�[�`
    }
   average/=11; //�p�⥭��
   
   int count = 0;
   String output = "The number below average has ";
   for(int i=0;i<11;i++) //��X�C�󥭧�����
    {
     if(num[i]<average)
      count++;
    }
   
   output+=count;
   System.out.print(output);
  }
}