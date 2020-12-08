public class Square extends GeometricObject implements Colorable
{
 private double side;//邊長

 //建構子
 public Square()
  {
   this(1.0,"While");
  }

 public Square(double side,String color)
  {
   super.setColor(color);
   this.side = side;
  }

 //取得面積
 public double getArea()
  {
   return side * side;
  }

 //取得周長
 public double getPerimeter()
  {
   return side * 4;
  }

 //定義如何塗色
 public String howToColor()
  {
   return "make it "+super.getColor();
  }
}