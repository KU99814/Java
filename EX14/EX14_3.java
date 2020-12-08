//Displaying a checkerboard

import javax.swing.*;
import java.awt.*;

public class EX14_3 extends JFrame 
{
 public EX14_3()
  {
   JPanel p1 = new Checkerboard();//棋盤panel
   add(p1);//加入
  }

 public static void main(String args[])
  {
   EX14_3 frame = new EX14_3();//宣告視窗
   frame.setSize(400,320);//大小
   frame.setTitle("EX14_3");//標題
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//棋盤panel
class Checkerboard extends JPanel
{
 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   int width = getSize().width;   //畫面長
   int height = getSize().height; //畫面寬
   
   int w = (int)(width/8); //邊長
   int h = (int)(height/8);


   //格子顏色
   Color[] color = {Color.white,Color.black};

   //劃出棋盤
   for(int i=0;i<8;i++)
    for(int j=0;j<8;j++)
     {
      g.setColor(color[(i+j) % 2]);//讓顏色交換
      g.fillRect(w*i,h*j,w,h);
     }
  }
}