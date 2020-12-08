//change the color of a circle

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX15_1 extends JFrame
{
 public EX15_1()
  {
   add(new ChangeCircleColor());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX15_1 frame = new EX15_1();//宣告視窗
   frame.setTitle("EX15_1");//標題
   frame.setSize(200,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //圓圈class
 class ChangeCircleColor extends JPanel
  {
   Color color = Color.red;//顏色
   int type = 0;   

   public ChangeCircleColor()
    {
     //加入滑鼠動作
     addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        //滑鼠點擊時座標
        int x = e.getX();
        int y = e.getY();
 
        //判斷距離是否小於半徑
        if(distance(x,y)<=10)
         {
          //判斷應該改變的顏色
          switch(type){
           case 0:color = Color.blue;
                  type = 1;
                  break;
           case 1:color = Color.red;
                  type = 0;
                  break;
          }
          repaint();//重繪
         }
       }
     });
    }

   //計算與圓心距離
   public int distance(int x,int y)
    {
     double dx = Math.pow(x-getWidth()/2,2);
     double dy = Math.pow(y-getHeight()/2,2);

     return (int)(Math.sqrt(dx+dy));
    }
  
   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
    
     //繪出圓 
     g.setColor(color);
     g.fillOval(getWidth()/2-10,getHeight()/2-10,20,20);
    }
  }
}