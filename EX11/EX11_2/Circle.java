public class Circle extends GeometricObject
{
 private double radius;//�b�|

 //�غc�l
 public Circle()
  {
   this(1.0);
  }

 public Circle(double radius)
  {
   this.radius = radius;
  }

 public double getRadius()//���o�b�|
  {
   return radius;
  }

 public void setRadius(double radius)//�]�w�b�|
  {
   this.radius = radius;
  }

 public double getArea()//���o���n
  {
   return radius*radius*Math.PI;
  }

 public double getPerimeter()//���o�P��
  {
   return 2*radius;
  }

 public void printCircle()//��ܪ��A
  {
   System.out.println("The circle is created "+getDateCreated() + 
                      "and the radius is "+radius);
  }
}
   