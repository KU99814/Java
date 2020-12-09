//sierpinski triangle

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX20_19 extends JFrame
{
 private int order = 0; //描繪次數
 private JButton jbLeft = new JButton(); //減少次數按鈕
 private JButton jbRight = new JButton(); //增加次數按鈕
 private SierpinskiTrianglePanel trianglePanel = new SierpinskiTrianglePanel();//繪圖panel

 public EX20_19()
  {
   //加入按鈕圖片
   jbLeft.setIcon(new ImageIcon("left.gif"));//左
   jbRight.setIcon(new ImageIcon("right.gif"));//右

   JPanel panel = new JPanel();//按鈕面板
 
   //加入按鈕
   panel.add(jbLeft);
   panel.add(jbRight);

   //對齊
   jbLeft.setHorizontalAlignment(SwingConstants.CENTER);
   jbRight.setHorizontalAlignment(SwingConstants.CENTER);
   
   //整合
   add(trianglePanel);
   add(panel,BorderLayout.SOUTH);

   //加入按鈕動作
   jbLeft.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     if(order>0)
      {
       order--;//減少次數
       trianglePanel.setOrder(order);//重繪
      }
    }
   });
   
   jbRight.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     order++;//增加次數
     trianglePanel.setOrder(order);//重繪
    }
   });
  }

 public static void main(String args[])
  {
   EX20_19 frame = new EX20_19();

   frame.setTitle("EX20_19");//宣告視窗
   frame.setSize(300,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //繪圖panel
 static class SierpinskiTrianglePanel extends JPanel
  {
   private int order = 0;//繪圖次數

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
     
     //初始點座標
     Point p1 = new Point(getWidth()/2,10);
     Point p2 = new Point(10,getHeight()-10);
     Point p3 = new Point(getWidth() - 10,getHeight()-10);
     
     //遞迴
     displayTriangles(g,order,p1,p2,p3);
    }

   //遞迴 取每個邊中點繪出三角形
   private static void displayTriangles(Graphics g,int order,Point p1,Point p2,Point p3)
    {
     if(order >= 0)
      {
       //繪出三角形
       g.drawLine(p1.x,p1.y,p2.x,p2.y);
       g.drawLine(p1.x,p1.y,p3.x,p3.y);
       g.drawLine(p2.x,p2.y,p3.x,p3.y);
     
       //取三邊中點
       Point midBetweenP1P2 = midpoint(p1,p2);
       Point midBetweenP2P3 = midpoint(p2,p3);
       Point midBetweenP3P1 = midpoint(p3,p1);
     
       //將所有點加入遞迴
       displayTriangles(g,order-1,p1,midBetweenP1P2,midBetweenP3P1);
       displayTriangles(g,order-1,midBetweenP1P2,p2,midBetweenP2P3);
       displayTriangles(g,order-1,midBetweenP3P1,midBetweenP2P3,p3);
      }
    }

   //取中點
   private static Point midpoint(Point p1,Point p2)
    {
     return new Point((p1.x+p2.x)/2,(p1.y+p2.y)/2);
    }
  }
}