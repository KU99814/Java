//Geometry:inside a triangle

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_21 extends JFrame
{
 //宣告構成三角形的三點
 MyPoint p1 = new MyPoint(20,20);
 MyPoint p2 = new MyPoint(100,100);
 MyPoint p3 = new MyPoint(140,40);

 //宣告三角形
 Triangle2D t = new Triangle2D(p1,p2,p3);

 public EX15_21()
  {
   add(new InTriangle());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX15_21 frame = new EX15_21();//宣告視窗
   frame.setTitle("EX15_21");//標題
   frame.setSize(300,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //三角形panel
 class InTriangle extends JPanel
  {
   //滑鼠位置
   int mouseX = -1;
   int mouseY = -1;

   public InTriangle()
    {
     //加入滑鼠動作事件
     addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
       //取得滑鼠位置
       mouseX = e.getX();
       mouseY = e.getY();
       repaint();//重繪
      }
     });
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //宣告多邊形
     Polygon p = new Polygon();

     //加入三角形三點
     p.addPoint((int)(p1.getX()),(int)(p1.getY()));
     p.addPoint((int)(p2.getX()),(int)(p2.getY()));
     p.addPoint((int)(p3.getX()),(int)(p3.getY()));

     g.drawPolygon(p);//繪圖
     
     MyPoint mp = new MyPoint(mouseX,mouseY);//滑鼠位置

     //判斷是否包含
     if(t.contains(mp))
      g.drawString("Mouse point inside the triangle",mouseX,mouseY);
     else
      g.drawString("Mouse point is not in the triangle",mouseX,mouseY);
    }
  }

 //三角形class
 class Triangle2D
  {
   MyPoint p1,p2,p3;//三頂點
 
   //建構子
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

   //設定P1
   public void setP1(MyPoint p1)
    {
     this.p1 = p1;
    }

   //回傳P1
   public MyPoint getP1()
    {
     return p1;
    }

   //設定P2
   public void setP2(MyPoint p2)
    {
     this.p1 = p2;
    }

   //回傳P2
   public MyPoint getP2()
    {
     return p2;
    }

   //設定P3
   public void setP3(MyPoint p3)
    {
     this.p3 = p3;
    }

   //回傳P3
   public MyPoint getP3()
    {
     return p3;
    }

   //取得面積
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

   //取得周長
   public double getPerimeter()
    {
     return (p1.distance(p2) + p1.distance(p3) + p3.distance(p2));
    }

   //檢查是否包含(點)
   public boolean contains(MyPoint p)
    {
     //將點與三頂點中各兩點組成三角形 若點在三角形內
     //則面積總和等於三角形
     Triangle2D t1 = new Triangle2D(p1,p2,p);
     Triangle2D t2 = new Triangle2D(p2,p3,p);
     Triangle2D t3 = new Triangle2D(p3,p1,p);

     if(p == p1 || p == p2 || p == p3)
      return true;

     return ((t1.getArea() + t2.getArea() + t3.getArea()) == getArea());
    }

   //判斷是否包含(三角形)
   public boolean contains(Triangle2D t)
    {
     //判斷三頂點是否都包含
     boolean c1 = contains(t.getP1());
     boolean c2 = contains(t.getP2());
     boolean c3 = contains(t.getP3());

     return c1 && c2 && c3;
    }
  }

 class MyPoint
  {
   //座標
   private double x;
   private double y;

   //建構子
   public MyPoint()
    {
     this(0.0,0.0);
    }

   public MyPoint(double x,double y)
    {
     this.x = x;
     this.y = y;
    }

   public double getX() //求X
    {
     return x;
    }

   public double getY() //求Y
    {
     return y;
    }

   public double distance(MyPoint point) //求與MyPoint的距離
    {
     double dx = Math.abs(point.getX() - x);
     double dy = Math.abs(point.getY() - y);

     return Math.sqrt(dx*dx + dy*dy);
    }

   public double distance(double px,double py) //求與指定點的距離
    {
     double dx = Math.abs(px - x);
     double dy = Math.abs(py - y);

     return Math.sqrt(dx*dx + dy*dy);
    }
  }
}