//Controlling a clock with thread

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;

public class EX29_7 extends JFrame
{
 private ClockControl[] SC = new ClockControl[3];

 JButton resumeAll = new JButton("Resume All");//�����Ȱ����s
 JButton suspendAll = new JButton("Suspend All");//�������s�}�l���s

 public EX29_7()
  {
   setLayout(new BorderLayout());//�]�w�ƪ��覡
   JPanel p1 = new JPanel(new GridLayout(1,3));//��m����panel

   //�̧ǱN����panel��J�Dpanel
   for(int i = 0;i<3;i++)
    {
     SC[i] = new ClockControl();
     p1.add(SC[i]);
    }
   
   //������spanel
   JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   
   //�[�J���s
   p2.add(suspendAll);
   p2.add(resumeAll);

   //�Npanel��X
   add(p1,BorderLayout.CENTER);
   add(p2,BorderLayout.SOUTH);
   
   resumeAll.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     
     for(int i=0;i<3;i++)
      SC[i].start();
    }
   });

   //�]�w�����Ȱ����s�ƥ�
   suspendAll.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     //�̧ǱNclock panel�]�w�Ȱ�
     for(int i=0;i<3;i++)
      SC[i].stop();
    }
   });

   for(int i=0;i<3;i++)
    new Thread(SC[i]).start();
  }

 //��ܮ�����panel
 class ClockControl extends JPanel implements Runnable
  {
   JButton resume = new JButton("Resume");//���}���s
   JButton suspend = new JButton("Suspend");//�Ȱ����s

   StillClock SC = new StillClock();//����ø��
 
   private boolean pause = false;//�P�_�O�_�Ȱ�

   public ClockControl()
    {
     setLayout(new BorderLayout());//�]�w�ƪ�
     add(SC,BorderLayout.CENTER);//�[�J������panel

     //���spanel �[�J���s
     JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
     p1.add(suspend);
     p1.add(resume);

     //��Xpanel
     add(p1,BorderLayout.SOUTH);

     //���ҫ��s�ƥ�
     resume.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
       pause = false;
      }
     });

     //�Ȱ����s�ƥ�
     suspend.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
       pause = true;
      }
     });
    }

   //�����Ȱ�
   public void start()
    {
     pause = false;
    }

   //�}�l�Ȱ�
   public void stop()
    {
     pause = true;
    }

   //�������øtask
   public void run()
    {
     try{
      while(true)
       {
        //�Y�O�Ȱ����A ����
        while(pause)
         {
          Thread.sleep(5);
         }
        
        SC.timeRun();//�����e�i
        SC.repaint();//��ø
        Thread.sleep(1000);
       }
     }
     catch(InterruptedException ex){}
    }
  }

 public static void main(String args[])
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_7 frame = new EX29_7();//�Ы�frame
     frame.setTitle("EX29_7");//���D
     frame.setSize(600,400);//�����j�p
     frame.setLocationRelativeTo(null);//�۹��m
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
     frame.setVisible(true);//���
    }
   });
  }
}