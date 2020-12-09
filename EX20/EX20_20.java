//Display circles

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX20_20 extends JFrame
{
 private DisplayOvalPanel ovalPanel = new DisplayOvalPanel();//繪圖panel

 public EX20_20()
  {
   add(ovalPanel);//加入panel
  }

 public static void main(String args[])
  {
   EX20_20 frame = new EX20_20();
   
   frame.setTitle("EX20_20");//標題
   frame.setSize(300,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //繪圖
 class DisplayOvalPanel extends JPanel
  {
   private int order = 1;//繪圖次數

   //設定次數
   public void setOrder(int order)
    {
     this.order = order;
     repaint();
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     displayOval(g,order);//遞迴方法
    }

   //繪圖遞迴
   private void displayOval(Graphics g,int order)
    {
     if(order <= 15)//到15為止
      {
       //繪製圓
       g.drawOval((getWidth()/2)-5*order,(getHeight()/2)-5*order,order*10,order*10);
     
       //遞迴
       displayOval(g,order+1);
      }
    }
  }
}