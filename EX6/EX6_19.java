//�H�����k�ƦC�}�C

public class EX6_19
{
 public static void main(String args[])
  {
   int[] num = {5,8,6,7,3}; //�]�}�C

   System.out.print("The array is "); //��ܭ���}�C
   for(int i=0;i<num.length;i++)
    System.out.print(num[i]+" ");

   deInsertionSort(num); //�Ƨ�
   System.out.println();

   System.out.print("Now the array is "); //��ܱƧǫ�}�C
   for(int i=0;i<num.length;i++)
    System.out.print(num[i]+" ");
  }

//insert sort descrease
 public static void deInsertionSort(int[] list)
  {
   for(int i=1;i<list.length;i++) //�q�@�}�l
    {
     int currentElement = list[i]; //��e��
     int k;
     for(k=i-1;k>=0&&list[k]<currentElement;k--) //�p�G���e�Ȥj ���
      list[k+1] = list[k];

     list[k+1] = currentElement;
    }
  }
}