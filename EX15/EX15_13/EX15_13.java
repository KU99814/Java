//Slide show

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EX15_13 extends JFrame
{
 public EX15_13()
  {
   add(new ImagePanel());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX15_13 frame = new EX15_13();//��ܵ���
   frame.setTitle("EX15_13");//���D
   frame.setSize(800,600);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //��ܹϤ�panel
 class ImagePanel extends JPanel
  {
   //�Ϥ��}�C
   Image[] image = new Image[25];
   int k=0;//�n��ܪ�index

   //�غc�l
   public ImagePanel()
    {
     //Ū���Ϥ�
     for(int i=0;i<25;i++)
      {
       ImageIcon icon = new ImageIcon("side/slide"+i+".jpg");
       image[i] = icon.getImage();
      }

     //�p�ɾ�
     Timer time = new Timer(1000,new TimerListener());
     time.start();//�}�l�ʧ@
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //��ܹϤ�
     g.drawImage(image[k],0,0,getWidth(),getHeight(),this);
     
     //����½��
     k++;
     if(k>=25)//�쭶���^�Y
      k=0;
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