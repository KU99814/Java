//Game:eye-hand coordination

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_18 extends JFrame
{
 public EX15_18()
  {
   add(new EyeHand());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX15_18 frame = new EX15_18();//�ŧi����
   frame.setTitle("EX15_18");//���D
   frame.setSize(200,100);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 class EyeHand extends JPanel
  {
   //��߮y��
   int centerX;
   int centerY;

   boolean touch = false;//�P�_�O�_�I����
   boolean first = true; //�P�_�O�_�Ĥ@�Ӷ�

   long currentTime;//�}�l�ɶ�

   int count = 0;//�p�ƾ� �N���I���X��

   public EyeHand()
    {
     System.out.println("circle1"+centerX+" "+centerY+" ");
     
     currentTime = System.currentTimeMillis();//�}�l�ɶ�

     //�[�J�ƹ��ʧ@
     addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
       //�P�_�O�_�b�ꤺ
       if(distance(e.getX(),e.getY(),centerX,centerY)<=10 && count<20)
        {
         touch = true;
         count++;//+1
         repaint();//��ø
        }
      }
     });
    }

   //�p��Z��
   public int distance(int x1,int y1,int x2,int y2)
    {
     return (int)(Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)));
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //�C��ƾ�r g b�H�����
     int r = (int)(Math.random()*256);
     int green = (int)(Math.random()*256);
     int b = (int)(Math.random()*256);

     //�Ĥ@���ɭn�t�~�w�q�y��
     if(first)
      {
       centerX = (int)(Math.random()*(getWidth()-10))+10;
       centerY = (int)(Math.random()*(getHeight()-10))+10;
       first = false;//����
      }

     //�I���Ƥp��20�e��
     if(count<20)
      {
       if(touch)//�p�G�I���� ���s�e��
        {
         centerX = (int)(Math.random()*(getWidth()-20))+10;
         centerY = (int)(Math.random()*(getHeight()-20))+10;
         touch = false;
        }
       //�e��
       g.setColor(new Color(r,green,b));
       g.fillOval(centerX-20,centerY-20,20,20);
       
      }
     else//�I���20���X�{��O�ɶ�
      {
       currentTime = System.currentTimeMillis() - currentTime;
       g.setColor(Color.black);
       g.drawString("Time spent "+ currentTime + " milliseconds",20,10);
       count++;
      }
    }
  }
}