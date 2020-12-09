//H-tree fractal

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX20_35 extends JFrame
{
 private JTextField jtfOrder = new JTextField(5);//��J�� ��Jø�Ϧ���
 private HPanel hPanel = new HPanel();//ø��

 public EX20_35()
  {
   JPanel panel = new JPanel();//�ާ@panel

   //�[�Jcomponent
   panel.add(new JLabel("Enter an order: "));
   panel.add(jtfOrder);

   //���
   jtfOrder.setHorizontalAlignment(SwingConstants.CENTER);
   
   //��X
   add(hPanel);
   add(panel,BorderLayout.SOUTH);

   //�[�J�ʧ@
   jtfOrder.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     //��J���� ø��
     hPanel.setOrder(Integer.parseInt(jtfOrder.getText()));
    }
   });
  }

 public static void main(String args[])
  {
   EX20_35 frame = new EX20_35();//�ŧi����

   frame.setTitle("EX20_35");
   frame.setSize(400,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //ø��panel
 static class HPanel extends JPanel
  {
   private int order = 0;//���j����

   //�]�w���ƨ�ø��
   public void setOrder(int order)
    {
     this.order = order;
     repaint();
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //�Ĥ@���I �]�b����
     Point p1 = new Point(getWidth()/2,getHeight()/2);
     
     //ø��method
     displayH(g,order,p1,getWidth()/3);
    }

   private static void displayH(Graphics g,int order,Point p1,int length)
    {
     //���oø�sH�������I �q�����I����
     Point p2 = new Point(p1.x-length/2,p1.y-length/2);
     Point p3 = new Point(p1.x-length/2,p1.y);
     Point p4 = new Point(p1.x-length/2,p1.y+length/2);
     Point p5 = new Point(p1.x+length/2,p1.y-length/2);
     Point p6 = new Point(p1.x+length/2,p1.y);
     Point p7 = new Point(p1.x+length/2,p1.y+length/2);

     if(order == 0)//base case
      {
       //ø�sH
       g.drawLine(p2.x,p2.y,p4.x,p4.y);
       g.drawLine(p3.x,p3.y,p6.x,p6.y);
       g.drawLine(p5.x,p5.y,p7.x,p7.y);
      }
     else
      {
       //ø�sH
       g.drawLine(p2.x,p2.y,p4.x,p4.y);
       g.drawLine(p3.x,p3.y,p6.x,p6.y);
       g.drawLine(p5.x,p5.y,p7.x,p7.y);

       //�N�䤤�|�I�@�������I��J���j
       displayH(g,order-1,p2,length/2);
       displayH(g,order-1,p4,length/2);
       displayH(g,order-1,p5,length/2);
       displayH(g,order-1,p7,length/2);
      }
    }
  }
}