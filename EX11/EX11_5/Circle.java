public class Circle extends GeometricObject implements Comparable
{
 private double radius;//半徑

 //建構子
 public Circle()
  {
  this(1.0);
  }

 public Circle(double radius)
  {
   this.radius = radius;
  }

 //取得半徑
 public double getRadius()
  {
   return radius;
  }

 //設定半徑
 public void setRadius(double radius)
  {
   this.radius = radius;
  }

 //取得面積
 public double getArea()
  {
   return radius*radius*Math.PI;
  }

 //取得周長
 public double getPerimeter()
  {
   return 2*radius;
  }

 //顯示狀態
 public void printCircle()
  {
   System.out.println("The circle is created "+getDateCreated() + 
                      "and the radius is "+radius);
  }

 //比較大小
 public int compareTo(Object o)
  {
   return (int)(getArea()-((Circle)o).getArea());
  }

 //判斷是否相等
 public boolean equals(Object o)
  {
   if(((Circle)o).getRadius() == radius)
    return true;
   else
    return false;
  }
}
   