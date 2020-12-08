//Extends MyPoint to do 3D

public class EX10_1
{
 public static void main(String args[])
  {
   ThreeDPoint p1 = new ThreeDPoint(); //�ŧi�I1
   ThreeDPoint p2 = new ThreeDPoint(10,30,25.5); //�ŧiP2

   System.out.print("The distance between p1 and p2 is "+p1.distance(p2)); //��ܶZ��
  }
}

//3D�I�y�� �~�Ӧ�MyPoint
class ThreeDPoint extends MyPoint
{
 private double z; //Z�y��
 
 //�غc�l
 public ThreeDPoint()
  {
   this(0,0,0);
  }

 public ThreeDPoint(double x,double y,double z)
  {
   super(x,y);//�ŧisuper class
   this.z = z;
  }

 //�^��Z
 public double getZ()
  {
   return z;
  }

 public double distance(ThreeDPoint point) //�D�PMyPoint���Z��
  {
   double dx = Math.abs(point.getX() - getX());
   double dy = Math.abs(point.getY() - getY());
   double dz = Math.abs(point.getZ() - z);

   return Math.sqrt(dx*dx + dy*dy+dz*dz);
  }
}