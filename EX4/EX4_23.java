//head or tail

public class EX4_23
{
 public static void main(String args[])
  {
   int head = 0; //��������
   int tail = 0; //�ϭ�����
   
   for(int i = 0;i<1000000;i++) //�i��1�ʸU��
    {
     int coin = (int)(Math.random()*2); //�H�H��0��1�����w�����ϭ�
      
     if(coin == 1)
      head++;
     else if(coin == 0)
      tail++;
    }
   
   System.out.print("The head has "+head+" the tail has "+tail);
  }
}
  
