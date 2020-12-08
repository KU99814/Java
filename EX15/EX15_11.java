//Controlling multiple moving labels

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_11 extends JFrame
{
 public EX15_11()
  {
   add(new MoveLabel());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX15_11 frame = new EX15_11();//�ŧi����
   frame.setTitle("EX15_11");//���D
   frame.setSize(400,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�ƥ�panel
 class MoveLabel extends JPanel
  {
   int x = -30;//�_�lX�y��

   public MoveLabel()
    {
     //�[�J�p�ɾ�
     Timer time = new Timer(1000,new TimerListener());
     time.start();//�}�l�ʧ@
    }
   
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     int y = 50;
     if(x < -20)//x�]��̥��� �^��̥k
      x = getWidth();
     x-=10;//�C��ø�ϩ�������
    
     //��ܤ�r �C�@�溥�����k��
     for(int i=1;i<=10;i++)
      {
       g.drawString("Line Number "+i,x+i*10,y+20*i);
      }
    }

   //�p�ɰʧ@
   class TimerListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {
       repaint();//��ø
      }
    }
  }
}