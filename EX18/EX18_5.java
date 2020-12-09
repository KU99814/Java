//ArraySizeException

import java.util.Scanner;

public class EX18_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   //��J�}�C����
   System.out.print("Enter two array's size: ");   
   int num1 = input.nextInt();
   int num2 = input.nextInt();


   //�ŧi�}�C
   int[] a1 = new int[num1];
   int[] a2 = new int[num2];

   //�p�G���פ��@�� throw
   if(a1.length != a2.length)
    throw new ArraySizeException(a1.length,a2.length);
   
   //�[�`
   int sum = 0;
   for(int i=0;i<num1;i++)
    {
     //�]�w�Ʀr
     a1[i] = i;
     a2[i] = 2*i;
     
     sum += a1[i]+a2[i];
    }

   //���
   System.out.print("The sum of two size is "+sum);
  }
}

class ArraySizeException extends NegativeArraySizeException{
  
   int size1;
   int size2;
   public ArraySizeException(int size1,int size2){
    super("�z�ǻ����D�k���Ʋժ���"+size1+" �M "+size2);
    this.size1 = size1;
    this.size2 = size2;
    //System.out.println("�z�ǻ����D�k���Ʋժ���!");
   }
  
   public ArraySizeException(String message){
    System.out.println(message);
   }  
}