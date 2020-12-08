//change the color of a circle

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX15_1 extends JFrame
{
 public EX15_1()
  {
   add(new ChangeCircleColor());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX15_1 frame = new EX15_1();//�ŧi����
   frame.setTitle("EX15_1");//���D
   frame.setSize(200,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //���class
 class ChangeCircleColor extends JPanel
  {
   Color color = Color.red;//�C��
   int type = 0;   

   public ChangeCircleColor()
    {
     //�[�J�ƹ��ʧ@
     addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        //�ƹ��I���ɮy��
        int x = e.getX();
        int y = e.getY();
 
        //�P�_�Z���O�_�p��b�|
        if(distance(x,y)<=10)
         {
          //�P�_���ӧ��ܪ��C��
          switch(type){
           case 0:color = Color.blue;
                  type = 1;
                  break;
           case 1:color = Color.red;
                  type = 0;
                  break;
          }
          repaint();//��ø
         }
       }
     });
    }

   //�p��P��߶Z��
   public int distance(int x,int y)
    {
     double dx = Math.pow(x-getWidth()/2,2);
     double dy = Math.pow(y-getHeight()/2,2);

     return (int)(Math.sqrt(dx+dy));
    }
  
   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
    
     //ø�X�� 
     g.setColor(color);
     g.fillOval(getWidth()/2-10,getHeight()/2-10,20,20);
    }
  }
}