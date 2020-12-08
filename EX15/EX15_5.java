//change colors using a mouse

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_5 extends JFrame
{
 public EX15_5()
  {
   add(new MouseAction());//加入滑鼠事件panel
  }

 public static void main(String args[])
  {
   EX15_5 frame = new EX15_5();//宣告視窗
   frame.setTitle("EX15_5");//標題
   frame.setSize(200,100);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //滑鼠事件panel
 class MouseAction extends JPanel
  {
   Color c = Color.white;//設定顏色

   public MouseAction()
    {
     //加入滑鼠事件
     addMouseListener(new MouseAdapter() {
     //觸發時改變背景顏色
      //按壓時 
      public void mousePressed(MouseEvent e) {
       c = Color.blue;
       setBackground(c);
      }
      
      //點擊時
      public void mouseClicked(MouseEvent e) {
       c = Color.red;
       setBackground(c);
      }

      //進入component時     
      public void mouseEntered(MouseEvent e) {
       c = Color.yellow;
       setBackground(c);
      }
      
      //滑鼠離開component時
      public void mouseExited(MouseEvent e) {
       c = Color.green;
       setBackground(c);
      }
     });
    }
  }
}