//Displaying font information

import java.awt.*;
import javax.swing.*;

public class EX14_16 extends JFrame
{
 public EX14_16()
  {
   JPanel p1 = new FontInfo();//�ŧipanel
   p1.setFont(new Font("TimesRoman",Font.BOLD,20));
   add(p1);//�[�Jpanel
   
  }

 public static void main(String args[])
  {
   EX14_16 frame = new EX14_16();//�ŧi����
   frame.setTitle("EX14_16");//���D
   frame.setSize(300,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

class FontInfo extends JPanel
{
 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   FontMetrics fm = g.getFontMetrics();
   String str = "Java is fun";
   g.drawString(str,50,50);//ø�s��r
   setToolTipText("Ascent: "+fm.getAscent()+" Descent: "+fm.getDescent()+
                  " Leading: "+fm.getLeading()+" string width: "+fm.stringWidth(str));//�[�J���ܤ�r
  }
   
}