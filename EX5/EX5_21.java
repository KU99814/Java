//�p��~�֥����P���t��

import java.util.Scanner;

public class EX5_21
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   double mean = 0;  //������
   double deviation = 0; //���t��
   double d1 = 0;
   final double n = 10;  //��J���ƥ�
   
   System.out.print("Enter ten numbers: ");   

   for(int i = 0;i<n;i++)  //��J�Q�Ӽ�
    {
     int age = input.nextInt();
     mean += age;  //��J���Ƭۥ[
     d1 += Math.pow(age,2);//����ۥ[
    }
   
   deviation = d1-(Math.pow(mean,2))/n;  //�B�� ����mean�٨S������
   mean /= n; //����
   deviation /= (n-1);
   deviation = Math.sqrt(deviation);//�}�ڸ�
   
   System.out.print("The mean is "+mean+" and the deviation is "+deviation); //��X
  }
}