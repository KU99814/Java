//��w�ƧǪk

public class EX6_18
{
 public static void main(String args[])
  {
   double[] num = {6.0,4.4,1.9,4.9,3.4,0.9,1.5}; //�ŧi�}�C

   //���
   System.out.print("The array is ");
   for(int i=0;i<num.length;i++)
    System.out.print(num[i]+" ");
   
   System.out.println();

   //�Ƨ�
   bubbleSort(num);

   //��ܱƧǫ�}�C
   System.out.print("Now the array is ");
   for(int i=0;i<num.length;i++)
    System.out.print(num[i]+" ");
  }

 //��w�ƧǪ�method
 public static void bubbleSort(double[] list)
  {
   boolean flag = true; //������flag
   double temp = 0; /* Temporary value for swapping two elements */
 
   for(int i = 0; i < list.length;i++)//�]���C���Ƨ��̤j�Ʃw�b�̥k �G�C���̫�index-1
    {
     flag = true;

     //�N�۾F��Ӽƨ̷ӻ��W�ƦC �����ӼƦC�������W�ƦC����
     for (int j = 0; j<list.length -i -1;j++)
      {
       if (list[j] > list[j+1])
        {
         temp = list[j];
         list[j] = list[j + 1];
         list[j + 1] = temp;
         flag = false;
        } // end if
      } // end for j = ...
 
    if (flag == true)
     break; 
   } // end for i = ...
 }
}