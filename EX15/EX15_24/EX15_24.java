//Controlling a clock

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class EX15_24 extends StillClock
{
 //�}�����s
 static JButton start = new JButton("Start");
 static JButton stop = new JButton("Stop");

 //�ŧi�p�ɾ�
 static Timer timer;

 public EX15_24()
  {
   //�w�q�p�ɾ�
   setCurrentTime();
   timer = new Timer(1000,new TimerListener());
   timer.start();//�}�l�ʧ@
  }

 //�p�ɾ��ʧ@
 class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     startClick();//�����ʧ@
     repaint();//��ø
    }
  }

 public static void main(String args[])
  {
   JFrame frame = new JFrame("EX15_24");//�ŧi����

   frame.setLayout(new BorderLayout());//�]�wlayout
   frame.add(new EX15_24(),BorderLayout.CENTER);

   //�]�w�}��panel
   JPanel button = new JPanel(new FlowLayout());

   //�[�J���s
   button.add(start);
   button.add(stop);

   //�}���ʧ@
   start.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e) {
      timer.start();//�}�l
     }
    });

   stop.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e) {
      timer.stop();//����
     }
    });

   frame.add(button,BorderLayout.SOUTH);//�[�Jpanel

   frame.setSize(400,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}