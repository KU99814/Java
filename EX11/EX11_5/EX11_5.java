//Enabling Circle Comparable

public class EX11_5 extends Circle
{
 public static void main(String args[])
  {
   //宣告兩個圓
   Circle c1 = new Circle(10);
   Circle c2 = new Circle(30);

   //判斷是否相等
   System.out.print("The two circle is equal ? "+c1.equals(c2));
  }
} 