//Using GridLayout

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX13_3 extends JFrame
{
 public EX13_3()
  {
   JButton jbtOK = new JButton("OK"); //Ok的按鈕
   JButton jbtCancel = new JButton("Cancel"); //取消的按鈕
   JButton jbtExit = new JButton("exit"); //離開的按鈕
   JTextField name = new JTextField(8);

   JPanel panel = new JPanel(new GridLayout(1,2,5,5));//文字輸入面板
   JPanel panel2 = new JPanel(new GridLayout(1,3,5,5));//按鈕面板
   
   //加入component
   panel.add(new JLabel("Name"));
   panel.add(name);

   panel2.add(jbtOK);
   panel2.add(jbtCancel);
   panel2.add(jbtExit);

   //設layout
   setLayout(new GridLayout(2,1,5,5));
   
   //加入panel
   add(panel);
   add(panel2);

   //設定事件
   OKListenerClass listener1 = new OKListenerClass();
   CancelListenerClass listener2 = new CancelListenerClass();
   ExitListenerClass listener3 = new ExitListenerClass();
   
   //加入事件
   jbtOK.addActionListener(listener1);
   jbtCancel.addActionListener(listener2);
   jbtExit.addActionListener(listener3);
  }

 public static void main(String args[])
  {
   JFrame frame = new EX13_3();//宣告視窗
   frame.setTitle("Handle Event");//標題
   frame.setSize(400,100); //大小
   frame.setLocation(200,100); //位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
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