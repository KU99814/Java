//Finding the smallest n such that n2 < 12000

public class EX4_12
{
 public static void main(String args[])
  {
   int i = 1; //��l����
   while(true)
    {
     double n = Math.pow(i,2); //�Ni����
     if(n>12000) //�p�G�j��12000 ���X�j��
      {
       break;
      }
     i++;
    }
 
   System.out.print("The smallet n that n2 < 12000 is "+i);
  }
}