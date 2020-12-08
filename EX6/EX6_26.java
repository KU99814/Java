//�D�X�̪񪺨��I

public class EX6_26
{
 public static void main(String args[])
  {
   double[][] points = {{-1,0,3},{-1,-1,-1},{4,1,1},
                        {2,0.5,9},{3.5,2,-1},{3,1.5,3},
                        {-1.5,4,2},{5.5,4,-0.5}}; //�]�y��

   int p1=0,p2=1; //�̪쪺���I

   double shortestDistances = distance(points[p1],points[p2]); //�̪쪺�Z��

   for(int i=0;i<points.length;i++) //�����
    {
     for(int j=i+1;j<points.length;j++)
      {
       double distance = distance(points[i],points[j]);
       if(distance < shortestDistances) //�p�󪺸� �մ�
        {
         shortestDistances = distance;
         p1 = i;
         p2 = j;
        }
      }
    }

   System.out.print("The nearest points are ("+points[p1][0]+","+points[p1][1]+","+points[p1][2]+")"+
                    " and ("+points[p2][0]+","+points[p2][1]+","+points[p2][2]+")"); //���
  } 

 public static double distance(double[] point1,double[] point2) //�p��Z��
  {
   double distance = 0;
   
   for(int i=0;i<point1.length;i++) //�y�жZ������
    distance += Math.pow((point2[i]-point1[i]),2);

   return Math.sqrt(distance);
  }
}