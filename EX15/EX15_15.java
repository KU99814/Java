//racing car

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_15 extends JFrame
{
 public EX15_15()
  {
   add(new RaceCar());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX15_15 frame = new EX15_15();//�ŧi����
   frame.setTitle("EX15_15");//���D
   frame.setSize(400,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //���lclass
 class RaceCar extends JPanel
  {
   int x = 0;//��lX�y��
   
   //�غc�l
   public RaceCar()
    {
     //�ŧi�p�ɾ�
     Timer time = new Timer(1000,new TimerListener());
     time.start();//�}�l�ʧ@
    }

   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     int y = getHeight();//ø�ϰѦ�Y�y��
     
     //����
     g.setColor(Color.red);
     g.fillOval(x+10,y-10,10,10);
     g.fillOval(x+30,y-10,10,10);

     //����
     g.setColor(Color.blue);
     g.fillRect(x,y-20,50,10);
     
     //����
     Polygon p = new Polygon();
     
     //�[�J�U���I
     p.addPoint(x+20,y-30);
     p.addPoint(x+30,y-30);
     p.addPoint(x+40,y-20);
     p.addPoint(x+10,y-20);
     
     //ø��
     g.setColor(Color.green);
     g.fillPolygon(p);
     
     x+=10;//����
     if(x+50>getWidth())//��F�e���̥k���� �^�쥪��
      x=0;
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
