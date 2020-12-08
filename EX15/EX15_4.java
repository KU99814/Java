//Alternating multiple message

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_4 extends JFrame
{
 public EX15_4()
  {
   add(new MouseAction());//加入事件panel
  }

 public static void main(String args[])
  {
   EX15_4 frame = new EX15_4();//宣告視窗
   frame.setTitle("EX15_4");//標題
   frame.setSize(200,100);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //滑鼠事件class
 class MouseAction extends JPanel
  {
   public MouseAction()
    {
     //加入滑鼠事件
     addMouseListener(new MouseAdapter() {
      //按壓時觸發
      public void mousePressed(MouseEvent e) {
       System.out.println("mouse pressed");
      }
      
      //釋放時觸發
      public void mouseReleased(MouseEvent e) {
       System.out.println("mouse released");
      }
      
      //點擊時觸發
      public void mouseClicked(MouseEvent e) {
         System.out.println("mouse clicked");
      }
     
      //滑鼠進入component時觸發
      public void mouseEntered(MouseEvent e) {
        System.out.println("mouse entered");
      }
      
      //滑鼠離開時觸發
      public void mouseExited(MouseEvent e) {
         System.out.println("mouse exited");
      }
     });
   }
  }
}