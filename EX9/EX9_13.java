//The Triangle2D class

import java.awt.geom.*;

public class EX9_13
{
 public static void main(String args[])
  {
   //�ŧi�T����
   Triangle2D t1 = new Triangle2D(new MyPoint(2.5,2),new MyPoint(4.2,3),new MyPoint(5,3.5));

   System.out.println("The area is "+t1.getArea());//���n
   System.out.println("The perimeter is "+t1.getPerimeter());//�P��
   System.out.println("Is dot (3,3) contain ? "+t1.contains(new MyPoint(3,3)));//�P�_�]�t
   System.out.println("Is the triangle (2.9,2),(4,1),(1,3.4) contain ? "+
                    t1.contains(new Triangle2D(new MyPoint(2.9,2),new MyPoint(4,1),new MyPoint(1,3.4))));
  // �P�_�ۥ�
   System.out.println("Is the triangle (2,5.5),(4,-3),(2,6.5) overlap ? "+
                    t1.contains(new Triangle2D(new MyPoint(2,5.5),new MyPoint(4,-3),new MyPoint(2,6.5))));
  }
}  

//�T����class
class Triangle2D
{
 MyPoint p1,p2,p3;//�T�ӳ��I
 
 //�غc�l
 public Triangle2D()
  {
   this(new MyPoint(),new MyPoint(1,1),new MyPoint(2,5));
  }

 public Triangle2D(MyPoint p1,MyPoint p2,MyPoint p3)
  {
   this.p1 = p1;
   this.p2 = p2;
   this.p3 = p3;
  }

 //�]�w�T�I
 public void setP1(MyPoint p1)
  {
   this.p1 = p1;
  }

 public MyPoint getP1()
  {
   return p1;
  }

 public void setP2(MyPoint p2)
  {
   this.p1 = p2;
  }

 //�^�ǤT�I
 public MyPoint getP2()
  {
   return p2;
  }

 public void setP3(MyPoint p3)
  {
   this.p3 = p3;
  }

 public MyPoint getP3()
  {
   return p3;
  }

 //���o���n
 public double getArea()
  {
   double x1 = p1.getX();
   double y1 = p1.getY();
   double x2 = p2.getX();
   double y2 = p2.getY();
   double x3 = p3.getX();
   double y3 = p3.getY();

   //���n����
   return Math.abs((x1*(y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))/2);
  }

 //���o�P��
 public double getPerimeter()
  {
   //�T�I���Z���ۥ[
   return (p1.distance(p2) + p1.distance(p3) + p3.distance(p2));
  }

 public boolean contains(MyPoint p)//�P�_�]�t(�I)
  {
   //�N�n�P�_���I�P�T�I�I�U���I�զ��T����
   Triangle2D t1 = new Triangle2D(p1,p2,p);
   Triangle2D t2 = new Triangle2D(p2,p3,p);
   Triangle2D t3 = new Triangle2D(p3,p1,p);

   if(p == p1 || p == p2 || p == p3)
    return true;

   //�Y�T�ӤT���έ��n�ۥ[����]�t�T���� �ΥN���I�b�T���Τ�
   return ((t1.getArea() + t2.getArea() + t3.getArea()) == getArea());
  }

 public boolean contains(Triangle2D t)//�P�_�]�t(�T����)
  {
   //�P�_�O�_�T�I�Ҧb�T���Τ�
   boolean c1 = contains(t.getP1());
   boolean c2 = contains(t.getP2());
   boolean c3 = contains(t.getP3());

   return c1 && c2 && c3;
  }

 //�P�_�ۥ�
 public boolean overlaps(Triangle2D t)
  {
   if((contains(t.getP1()) || contains(t.getP2()) || contains(t.getP3())) && !contains(t))
    return true;
   
   //�ϥ�Line2D�ˬd�ۥ�
   Line2D l1 = new Line2D.Double(p1.getX(),p1.getY(),p2.getX(),p2.getY());
   Line2D l2 = new Line2D.Double(p2.getX(),p2.getY(),p3.getX(),p3.getY());
   Line2D l3 = new Line2D.Double(p3.getX(),p3.getY(),p1.getX(),p1.getY());
   Line2D l4 = new Line2D.Double(t.getP1().getX(),t.getP1().getY(),t.getP2().getX(),t.getP2().getY());
   Line2D l5 = new Line2D.Double(t.getP2().getX(),t.getP2().getY(),t.getP3().getX(),t.getP3().getY());
   Line2D l6 = new Line2D.Double(t.getP3().getX(),t.getP3().getY(),t.getP1().getX(),t.getP1().getY());

   //�ˬd��O�_���ۥ�
   if(l1.intersectsLine(l4) || l1.intersectsLine(l5) || l1.intersectsLine(l6))
    return true;
   if(l2.intersectsLine(l4) || l2.intersectsLine(l5) || l2.intersectsLine(l6))
    return true;
   if(l3.intersectsLine(l4) || l3.intersectsLine(l5) || l3.intersectsLine(l6))
    return true;

   return false;
  }
}

//�I��class
class MyPoint
{
 //�y��
 private double x;
 private double y;

 //�غc�l
 public MyPoint()
  {
   this(0.0,0.0);
  }

 public MyPoint(double x,double y)
  {
   this.x = x;
   this.y = y;
  }

 public double getX() //�DX
  {
   return x;
  }

 public double getY() //�DY
  {
   return y;
  }

 public double distance(MyPoint point) //�D�PMyPoint���Z��
  {
   double dx = Math.abs(point.getX() - x);
   double dy = Math.abs(point.getY() - y);

   return Math.sqrt(dx*dx + dy*dy);
  }

 public double distance(double px,double py) //�D�P���w�I���Z��
  {
   double dx = Math.abs(px - x);
   double dy = Math.abs(py - y);

   return Math.sqrt(dx*dx + dy*dy);
  }
}