//Using JProgressBar randomly value

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

public class EX29_12 extends JFrame
{
 private JProgressBar jpb = new JProgressBar();//進度條物件

 public EX29_12()
  {
   //設定進度條物件
   jpb.setStringPainted(true);//繪出百分比
   jpb.setValue(0);//初始值
   jpb.setMaximum(100);//最大值

   add(jpb);//加入frame
   
   new Thread(new RandomTask()).start();//開始執行緒
  }

 //設定隨機的value的 task 
 class RandomTask implements Runnable
  {
   public void run()
    {
     try{
      while(true)
       {
        int num = (int)(Math.random()*100+1);//隨機數
        jpb.setValue(num);//設定數字
        Thread.sleep(500);//睡眠0.5秒
       }
     }
     catch(InterruptedException ex){}
    }
  }

 public static void main(String args[])
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_12 frame = new EX29_12();//frame物件
     frame.setTitle("EX29_12");//標題
     frame.setSize(400,70);//大小
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
     frame.setLocationRelativeTo(null);//相對位置
     frame.setVisible(true);//顯示
    }
   });
  }
}