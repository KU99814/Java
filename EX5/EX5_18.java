//�ϥ�Math.sqrt�p�⥭���

public class EX5_18
{
 public static void main(String args[])
  {
   System.out.println("Number\t\tSquarRoot"); //��X����

   //�q0��20 �̧���ܥ����
   for(int i =0;i<=20;i+=2)
    {
     double SR = (int)(Math.sqrt(i)*10000);
     SR/=10000;
     System.out.println(i+"  \t\t "+SR);
    }
  }
}