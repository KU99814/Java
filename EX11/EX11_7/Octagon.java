public class Octagon extends GeometricObject implements Cloneable, Comparable
{
 private double size;//邊長

 //建構子
 public Octagon()
  {
   this(1.0);
  }

 public Octagon(double size)
  {
   this.size = size;
  }

 //設定長度
 public void setSize()
  {
   this.size = size;
  }

 //取得面積
 public double getArea()
  {
   return (2+(4/Math.sqrt(2)))*size*size;
  }

 //取得周長
 public double getPerimeter()
  {
   return 8*size;
  }

 //複製
 public Object clone()
  {
   try 
    {
     Octagon octagon = (Octagon)super.clone();
     return octagon;
    }
    catch (CloneNotSupportedException ex) 
     {
      return null;
     }
   }

 //比較
 public int compareTo(Object o)
  {
   return (int)(getArea() - ((Octagon)o).getArea());
  }
}