//Bouncing ball with thread

import java.awt.*;
import javax.swing.*;

public class EX29_6 extends JFrame
{
 //constructor
 public EX29_6()
  {
   add(new BallControl());
  }

 public static void main(String args[])
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_6 frame = new EX29_6();//�Ыت���
     frame.setTitle("EX29_6");//���D
     frame.setSize(800,400);//�����j�p
     frame.setLocationRelativeTo(null);//�۹��m
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
     frame.setVisible(true);//��ܵ���
    }
   });
  }
}
