//Using GridLayout

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX13_3 extends JFrame
{
 public EX13_3()
  {
   JButton jbtOK = new JButton("OK"); //Ok�����s
   JButton jbtCancel = new JButton("Cancel"); //���������s
   JButton jbtExit = new JButton("exit"); //���}�����s
   JTextField name = new JTextField(8);

   JPanel panel = new JPanel(new GridLayout(1,2,5,5));//��r��J���O
   JPanel panel2 = new JPanel(new GridLayout(1,3,5,5));//���s���O
   
   //�[�Jcomponent
   panel.add(new JLabel("Name"));
   panel.add(name);

   panel2.add(jbtOK);
   panel2.add(jbtCancel);
   panel2.add(jbtExit);

   //�]layout
   setLayout(new GridLayout(2,1,5,5));
   
   //�[�Jpanel
   add(panel);
   add(panel2);

   //�]�w�ƥ�
   OKListenerClass listener1 = new OKListenerClass();
   CancelListenerClass listener2 = new CancelListenerClass();
   ExitListenerClass listener3 = new ExitListenerClass();
   
   //�[�J�ƥ�
   jbtOK.addActionListener(listener1);
   jbtCancel.addActionListener(listener2);
   jbtExit.addActionListener(listener3);
  }

 public static void main(String args[])
  {
   JFrame frame = new EX13_3();//�ŧi����
   frame.setTitle("Handle Event");//���D
   frame.setSize(400,100); //�j�p
   frame.setLocation(200,100); //��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true); //���
  }
}

//OK�ƥ�
class OKListenerClass implements ActionListener
{
 public void actionPerformed(ActionEvent e)
  {
   System.out.println("Ok button clicked");
  }
}


//canael�ƥ�
class CancelListenerClass implements ActionListener
{
 public void actionPerformed(ActionEvent e)
  {
   System.out.println("Cancel button clicked");
  }
}

//exit�ƥ�
class ExitListenerClass implements ActionListener
{
 public void actionPerformed(ActionEvent e)
  {
   System.out.println("exit button clicked");
  }
}