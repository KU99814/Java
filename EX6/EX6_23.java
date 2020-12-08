//�H�����k�ƥX���u�`�ɼ�

public class EX6_23
{
 public static void main(String args[])
  {
   int[][] workHour = {
     {2,4,3,4,5,8,8},
     {7,3,4,3,3,4,4},
     {3,3,4,3,3,2,2},
     {9,3,4,7,3,4,1},
     {3,5,4,3,6,3,8},
     {3,4,4,6,3,4,4},
     {3,7,4,8,3,8,4},
     {6,3,5,9,2,7,9}}; //�]���u�C�Ѥu�@�ɼ�
   int[] total = new int[workHour.length]; //���u�`�ɼ�
   int[] employee = new int[workHour.length]; //���u
   
   for(int i=0;i<workHour.length;i++) //��X���u�`�ɼ�
    {
     total[i] = totalHour(workHour[i]);
     employee[i] = i;
    }

   selectionSort(total,employee); //�ƦC

   for(int i=0;i<workHour.length;i++)
    System.out.println("Employee "+employee[i]+"'s total hour is "+total[i]);
  }

 public static int totalHour(int[] list) //���u�`�ɼ�
  {
   int sum = 0;

   for(int i=0;i<list.length;i++)
    sum+=list[i];

   return sum;
  }

 public static void selectionSort(int[] list,int[] list2) //�ƦC ���u��ۭ��u�`�ɼư�
  {
   //�q�̫᭱���e��
   for(int i=list.length-1;i>=1;i--) 
    {
     int currentMin = list[0];//�N�Ĥ@�ӼƳ]���̤p
     int currentMinIndex = 0;
     int currentMin2 = list2[0];

     for(int j=1;j<=i;j++)
      {
       //�p�G�᭱�٦���p���� �Υ����N�̤p��
       if(currentMin > list[j])
        {
         currentMin = list[j];
         currentMinIndex = j;
         currentMin2 = list2[j];
        }
      }
    
     //
     if(currentMinIndex != i)
      {
       list[currentMinIndex] = list[i];
       list[i] = currentMin;
       list2[currentMinIndex] = list2[i];
       list2[i] = currentMin2;
      }
    }
  }
}