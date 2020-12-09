//Using two radio button groups

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX16_1 extends JFrame
{
 //�I����s�� ����C��
 private JRadioButton jRed = new JRadioButton("Red");//��
 private JRadioButton jYellow = new JRadioButton("Yellow");//��
 private JRadioButton jWhite = new JRadioButton("White");//��
 private JRadioButton jGray = new JRadioButton("Gray");//��
 private JRadioButton jGreen = new JRadioButton("Green");//��

 //�I����s�� ��ܧΪ�
 private JRadioButton jRect = new JRadioButton("Rectangle");//�����
 private JRadioButton jOval = new JRadioButton("Oval"); //���

 public EX16_1()
  {
   setLayout(new BorderLayout());//�]�wlayout

   JPanel p1 = new JPanel(); //radio panel
   final GraphicsPanel p2 = new GraphicsPanel(); //graphic panel
   JPanel p3 = new JPanel(); // geometry panel

   //�[�J�C��s
   p1.add(jRed);
   p1.add(jYellow);
   p1.add(jWhite);
   p1.add(jGray);
   p1.add(jGreen);

   //�N�C����s�k���@��
   ButtonGroup group1 = new ButtonGroup();
   group1.add(jRed);
   group1.add(jYellow);
   group1.add(jWhite);
   group1.add(jGray);
   group1.add(jGreen);

   //�C�ӫ��s�[�J�ʧ@ �I�������C��
   jRed.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.red);
    }
   });

   jYellow.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.yellow);
    }
   });

   jWhite.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.white);
    }
   });

   jGray.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.gray);
    }
   });

   jGreen.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.green);
    }
   });

   //�N�Ϊ����s�[�Jpanel
   p3.add(jRect);
   p3.add(jOval);

   //�N���s�k���@��
   ButtonGroup group2 = new ButtonGroup();
   group2.add(jRect);
   group2.add(jOval);

   //�Ϊ����s�[�J�ʧ@
   jRect.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setPaint(true);
    }
   });

   jOval.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setPaint(false);
    }
   });

   //�]�w��l���A
   jRed.setSelected(true);
   p2.setBackground(Color.red);
   jRect.setSelected(true);
   p2.setPaint(true);

   //�N�U��panel�[�Jframe
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(p3,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_1 frame = new EX16_1();//�ŧi����
   frame.setTitle("EX16_1");//���D
   frame.setSize(500,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //ø��panel
 class GraphicsPanel extends JPanel
  {
   boolean thePaint = false;//�Ϊ��P�_
   
   //�]�w�Ϊ�
   public void setPaint(boolean thePaint)
    {
     this.thePaint = thePaint;
     repaint();
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //�M�w���e
     int w = (int)(getWidth()*0.8);
     int h = (int)(getHeight()*0.8);

     //�ھ�thePaint�P�_��ø���اΪ�
     if(thePaint)
      g.drawRect(getWidth()/2-w/2,getHeight()/2-h/2,w,h);
     else
      g.drawOval(getWidth()/2-h/2,getHeight()/2-h/2,h/2,h/2);
    }
  }
}
   