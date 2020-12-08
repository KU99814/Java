//Using FlowLayout

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX13_1 extends JFrame
{
 public EX13_1()
  {
   JButton jbtOK = new JButton("OK"); //Ok的按鈕
   JButton jbtCancel = new JButton("Cancel"); //取消的按鈕
   JButton jbtExit = new JButton("exit"); //離開的按鈕
   JTextField name = new JTextField(8);

   JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));//設定排版
   JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));//設定排版   

   //加入component
   panel.add(new JLabel("Name"));
   panel.add(name);
   panel2.add(jbtOK);
   panel2.add(jbtCancel);
   panel2.add(jbtExit);

   //設panel
   setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
   add(panel);
   add(panel2);

   //設定事件
   OKListenerClass listener1 = new OKListenerClass(); //OK事件
   CancelListenerClass listener2 = new CancelListenerClass(); //Cancel事件
   ExitListenerClass listener3 = new ExitListenerClass(); //EXIT事件
   
   //按鈕加入事件
   jbtOK.addActionListener(listener1);
   jbtCancel.addActionListener(listener2);
   jbtExit.addActionListener(listener3);
  }

 public static void main(String args[])
  {
   JFrame frame = new EX13_1();//宣告視窗
   //設定視窗
   frame.setTitle("Handle Event"); //標題
   frame.setSize(600,100); //大小
   frame.setLocation(300,200); //位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉時動作
   frame.setVisible(true); //顯示
  }
}

//OK事件
class OKListenerClass implements ActionListener
{
 public void actionPerformed(ActionEvent e)
  {
   System.out.println("Ok button clicked");
  }
}


//canael事件
class CancelListenerClass implements ActionListener
{
 public void actionPerformed(ActionEvent e)
  {
   System.out.println("Cancel button clicked");
  }
}

//exit事件
class ExitListenerClass implements ActionListener
{
 public void actionPerformed(ActionEvent e)
  {
   System.out.println("exit button clicked");
  }
}