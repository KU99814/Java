//Geometry:inside a rectangle

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_20 extends JFrame
{
 Rectangle2D r = new Rectangle2D(100,60,100,40);//宣告長方形

 public EX15_20()
  {
   add(new InRectangle());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX15_20 frame = new EX15_20();//宣告視窗
   frame.setTitle("EX15_20");//標題
   frame.setSize(300,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //顯示長方形panel
 class InRectangle extends JPanel
  {
   //滑鼠座標
   int mouseX = -1;
   int mouseY = -1;

   //建構子
   public InRectangle()
    {
     //加入滑鼠動作
     addMouseMotionListener(new MouseMotionAdapter() {
      //滑鼠移動觸發
      public void mouseMoved(MouseEvent e) {
       //取得滑鼠位置
       mouseX = e.getX();
       mouseY = e.getY();
       repaint();//重繪
      }
     });
    }

   //
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //取得繪圖用座標
     int x = (int)(r.getX()-r.getWidth()/2);
     int y = (int)(r.getY()-r.getHeight()/2);

     //畫出長方形
     g.drawRect(x,y,(int)(r.getWidth()),(int)(r.getHeight()));

     //判斷是否在長方形內
     if(r.contains(mouseX,mouseY))
      g.drawString("Mouse point inside the rectangle",mouseX,mouseY);
     else
      g.drawString("Mouse point is not in the rectangle",mouseX,mouseY);
    }
  }

 class Rectangle2D
  {
   private double x,y; //中心座標
   private double width,height; //寬與高

   //建構子
   public Rectangle2D()
    {
     this(0,0,1,1);
    }

   public Rectangle2D(double x,double y,double width,double height)
    {
     this.x = x;
     this.y = y;
     this.width = width;
     this.height = height;
    }

   //設定座標
   public void setX(double x) 
    {
     this.x = x;
    }

   public void setY(double y)
    {
     this.y = y;
    }

   //設定長寬
   public void setWidth(double width)
    {
     this.width = width;
    }

   public void setHeight(double height)
    {
     this.height = height;
    }

   //回傳座標
   public double getX()
    {
     return x;
    }

   public double getY()
    {
     return y;
    }

   //回傳長寬
   public double getWidth()
    {
     return width;
    }

   public double getHeight()
    {
     return height;
    }

   public double getArea() //回傳面積
    {
     return width * height;
    }

   public double getPerimeter() //回傳周長
    {
     return 2*(width+height);
    }

   public boolean contains(double x1,double y1) //驗證是否包含(點)
    {
     double dx1 = x - width/2;
     double dy1 = y - height/2;
     double dx2 = x + width/2;
     double dy2 = y + height/2;
    
     return (x1 >=dx1 && x1 <= dx2 && y1 >= dy1 && y1 <= dy2);
    }

   //判斷是否包含(長方形)
   public boolean contains(Rectangle2D r)
    {
     boolean bx = (x-width/2 <= r.getX()-r.getWidth()/2 && x+width/2 >= r.getX()+r.getWidth()/2);
     boolean by = (y-height/2 <= r.getY()-r.getHeight()/2 && y+height/2 >= r.getY()+r.getHeight()/2);

     return (bx && by);
    }

   public boolean overlaps(Rectangle2D r) //驗證是否相交
    {
     double dx = Math.abs(x - r.getX());
     double dy = Math.abs(y - r.getY());

     return (dx < width && dy < height && !contains(r));
    }
  }
}