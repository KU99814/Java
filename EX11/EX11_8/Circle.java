public class Circle extends GeometricObject implements Comparable
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

 //���o�b�|
 public double getRadius()
  {
   return radius;
  }

 //�]�w�b�|
 public void setRadius(double radius)
  {
   this.radius = radius;
  }

 //���o���n
 public double getArea()
  {
   return radius*radius*Math.PI;
  }

 //���o�P��
 public double getPerimeter()
  {
   return 2*radius;
  }

 //��ܪ��A
 public void printCircle()
  {
   System.out.println("The circle is created "+getDateCreated() + 
                      "and the radius is "+radius);
  }

 //����j�p
 public int compareTo(Object o)
  {
   return (int)(getArea()-((Circle)o).getArea());
  }

 //�P�_�O�_�۵�
 public boolean equals(Object o)
  {
   if(((Circle)o).getRadius() == radius)
    return true;
   else
    return false;
  }
}
   