//Using FlowLayout

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX13_1 extends JFrame
{
 public EX13_1()
  {
   JButton jbtOK = new JButton("OK"); //Ok�����s
   JButton jbtCancel = new JButton("Cancel"); //���������s
   JButton jbtExit = new JButton("exit"); //���}�����s
   JTextField name = new JTextField(8);

   JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));//�]�w�ƪ�
   JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));//�]�w�ƪ�   

   //�[�Jcomponent
   panel.add(new JLabel("Name"));
   panel.add(name);
   panel2.add(jbtOK);
   panel2.add(jbtCancel);
   panel2.add(jbtExit);

   //�]panel
   setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
   add(panel);
   add(panel2);

   //�]�w�ƥ�
   OKListenerClass listener1 = new OKListenerClass(); //OK�ƥ�
   CancelListenerClass listener2 = new CancelListenerClass(); //Cancel�ƥ�
   ExitListenerClass listener3 = new ExitListenerClass(); //EXIT�ƥ�
   
   //���s�[�J�ƥ�
   jbtOK.addActionListener(listener1);
   jbtCancel.addActionListener(listener2);
   jbtExit.addActionListener(listener3);
  }

 public static void main(String args[])
  {
   JFrame frame = new EX13_1();//�ŧi����
   //�]�w����
   frame.setTitle("Handle Event"); //���D
   frame.setSize(600,100); //�j�p
   frame.setLocation(300,200); //��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ɰʧ@
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