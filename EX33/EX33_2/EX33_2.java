//Phone Dialer using BorderLayout,GridLayout,and FlowLayout

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class EX33_2 extends JFrame
{
 private JTextField jtfDisplay = new JTextField(); //��ܸ��X

 //�ާ@���s
 private JButton jbZero = new JButton("0");
 private JButton jbAsterisk = new JButton("*");
 private JButton jbExtension = new JButton("#"); 
 private JButton jbDial = new JButton("Dial");
 private JButton jbHangup = new JButton("Hangup");
 private JButton jbRedial = new JButton("Redial");

 private StringBuilder sPhoto = new StringBuilder();//��ܸ��X�r��

 public EX33_2()
  {
   JPanel pClick = new JPanel(new GridLayout(4,3,5,10));//���䭱�O
   
   //�[�J�Ʀr��
   for(int i =1;i<=9;i++)
   {
    JButton btnNum = new JButton(i+"");
    pClick.add(btnNum);
    btnNum.addActionListener(new ClickListener());
   }
   
   pClick.add(jbAsterisk);
   pClick.add(jbZero);
   pClick.add(jbExtension);

   //�[�J����ƥ�
   jbAsterisk.addActionListener(new ClickListener());
   jbZero.addActionListener(new ClickListener());
   jbExtension.addActionListener(new ClickListener());

   JPanel pFunc = new JPanel(new FlowLayout());

   pFunc.add(jbDial);
   pFunc.add(jbHangup);
   pFunc.add(jbRedial);

   //�����ƥ�
   jbRedial.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
     sPhoto.delete(0, sPhoto.length());
     jtfDisplay.setText(sPhoto.toString());
    }
   });

   //�[�J�ƪ�
   setLayout(new BorderLayout(5,5));
   add(jtfDisplay,BorderLayout.NORTH);
   add(pClick,BorderLayout.CENTER);
   add(pFunc,BorderLayout.SOUTH);
  }

 //����ƥ� ���o���s��r
 class ClickListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     sPhoto.append(e.getActionCommand());
     jtfDisplay.setText(sPhoto.toString());
    }
  }

 public static void main(String args[])
  {
   EX33_2 frame = new EX33_2();
   
   frame.setTitle("EX33_2");//���D
   frame.setSize(300,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}