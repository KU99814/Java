//Filling a cylinder

import javax.swing.*;
import java.awt.*;

public class EX14_10 extends JFrame
{
 public EX14_10()
  {
   add(new cylinder());//加入panel
  }

 public static void main(String args[])
  {
   EX14_10 frame = new EX14_10();//宣告視窗
   frame.setTitle("EX14_10");//標題
   frame.setSize(400,400); //大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//圓柱體class
class cylinder extends JPanel
{
 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //中心座標XY
   int x = getWidth()/2;
   int y = getHeight()/2;

   //橢圓的長與寬
   int w = (int)(getWidth()*0.4);
   int h = (int)(getHeight()*0.2);
   int rectY = y-w+h/2;//高
   x-=w/2;//將X左移

   //繪製底部橢圓
   g.setColor(Color.blue);
   g.fillOval(x,y,w,h);
   //繪製邊緣
   g.setColor(Color.black);
   g.drawOval(x,y,w,h); 

   //繪製柱體
   g.setColor(Color.blue);
   g.fillRect(x,rectY,w,w);  
   
   y-=w;//將Y上移
   //繪製頂部圓
   g.fillOval(x,y,w,h);
   g.setColor(Color.black);
   g.drawOval(x,y,w,h);
  }
}