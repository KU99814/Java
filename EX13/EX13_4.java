//Using Color

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX13_4 extends JFrame
{
 public EX13_4()
  {
   JButton jbtOK = new JButton("OK"); //Ok的按鈕
   JButton jbtCancel = new JButton("Cancel"); //取消的按鈕
   JButton jbtExit = new JButton("exit"); //離開的按鈕
   JLabel nameL = new JLabel("Name"); //文字
   JTextField name = new JTextField(8); //文字輸入項

   JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));//文字輸入版面
   JPanel panel2 = new JPanel(); //按鈕版面
   
   //設定OK按鈕顏色
   jbtOK.setBackground(Color.gray);
   jbtOK.setForeground(Color.red);

   //設定cancel按鈕顏色
   jbtCancel.setBackground(Color.gray);
   jbtCancel.setForeground(Color.blue);

   //設定Exit按鈕顏色   
   jbtExit.setBackground(Color.gray);
   jbtExit.setForeground(Color.green);

   //設定文字顏色
   nameL.setForeground(Color.white);
   name.setForeground(Color.yellow);

   //加入component   
   panel.add(nameL);
   panel.add(name);

   panel2.add(jbtOK);
   panel2.add(jbtCancel);
   panel2.add(jbtExit);

   //設layout
   setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
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
   JFrame frame = new EX13_4();//宣告視窗
   frame.setTitle("Handle Event");//標題
   frame.setSize(400,100); //大小
   frame.setLocation(200,100);//位置
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