//Displayint TicTacToe board

import javax.swing.*;
import java.awt.*;

public class EX14_7 extends JFrame
{
 public EX14_7()
  {
   add(new TicTacToe());
  }

 public static void main(String args[])
  {
   EX14_7 frame = new EX14_7();//�ŧi����
   frame.setTitle("EX14_7");//���D
   frame.setSize(400,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//���r�C��class
class TicTacToe extends JPanel
{
 //�`��
 public static final int NOTHING = 0;//�N��Ů�
 public static final int X = 1; //�N��X
 public static final int O = 2; //�N��O

 //�غc�l
 public TicTacToe()
  {}

 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //�C����e
   int w = (getWidth()-30)/3;
   int h = (getHeight()-30)/3;
   
   for(int i=0;i<3;i++)
    {
     for(int j=0;j<3;j++)
      {
       int type = (int)(Math.random()*3);//�H����w���
       if(type==X)//���X
        {
         g.drawLine(10*(i+1)+w*i,10*(j+1)+h*j,10*(i+1)+w*(i+1),10*(j+1)+h*(j+1));
         g.drawLine(10*(i+1)+w*(i+1),10*(j+1)+h*j,10*(i+1)+w*i,10*(j+1)+h*(j+1));
        }
        else if(type==O)//���O
        {
         g.drawOval(10*(i+1)+w*i,10*(j+1)+h*j,w,h);
        }
      }
    }
  }
}