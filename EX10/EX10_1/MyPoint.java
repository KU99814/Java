public class MyPoint
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