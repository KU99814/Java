//求出最近的兩點

public class EX6_26
{
 public static void main(String args[])
  {
   double[][] points = {{-1,0,3},{-1,-1,-1},{4,1,1},
                        {2,0.5,9},{3.5,2,-1},{3,1.5,3},
                        {-1.5,4,2},{5.5,4,-0.5}}; //設座標

   int p1=0,p2=1; //最初的兩點

   double shortestDistances = distance(points[p1],points[p2]); //最初的距離

   for(int i=0;i<points.length;i++) //做比較
    {
     for(int j=i+1;j<points.length;j++)
      {
       double distance = distance(points[i],points[j]);
       if(distance < shortestDistances) //小於的話 調換
        {
         shortestDistances = distance;
         p1 = i;
         p2 = j;
        }
      }
    }

   System.out.print("The nearest points are ("+points[p1][0]+","+points[p1][1]+","+points[p1][2]+")"+
                    " and ("+points[p2][0]+","+points[p2][1]+","+points[p2][2]+")"); //顯示
  } 

 public static double distance(double[] point1,double[] point2) //計算距離
  {
   double distance = 0;
   
   for(int i=0;i<point1.length;i++) //座標距離公式
    distance += Math.pow((point2[i]-point1[i]),2);

   return Math.sqrt(distance);
  }
}