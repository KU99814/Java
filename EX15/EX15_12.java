//Creating a running fans

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX15_12 extends JFrame
{
 public EX15_12()
  {
   add(new Fans());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX15_12 frame = new EX15_12();//�ŧi����
   frame.setTitle("EX15_12");//���D
   frame.setSize(400,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//����panel
class Fans extends JPanel
{
 int angle = 0;//�_�l����

 //�غc�l
 public Fans()
  {
   //�[�J�p�ɾ�
   Timer time = new Timer(100,new TimerListener());
   time.start();//�}�l�ʧ@
  }

 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //���߮y�лP�b�|
   int x = getWidth()/2;
   int y = getHeight()/2;
   int radius = (int)(Math.min(x*2,y*2)*0.4);

   //����ø��
   x-=radius;
   y-=radius;

   //ø�X�~��P����
   g.drawOval(x-10,y-10,radius*2+20,radius*2+20);
   g.fillArc(x,y,2*radius,2*radius,angle,30);
   g.fillArc(x,y,2*radius,2*radius,angle+90,30);
   g.fillArc(x,y,2*radius,2*radius,angle+180,30);
   g.fillArc(x,y,2*radius,2*radius,angle+270,30);

   //�C���_�l���ץ[10 �ϭ������� 
   angle+=10;
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
   