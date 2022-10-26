//Creating custom event sets and source component
//modify EX32_1

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EX32_3 extends JFrame
{
 private JButton jbt = new JButton("Hit me");//按鈕
 private Counter counter = new Counter();//計數Label
 private JPanel alterLabel = new JPanel();

 public EX32_3()
  {
   alterLabel.setOpaque(true);
   alterLabel.setBackground(Color.green);
   //排版
   setLayout(new FlowLayout());
   add(jbt);
   add(counter);
   add(alterLabel);

   //加入按鈕事件
   jbt.addActionListener(new ButtonListener(counter));
  }

//計數器物件
class Counter extends JLabel
 {
  private int count = 0;//計數
  private int maxValue = 10;
  private Alarm alarm = new Alarm();
  
  public Counter()
   {
    setText(count+"");
   }
  
  //增加數字
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

 //按鈕事件 增加數字
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
     this.counter = counter;//綁定物件
    }

   public void actionPerformed(ActionEvent e)
    {
     //按鈕觸發增加事件
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
   //觸發事件改變顏色
   public void maxValueReached(MaxValueEvent e)
    {
     alterLabel.setBackground(Color.red);
    }   
  }

 public static void main(String args[])
  {
   EX32_3 frame = new EX32_3();//frame
   frame.setTitle("EX32_3");//標題
   frame.setSize(100,100);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}