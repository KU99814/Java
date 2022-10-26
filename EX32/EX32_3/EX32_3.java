//Creating custom event sets and source component
//modify EX32_1

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EX32_3 extends JFrame
{
 private JButton jbt = new JButton("Hit me");//���s
 private Counter counter = new Counter();//�p��Label
 private JPanel alterLabel = new JPanel();

 public EX32_3()
  {
   alterLabel.setOpaque(true);
   alterLabel.setBackground(Color.green);
   //�ƪ�
   setLayout(new FlowLayout());
   add(jbt);
   add(counter);
   add(alterLabel);

   //�[�J���s�ƥ�
   jbt.addActionListener(new ButtonListener(counter));
  }

//�p�ƾ�����
class Counter extends JLabel
 {
  private int count = 0;//�p��
  private int maxValue = 10;
  private Alarm alarm = new Alarm();
  
  public Counter()
   {
    setText(count+"");
   }
  
  //�W�[�Ʀr
  public void increment()
   {
    count++;
    if(count==maxValue)
     {
      alarm.maxValueReached(new MaxValueEvent(this));
     }
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

 class MaxValueEvent extends java.util.EventObject
  {
   public MaxValueEvent(Object source)
    {
     super(source);
    }
  }

 interface MaxValueListener extends java.util.EventListener
  {
   public void maxValueReached(MaxValueEvent e);
  }

 class Alarm implements MaxValueListener
  {
   //Ĳ�o�ƥ�����C��
   public void maxValueReached(MaxValueEvent e)
    {
     alterLabel.setBackground(Color.red);
    }   
  }

 public static void main(String args[])
  {
   EX32_3 frame = new EX32_3();//frame
   frame.setTitle("EX32_3");//���D
   frame.setSize(100,100);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}