//using Icon

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class EX13_6 extends JFrame
{
 //Ū���Ϥ�
 private ImageIcon i1 = new ImageIcon("flag4.gif");
 private ImageIcon i2 = new ImageIcon("flag5.gif");
 private ImageIcon i3 = new ImageIcon("flag6.gif");
 private ImageIcon i4 = new ImageIcon("flag9.gif");
   
 public EX13_6()
  {
   Border lineBorder = new LineBorder(Color.BLACK,2);//�ŧi���

   //�ŧi��m�Ϥ�  
   JLabel l1 = new JLabel(i1);
   JLabel l2 = new JLabel(i2);
   JLabel l3 = new JLabel(i3);
   JLabel l4 = new JLabel(i4);

   //�]�w���
   l1.setBorder(lineBorder);
   l2.setBorder(lineBorder);
   l3.setBorder(lineBorder);
   l4.setBorder(lineBorder);

   //�]�w����
   setLayout(new GridLayout(2,2,5,5));
   
   //�[�Jpanel
   add(l1);
   add(l2);
   add(l3);
   add(l4);
  }

  public static void main(String args[])
  {
   JFrame frame = new EX13_6();//�ŧi����
   frame.setTitle("EX13_6");//�ŧi���D
   frame.setSize(400,400); //�ŧi�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}