//Using ComponentEvent

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EX15_2 extends JFrame
{
 public EX15_2()
  {
   addComponentListener(new ListenerClass());//加入事件
  }

 public static void main(String args[])
  {
   EX15_2 frame = new EX15_2();//宣告視窗
   frame.setTitle("EX15_2");//標題
   frame.setSize(200,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //事件class
 class ListenerClass implements ComponentListener
  {
   //component移動時觸發
   public void componentMoved(ComponentEvent e) 
    {
     System.out.println("Component moved");
    }

   //component隱藏時觸發
   public void componentHidden(ComponentEvent e)
    {
     System.out.println("Component hidden");
    }
   //component改變大小時觸發
   public void componentResized(ComponentEvent e)
    {
     System.out.println("Component resized");
    }
 
   //component出現時觸發
   public void componentShown(ComponentEvent e)
    {
     System.out.println("Component shown");
    } 
  }
}