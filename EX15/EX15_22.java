//Game:bean machian animation

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX15_22 extends JFrame
{
 public EX15_22()
  {
   add(new BeanMachine());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX15_22 frame = new EX15_22();//宣告視窗
   frame.setTitle("EX15_22");//標題
   frame.setSize(300,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//球檯panel
class BeanMachine extends JPanel
{
 //球座標陣列
 int[] ballX = new int[10];
 int[] ballY = new int[10];

 //目前行動求座標
 int startBallX = 0;
 int startBallY = 0;

 boolean start = true;//開始信號

 //記球數
 int count = 0;
 int rount = 0;//計行數
 int[] rowY = new int[8];//行

 public BeanMachine()
  {
   //計時器
   Timer timer = new Timer(100,new TimerListener());
   timer.start();//開始動作
  }

 //計時事件
 public class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     repaint();//重繪
    }
  }

 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   //入口
   g.drawLine(getWidth()/2-10,getHeight()/2-120,getWidth()/2-10,getHeight()/2-100);
   g.drawLine(getWidth()/2+10,getHeight()/2-120,getWidth()/2+10,getHeight()/2-100);

   //斜線
   g.drawLine(getWidth()/2-10,getHeight()/2-100,getWidth()/2-80,getHeight()/2+40);
   g.drawLine(getWidth()/2+10,getHeight()/2-100,getWidth()/2+80,getHeight()/2+40);

   //底部
   g.drawLine(getWidth()/2-80,getHeight()/2+40,getWidth()/2-80,getHeight()/2+100);
   g.drawLine(getWidth()/2+80,getHeight()/2+40,getWidth()/2+80,getHeight()/2+100);
   g.drawLine(getWidth()/2-80,getHeight()/2+100,getWidth()/2+80,getHeight()/2+100);

   //欄杆
   for(int i=1;i<8;i++)
    g.drawLine(getWidth()/2-80+(20*i),getHeight()/2+40,getWidth()/2-80+(20*i),getHeight()/2+100);

   //柱子
   for(int i=1;i<8;i++)
    {
     int x = getWidth()/2-10*(i-1);
     int y = getHeight()/2-80 + 20*(i-1); 
     for(int j=1;j<=i;j++)
      g.fillOval(x-5+(j-1)*20,y-10,10,10);
    }

   //起始定義欄位
   if(count==0)
    {
     for(int i=0;i<8;i++)
      rowY[i] = getHeight()/2+100-10;
    }
   
   if(start && count<10) //開始狀態
    {
     startBallX = getWidth()/2-5;     //新的座標
     startBallY = getHeight()/2-120+10;
     rount = 0;//決定掉落行
     start = false;
    }

   else if(!start && count<10)//掉落狀態
    {
     g.setColor(Color.red);
     g.fillOval(startBallX,startBallY,10,10);//畫球
     
     if(startBallY < getHeight()/2+40) //球落到欄位前的行動
      {
       if((startBallY -(getHeight()/2-80))%20==0) //碰到柱子時的處理
        {
         int i = (int)(Math.random()*2);  //決定左右
         if(i==0)
          startBallX -=10;
         else if(i==1)
          startBallX +=10;

         rount+=i;
        }
       startBallY+=10; 
      }
     else
      {
       if(startBallY!=rowY[rount]) //決定最終落點
        startBallY+=10;
       else
        {
         ballX[count] = startBallX;
         ballY[count] = startBallY;
         rowY[rount]-=10;
         count++;
         start = true;
        }
      }
    }
   
   g.setColor(Color.red);  //繪出每一顆球
   for(int i=0;i<count;i++)
    {
     g.fillOval(ballX[i],ballY[i],10,10);
    } 
  }
}