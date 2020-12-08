//Using BorderLayout

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX13_2 extends JFrame
{
 public EX13_2()
  {
   JButton jbtOK = new JButton("OK"); //Ok�����s
   JButton jbtCancel = new JButton("Cancel"); //���������s
   JButton jbtExit = new JButton("exit"); //���}�����s
   JTextField name = new JTextField(8); //��r��J��

   JPanel panel = new JPanel(new BorderLayout());//��b�W�誺panel
   JPanel panel2 = new JPanel(new BorderLayout()); //��b�U�誺panel
   
   //�[�Jcomponent
   panel.add(new JLabel("Name"),BorderLayout.WEST);
   panel.add(name,BorderLayout.CENTER);

   panel2.add(jbtOK,BorderLayout.WEST);
   panel2.add(jbtCancel,BorderLayout.CENTER);
   panel2.add(jbtExit,BorderLayout.EAST);

   //�]panel��layout
   setLayout(new BorderLayout());
   add(panel,BorderLayout.NORTH);
   add(panel2,BorderLayout.SOUTH);

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
   JFrame frame = new EX13_2();//�ŧi����
   frame.setTitle("Handle Event"); //���D
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