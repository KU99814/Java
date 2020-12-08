//Extends MyPoint to do 3D

public class EX10_1
{
 public static void main(String args[])
  {
   ThreeDPoint p1 = new ThreeDPoint(); //宣告點1
   ThreeDPoint p2 = new ThreeDPoint(10,30,25.5); //宣告P2

   System.out.print("The distance between p1 and p2 is "+p1.distance(p2)); //顯示距離
  }
}

//3D點座標 繼承自MyPoint
class ThreeDPoint extends MyPoint
{
 private double z; //Z座標
 
 //建構子
 public ThreeDPoint()
  {
   this(0,0,0);
  }

 public ThreeDPoint(double x,double y,double z)
  {
   super(x,y);//宣告super class
   this.z = z;
  }

 //回傳Z
 public double getZ()
  {
   return z;
  }

 public double distance(ThreeDPoint point) //求與MyPoint的距離
  {
   double dx = Math.abs(point.getX() - getX());
   double dy = Math.abs(point.getY() - getY());
   double dz = Math.abs(point.getZ() - z);

   return Math.sqrt(dx*dx + dy*dy+dz*dz);
  }
}