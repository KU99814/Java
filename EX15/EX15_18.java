//Game:eye-hand coordination

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_18 extends JFrame
{
 public EX15_18()
  {
   add(new EyeHand());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX15_18 frame = new EX15_18();//宣告視窗
   frame.setTitle("EX15_18");//標題
   frame.setSize(200,100);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 class EyeHand extends JPanel
  {
   //圓心座標
   int centerX;
   int centerY;

   boolean touch = false;//判斷是否點擊到
   boolean first = true; //判斷是否第一個圓

   long currentTime;//開始時間

   int count = 0;//計數器 代表點擊幾次

   public EyeHand()
    {
     System.out.println("circle1"+centerX+" "+centerY+" ");
     
     currentTime = System.currentTimeMillis();//開始時間

     //加入滑鼠動作
     addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
       //判斷是否在圓內
       if(distance(e.getX(),e.getY(),centerX,centerY)<=10 && count<20)
        {
         touch = true;
         count++;//+1
         repaint();//重繪
        }
      }
     });
    }

   //計算距離
   public int distance(int x1,int y1,int x2,int y2)
    {
     return (int)(Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)));
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //顏色數據r g b隨機選擇
     int r = (int)(Math.random()*256);
     int green = (int)(Math.random()*256);
     int b = (int)(Math.random()*256);

     //第一次時要另外定義座標
     if(first)
      {
       centerX = (int)(Math.random()*(getWidth()-10))+10;
       centerY = (int)(Math.random()*(getHeight()-10))+10;
       first = false;//關閉
      }

     //點擊數小於20畫圓
     if(count<20)
      {
       if(touch)//如果點擊到 重新畫圓
        {
         centerX = (int)(Math.random()*(getWidth()-20))+10;
         centerY = (int)(Math.random()*(getHeight()-20))+10;
         touch = false;
        }
       //畫圓
       g.setColor(new Color(r,green,b));
       g.fillOval(centerX-20,centerY-20,20,20);
       
      }
     else//點到第20次出現花費時間
      {
       currentTime = System.currentTimeMillis() - currentTime;
       g.setColor(Color.black);
       g.drawString("Time spent "+ currentTime + " milliseconds",20,10);
       count++;
      }
    }
  }
}