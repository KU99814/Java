//Handling event

import javax.swing.*;
import java.awt.event.*;

public class EX11_1 extends JFrame
{
 public EX11_1()
  {
   JButton jbtOK = new JButton("OK"); //Ok�����s
   JButton jbtCancel = new JButton("Cancel"); //���������s
   JButton jbtExit = new JButton("exit"); //���}�����s

   //�ŧipanel
   JPanel panel = new JPanel();

   //�[�J���s
   panel.add(jbtOK);
   panel.add(jbtCancel);
   panel.add(jbtExit);

   //�]panel
   add(panel);

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
   //�]����
   JFrame frame = new EX11_1();
   frame.setTitle("Handle Event");//���D
   frame.setSize(200,150);//�j�p
   frame.setLocation(200,100); //�X�{��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����
   frame.setVisible(true); //�X�{
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