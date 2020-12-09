//Generic Maximum element in an two-dimensional array

import java.util.*;

public class EX21_6
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
 
   System.out.print("Enter the number of row: ");
   int row = input.nextInt();//��J�}�C�C����

   System.out.print("Enter the number of column: ");
   int column = input.nextInt();//��J�}�C�����

   Integer[][] array = new Integer[row][column];//�ŧi�}�C
   System.out.print("Enter numbers: ");//��J�}�C
   for(int i=0;i<row;i++)
    for(int j=0;j<column;j++)
    array[i][j] = input.nextInt();
   
   double max = EX21_6.<Integer>maxRowSum(array);//�N�C�@�C�U�ۥ[�` �D�̤j��
   System.out.println("The max number in array is "+max);//���
  }

 public static <E extends Number> double maxRowSum(E[][] list)
  {
   double max = 0;//�w�]�̤j��

   for(int i=0;i<list[0].length;i++)//�Ĥ@�C�[�`
    max+=list[0][i].doubleValue();
   
   for(int i=1;i<list.length;i++)
    {
     //�N����C�@�C�[�`
     double currentRow = 0;
     for(int j=0;j<list[i].length;j++)
      currentRow += list[i][j].doubleValue();

     //����̤j��
     if(max < currentRow)
      max = currentRow;
    }

   return max;
  }
}  