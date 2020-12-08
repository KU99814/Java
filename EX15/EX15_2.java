//Using ComponentEvent

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EX15_2 extends JFrame
{
 public EX15_2()
  {
   addComponentListener(new ListenerClass());//�[�J�ƥ�
  }

 public static void main(String args[])
  {
   EX15_2 frame = new EX15_2();//�ŧi����
   frame.setTitle("EX15_2");//���D
   frame.setSize(200,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�ƥ�class
 class ListenerClass implements ComponentListener
  {
   //component���ʮ�Ĳ�o
   public void componentMoved(ComponentEvent e) 
    {
     System.out.println("Component moved");
    }

   //component���î�Ĳ�o
   public void componentHidden(ComponentEvent e)
    {
     System.out.println("Component hidden");
    }
   //component���ܤj�p��Ĳ�o
   public void componentResized(ComponentEvent e)
    {
     System.out.println("Component resized");
    }
 
   //component�X�{��Ĳ�o
   public void componentShown(ComponentEvent e)
    {
     System.out.println("Component shown");
    } 
  }
}