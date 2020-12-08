//Geometry:Thhe Circle2D class

public class EX9_11
{
 public static void main(String args[])
  {
   Circle2D c1 = new Circle2D(2,2,5.5);
   
   System.out.println("The area is "+c1.getArea()+" the perimeter is "+c1.getPerimeter()); //面積與周長
   System.out.println("Is c1 contains the dot(3,3)? "+ c1.contains(3,3)); //是否包含這點
   System.out.println("Is c1 contains the circle(4,5,10.5)? "+ c1.contains(new Circle2D(4,5,10.5))); 
   //是否包含這圓
   System.out.println("Is c1 ovarlap the circle(3,5,2.3)? "+ c1.overlaps(new Circle2D(3,5,2.3)));
   //是否與這圓相交
  }
}

//圓的class
class Circle2D
{
 private double x,y; //圓心座標
 private double radius; //半徑
 
 //建構子
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

 //回傳值得method
 public double getX() //X
  {
   return x;
  }

 public double getY()//Y
  {
   return y;
  }

 public double getRadius()//半徑
  {
   return radius;
  }

 public double getArea() //面積
  {
   return Math.PI*radius*radius;
  }

 public double getPerimeter() //周長
  {
   return 2 * radius * Math.PI;
  }

 public boolean contains(double x1,double y1) //判斷是否包含(點)
  {
   double dx = Math.abs(x - x1);
   double dy = Math.abs(y - y1);
   
   return (radius >= Math.sqrt(dx*dx + dy*dy)); //與圓心距離不超半徑
  }

 public boolean contains(Circle2D circle) //判斷是否包含(圓)
  {
   double dx = Math.abs(x -circle.getX());
   double dy = Math.abs(y -circle.getY());

   if(getArea()<circle.getArea())
    return false;

   //兩圓心距離不超過包含圓半徑相減且被包含圓半徑小於包含圓
   return (Math.sqrt(dx*dx + dy*dy) <= radius - circle.getRadius());
  }

 //是否交疊
 public boolean overlaps(Circle2D circle)
  {
   double dx = Math.abs(x -circle.getX());
   double dy = Math.abs(y -circle.getY());

   //圓心距離小於半徑相加又非包含
   return (radius + circle.getRadius()) > Math.sqrt(dx*dx + dy*dy) && 
           !contains(circle) && !circle.contains(new Circle2D(x,y,radius));
  }
}