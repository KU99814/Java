//Finding the largest n such that n2 < 30000

public class EX4_13
{
 public static void main(String args[])
  {
   int i = 1; //��l����

   while(true)//��X���������̱�����p��30000����
    {
     double n = Math.pow(i,2); //�Ni����

     if(n>30000) //�Y�j��30000 ���X
      {
       break;
      }
     i++;
    }
   
   //���i-1 �]��i����j��30000
   System.out.print("The largest n such that n2 < 30000 is "+(i-1));
  }
}