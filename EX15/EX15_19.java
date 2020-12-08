//Display multiple message where clicked

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_19 extends JFrame
{
 public EX15_19()
  {
   add(new TwoCircle());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX15_19 frame = new EX15_19();//�ŧi����
   frame.setTitle("EX15_19");//���D
   frame.setSize(500,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //���class
 class TwoCircle extends JPanel
  {
   //�x�s�ƹ��y��
   int mouseX = 0;
   int mouseY = 0;

   //��ܦr��
   String message = "";

   boolean start = false;//�O�_�}�l

   //�غc�l
   public TwoCircle()
    {
     //�[�J�ƹ��ʧ@
     addMouseListener(new MouseAdapter() {
      //�I��
      public void mouseClicked(MouseEvent e) {
       //���o�ƹ��y��
       mouseX = e.getX();
       mouseY = e.getY();

       start = true;//�}�l���
       repaint();//��ø
      }
     });
    }

   //�P�_�O�_�b�餺 ���b�|��75 �G�Τ@�P�_
   public boolean inside(int x1,int y1,int x2,int y2)
    {
     //�p��Z��
     int distance = (int)(Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)));
      
     if(distance <=75)
      return true;
     else 
      return false;
    }   

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //���X��Ӷ�
     g.setColor(Color.red);
     g.fillOval(50,50,150,150);
     g.setColor(Color.cyan);
     g.fillOval(210,210,150,150);

     if(start)//�}�l��ܦr��
      {
       g.setColor(Color.black);
       //�ھڷƹ���m��ܬ����r��
       if(inside(125,125,mouseX,mouseY))
        g.drawString("You clicked inside red circle",mouseX,mouseY);
       else if(inside(285,285,mouseX,mouseY))
        g.drawString("You clicked inside cyan circle",mouseX,mouseY);
       else
        g.drawString("You  didn't click inside any circle",mouseX,mouseY);
      }
    }
  }
}