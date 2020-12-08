//Geometry: the Rectangle2D class

public class EX9_12
{
 public static void main(String args[])
  {
   Rectangle2D r1 = new Rectangle2D(2,2,5.5,4.9);
   
   System.out.println("The area is "+r1.getArea()); //顯示面積
   System.out.println("The perimeter is "+r1.getPerimeter()); //顯示周長
   System.out.println("Is dot (3,3) contained in r1? "+r1.contains(3,3)); //顯示是否包含這點
   System.out.println("Is rectangle (4,5,10.5,3.2) contained in r1? "+
                       r1.contains(new Rectangle2D(4,5,10.5,3.2))); //顯示是否包含這矩形
   System.out.println("Is rectangle (3,5,2.3,5.4) contained in r1? "+
                        r1.overlaps(new Rectangle2D(3,5,2.3,5.4))); //顯示是否與這矩形相交
  }
}

class Rectangle2D
{
 private double x,y; //中心座標
 private double width,height; //寬與高

 public Rectangle2D()
  {
   this(0,0,1,1);
  }

 public Rectangle2D(double x,double y,double width,double height)
  {
   this.x = x;
   this.y = y;
   this.width = width;
   this.height = height;
  }

 //取得座標
 public void setX(double x) 
  {
   this.x = x;
  }

 public void setY(double y)
  {
   this.y = y;
  }

 //取得長寬
 public void setWidth(double width)
  {
   this.width = width;
  }

 public void setHeight(double height)
  {
   this.height = height;
  }

 //回傳座標
 public double getX()
  {
   return x;
  }

 public double getY()
  {
   return y;
  }

 //回傳長寬
 public double getWidth()
  {
   return width;
  }

 public double getHeight()
  {
   return height;
  }

 public double getArea() //回傳面積
  {
   return width * height;
  }

 public double getPerimeter() //回傳周長
  {
   return 2*(width+height);
  }

 public boolean contains(double x1,double y1) //驗證是否包含(點)
  {
   double dx1 = x - width/2;
   double dy1 = y - height/2;
   double dx2 = x + width/2;
   double dy2 = y + height/2;
   
   //以長方形四點X Y 為最大/小值 檢查點是否落在這範圍
   return (x1 >=dx1 && x1 <= dx2 && y1 >= dy1 && y1 <= dy2);
  }

 public boolean contains(Rectangle2D r)//驗證是否包含(長方形)
  {
   //判斷被包含長方形四點是否都被包含
   boolean bx = (x-width/2 <= r.getX()-r.getWidth()/2 && x+width/2 >= r.getX()+r.getWidth()/2);
   boolean by = (y-height/2 <= r.getY()-r.getHeight()/2 && y+height/2 >= r.getY()+r.getHeight()/2);

   return (bx && by);
  }

 public boolean overlaps(Rectangle2D r) //驗證是否相交
  {
   //先以兩個長方形長寬算出不相交最小距離
   double Hpow = Math.pow(height+r.getHeight(),2);
   double Wpow = Math.pow(width-r.getWidth(),2);
   double min = Math.sqrt(Hpow+Wpow);
   
   //計算兩中心距離
   double dx = Math.pow(x-r.getX(),2);
   double dy = Math.pow(y-r.getY(),2);
   double distance = Math.sqrt(dx+dy);
   //判斷距離是否太大以及是否互相包含
   return ( distance<min && !contains(r) && !r.contains(new Rectangle2D(x,y,width,height)));
  }
}