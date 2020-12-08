//The Colorable interface

public class EX11_3 extends Square
{
 public static void main(String args[])
  {
   //宣告各種正方形
   GeometricObject[] o = {new Square(10,"white"),
                          new Square(10,"Black"),
                          new Square(10,"red"),
                          new Square(10,"Blue"),
                          new Square(10,"yellow")};

   //顯示如何塗色
   for(int i=0;i<5;i++)
    if(o[i] instanceof Colorable)
     System.out.println(((Colorable)o[i]).howToColor());
  }
}