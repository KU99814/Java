//��method�p�⥭��

public class EX6_8
{
 public static void main(String args[])
  {
   int first = average(new int[]{1,2,3,4,5,6}); //�Ĥ@��int��method
   double second = average(new double[]{6.0,404,1.9,2.9,3.4,3.5});//�ĤG��double��method
   
   System.out.println("The first average is "+first);
   System.out.println("The second average is "+second);
  }

 //int�o����
 public static int average(int[] array)
  {
   int total = 0;//�[�`

   //�ۥ[
   for(int i=0;i<array.length;i++)
    total+=array[i];
   
   //���H�Ӽƥ���
   total/=array.length;
   return total; //�^��
  }

 //double������
 public static double average(double[] array)
  {
   double total = 0; //�[�`

   //�ۥ[
   for(int i=0;i<array.length;i++)
    total+=array[i];
   
   //���H�Ӽƥ���
   total/=array.length;
   return total; //�^��
  }
}