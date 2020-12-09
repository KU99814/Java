//H-tree fractal

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX20_35 extends JFrame
{
 private JTextField jtfOrder = new JTextField(5);//輸入欄 輸入繪圖次數
 private HPanel hPanel = new HPanel();//繪圖

 public EX20_35()
  {
   JPanel panel = new JPanel();//操作panel

   //加入component
   panel.add(new JLabel("Enter an order: "));
   panel.add(jtfOrder);

   //對齊
   jtfOrder.setHorizontalAlignment(SwingConstants.CENTER);
   
   //整合
   add(hPanel);
   add(panel,BorderLayout.SOUTH);

   //加入動作
   jtfOrder.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     //輸入次數 繪圖
     hPanel.setOrder(Integer.parseInt(jtfOrder.getText()));
    }
   });
  }

 public static void main(String args[])
  {
   EX20_35 frame = new EX20_35();//宣告視窗

   frame.setTitle("EX20_35");
   frame.setSize(400,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //繪圖panel
 static class HPanel extends JPanel
  {
   private int order = 0;//遞迴次數

   //設定次數並繪圖
   public void setOrder(int order)
    {
     this.order = order;
     repaint();
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //第一個點 設在中心
     Point p1 = new Point(getWidth()/2,getHeight()/2);
     
     //繪圖method
     displayH(g,order,p1,getWidth()/3);
    }

   private static void displayH(Graphics g,int order,Point p1,int length)
    {
     //取得繪製H的六個點 從中心點延伸
     Point p2 = new Point(p1.x-length/2,p1.y-length/2);
     Point p3 = new Point(p1.x-length/2,p1.y);
     Point p4 = new Point(p1.x-length/2,p1.y+length/2);
     Point p5 = new Point(p1.x+length/2,p1.y-length/2);
     Point p6 = new Point(p1.x+length/2,p1.y);
     Point p7 = new Point(p1.x+length/2,p1.y+length/2);

     if(order == 0)//base case
      {
       //繪製H
       g.drawLine(p2.x,p2.y,p4.x,p4.y);
       g.drawLine(p3.x,p3.y,p6.x,p6.y);
       g.drawLine(p5.x,p5.y,p7.x,p7.y);
      }
     else
      {
       //繪製H
       g.drawLine(p2.x,p2.y,p4.x,p4.y);
       g.drawLine(p3.x,p3.y,p6.x,p6.y);
       g.drawLine(p5.x,p5.y,p7.x,p7.y);

       //將其中四點作為中心點輸入遞迴
       displayH(g,order-1,p2,length/2);
       displayH(g,order-1,p4,length/2);
       displayH(g,order-1,p5,length/2);
       displayH(g,order-1,p7,length/2);
      }
    }
  }
}