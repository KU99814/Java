public class Rectangle extends GeometricObject implements Comparable
{
 private double width; //寬
 private double height; //長
 
 //建構子
 public Rectangle()
  {
   this(1.0,1.0);
  }

 public Rectangle(double width,double height)
  {
   this.width = width;
   this.height = height;
  }

 //取得寬
 public double getWidth()
  {
   return width;
  }

 //設定寬
 public void setWidth(double width)
  {
   this.width = width;
  }

 //取得長
 public double getHeight()
  {
   return height;
  }

 //設定長
 public void setHeight(double height)
  {
   this.height = height;
  }

 //取得面積
 public double getArea()
  {
   return width * height;
  }

 //取得周長
 public double getPerimeter()
  {
   return 2*(width + height);
  }

 //比較大小
 public int compareTo(Object o)
  {
   return (int)(getArea() - ((Rectangle)o).getArea());
  }

 //判斷是否相等
 public boolean equals(Object o)
  {
   if(compareTo(o) == 0)
    return true;
   else
    return false;
  }
}