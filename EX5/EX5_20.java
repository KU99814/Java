//�ϥ�Math�p��sin�Mcos

public class EX5_20
{
 public static void main(String args[])
  {
   System.out.println("Degree\t\tSin\t\tCos");//�C��

   for(int i = 0;i<=360;i+=10)
    {
     double s = (int)(Math.sin(Math.toRadians(i))*10000); //sin�� ��i�ഫ������
     s /= 10000;//�d�p���I��|��
     double c = (int)(Math.cos(Math.toRadians(i))*10000); //cos��
     c /= 10000;//�d�p���I��|��
     System.out.println(i+"\t\t"+s+"\t\t"+c); //���
    }
  }
}