public class Octagon extends GeometricObject implements Cloneable, Comparable
{
 private double size;//���

 //�غc�l
 public Octagon()
  {
   this(1.0);
  }

 public Octagon(double size)
  {
   this.size = size;
  }

 //�]�w����
 public void setSize()
  {
   this.size = size;
  }

 //���o���n
 public double getArea()
  {
   return (2+(4/Math.sqrt(2)))*size*size;
  }

 //���o�P��
 public double getPerimeter()
  {
   return 8*size;
  }

 //�ƻs
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

 //���
 public int compareTo(Object o)
  {
   return (int)(getArea() - ((Octagon)o).getArea());
  }
}