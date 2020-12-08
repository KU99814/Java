//Geometry:inside a rectangle

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_20 extends JFrame
{
 Rectangle2D r = new Rectangle2D(100,60,100,40);//�ŧi�����

 public EX15_20()
  {
   add(new InRectangle());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX15_20 frame = new EX15_20();//�ŧi����
   frame.setTitle("EX15_20");//���D
   frame.setSize(300,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //��ܪ����panel
 class InRectangle extends JPanel
  {
   //�ƹ��y��
   int mouseX = -1;
   int mouseY = -1;

   //�غc�l
   public InRectangle()
    {
     //�[�J�ƹ��ʧ@
     addMouseMotionListener(new MouseMotionAdapter() {
      //�ƹ�����Ĳ�o
      public void mouseMoved(MouseEvent e) {
       //���o�ƹ���m
       mouseX = e.getX();
       mouseY = e.getY();
       repaint();//��ø
      }
     });
    }

   //
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //���oø�ϥήy��
     int x = (int)(r.getX()-r.getWidth()/2);
     int y = (int)(r.getY()-r.getHeight()/2);

     //�e�X�����
     g.drawRect(x,y,(int)(r.getWidth()),(int)(r.getHeight()));

     //�P�_�O�_�b����Τ�
     if(r.contains(mouseX,mouseY))
      g.drawString("Mouse point inside the rectangle",mouseX,mouseY);
     else
      g.drawString("Mouse point is not in the rectangle",mouseX,mouseY);
    }
  }

 class Rectangle2D
  {
   private double x,y; //���߮y��
   private double width,height; //�e�P��

   //�غc�l
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

   //�]�w�y��
   public void setX(double x) 
    {
     this.x = x;
    }

   public void setY(double y)
    {
     this.y = y;
    }

   //�]�w���e
   public void setWidth(double width)
    {
     this.width = width;
    }

   public void setHeight(double height)
    {
     this.height = height;
    }

   //�^�Ǯy��
   public double getX()
    {
     return x;
    }

   public double getY()
    {
     return y;
    }

   //�^�Ǫ��e
   public double getWidth()
    {
     return width;
    }

   public double getHeight()
    {
     return height;
    }

   public double getArea() //�^�ǭ��n
    {
     return width * height;
    }

   public double getPerimeter() //�^�ǩP��
    {
     return 2*(width+height);
    }

   public boolean contains(double x1,double y1) //���ҬO�_�]�t(�I)
    {
     double dx1 = x - width/2;
     double dy1 = y - height/2;
     double dx2 = x + width/2;
     double dy2 = y + height/2;
    
     return (x1 >=dx1 && x1 <= dx2 && y1 >= dy1 && y1 <= dy2);
    }

   //�P�_�O�_�]�t(�����)
   public boolean contains(Rectangle2D r)
    {
     boolean bx = (x-width/2 <= r.getX()-r.getWidth()/2 && x+width/2 >= r.getX()+r.getWidth()/2);
     boolean by = (y-height/2 <= r.getY()-r.getHeight()/2 && y+height/2 >= r.getY()+r.getHeight()/2);

     return (bx && by);
    }

   public boolean overlaps(Rectangle2D r) //���ҬO�_�ۥ�
    {
     double dx = Math.abs(x - r.getX());
     double dy = Math.abs(y - r.getY());

     return (dx < width && dy < height && !contains(r));
    }
  }
}