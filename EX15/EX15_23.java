//Geometry:closest pair of points

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class EX15_23 extends JFrame
{
 public EX15_23()
  {
   add(new ClosestPoint());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX15_23 frame = new EX15_23();//宣告視窗
   frame.setTitle("EX15_23");//標題
   frame.setSize(500,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 class ClosestPoint extends JPanel
  {
   ArrayList list = new ArrayList();//儲存點陣列

   public ClosestPoint()
    {
     //加入滑鼠事件
     addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
       MyPoint p = new MyPoint(e.getX(),e.getY()); //新增點
       list.add(p);//加入陣列
       repaint();//重繪
      }
     });
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //先預設最短距離
     int minDis = (int)(Math.sqrt(Math.pow(getWidth(),2) + Math.pow(getHeight(),2))); 

     for(int i=0;i<list.size()-1;i++) //逐個比較各點距離
      {
       MyPoint p1 = (MyPoint)(list.get(i));
       for(int j=i+1;j<list.size();j++)
        {
         MyPoint p2 = (MyPoint)(list.get(j));
         
         if(p1.distance(p2) <minDis) //如是最小距離就塗黑
          {
           minDis = p1.distance(p2);
           for(int k=0;k<list.size()-1;k++)
            {
             MyPoint p = (MyPoint)(list.get(k));
             p.setFill(false);
            }
           p1.setFill(true);
           p2.setFill(true);
          }
        }
      }

     int count = 0;
     //繪出點
     for(int i=0;i<list.size();i++)
      {
       MyPoint p = (MyPoint)(list.get(i));

       if(p.getFill()&&count<2)
        {
         g.fillOval(p.getX(),p.getY(),5,5);
         count++;
        }
       else
        g.drawOval(p.getX(),p.getY(),5,5);
      }
    }
  }

 //點class
 class MyPoint
  {
   //座標
   private int x;
   private int y;

   //是否填滿
   private boolean fill;
   
   //建構子
   public MyPoint(int x,int y)
    {
     this.x = x;
     this.y = y;
     fill = false;
    }

   //取得座標X Y
   public int getX()
    {
     return x;
    }

   public int getY()
    {
     return y;
    }

   //設定填滿
   public void setFill(boolean fill)
    {
     this.fill = fill;
    }

   //回傳是否填滿
   public boolean getFill()
    {
     return fill;
    }

   //計算距離
   public int distance(MyPoint p)
    {
     return (int)(Math.sqrt(Math.pow((p.getX() - x),2) + Math.pow((p.getY()-y),2)));
    }
  }
}