//Koch snow flake fractal

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX20_27 extends JApplet
{
 private JTextField jtfOrder = new JTextField(5);//��J�� ��J����
 private SierpinskiTrianglePanel trianglePanel = new SierpinskiTrianglePanel();//ø��panel

 public EX20_27()
  {
   JPanel panel = new JPanel();//��Jpanel

   //�[�Jcomponent
   panel.add(new JLabel("Enter an order: "));
   panel.add(jtfOrder);
   jtfOrder.setHorizontalAlignment(SwingConstants.CENTER);//���

   //��X   
   add(trianglePanel);
   add(panel,BorderLayout.SOUTH);

   //�[�J�ʧ@
   jtfOrder.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     trianglePanel.setOrder(Integer.parseInt(jtfOrder.getText()));
    }
   });
  }

 public static void main(String args[])
  {
   JFrame frame = new JFrame("EX20_27");//�ŧi����
   
   EX20_27 applet = new EX20_27();
   frame.add(applet,BorderLayout.CENTER);//�[�JJAPP
   
   applet.init();//��l��

   frame.setSize(400,400);//�j�p
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
     
     //��l�T�I
     Point p1 = new Point(getWidth()/2,10);
     Point p2 = new Point(40,getHeight()-40);
     Point p3 = new Point(getWidth() - 40,getHeight()-40);
     
     //���j
     displayTriangles(g,order,p1,p2);
     displayTriangles(g,order,p2,p3);
     displayTriangles(g,order,p3,p1);
    }

   //���jø�s�T������
   private static void displayTriangles(Graphics g,int order,Point p1,Point p2)
    {
     if(order == 0)//base case
      {
       g.drawLine(p1.x,p1.y,p2.x,p2.y);//ø��
      }
     else
      {
       int deltaX = p2.x - p1.x;
       int deltaY = p2.y - p1.y;

       //����W���I
       Point P1P2 = new Point(p1.x + deltaX / 3,p1.y + deltaY / 3);
       Point P2P1 = new Point(p1.x + 2*deltaX / 3,p1.y + 2*deltaY / 3);
       
       //���ĤT�I
       int p3x = (int) (0.5 * (p1.x+p2.x) + Math.sqrt(3) * (p1.y-p2.y)/6);
       int p3y = (int) (0.5 * (p1.y+p2.y) + Math.sqrt(3) * (p2.x-p1.x)/6);
   
       Point p3 = new Point(p3x,p3y);

       //�C�@�q�i�H�����|�q ���j
       displayTriangles(g,order-1,p1,P1P2);
       displayTriangles(g,order-1,P1P2,p3);
       displayTriangles(g,order-1,p3,P2P1);
       displayTriangles(g,order-1,P2P1,p2);
      }
    }
  }
}