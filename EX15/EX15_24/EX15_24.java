//Controlling a clock

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class EX15_24 extends StillClock
{
 //開關按鈕
 static JButton start = new JButton("Start");
 static JButton stop = new JButton("Stop");

 //宣告計時器
 static Timer timer;

 public EX15_24()
  {
   //定義計時器
   setCurrentTime();
   timer = new Timer(1000,new TimerListener());
   timer.start();//開始動作
  }

 //計時器動作
 class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     startClick();//時鐘動作
     repaint();//重繪
    }
  }

 public static void main(String args[])
  {
   JFrame frame = new JFrame("EX15_24");//宣告視窗

   frame.setLayout(new BorderLayout());//設定layout
   frame.add(new EX15_24(),BorderLayout.CENTER);

   //設定開關panel
   JPanel button = new JPanel(new FlowLayout());

   //加入按鈕
   button.add(start);
   button.add(stop);

   //開關動作
   start.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e) {
      timer.start();//開始
     }
    });

   stop.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e) {
      timer.stop();//停止
     }
    });

   frame.add(button,BorderLayout.SOUTH);//加入panel

   frame.setSize(400,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}