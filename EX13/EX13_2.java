//Using BorderLayout

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX13_2 extends JFrame
{
 public EX13_2()
  {
   JButton jbtOK = new JButton("OK"); //Ok的按鈕
   JButton jbtCancel = new JButton("Cancel"); //取消的按鈕
   JButton jbtExit = new JButton("exit"); //離開的按鈕
   JTextField name = new JTextField(8); //文字輸入欄

   JPanel panel = new JPanel(new BorderLayout());//放在上方的panel
   JPanel panel2 = new JPanel(new BorderLayout()); //放在下方的panel
   
   //加入component
   panel.add(new JLabel("Name"),BorderLayout.WEST);
   panel.add(name,BorderLayout.CENTER);

   panel2.add(jbtOK,BorderLayout.WEST);
   panel2.add(jbtCancel,BorderLayout.CENTER);
   panel2.add(jbtExit,BorderLayout.EAST);

   //設panel的layout
   setLayout(new BorderLayout());
   add(panel,BorderLayout.NORTH);
   add(panel2,BorderLayout.SOUTH);

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
   JFrame frame = new EX13_2();//宣告視窗
   frame.setTitle("Handle Event"); //標題
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