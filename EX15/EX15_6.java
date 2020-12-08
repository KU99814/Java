//Alternating two message

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_6 extends JFrame
{
 

 public EX15_6()
  {
   add(new MouseAction());//�[�J�ƥ�panel
  }

 public static void main(String args[])
  {
   EX15_6 frame = new EX15_6();//�ŧi����
   frame.setTitle("EX15_6");//���D
   frame.setSize(200,100);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�ƹ��ʧ@panel
 class MouseAction extends JPanel
  {
   //��ܪ���Ӥ�r
   String message1 = "Java is fun";
   String message2 = "Java is powerful";
   int change = 1;//��ܲ{�b�n��ܭ���

   public MouseAction()
    {
     //�[�J�ƹ��ƥ�
     addMouseListener(new MouseAdapter() {      
 
      //�I���ɧ��ܤ�r
      public void mouseClicked(MouseEvent e) {
       //�����ܼƨM�w��ܤ�r
       if(change == 1)
        change = 2;
       else
        change = 1;
       repaint();
      }
     });
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //ø�X��r
     if(change == 1)
      g.drawString(message1,getWidth()/2-50,getHeight()/2);
     else
      g.drawString(message2,getWidth()/2-50,getHeight()/2);
    }
  }
}