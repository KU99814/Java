//Creating a running fans with thread

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;

public class EX29_5 extends JFrame
{
 private JButton jbStart = new JButton("Start");//�}�l���s
 private JButton jbStop = new JButton("Stop");//������s
 private JButton jbReverse = new JButton("Reverse");//������s
 private JScrollBar v = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,100);//�t�ױ�

 Fans fan = new Fans();//��������

 int speed = 10;//��ʳt��

 Thread thread;//������ʰ���� 

 public EX29_5()
  {
   JPanel p1 = new JPanel(new GridLayout(1,3));//���spanel

   //p1�[�J���s
   p1.add(jbStart);
   p1.add(jbStop);
   p1.add(jbReverse);

   //�Npanel�P�t�ױ��[�Jframe
   add(p1,BorderLayout.NORTH);
   add(fan,BorderLayout.CENTER);
   add(v,BorderLayout.SOUTH);

   //start���s�ƥ�
   jbStart.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     thread = new Thread(new FanAnimator());//�Ыذ����
     thread.start();//����
    }
   });

   //stop���s�ƥ�
   jbStop.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     //�P�_������O�_�s�b�B�s��
     if(thread!=null && thread.isAlive())
      thread.interrupt();//�Y�O ���_�L
    }
   });

   //������s�ƥ�
   jbReverse.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     fan.Reverse();//��������V
    }
   });

   //�t�ױ��ƥ�
   v.addAdjustmentListener(new AdjustmentListener(){
    public void adjustmentValueChanged(AdjustmentEvent e){
     int value = (int)(v.getValue());//���o�ثe�ƭ�
     speed=10 + value;//���ܳt��
    }
   });
  }

 //��ʭ���task
 class FanAnimator implements Runnable
  {
   //����
   public void run()
    {
     try{
      while(true){
       fan.repaint();//��ø
       Thread.sleep(120-speed);//��v�ɶ� �t�׶V�j�ɶ��V�u
      }    
     }
     catch(InterruptedException ex){}
    }
  }

 public static void main(String args[])
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_5 frame = new EX29_5();//�Ы�frame
     frame.setTitle("EX29_5");//���D
     frame.setSize(400,400);//�����j�p
     frame.setLocationRelativeTo(null);//�۹��m
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
     frame.setVisible(true);//���
    }
   });
  }
}

//����class
class Fans extends JPanel
{
 private int angle = 0;//ø�ϥΨ���
 private int change = 10;//�������צ첾

 //�N��ʤ�V�ܬۤ�
 public void Reverse()
  {
   change*=-1;
  }

 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //��߮y��x y
   int x = getWidth()/2;
   int y = getHeight()/2;

   //�b�|
   int radius = (int)(Math.min(x*2,y*2)*0.4);

   //�Nx y ��h�b�|�N�Oø�ϰ_�l�I
   x-=radius;
   y-=radius;

   //ø�X��Υ~��
   g.drawOval(x-10,y-10,radius*2+20,radius*2+20);

   //ø�X�|������
   g.fillArc(x,y,2*radius,2*radius,angle,30);
   g.fillArc(x,y,2*radius,2*radius,angle+90,30);
   g.fillArc(x,y,2*radius,2*radius,angle+180,30);
   g.fillArc(x,y,2*radius,2*radius,angle+270,30);

   angle+=change;//���ץ[��t ��{�X���
  }
}
   