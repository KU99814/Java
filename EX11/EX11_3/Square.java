public class Square extends GeometricObject implements Colorable
{
 private double side;//���

 //�غc�l
 public Square()
  {
   this(1.0,"While");
  }

 public Square(double side,String color)
  {
   super.setColor(color);
   this.side = side;
  }

 //���o���n
 public double getArea()
  {
   return side * side;
  }

 //���o�P��
 public double getPerimeter()
  {
   return side * 4;
  }

 //�w�q�p����
 public String howToColor()
  {
   return "make it "+super.getColor();
  }
}