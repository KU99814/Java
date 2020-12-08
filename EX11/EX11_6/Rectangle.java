public class Rectangle extends GeometricObject implements Comparable
{
 private double width; //�e
 private double height; //��
 
 //�غc�l
 public Rectangle()
  {
   this(1.0,1.0);
  }

 public Rectangle(double width,double height)
  {
   this.width = width;
   this.height = height;
  }

 //���o�e
 public double getWidth()
  {
   return width;
  }

 //�]�w�e
 public void setWidth(double width)
  {
   this.width = width;
  }

 //���o��
 public double getHeight()
  {
   return height;
  }

 //�]�w��
 public void setHeight(double height)
  {
   this.height = height;
  }

 //���o���n
 public double getArea()
  {
   return width * height;
  }

 //���o�P��
 public double getPerimeter()
  {
   return 2*(width + height);
  }

 //����j�p
 public int compareTo(Object o)
  {
   return (int)(getArea() - ((Rectangle)o).getArea());
  }

 //�P�_�O�_�۵�
 public boolean equals(Object o)
  {
   if(compareTo(o) == 0)
    return true;
   else
    return false;
  }
}