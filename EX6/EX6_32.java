//�p��Q�v

import java.util.Scanner;

public class EX6_32
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   double[] rates = {0.10,0.15,0.27,0.30,0.35,0.386}; //�Q�v
   int[][] brackets = {{6000,27950,67700,141250,307050}, 
                       {12000,46700,112850,171950,307050},
                       {6000,23350,56425,85975,153525},
                       {10000,37450,96700,156600,307050}}; //�̳y�Ҧ��M���B�j�p������k

   System.out.println("0-single filer, 1-married jointly,");
   System.out.println("2-married separately, 3-heah of hoursehold");

   System.out.print("Enter the filling status: "); //��J�Ҧ�
   int k = input.nextInt();

   System.out.print("Enter the taxable income: "); //��J���B
   int income = input.nextInt();

   int incomeTo = 0;

   //�������B�϶�
   for(int index=0;index<brackets[k].length;index++) 
    {
     if(income > brackets[k][index])
      {
       incomeTo++;
      }
     else
      break;     
    }

   double tax = 0;

   System.out.println(incomeTo);
 
   //�p��
   for(int i=0;i<incomeTo+1;i++)
    {
     if(i == 0)//�Y
      tax += brackets[k][i]*rates[i];
     else if(i == incomeTo)//��
      tax += (income - brackets[k][i-1])*rates[i];
     else//����
      tax += (brackets[k][i] - brackets[k][i-1])*rates[i];
    }
 
   System.out.print("Tax is "+tax);
  }
}
       