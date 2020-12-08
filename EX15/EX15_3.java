//moving the round rectangle

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX15_3 extends JFrame
{
 //����y��
 private int x = 50;
 private int y = 50;

 public EX15_3()
  {
   JButton left = new JButton("Left");//�������s
   JButton right = new JButton("Right");//�k�����s
   JButton up = new JButton("Up");//�W�����s
   JButton down = new JButton("Down");//�U�����s

   //���U���s�[�J�ƥ�
   left.addActionListener(new LeftClass());
   right.addActionListener(new RightClass());
   up.addActionListener(new UpClass());
   down.addActionListener(new DownClass());

   JPanel p1 = new JPanel();//���spanel

   //�[�J���s
   p1.add(left);
   p1.add(right);
   p1.add(up);
   p1.add(down);
   
   setLayout(new BorderLayout());//�]�wlayout
   add(p1,BorderLayout.NORTH);//p1�[�J�b�_��
   add(new RoundedRect(),BorderLayout.CENTER);//��ܤ��panel�[�J�b����
  }

 public static void main(String args[])
  {
   EX15_3 frame = new EX15_3();//�ŧi����
   frame.setTitle("EX15_3");//���D
   frame.setSize(500,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //���panel
 class RoundedRect extends JPanel
  {
   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //ø�X���
     g.setColor(Color.red);//�C��
     g.fillRoundRect(x,y,40,40,10,10);
    }
  }

 //�������s�ƥ�
 class LeftClass implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     x-=10;
     repaint();
    }
  }

 //�k�����s�ƥ�
 class RightClass implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     x+=10;
     repaint();
    }
  }

 //�W�����s�ƥ�
 class UpClass implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     y-=10;
     repaint();
    }
  }

 //�U�����s�ƥ�
 class DownClass implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     y+=10;
     repaint();
    }
  }
}