//Slide show

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EX15_13 extends JFrame
{
 public EX15_13()
  {
   add(new ImagePanel());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX15_13 frame = new EX15_13();//顯示視窗
   frame.setTitle("EX15_13");//標題
   frame.setSize(800,600);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //顯示圖片panel
 class ImagePanel extends JPanel
  {
   //圖片陣列
   Image[] image = new Image[25];
   int k=0;//要顯示的index

   //建構子
   public ImagePanel()
    {
     //讀取圖片
     for(int i=0;i<25;i++)
      {
       ImageIcon icon = new ImageIcon("side/slide"+i+".jpg");
       image[i] = icon.getImage();
      }

     //計時器
     Timer time = new Timer(1000,new TimerListener());
     time.start();//開始動作
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //顯示圖片
     g.drawImage(image[k],0,0,getWidth(),getHeight(),this);
     
     //往後翻面
     k++;
     if(k>=25)//到頁尾回頭
      k=0;
    }

   //計時動作
   class TimerListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {
       repaint();//重繪
      }
    }
  }
}