//Drawing lines using the keys

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_9 extends JFrame
{
 //�{�b�Ҧb�y��
 int x = 100;
 int y = 100;

 public EX15_9()
  {
   KeyAction p1 = new KeyAction();//�ŧi�ƥ�panel
   p1.setFocusable(true);//�]�w������L�ƥ�
   add(p1);//�[�J
  }

 public static void main(String args[])
  {
   EX15_9 frame = new EX15_9();//�ŧi����
   frame.setTitle("EX15_9");//���D
   frame.setSize(400,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�ƥ�panel
 class KeyAction extends JPanel
  {
   //ø�ϥ�polygon
   Polygon p = new Polygon();

   //�غc�l
   public KeyAction()
    {
     //�[�J��l���I
     p.addPoint(x,y);

     //�[�J��L�ƥ�
     addKeyListener(new KeyAdapter() {      
      public void keyPressed(KeyEvent e) {
        //�ھګ���M�w�[�J���I�y��
        switch(e.getKeyCode()) {
         case KeyEvent.VK_DOWN: y+=20;p.addPoint(x,y);break;//���U �y�ФU��
         case KeyEvent.VK_UP: y-=20;p.addPoint(x,y);break;//���W �y�ФW��
         case KeyEvent.VK_LEFT: x-=20;p.addPoint(x,y);break;//���� �y�Х���
         case KeyEvent.VK_RIGHT: x+=20;p.addPoint(x,y);break;//���k �y�Хk��
        }

       repaint();//��ø
      }
     });
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //�ھ�polygonø�X�u
     g.drawPolyline(p.xpoints,p.ypoints,p.npoints);
    }
  }
}