//Displaying a character

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_8 extends JFrame
{
 char message = ' ';//��ܪ��r��

 //��ܪ��y��
 int x = 20;
 int y = 20;

 public EX15_8()
  {
   KeyAction p1 = new KeyAction();//�ŧi�ƥ�panel
   p1.setFocusable(true);//�]�w������L�ƥ�
   add(p1);//�[�J
  }

 public static void main(String args[])
  {
   EX15_8 frame = new EX15_8();//�ŧi����
   frame.setTitle("EX15_8");//���D
   frame.setSize(200,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�ƥ�panel
 class KeyAction extends JPanel
  {
   //�غc�l
   public KeyAction()
    {
     //�[�J��L�ƥ�
     addKeyListener(new KeyAdapter() {      
      public void keyPressed(KeyEvent e) {
       //��ܫ��U�������r
       message = e.getKeyChar();
       repaint();//��ø
      }
     });

     //�[�J�ƹ��ʧ@�ƥ�
     addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
       //���o�ƹ��y�� �a�J��r��ܮy��
       x = e.getX();
       y = e.getY();

       repaint();//��ø
      }
     });
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //��ܤ�r
     g.drawString(String.valueOf(message),x,y);
    }
  }
}