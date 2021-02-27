//��

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

 //��� �ϥέ��n
 public int compareTo(GeometricObject o)
  {
   if(getArea()>o.getArea())//�Y���j �^��1
    return 1;
   else if(getArea()<o.getArea())//�Y���p �^��-1
    return -1;
   else//�۵� �^��0
    return 0;
  }
}
   