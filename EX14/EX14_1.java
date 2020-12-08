//Displaying nine rectangles as a grid

import javax.swing.*;
import java.awt.*;

public class EX14_1 extends JFrame 
{
 public EX14_1()
  {
   JPanel p1 = new NineRectangle();//宣告panel
   add(p1);
  }

 public static void main(String args[])
  {
   EX14_1 frame = new EX14_1();//宣告視窗
   frame.setSize(300,150);//大小
   frame.setTitle("EX14_1"); //標題
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true); //顯示
  }
}

//顯示長方形grid
class NineRectangle extends JPanel
{
 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);//必要
   
   int width = getSize().width;   //畫面長
   int height = getSize().height; //畫面寬
   
   int w = (int)(width/3); //邊長
   int h = (int)(height/3);


   //九個長方形
   g.setColor(Color.black);//黑
   g.fillRect(w*0,h*0,w,h);

   g.setColor(Color.red);//紅
   g.fillRect(w*1,h*0,w,h);

   g.setColor(Color.blue);//藍
   g.fillRect(w*2,h*0,w,h);

   g.setColor(Color.white);//白
   g.fillRect(w*0,h*1,w,h);

   g.setColor(Color.yellow);//黃
   g.fillRect(w*1,h*1,w,h);

   g.setColor(Color.green);//綠
   g.fillRect(w*2,h*1,w,h);

   g.setColor(Color.gray);//灰
   g.fillRect(w*0,h*2,w,h);
   
   g.setColor(Color.pink);//粉紅
   g.fillRect(w*1,h*2,w,h);

   g.setColor(Color.orange);//橘
   g.fillRect(w*2,h*2,w,h);
  }
}