//Displaying labels

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class EX13_5 extends JFrame
{
 public EX13_5()
  {
   JPanel p1 = new JPanel();//�Ĥ@���r
   p1.add(new JLabel("Departmant of Computer Science"));
   
   JPanel p2 = new JPanel();//�ĤG���r
   p2.add(new JLabel("School of Computing"));

   JPanel p3 = new JPanel();//�ĤT���r
   p3.add(new JLabel("Armstrong Atlantic State University"));

   JPanel p4 = new JPanel();//�ĥ|���r
   p4.add(new JLabel("Tel:(912)921-6440"));

   Border lineBorder = new LineBorder(Color.BLACK,2);//�ŧi���

   //�]�w���   
   p1.setBorder(lineBorder);
   p2.setBorder(lineBorder);
   p3.setBorder(lineBorder);
   p4.setBorder(lineBorder);

   //�]�wlayout
   setLayout(new GridLayout(4,1));

   //�[�Jpanel
   add(p1);
   add(p2);
   add(p3);
   add(p4);
  }

 public static void main(String args[])
  {
   JFrame frame = new EX13_5();//�ŧi����
   frame.setTitle("EX13_5");//���D
   frame.setSize(300,150); //�j�p
   frame.setLocationRelativeTo(null);//��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}