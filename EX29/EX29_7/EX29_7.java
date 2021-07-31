//Controlling a clock with thread

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;

public class EX29_7 extends JFrame
{
 private ClockControl[] SC = new ClockControl[3];

 JButton resumeAll = new JButton("Resume All");//全部暫停按鈕
 JButton suspendAll = new JButton("Suspend All");//全部重新開始按鈕

 public EX29_7()
  {
   setLayout(new BorderLayout());//設定排版方式
   JPanel p1 = new JPanel(new GridLayout(1,3));//放置時鐘panel

   //依序將時鐘panel放入主panel
   for(int i = 0;i<3;i++)
    {
     SC[i] = new ClockControl();
     p1.add(SC[i]);
    }
   
   //全體按鈕panel
   JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   
   //加入按鈕
   p2.add(suspendAll);
   p2.add(resumeAll);

   //將panel整合
   add(p1,BorderLayout.CENTER);
   add(p2,BorderLayout.SOUTH);
   
   resumeAll.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     
     for(int i=0;i<3;i++)
      SC[i].start();
    }
   });

   //設定全部暫停按鈕事件
   suspendAll.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     //依序將clock panel設定暫停
     for(int i=0;i<3;i++)
      SC[i].stop();
    }
   });

   for(int i=0;i<3;i++)
    new Thread(SC[i]).start();
  }

 //顯示時鐘的panel
 class ClockControl extends JPanel implements Runnable
  {
   JButton resume = new JButton("Resume");//重開按鈕
   JButton suspend = new JButton("Suspend");//暫停按鈕

   StillClock SC = new StillClock();//時鐘繪圖
 
   private boolean pause = false;//判斷是否暫停

   public ClockControl()
    {
     setLayout(new BorderLayout());//設定排版
     add(SC,BorderLayout.CENTER);//加入時鐘到panel

     //按鈕panel 加入按鈕
     JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
     p1.add(suspend);
     p1.add(resume);

     //整合panel
     add(p1,BorderLayout.SOUTH);

     //重啟按鈕事件
     resume.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
       pause = false;
      }
     });

     //暫停按鈕事件
     suspend.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
       pause = true;
      }
     });
    }

   //結束暫停
   public void start()
    {
     pause = false;
    }

   //開始暫停
   public void stop()
    {
     pause = true;
    }

   //執行緒重繪task
   public void run()
    {
     try{
      while(true)
       {
        //若是暫停狀態 空轉
        while(pause)
         {
          Thread.sleep(5);
         }
        
        SC.timeRun();//時鐘前進
        SC.repaint();//重繪
        Thread.sleep(1000);
       }
     }
     catch(InterruptedException ex){}
    }
  }

 public static void main(String args[])
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_7 frame = new EX29_7();//創建frame
     frame.setTitle("EX29_7");//標題
     frame.setSize(600,400);//視窗大小
     frame.setLocationRelativeTo(null);//相對位置
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
     frame.setVisible(true);//顯示
    }
   });
  }
}