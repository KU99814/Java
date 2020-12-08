//Entering and displaying a string

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_7 extends JFrame
{
 String message = "";//��ܪ��r��

 public EX15_7()
  {
   KeyAction p1 = new KeyAction();//�ŧipanel
   p1.setFocusable(true);//�]�w������L�ƥ�
   add(p1);//�[�J
  }

 public static void main(String args[])
  {
   EX15_7 frame = new EX15_7();//�ŧi����
   frame.setTitle("EX15_7");//���D
   frame.setSize(200,100);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //��L�ʧ@
 class KeyAction extends JPanel
  {
   public KeyAction()
    {
     //�[�J��L�ƥ�
     addKeyListener(new KeyAdapter() {     

      //����ƥ� 
      public void keyPressed(KeyEvent e) {
       //�p�G��Enter �r��M��
       if(e.getKeyCode() == KeyEvent.VK_ENTER)
        message = "";
       else//��L������ܥX��r
        message += String.valueOf(e.getKeyChar());

       repaint();//��ø
      }
     });
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
 
     //��ܤ�r    
     g.drawString(message,getWidth()/2-50,getHeight()/2);
    }
  }
}