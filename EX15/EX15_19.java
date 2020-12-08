//Display multiple message where clicked

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_19 extends JFrame
{
 public EX15_19()
  {
   add(new TwoCircle());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX15_19 frame = new EX15_19();//宣告視窗
   frame.setTitle("EX15_19");//標題
   frame.setSize(500,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //兩圓class
 class TwoCircle extends JPanel
  {
   //儲存滑鼠座標
   int mouseX = 0;
   int mouseY = 0;

   //顯示字串
   String message = "";

   boolean start = false;//是否開始

   //建構子
   public TwoCircle()
    {
     //加入滑鼠動作
     addMouseListener(new MouseAdapter() {
      //點擊
      public void mouseClicked(MouseEvent e) {
       //取得滑鼠座標
       mouseX = e.getX();
       mouseY = e.getY();

       start = true;//開始顯示
       repaint();//重繪
      }
     });
    }

   //判斷是否在園內 兩圓半徑皆75 故統一判斷
   public boolean inside(int x1,int y1,int x2,int y2)
    {
     //計算距離
     int distance = (int)(Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)));
      
     if(distance <=75)
      return true;
     else 
      return false;
    }   

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //劃出兩個圓
     g.setColor(Color.red);
     g.fillOval(50,50,150,150);
     g.setColor(Color.cyan);
     g.fillOval(210,210,150,150);

     if(start)//開始顯示字串
      {
       g.setColor(Color.black);
       //根據滑鼠位置顯示相應字串
       if(inside(125,125,mouseX,mouseY))
        g.drawString("You clicked inside red circle",mouseX,mouseY);
       else if(inside(285,285,mouseX,mouseY))
        g.drawString("You clicked inside cyan circle",mouseX,mouseY);
       else
        g.drawString("You  didn't click inside any circle",mouseX,mouseY);
      }
    }
  }
}