//Alternating two message

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_6 extends JFrame
{
 

 public EX15_6()
  {
   add(new MouseAction());//加入事件panel
  }

 public static void main(String args[])
  {
   EX15_6 frame = new EX15_6();//宣告視窗
   frame.setTitle("EX15_6");//標題
   frame.setSize(200,100);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //滑鼠動作panel
 class MouseAction extends JPanel
  {
   //顯示的兩個文字
   String message1 = "Java is fun";
   String message2 = "Java is powerful";
   int change = 1;//表示現在要顯示哪個

   public MouseAction()
    {
     //加入滑鼠事件
     addMouseListener(new MouseAdapter() {      
 
      //點擊時改變文字
      public void mouseClicked(MouseEvent e) {
       //改變變數決定顯示文字
       if(change == 1)
        change = 2;
       else
        change = 1;
       repaint();
      }
     });
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //繪出文字
     if(change == 1)
      g.drawString(message1,getWidth()/2-50,getHeight()/2);
     else
      g.drawString(message2,getWidth()/2-50,getHeight()/2);
    }
  }
}