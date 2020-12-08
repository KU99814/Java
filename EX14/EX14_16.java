//Displaying font information

import java.awt.*;
import javax.swing.*;

public class EX14_16 extends JFrame
{
 public EX14_16()
  {
   JPanel p1 = new FontInfo();//宣告panel
   p1.setFont(new Font("TimesRoman",Font.BOLD,20));
   add(p1);//加入panel
   
  }

 public static void main(String args[])
  {
   EX14_16 frame = new EX14_16();//宣告視窗
   frame.setTitle("EX14_16");//標題
   frame.setSize(300,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

class FontInfo extends JPanel
{
 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   FontMetrics fm = g.getFontMetrics();
   String str = "Java is fun";
   g.drawString(str,50,50);//繪製文字
   setToolTipText("Ascent: "+fm.getAscent()+" Descent: "+fm.getDescent()+
                  " Leading: "+fm.getLeading()+" string width: "+fm.stringWidth(str));//加入提示文字
  }
   
}