//Displaying a horizontal chart

import javax.swing.*;
import java.awt.*;

public class EX14_14 extends JFrame
{
 public EX14_14()
  {
   add(new Score());//�[�Jpanel
  }

 public static void main(String args[])
  {
   EX14_14 frame = new EX14_14();//�ŧi����
   frame.setTitle("EX14_14");//���D
   frame.setSize(400,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//��ܱo����ø�s������
class Score extends JPanel
{
 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   g.drawLine(5,10,5,getHeight()-10);

   g.setColor(Color.red);
   g.drawString("Project -- 20%",10,15);
   g.fillRect(10,15,(int)((getWidth()-20)*0.2),10);

   g.setColor(Color.blue);
   g.drawString("Quizzes -- 10%",10,45);
   g.fillRect(10,45,(int)((getWidth()-20)*0.1),10);

   g.setColor(Color.pink);
   g.drawString("Midtems -- 30%",10,75);
   g.fillRect(10,75,(int)((getWidth()-20)*0.3),10);

   g.setColor(Color.gray);
   g.drawString("Final -- 40%",10,105);
   g.fillRect(10,105,(int)((getWidth()-20)*0.4),10);
  }
}