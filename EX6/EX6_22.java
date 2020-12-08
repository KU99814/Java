//�̦��Z�ƦC�ǥ�

public class EX6_22
{
 public static void main(String args[])
  {
   char[][] answers = {
    {'A','B','A','C','C','D','E','E','A','D'},
    {'D','B','A','B','C','A','E','E','A','D'},
    {'E','D','D','A','C','B','E','E','A','D'},
    {'C','B','A','E','D','C','E','E','A','D'},
    {'A','B','D','C','C','D','E','E','A','D'},
    {'B','B','E','C','C','D','E','E','A','D'},
    {'B','B','A','C','C','D','E','E','A','D'},

    {'E','B','E','C','C','D','E','E','A','D'}};//�ǥͪ�����

   char[] key = {'D','B','D','C','C','D','A','E','A','D'}; //�зǵ���
   int[] correntCount = new int[answers.length]; //�����
   int[] student = new int[answers.length]; //�ǥͪ�index

   for(int i=0;i<answers.length;i++) //�ֹ�
    {
     for(int j=0;j<answers[i].length;j++) //�������Z
      if(answers[i][j] == key[j])
       correntCount[i]++;

     student[i] = i+1; //�O���ǥ�index
    }

   insertionSort(correntCount,student); //�ƦC

   for(int i=0;i<answers.length;i++)
    System.out.println("Student "+student[i]+"'s corrent count is "+correntCount[i]); //���
  }

 public static void insertionSort(int[] list,int[] order)
  {
   for(int i=1;i<list.length;i++) //�ƦC
    {
     int currentElement = list[i];
     int currentOrder = order[i];
     int k;
     
     for(k=i-1;k>=0&&list[k] > currentElement;k--) //�w���Z�ӱƧǾǥ�
      {
       list[k + 1] = list[k];
       order[k + 1] = order[k];
      }

     list[k+1] = currentElement;
     order[k+1] = currentOrder;
    }
  }
}
  