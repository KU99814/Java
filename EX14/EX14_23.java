//Displaying a rectanguloid

import javax.swing.*;
import java.awt.*;

public class EX14_23 extends JFrame
{
 public EX14_23()
  {
   add(new Rectanguloid());//加入
  }

 public static void main(String args[])
  {
   EX14_23 frame = new EX14_23();//宣告視窗
   frame.setTitle("EX14_23");//標題
   frame.setSize(400,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}


//長方體class
class Rectanguloid extends JPanel
{
 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //長與寬
   int w = (int)(getWidth()*0.6);
   int h = (int)(getHeight()*0.4);

   //中心
   int x = getWidth()/2;
   int y = getHeight()/2;

   //後面平行四邊形
   g.drawLine(x-(w/2),y-(h/2),x+(w/2),y-(h/2));
   g.drawLine(x-(w/2),y+(h/2),x+(w/2),y+(h/2));
   g.drawLine(x-(w/2),y-(h/2),x-(w/2),y+(h/2));
   g.drawLine(x+(w/2),y-(h/2),x+(w/2),y+(h/2));

   //前面平行四邊形
   g.drawLine(x-(w/2)-(x/6),y-(h/2)+(y/4),x+(w/2)-(x/6),y-(h/2)+(y/4));
   g.drawLine(x-(w/2)-(x/6),y+(h/2)+(y/4),x+(w/2)-(x/6),y+(h/2)+(y/4));
   g.drawLine(x-(w/2)-(x/6),y-(h/2)+(y/4),x-(w/2)-(x/6),y+(h/2)+(y/4));
   g.drawLine(x+(w/2)-(x/6),y-(h/2)+(y/4),x+(w/2)-(x/6),y+(h/2)+(y/4));

   //中間四邊
   g.drawLine(x-(w/2)-(x/6),y-(h/2)+(y/4),x-(w/2),y-(h/2));
   g.drawLine(x-(w/2)-(x/6),y+(h/2)+(y/4),x-(w/2),y+(h/2));
   g.drawLine(x+(w/2)-(x/6),y-(h/2)+(y/4),x+(w/2),y-(h/2));
   g.drawLine(x+(w/2)-(x/6),y+(h/2)+(y/4),x+(w/2),y+(h/2));
  }
}