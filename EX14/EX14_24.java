//Game:bean machian

import javax.swing.*;
import java.awt.*;

public class EX14_24 extends JFrame
{
 public EX14_24()
  {
   add(new BeanMachine());//�[�J
  }

 public static void main(String args[])
  {
   EX14_24 frame = new EX14_24();//�ŧi����
   frame.setTitle("EX14_24");//���D
   frame.setSize(300,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

class BeanMachine extends JPanel
{
 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   //�J�f
   g.drawLine(getWidth()/2-10,getHeight()/2-120,getWidth()/2-10,getHeight()/2-100);
   g.drawLine(getWidth()/2+10,getHeight()/2-120,getWidth()/2+10,getHeight()/2-100);

   //�׽u
   g.drawLine(getWidth()/2-10,getHeight()/2-100,getWidth()/2-80,getHeight()/2+40);
   g.drawLine(getWidth()/2+10,getHeight()/2-100,getWidth()/2+80,getHeight()/2+40);

   //����
   g.drawLine(getWidth()/2-80,getHeight()/2+40,getWidth()/2-80,getHeight()/2+100);
   g.drawLine(getWidth()/2+80,getHeight()/2+40,getWidth()/2+80,getHeight()/2+100);
   g.drawLine(getWidth()/2-80,getHeight()/2+100,getWidth()/2+80,getHeight()/2+100);

   //���
   for(int i=1;i<8;i++)
    g.drawLine(getWidth()/2-80+(20*i),getHeight()/2+40,getWidth()/2-80+(20*i),getHeight()/2+100);

   //�W�l
   int dis = 10;
   for(int i=1;i<8;i++)
    {
     int x = getWidth()/2-dis*(i-1);
     int y = getHeight()/2-80 + 20*(i-1); 
     for(int j=1;j<=i;j++)
      g.fillOval(x-5+(j-1)*20,y-10,10,10);
    }  
  }
}