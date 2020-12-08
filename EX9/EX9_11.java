//Geometry:Thhe Circle2D class

public class EX9_11
{
 public static void main(String args[])
  {
   Circle2D c1 = new Circle2D(2,2,5.5);
   
   System.out.println("The area is "+c1.getArea()+" the perimeter is "+c1.getPerimeter()); //���n�P�P��
   System.out.println("Is c1 contains the dot(3,3)? "+ c1.contains(3,3)); //�O�_�]�t�o�I
   System.out.println("Is c1 contains the circle(4,5,10.5)? "+ c1.contains(new Circle2D(4,5,10.5))); 
   //�O�_�]�t�o��
   System.out.println("Is c1 ovarlap the circle(3,5,2.3)? "+ c1.overlaps(new Circle2D(3,5,2.3)));
   //�O�_�P�o��ۥ�
  }
}

//�ꪺclass
class Circle2D
{
 private double x,y; //��߮y��
 private double radius; //�b�|
 
 //�غc�l
 public Circle2D()
  {
   this(0,0,1);
  }

 public Circle2D(double x,double y,double radius)
  {
   this.x = x;
   this.y = y;
   this.radius = radius;
  }

 //�^�ǭȱomethod
 public double getX() //X
  {
   return x;
  }

 public double getY()//Y
  {
   return y;
  }

 public double getRadius()//�b�|
  {
   return radius;
  }

 public double getArea() //���n
  {
   return Math.PI*radius*radius;
  }

 public double getPerimeter() //�P��
  {
   return 2 * radius * Math.PI;
  }

 public boolean contains(double x1,double y1) //�P�_�O�_�]�t(�I)
  {
   double dx = Math.abs(x - x1);
   double dy = Math.abs(y - y1);
   
   return (radius >= Math.sqrt(dx*dx + dy*dy)); //�P��߶Z�����W�b�|
  }

 public boolean contains(Circle2D circle) //�P�_�O�_�]�t(��)
  {
   double dx = Math.abs(x -circle.getX());
   double dy = Math.abs(y -circle.getY());

   if(getArea()<circle.getArea())
    return false;

   //���߶Z�����W�L�]�t��b�|�۴�B�Q�]�t��b�|�p��]�t��
   return (Math.sqrt(dx*dx + dy*dy) <= radius - circle.getRadius());
  }

 //�O�_���|
 public boolean overlaps(Circle2D circle)
  {
   double dx = Math.abs(x -circle.getX());
   double dy = Math.abs(y -circle.getY());

   //��߶Z���p��b�|�ۥ[�S�D�]�t
   return (radius + circle.getRadius()) > Math.sqrt(dx*dx + dy*dy) && 
           !contains(circle) && !circle.contains(new Circle2D(x,y,radius));
  }
}