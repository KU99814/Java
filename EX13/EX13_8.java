import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class EX13_8 extends JFrame
{
 public EX13_8()
  {
   //�ŧi��r
   JLabel l1 = new JLabel("black");
   JLabel l2 = new JLabel("blue");
   JLabel l3 = new JLabel("cyan");
   JLabel l4 = new JLabel("green");
   JLabel l5 = new JLabel("magenta");
   JLabel l6 = new JLabel("orange");
   
   Border lineBorder = new LineBorder(Color.yellow,2);//�ŧi���
   Font font = new Font("TimesRoman",Font.BOLD,20); //�ŧi�r��

   //�]�wLabel1
   l1.setBackground(Color.white);
   l1.setForeground(Color.black);
   l1.setFont(font);
   l1.setBorder(lineBorder);

   //�]�wLabel2
   l2.setBackground(Color.white);
   l2.setForeground(Color.blue);
   l2.setFont(font);
   l2.setBorder(lineBorder);

   //�]�wLabel3
   l3.setBackground(Color.white);
   l3.setForeground(Color.cyan);
   l3.setFont(font);
   l3.setBorder(lineBorder);

   //�]�wLabel4
   l4.setBackground(Color.white);
   l4.setForeground(Color.green);
   l4.setFont(font);
   l4.setBorder(lineBorder);

   //�]�wLabel5
   l5.setBackground(Color.white);
   l5.setForeground(Color.magenta);
   l5.setFont(font);
   l5.setBorder(lineBorder);

   //�]�wLabel6
   l6.setBackground(Color.white);
   l6.setForeground(Color.orange);
   l6.setFont(font);
   l6.setBorder(lineBorder);

   setLayout(new GridLayout(2,3));//�]�wLayout

   //�[�Jpanel
   add(l1);
   add(l2);
   add(l3);
   add(l4);
   add(l5);
   add(l6);
  }

 public static void main(String args[])
  {
   JFrame frame = new EX13_8();//�ŧi����
   frame.setTitle("EX13_8");//���D
   frame.setSize(400,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}