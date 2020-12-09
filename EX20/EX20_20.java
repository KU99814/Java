//Display circles

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX20_20 extends JFrame
{
 private DisplayOvalPanel ovalPanel = new DisplayOvalPanel();//ø��panel

 public EX20_20()
  {
   add(ovalPanel);//�[�Jpanel
  }

 public static void main(String args[])
  {
   EX20_20 frame = new EX20_20();
   
   frame.setTitle("EX20_20");//���D
   frame.setSize(300,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //ø��
 class DisplayOvalPanel extends JPanel
  {
   private int order = 1;//ø�Ϧ���

   //�]�w����
   public void setOrder(int order)
    {
     this.order = order;
     repaint();
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     displayOval(g,order);//���j��k
    }

   //ø�ϻ��j
   private void displayOval(Graphics g,int order)
    {
     if(order <= 15)//��15����
      {
       //ø�s��
       g.drawOval((getWidth()/2)-5*order,(getHeight()/2)-5*order,order*10,order*10);
     
       //���j
       displayOval(g,order+1);
      }
    }
  }
}