import javax.swing.*;
import java.awt.*;

public class EX13_7 extends JFrame
{
 private ImageIcon cross = new ImageIcon("x.gif");   //���JX��
 private ImageIcon not = new ImageIcon("o.gif");     //���JO��

 public EX13_7()
  {
   setLayout(new GridLayout(3,3));                 //�]�wlayout
   
   for(int i = 0;i<9;i++)                          //�H���X�{OX�B�Ů�
    {
     int r = (int)(Math.random()*3);            

     if(r == 1)
      add(new JLabel(cross));//��mX
     else if(r == 2) //��mO
      add(new JLabel(not));
     else //�ť�
      add(new JLabel());
    }
  }
 public static void main(String args[])
  {
   EX13_7 frame = new EX13_7();//�ŧi����
   frame.setTitle("frame");//���D
   frame.setSize(300,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true); //���
  }
}