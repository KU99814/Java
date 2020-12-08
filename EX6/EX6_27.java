//找出所有最短距離的點

public class EX6_27
{
 public static void main(String args[])
  {
   double[][] points = {{-1,1},{0,0},{1,1},{2,1},
           {2,-1},{3,3},{4,2},{4,1}}; //設座標
   int p1=0,p2=1; 
   double shortestDistances = distance(points[p1],points[p2]); //設起始最短距離
   
   for(int i=0;i< points.length;i++) //比較 找最短距離
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

   //儲存符合最近點的兩點
   //不知有多少點 預設長度設最長
   int[] pairA = new int[points.length]; //第一點index
   int[] pairB = new int[points.length]; //第二點index
   int k = 0; //配對數
   
   for(int i=0;i< points.length;i++) //找出所有有最短距離的點
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

   System.out.print("All closest pairs of points are: "); //顯示
   System.out.println();
   for(int i=0;i<k;i++)
    {
     System.out.println("("+points[pairA[i]][0]+","+points[pairA[i]][1]+") "+
                       "("+points[pairB[i]][0]+","+points[pairB[i]][1]+")");
    }
  }

 public static double distance(double[] point1,double[] point2) //計算距離
  {
   double distance = 0;
   
   for(int i=0;i<point1.length;i++) //座標距離公式
    distance += Math.pow((point2[i]-point1[i]),2);

   return Math.sqrt(distance);
  }
}