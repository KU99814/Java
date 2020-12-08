//Displaying an addition table

import javax.swing.*;
import java.awt.*;

public class EX14_4 extends JFrame
{
 public EX14_4()
  {
   JPanel p1 = new AdditionalTable();//�ŧi�[�k��
   add(p1);//�[�J
  }
 
 public static void main(String args[])
  {
   EX14_4 frame = new EX14_4();//�ŧi����
   frame.setSize(400,400);//�j�p
   frame.setTitle("EX14_4");//���D
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//�[�k��
class AdditionalTable extends JPanel
{
 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   String title = "Addition Table";//���D

   int x = (getWidth() - 100)/25; //�վ���
   int y = (getHeight()-120)/25;

   g.setFont(new Font("Courie",Font.BOLD,30));  //�]�w�r���B�j�p
   g.setColor(Color.red); //�]�w�C��
   g.drawString(title,90,70);

   g.setColor(Color.black);
   g.drawRect(90,100,getWidth() - 100,getHeight()-120);//ø�s���

   g.setFont(new Font("Courie",Font.BOLD,15));

   for(int i=0;i<x;i++)//��
    {
     g.drawString((i+1)+"",100+25*i,90);
    }
    
   for(int i=0;i<y;i++)//�C
    {
     g.drawString((i+1)+"",70,120+25*i);
    }

    g.setColor(Color.red);
    //ø�X�Ʀr�L
    for(int i=0;i<x;i++)
     for(int j=0;j<y;j++)
      g.drawString(((i+1)+(j+1))+"",100+i*25,120+j*25);
  }
}   
   