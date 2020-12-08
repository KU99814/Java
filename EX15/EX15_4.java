//Alternating multiple message

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_4 extends JFrame
{
 public EX15_4()
  {
   add(new MouseAction());//�[�J�ƥ�panel
  }

 public static void main(String args[])
  {
   EX15_4 frame = new EX15_4();//�ŧi����
   frame.setTitle("EX15_4");//���D
   frame.setSize(200,100);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�ƹ��ƥ�class
 class MouseAction extends JPanel
  {
   public MouseAction()
    {
     //�[�J�ƹ��ƥ�
     addMouseListener(new MouseAdapter() {
      //������Ĳ�o
      public void mousePressed(MouseEvent e) {
       System.out.println("mouse pressed");
      }
      
      //�����Ĳ�o
      public void mouseReleased(MouseEvent e) {
       System.out.println("mouse released");
      }
      
      //�I����Ĳ�o
      public void mouseClicked(MouseEvent e) {
         System.out.println("mouse clicked");
      }
     
      //�ƹ��i�Jcomponent��Ĳ�o
      public void mouseEntered(MouseEvent e) {
        System.out.println("mouse entered");
      }
      
      //�ƹ����}��Ĳ�o
      public void mouseExited(MouseEvent e) {
         System.out.println("mouse exited");
      }
     });
   }
  }
}