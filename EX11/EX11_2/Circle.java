public class Circle extends GeometricObject
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

 public double getRadius()//取得半徑
  {
   return radius;
  }

 public void setRadius(double radius)//設定半徑
  {
   this.radius = radius;
  }

 public double getArea()//取得面積
  {
   return radius*radius*Math.PI;
  }

 public double getPerimeter()//取得周長
  {
   return 2*radius;
  }

 public void printCircle()//顯示狀態
  {
   System.out.println("The circle is created "+getDateCreated() + 
                      "and the radius is "+radius);
  }
}
   