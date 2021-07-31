//Using JProgressBar randomly value

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

public class EX29_12 extends JFrame
{
 private JProgressBar jpb = new JProgressBar();//�i�ױ�����

 public EX29_12()
  {
   //�]�w�i�ױ�����
   jpb.setStringPainted(true);//ø�X�ʤ���
   jpb.setValue(0);//��l��
   jpb.setMaximum(100);//�̤j��

   add(jpb);//�[�Jframe
   
   new Thread(new RandomTask()).start();//�}�l�����
  }

 //�]�w�H����value�� task 
 class RandomTask implements Runnable
  {
   public void run()
    {
     try{
      while(true)
       {
        int num = (int)(Math.random()*100+1);//�H����
        jpb.setValue(num);//�]�w�Ʀr
        Thread.sleep(500);//�ίv0.5��
       }
     }
     catch(InterruptedException ex){}
    }
  }

 public static void main(String args[])
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_12 frame = new EX29_12();//frame����
     frame.setTitle("EX29_12");//���D
     frame.setSize(400,70);//�j�p
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
     frame.setLocationRelativeTo(null);//�۹��m
     frame.setVisible(true);//���
    }
   });
  }
}