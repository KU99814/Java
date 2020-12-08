//change colors using a mouse

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_5 extends JFrame
{
 public EX15_5()
  {
   add(new MouseAction());//�[�J�ƹ��ƥ�panel
  }

 public static void main(String args[])
  {
   EX15_5 frame = new EX15_5();//�ŧi����
   frame.setTitle("EX15_5");//���D
   frame.setSize(200,100);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�ƹ��ƥ�panel
 class MouseAction extends JPanel
  {
   Color c = Color.white;//�]�w�C��

   public MouseAction()
    {
     //�[�J�ƹ��ƥ�
     addMouseListener(new MouseAdapter() {
     //Ĳ�o�ɧ��ܭI���C��
      //������ 
      public void mousePressed(MouseEvent e) {
       c = Color.blue;
       setBackground(c);
      }
      
      //�I����
      public void mouseClicked(MouseEvent e) {
       c = Color.red;
       setBackground(c);
      }

      //�i�Jcomponent��     
      public void mouseEntered(MouseEvent e) {
       c = Color.yellow;
       setBackground(c);
      }
      
      //�ƹ����}component��
      public void mouseExited(MouseEvent e) {
       c = Color.green;
       setBackground(c);
      }
     });
    }
  }
}