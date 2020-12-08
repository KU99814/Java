//MyPoint class

public class EX9_4
{
 public static void main(String args[])
  {
   MyPoint p1 = new MyPoint();  //p1
   MyPoint p2 = new MyPoint(10,30.5); //p2
   
   System.out.println("The distance between p1 and (5,5) is + "+p1.distance(5,5));
   //p1��(5,5)���Z��
   System.out.println("The distance between p1 and p2 is + "+p1.distance(p2));
   //p1��p2���Z��
  }
}

class MyPoint
{
 //�y��
 private double x;
 private double y;

 //�غc�l
 public MyPoint()
  {
   this(0.0,0.0);
  }

 public MyPoint(double x,double y)
  {
   this.x = x;
   this.y = y;
  }

 public double getX() //�DX
  {
   return x;
  }

 public double getY() //�DY
  {
   return y;
  }

 public double distance(MyPoint point) //�D�PMyPoint���Z��
  {
   double dx = Math.abs(point.getX() - x);
   double dy = Math.abs(point.getY() - y);

   return Math.sqrt(dx*dx + dy*dy);
  }

 public double distance(double px,double py) //�D�P���w�I���Z��
  {
   double dx = Math.abs(px - x);
   double dy = Math.abs(py - y);

   return Math.sqrt(dx*dx + dy*dy);
  }
}