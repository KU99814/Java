//Financial application: monetary units

import java.util.Scanner;

public class EX3_7
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter an amount in double, for example 11.56: ");
   double amount = input.nextDouble();//��J���B

   //�H�U�ഫ���U���
   int remainingAmount = (int)(amount*100);

   int numberOfOneDollars = remainingAmount / 100;// dollar
   remainingAmount = remainingAmount % 100;

   int numberOfQuarters = remainingAmount / 25; //quarters
   remainingAmount = remainingAmount % 25;
 
   int numberOfDimes = remainingAmount / 10; //dimes
   remainingAmount = remainingAmount % 10;

   int numberOfNickels = remainingAmount / 5; //nickel
   remainingAmount = remainingAmount % 5;

   int numberOfPennies = remainingAmount; //penny

   String output = "Your amount " + amount + " consists of \n";

   //�p�G�ӳ��ܤ֦��@�� ��ܸӳ�� 
   //�Ϥ��X�Ƽƫ�
   if(numberOfOneDollars>0)//�p�Gdollar��줣��0
     {
      output += "\t" + numberOfOneDollars + " dollar"; //�[�Wdollar�ƶq
      if(numberOfOneDollars>1)//�Ƽƫ��[S
       {
        output += "s";
       }
     }
    if(numberOfQuarters>0) //�p�Gquarter��줣��0
     {
      output += "\n\t" + numberOfQuarters + " quarter";//�[�Wquarter�ƶq �o�̶}�l�y���[�_��
      if(numberOfQuarters>1)//�Ƽƫ��[S
       {
        output += "s";
       }
     }
    if(numberOfDimes>0) //�p�Gdime��줣��0
     {
       output += "\n\t" + numberOfDimes + " dime";//�[�Wdime�ƶq
      if(numberOfDimes>1)//�Ƽƫ��[S
       {
        output += "s";
       }
     }
    if(numberOfNickels>0) //�p�Gnickle��줣��0
     {
      output += "\n\t" + numberOfNickels + " nickel";//�[�Wnickle�ƶq
      if(numberOfNickels>1)//�Ƽƫ��[S
       {
        output += "s";
       }
     }
    if(numberOfPennies>0) //�p�Gpenny��줣��0
     {
      output += "\n\t" + numberOfPennies + " penn";//�[�Wpenny�ƶq
      if(numberOfPennies>1)//�r����y �Ƽƫ��hy�[ies
       {
        output += "ies\n";
       }
      else
       {
        output += "y\n";
       }
     }
   System.out.println(output);//��ܵ��G
  }
}