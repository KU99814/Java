//sierpinski triangle

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX20_19 extends JFrame
{
 private int order = 0; //�yø����
 private JButton jbLeft = new JButton(); //��֦��ƫ��s
 private JButton jbRight = new JButton(); //�W�[���ƫ��s
 private SierpinskiTrianglePanel trianglePanel = new SierpinskiTrianglePanel();//ø��panel

 public EX20_19()
  {
   //�[�J���s�Ϥ�
   jbLeft.setIcon(new ImageIcon("left.gif"));//��
   jbRight.setIcon(new ImageIcon("right.gif"));//�k

   JPanel panel = new JPanel();//���s���O
 
   //�[�J���s
   panel.add(jbLeft);
   panel.add(jbRight);

   //���
   jbLeft.setHorizontalAlignment(SwingConstants.CENTER);
   jbRight.setHorizontalAlignment(SwingConstants.CENTER);
   
   //��X
   add(trianglePanel);
   add(panel,BorderLayout.SOUTH);

   //�[�J���s�ʧ@
   jbLeft.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     if(order>0)
      {
       order--;//��֦���
       trianglePanel.setOrder(order);//��ø
      }
    }
   });
   
   jbRight.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     order++;//�W�[����
     trianglePanel.setOrder(order);//��ø
    }
   });
  }

 public static void main(String args[])
  {
   EX20_19 frame = new EX20_19();

   frame.setTitle("EX20_19");//�ŧi����
   frame.setSize(300,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //ø��panel
 static class SierpinskiTrianglePanel extends JPanel
  {
   private int order = 0;//ø�Ϧ���

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
     
     //��l�I�y��
     Point p1 = new Point(getWidth()/2,10);
     Point p2 = new Point(10,getHeight()-10);
     Point p3 = new Point(getWidth() - 10,getHeight()-10);
     
     //���j
     displayTriangles(g,order,p1,p2,p3);
    }

   //���j ���C���䤤�Iø�X�T����
   private static void displayTriangles(Graphics g,int order,Point p1,Point p2,Point p3)
    {
     if(order >= 0)
      {
       //ø�X�T����
       g.drawLine(p1.x,p1.y,p2.x,p2.y);
       g.drawLine(p1.x,p1.y,p3.x,p3.y);
       g.drawLine(p2.x,p2.y,p3.x,p3.y);
     
       //���T�䤤�I
       Point midBetweenP1P2 = midpoint(p1,p2);
       Point midBetweenP2P3 = midpoint(p2,p3);
       Point midBetweenP3P1 = midpoint(p3,p1);
     
       //�N�Ҧ��I�[�J���j
       displayTriangles(g,order-1,p1,midBetweenP1P2,midBetweenP3P1);
       displayTriangles(g,order-1,midBetweenP1P2,p2,midBetweenP2P3);
       displayTriangles(g,order-1,midBetweenP3P1,midBetweenP2P3,p3);
      }
    }

   //�����I
   private static Point midpoint(Point p1,Point p2)
    {
     return new Point((p1.x+p2.x)/2,(p1.y+p2.y)/2);
    }
  }
}