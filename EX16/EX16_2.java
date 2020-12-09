//Selecting geometrics figures

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class EX16_2 extends JFrame
{
 //�I�����s�s ��ܧΪ�
 private JRadioButton jLine = new JRadioButton("Line");//�u
 private JRadioButton jRect = new JRadioButton("Rectangle");//�����
 private JRadioButton jOval = new JRadioButton("Oval");//���

 //������s
 private JCheckBox jFill = new JCheckBox("Filled");//�O�_��

 public EX16_2()
  {
   final FigurePanel p1 = new FigurePanel();//ø��panel
   p1.setBorder(new LineBorder(Color.BLACK,1));//���

   JPanel p2 = new JPanel(new FlowLayout());//���spanel

   //�[�J���s
   p2.add(jLine);
   p2.add(jRect);
   p2.add(jOval);
   p2.add(jFill);

   //�N��ܫ��s�k���@�s
   ButtonGroup group = new ButtonGroup();
   group.add(jLine);
   group.add(jRect);
   group.add(jOval);

   //��ܫ��s�[�J�ʧ@ ø�X���w�ϧ�
   jLine.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     p1.selectGraphic(1);
    }
   });

   jRect.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     p1.selectGraphic(2);
    }
   });

   jOval.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     p1.selectGraphic(3);
    }
   });

   //�[�J�ʧ@ �Ŀ�Y��
   jFill.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     p1.setFill(jFill.isSelected());
    }
   });
  
   setLayout(new BorderLayout(10,10));//�]�wlayout

   //�[�Jpanel
   add(p1,BorderLayout.CENTER);
   add(p2,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_2 frame = new EX16_2();//�ŧi����
   frame.setTitle("EX16_2");//���D
   frame.setSize(500,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 class FigurePanel extends JPanel
  {
   //���A�ܼ� �M�w�nø���ع�
   final int LINE = 1;//�u
   final int RECT = 2;//�����
   final int OVAL = 3;//��

   int select = 1;//�{�b���A
   boolean fill;//�O�_��

   public void selectGraphic(int select) //��ܹϤ�
    {
     this.select = select;
     repaint();
    }
   
   public void setFill(boolean fill)  //�O�_��
    {
     this.fill = fill;
     repaint();
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //���߮y��
     int x = getWidth()/2;
     int y = getHeight()/2;

     //���e
     int w = (int)(getWidth()*0.8);
     int h = (int)(getHeight()*0.8);

     if(fill)//�P�_�O�_��
      {
       switch(select)//�ھڪ��Aø��
        {
         case LINE: g.drawLine(x-w/2,y-h/2,x+w/2,y+h/2);break;
         case RECT: g.fillRect(x-w/2,y-h/2,w,h);break;
         case OVAL: g.fillOval(x-w/2,y-h/2,w,h);break;
        }
      }
       
     else//����
      {
       switch(select)
        {
         case LINE: g.drawLine(x-w/2,y-h/2,x+w/2,y+h/2);break;
         case RECT: g.drawRect(x-w/2,y-h/2,w,h);break;
         case OVAL: g.drawOval(x-w/2,y-h/2,w,h);break;
        }
      } 
    }
  }
}