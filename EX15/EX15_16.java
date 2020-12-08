//Moving a circle using the keys

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_16 extends JFrame
{
 //��l��y��
 int x = 100;
 int y = 100;

 public EX15_16()
  {
   KeyAction p1 = new KeyAction();//�ŧipanel
   p1.setFocusable(true);//�]�w��������ƥ�
   add(p1);//�[�J
  }

 public static void main(String args[])
  {
   EX15_16 frame = new EX15_16();//�ŧi����
   frame.setTitle("EX15_16");//���D
   frame.setSize(400,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //����ƥ�panel
 class KeyAction extends JPanel
  {
   //�غc�l
   public KeyAction()
    {
     //�[�J��L�ƥ�
     addKeyListener(new KeyAdapter() {      
      public void keyPressed(KeyEvent e) {
        //�ھګ���W�U���k�Ӳ���
        switch(e.getKeyCode()) {
         case KeyEvent.VK_DOWN: y+=10;break;
         case KeyEvent.VK_UP: y-=10;break;
         case KeyEvent.VK_LEFT: x-=10;break;
         case KeyEvent.VK_RIGHT: x+=10;break;
         default:break;
        }
       repaint();//��ø
      }
     });
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //ø�X��
     g.drawOval(x,y,10,10);
    }
  }
}