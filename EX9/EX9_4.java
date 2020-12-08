//MyPoint class

public class EX9_4
{
 public static void main(String args[])
  {
   MyPoint p1 = new MyPoint();  //p1
   MyPoint p2 = new MyPoint(10,30.5); //p2
   
   System.out.println("The distance between p1 and (5,5) is + "+p1.distance(5,5));
   //p1跟(5,5)的距離
   System.out.println("The distance between p1 and p2 is + "+p1.distance(p2));
   //p1跟p2的距離
  }
}

class MyPoint
{
 //座標
 private double x;
 private double y;

 //建構子
 public MyPoint()
  {
   this(0.0,0.0);
  }

 public MyPoint(double x,double y)
  {
   this.x = x;
   this.y = y;
  }

 public double getX() //求X
  {
   return x;
  }

 public double getY() //求Y
  {
   return y;
  }

 public double distance(MyPoint point) //求與MyPoint的距離
  {
   double dx = Math.abs(point.getX() - x);
   double dy = Math.abs(point.getY() - y);

   return Math.sqrt(dx*dx + dy*dy);
  }

 public double distance(double px,double py) //求與指定點的距離
  {
   double dx = Math.abs(px - x);
   double dy = Math.abs(py - y);

   return Math.sqrt(dx*dx + dy*dy);
  }
}