//raising flag

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_14 extends JFrame
{
 public EX15_14()
  {
   add(new RaisingFlag());//�ŧi�å[�J
  }

 public  static void main(String args[])
  {
   EX15_14 frame = new EX15_14();//�ŧi����
   frame.setTitle("EX15_14");//���D
   frame.setSize(300,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�ɺXclass
 class RaisingFlag extends JPanel
  {
   int y = 0;//��ly�y��

   //���o�Ϥ�
   ImageIcon icon = new ImageIcon("flag6.gif");
   Image image = icon.getImage();

   //�غc�l
   public RaisingFlag()
    {
     //�p�ɾ�
     Timer time = new Timer(100,new TimerListener());
     time.start();//�}�l�ʧ@
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //�ɨ쳻�ɦ^�쩳��
     if(y<=0)
      y = getHeight()-50;

     //ø��
     g.drawImage(image,0,y,100,50,this);
     y-=5;//�W��
    }

   //�p�ɰʧ@
   class TimerListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {
       repaint();//ø��
      }
    }
  }
}