//Moving a circle using keys

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_17 extends JFrame
{
 public EX15_17()
  {
   add(new MouseMoveCircle());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX15_17 frame = new EX15_17();//宣告視窗
   frame.setTitle("EX15_17");//標題
   frame.setSize(200,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //滑鼠動作class
 class MouseMoveCircle extends JPanel
  {
   //滑鼠座標
   int mouseX = 0;
   int mouseY = 0;

   boolean first = true;//確認滑鼠是否點擊 避免誤判

   //圓座標
   int circleX = 50;
   int circleY = 50;
   
   //建構子
   public MouseMoveCircle()
    {
     //滑鼠事件

     //以按壓更新滑鼠座標
     addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
       mouseX = e.getX();
       mouseY = e.getY();
      }
     });

     addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
       if(first)//第一次點擊
        {
         mouseX = e.getX();
         mouseY = e.getY();
         first = false;
        }
       else
        {
         //判斷滑鼠是否在圓內
         if(inside(e.getX(),e.getY(),circleX,circleY))
          {
           //滑鼠移動距離
           int distX = e.getX() - mouseX;
           int distY = e.getY() - mouseY;
           
           //讓圓跟著移動
           circleX += distX;
           circleY += distY;

           //更新滑鼠座標
           mouseX = e.getX();
           mouseY = e.getY();
          }
        }
       repaint();//重繪
      }
     });
    }
   
   //半段是否在圓內
   public boolean inside(int x1,int y1,int x2,int y2)
    {
     //與圓心距離
     int distance = (int)(Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)));
      
     //判斷是否小於半徑
     if(distance <=10)
      return true;
     else 
      return false;
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //繪圓
     g.drawOval(circleX-5,circleY-5,10,10);
    }
  }
}