//raising flag by thread

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.applet.*;
import java.util.concurrent.*;

public class EX29_3 extends JFrame
{
 RaisingFlag p1 = new RaisingFlag(); //�ɺX�ʵe��panel

 AudioClip audio;//��q

 //constructor
 public EX29_3()
  {
   ImageIcon icon = new ImageIcon(this.getClass().getResource("flag6.gif"));//��X�Ϯ�
   Image image = icon.getImage();//�ରImage����Hø�X

   p1.setImage(image);//��J��X�Ϯ�
   add(p1);//��Jframe

   audio = Applet.newAudioClip(getClass().getResource("us.mid"));//���J����
   audio.loop();//�`������

   new Thread(new Raising()).start();//������}�l����
  }

 public static void main(String args[])
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_3 frame = new EX29_3();//�Ы�frame
     frame.setTitle("EX29_3");//���D
     frame.setSize(500,500);//�����j�p
     frame.setLocationRelativeTo(null);//�۹��m
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
     frame.setVisible(true);//��ܵ���
    }
   });
  }


 //���ư���p1��ø�Ϫ�task
 class Raising implements Runnable
  {
   public void run()
    {
     try{
      while(true)
       {
        p1.repaint();//��ø
        Thread.sleep(10);
       }
     }
     catch(InterruptedException ex){}
    }
  }

 //�ɺXclass
 class RaisingFlag extends JPanel
  {
   int y = 0;//��X�Ҧb��y�y��
   
   Image image;//��X

   //constructor
   public RaisingFlag()
    {
    }

   //�]�w�Ϯ�
   public void setImage(Image image)
    {
     this.image = image;
     repaint();
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //�Yy�p��s ���s�^��e���̩���     
     if(y<=0)
      y = getHeight()-50;
     g.drawImage(image,0,y,100,50,this);//ø�X��X
     y-=5;//�C��-5 ��ܤW�ɲ���
    }
  }
}