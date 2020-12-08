//Game:bean machian

import javax.swing.*;
import java.awt.*;

public class EX14_24 extends JFrame
{
 public EX14_24()
  {
   add(new BeanMachine());//加入
  }

 public static void main(String args[])
  {
   EX14_24 frame = new EX14_24();//宣告視窗
   frame.setTitle("EX14_24");//標題
   frame.setSize(300,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

class BeanMachine extends JPanel
{
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
   int dis = 10;
   for(int i=1;i<8;i++)
    {
     int x = getWidth()/2-dis*(i-1);
     int y = getHeight()/2-80 + 20*(i-1); 
     for(int j=1;j<=i;j++)
      g.fillOval(x-5+(j-1)*20,y-10,10,10);
    }  
  }
}