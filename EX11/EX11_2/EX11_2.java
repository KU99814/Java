//The ComparableCircle use implement

public class EX11_2
{
 public static void main(String args[])
  {
   //宣告兩個圓
   ComparableCircle c1 = new ComparableCircle(10);
   ComparableCircle c2 = new ComparableCircle(20);
   
   System.out.print("The two circle the larger is "+(c1.compareTo(c2)>0 ? "c1": "c2"));//比較大小
  }
}

class ComparableCircle extends Circle implements Comparable
{
 //建構子
 public ComparableCircle()
  {
   super();
  }

 public ComparableCircle(double r)
  {
   super(r);
  }

 public int compareTo(Object o)//比較大小
  {
   return (int)(getArea() -( (Circle)o).getArea());
  }
}