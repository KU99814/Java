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
     EX29_6 frame = new EX29_6();//創建物件
     frame.setTitle("EX29_6");//標題
     frame.setSize(800,400);//視窗大小
     frame.setLocationRelativeTo(null);//相對位置
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
     frame.setVisible(true);//顯示視窗
    }
   });
  }
}
