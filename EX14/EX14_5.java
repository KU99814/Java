//Displaying numbers in a triangular pattern

import javax.swing.*;
import java.awt.*;

public class EX14_5 extends JFrame
{
 public EX14_5()
  {
   add(new TriangularPattern());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX14_5 frame = new EX14_5();//�ŧi����
   frame.setSize(400,400);//�j�p
   frame.setTitle("EX14_5"); //���D
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//�ˤT���μƦCpanel
class TriangularPattern extends JPanel
{
 //ø�s
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   g.setFont(new Font("Courie",Font.BOLD,15));//�]�w�r��

   int x = (getHeight()-20)/25;//�����H�r�Z�o��r���Ӽ�

   for(int i=0;i<x;i++)
    for(int j=0;j<i;j++)
     g.drawString((j+1)+"",10+j*25,20+(x-i)*25);
  }
}