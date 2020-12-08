//Geometry:inside a triangle

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_21 extends JFrame
{
 //�ŧi�c���T���Ϊ��T�I
 MyPoint p1 = new MyPoint(20,20);
 MyPoint p2 = new MyPoint(100,100);
 MyPoint p3 = new MyPoint(140,40);

 //�ŧi�T����
 Triangle2D t = new Triangle2D(p1,p2,p3);

 public EX15_21()
  {
   add(new InTriangle());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX15_21 frame = new EX15_21();//�ŧi����
   frame.setTitle("EX15_21");//���D
   frame.setSize(300,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�T����panel
 class InTriangle extends JPanel
  {
   //�ƹ���m
   int mouseX = -1;
   int mouseY = -1;

   public InTriangle()
    {
     //�[�J�ƹ��ʧ@�ƥ�
     addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
       //���o�ƹ���m
       mouseX = e.getX();
       mouseY = e.getY();
       repaint();//��ø
      }
     });
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //�ŧi�h���
     Polygon p = new Polygon();

     //�[�J�T���ΤT�I
     p.addPoint((int)(p1.getX()),(int)(p1.getY()));
     p.addPoint((int)(p2.getX()),(int)(p2.getY()));
     p.addPoint((int)(p3.getX()),(int)(p3.getY()));

     g.drawPolygon(p);//ø��
     
     MyPoint mp = new MyPoint(mouseX,mouseY);//�ƹ���m

     //�P�_�O�_�]�t
     if(t.contains(mp))
      g.drawString("Mouse point inside the triangle",mouseX,mouseY);
     else
      g.drawString("Mouse point is not in the triangle",mouseX,mouseY);
    }
  }

 //�T����class
 class Triangle2D
  {
   MyPoint p1,p2,p3;//�T���I
 
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

   //�]�wP1
   public void setP1(MyPoint p1)
    {
     this.p1 = p1;
    }

   //�^��P1
   public MyPoint getP1()
    {
     return p1;
    }

   //�]�wP2
   public void setP2(MyPoint p2)
    {
     this.p1 = p2;
    }

   //�^��P2
   public MyPoint getP2()
    {
     return p2;
    }

   //�]�wP3
   public void setP3(MyPoint p3)
    {
     this.p3 = p3;
    }

   //�^��P3
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

     return Math.abs((x1*(y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))/2);
    }

   //���o�P��
   public double getPerimeter()
    {
     return (p1.distance(p2) + p1.distance(p3) + p3.distance(p2));
    }

   //�ˬd�O�_�]�t(�I)
   public boolean contains(MyPoint p)
    {
     //�N�I�P�T���I���U���I�զ��T���� �Y�I�b�T���Τ�
     //�h���n�`�M����T����
     Triangle2D t1 = new Triangle2D(p1,p2,p);
     Triangle2D t2 = new Triangle2D(p2,p3,p);
     Triangle2D t3 = new Triangle2D(p3,p1,p);

     if(p == p1 || p == p2 || p == p3)
      return true;

     return ((t1.getArea() + t2.getArea() + t3.getArea()) == getArea());
    }

   //�P�_�O�_�]�t(�T����)
   public boolean contains(Triangle2D t)
    {
     //�P�_�T���I�O�_���]�t
     boolean c1 = contains(t.getP1());
     boolean c2 = contains(t.getP2());
     boolean c3 = contains(t.getP3());

     return c1 && c2 && c3;
    }
  }

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
}