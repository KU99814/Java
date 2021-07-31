//raising flag by thread

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.applet.*;
import java.util.concurrent.*;

public class EX29_3 extends JFrame
{
 RaisingFlag p1 = new RaisingFlag(); //升旗動畫的panel

 AudioClip audio;//國歌

 //constructor
 public EX29_3()
  {
   ImageIcon icon = new ImageIcon(this.getClass().getResource("flag6.gif"));//國旗圖案
   Image image = icon.getImage();//轉為Image物件以繪出

   p1.setImage(image);//放入國旗圖案
   add(p1);//放入frame

   audio = Applet.newAudioClip(getClass().getResource("us.mid"));//載入音樂
   audio.loop();//循環播放

   new Thread(new Raising()).start();//執行緒開始執行
  }

 public static void main(String args[])
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_3 frame = new EX29_3();//創建frame
     frame.setTitle("EX29_3");//標題
     frame.setSize(500,500);//視窗大小
     frame.setLocationRelativeTo(null);//相對位置
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
     frame.setVisible(true);//顯示視窗
    }
   });
  }


 //重複執行p1的繪圖的task
 class Raising implements Runnable
  {
   public void run()
    {
     try{
      while(true)
       {
        p1.repaint();//重繪
        Thread.sleep(10);
       }
     }
     catch(InterruptedException ex){}
    }
  }

 //升旗class
 class RaisingFlag extends JPanel
  {
   int y = 0;//國旗所在的y座標
   
   Image image;//國旗

   //constructor
   public RaisingFlag()
    {
    }

   //設定圖案
   public void setImage(Image image)
    {
     this.image = image;
     repaint();
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //若y小於零 重新回到畫面最底部     
     if(y<=0)
      y = getHeight()-50;
     g.drawImage(image,0,y,100,50,this);//繪出國旗
     y-=5;//每次-5 表示上升移動
    }
  }
}