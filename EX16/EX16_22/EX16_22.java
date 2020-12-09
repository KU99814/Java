//輸入檔名顯示檔案內容 隨時間輸入不同檔案

import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_22 extends JFrame
{
 private JTextArea jta = new JTextArea(); // 顯示內容
 Timer timer = new Timer(1000,new TimerListener()); //計時器
 int count = 0;//顯示第幾張

 public EX16_22()
  {
   //分行
   jta.setWrapStyleWord(true);
   jta.setLineWrap(true);

   //設為不能編輯
   jta.setEditable(false);

   JScrollPane scrollPane = new JScrollPane(jta);//加入滾動條
   
   add(scrollPane,BorderLayout.CENTER);
   timer.start(); //開始
  }

 //計時動作
 class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     if(count>9)//超過最後一數後回到原點
      count = 0;
     try
      {
       Scanner input = new Scanner(new File("slide"+count+".txt"));//讀取檔案
       String s = "";
       
       //讀取文字
       while(input.hasNext())
        {
         s += input.next()+" ";
        }
       jta.setText(s);//設定文本
       count++;
      }
     catch(Exception ex){}
    }
  }

 public static void main(String args[])
  {
   EX16_22 frame = new EX16_22();//宣告視窗
   frame.setTitle("EX16_22");//標題
   frame.setSize(600,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}
