//Handling event

import javax.swing.*;
import java.awt.event.*;

public class EX11_1 extends JFrame
{
 public EX11_1()
  {
   JButton jbtOK = new JButton("OK"); //Ok的按鈕
   JButton jbtCancel = new JButton("Cancel"); //取消的按鈕
   JButton jbtExit = new JButton("exit"); //離開的按鈕

   //宣告panel
   JPanel panel = new JPanel();

   //加入按鈕
   panel.add(jbtOK);
   panel.add(jbtCancel);
   panel.add(jbtExit);

   //設panel
   add(panel);

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
   //設視窗
   JFrame frame = new EX11_1();
   frame.setTitle("Handle Event");//標題
   frame.setSize(200,150);//大小
   frame.setLocation(200,100); //出現位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉
   frame.setVisible(true); //出現
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