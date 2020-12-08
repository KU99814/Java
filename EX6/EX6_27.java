//��X�Ҧ��̵u�Z�����I

public class EX6_27
{
 public static void main(String args[])
  {
   double[][] points = {{-1,1},{0,0},{1,1},{2,1},
           {2,-1},{3,3},{4,2},{4,1}}; //�]�y��
   int p1=0,p2=1; 
   double shortestDistances = distance(points[p1],points[p2]); //�]�_�l�̵u�Z��
   
   for(int i=0;i< points.length;i++) //��� ��̵u�Z��
    {
     for(int j=i+1;j<points.length;j++)
      {
       double distance = distance(points[i],points[j]);
       if(shortestDistances > distance)
        {
         p1 = i;
         p2 = j;
         shortestDistances = distance;
        }
      }
    }

   //�x�s�ŦX�̪��I�����I
   //�������h���I �w�]���׳]�̪�
   int[] pairA = new int[points.length]; //�Ĥ@�Iindex
   int[] pairB = new int[points.length]; //�ĤG�Iindex
   int k = 0; //�t���
   
   for(int i=0;i< points.length;i++) //��X�Ҧ����̵u�Z�����I
    {
     for(int j=i+1;j<points.length;j++)
      {
       double distance = distance(points[i],points[j]);
       if(shortestDistances == distance)
        {
         pairA[k] = i;
         pairB[k] = j;
         k++;
        }
      }
    }

   System.out.print("All closest pairs of points are: "); //���
   System.out.println();
   for(int i=0;i<k;i++)
    {
     System.out.println("("+points[pairA[i]][0]+","+points[pairA[i]][1]+") "+
                       "("+points[pairB[i]][0]+","+points[pairB[i]][1]+")");
    }
  }

 public static double distance(double[] point1,double[] point2) //�p��Z��
  {
   double distance = 0;
   
   for(int i=0;i<point1.length;i++) //�y�жZ������
    distance += Math.pow((point2[i]-point1[i]),2);

   return Math.sqrt(distance);
  }
}