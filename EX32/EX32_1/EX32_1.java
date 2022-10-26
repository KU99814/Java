//Creating source and listener

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EX32_1 extends JFrame
{
 private JButton jbt = new JButton("Hit me");//���s
 private Counter counter = new Counter();//�p��Label

 public EX32_1()
  {
   //�ƪ�
   setLayout(new FlowLayout());
   add(jbt);
   add(counter);

   //�[�J���s�ƥ�
   jbt.addActionListener(new ButtonListener(counter));
  }

//�p�ƾ�����
class Counter extends JLabel
 {
  private int count = 0;//�p��
  
  public Counter()
   {
    setText(count+"");
   }
  
  //�W�[�Ʀr
  public void increment()
   {
    count++;
    setText(count+"");
   }
 }

 //���s�ƥ� �W�[�Ʀr
 class ButtonListener implements ActionListener
  {
   private Counter counter;

   //constructor
   public ButtonListener()
    {
     counter = new Counter();
    }
   
   public ButtonListener(Counter counter)
    {
     this.counter = counter;//�j�w����
    }

   public void actionPerformed(ActionEvent e)
    {
     //���sĲ�o�W�[�ƥ�
     counter.increment();
    }
  }

 public static void main(String args[])
  {
   EX32_1 frame = new EX32_1();//frame
   frame.setTitle("EX32_1");//���D
   frame.setSize(100,100);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}