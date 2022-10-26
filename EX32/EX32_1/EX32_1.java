//Creating source and listener

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EX32_1 extends JFrame
{
 private JButton jbt = new JButton("Hit me");//按鈕
 private Counter counter = new Counter();//計數Label

 public EX32_1()
  {
   //排版
   setLayout(new FlowLayout());
   add(jbt);
   add(counter);

   //加入按鈕事件
   jbt.addActionListener(new ButtonListener(counter));
  }

//計數器物件
class Counter extends JLabel
 {
  private int count = 0;//計數
  
  public Counter()
   {
    setText(count+"");
   }
  
  //增加數字
  public void increment()
   {
    count++;
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

 public static void main(String args[])
  {
   EX32_1 frame = new EX32_1();//frame
   frame.setTitle("EX32_1");//標題
   frame.setSize(100,100);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}