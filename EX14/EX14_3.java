//Displaying a checkerboard

import javax.swing.*;
import java.awt.*;

public class EX14_3 extends JFrame 
{
 public EX14_3()
  {
   JPanel p1 = new Checkerboard();//�ѽLpanel
   add(p1);//�[�J
  }

 public static void main(String args[])
  {
   EX14_3 frame = new EX14_3();//�ŧi����
   frame.setSize(400,320);//�j�p
   frame.setTitle("EX14_3");//���D
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//�ѽLpanel
class Checkerboard extends JPanel
{
 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   int width = getSize().width;   //�e����
   int height = getSize().height; //�e���e
   
   int w = (int)(width/8); //���
   int h = (int)(height/8);


   //��l�C��
   Color[] color = {Color.white,Color.black};

   //���X�ѽL
   for(int i=0;i<8;i++)
    for(int j=0;j<8;j++)
     {
      g.setColor(color[(i+j) % 2]);//���C��洫
      g.fillRect(w*i,h*j,w,h);
     }
  }
}