//displaying a checkerbroad

import javax.swing.*;
import java.awt.*;

public class EX13_10 extends JFrame
{
 public EX13_10()
  {
   setLayout(new GridLayout(7,8));//�]��7*8���榡
   
   int count = 0;//����
   int j=0;//�����¥�
   for(int i=0;i<56;i++,j++)
    {
     JButton b = new JButton();//���s
     if(count%8==0&&count!=0)//�]���n�¥լ۶� �U�@��n���C��
      j++;
     if(j%2==0)
      b.setBackground(Color.white);//�զ�
     else
      b.setBackground(Color.black);//�¦�
     
     add(b);//�[�J
     count++;
    }
  }

 public static void main(String args[])
  {
   JFrame frame = new EX13_10();//�ŧi����
   frame.setTitle("EX13_10");//���D
   frame.setSize(400,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}