//輸入檔名顯示檔案內容

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_19 extends JFrame
{
 private JTextArea jta = new JTextArea(); // 顯示內容
 private JTextField jtfile = new JTextField(13); //輸入檔名
 private JButton view = new JButton("View"); //執行

 public EX16_19()
  {
   //設定分行
   jta.setWrapStyleWord(true);
   jta.setLineWrap(true);

   //設定不能編輯文本
   jta.setEditable(false);

   JScrollPane scrollPane = new JScrollPane(jta);//加入滾動條
   
   //輸入檔案panel
   JPanel p1 = new JPanel();
   p1.add(new JLabel("Filename"));
   p1.add(jtfile);
   p1.add(view);
   
   ///加入動作 顯示檔案文本
   view.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try
     {
      Scanner input = new Scanner(new File(jtfile.getText())); //讀檔
     
      String s = "";//顯示字串

      while(input.hasNext()) 
       {
        s += input.next();//輸入文本
       }
    
      jta.setText(s);//顯示
     }
     catch(Exception ex){
     //如果失敗
     jta.setText("error");}
    }
   });

   //整合
   add(scrollPane,BorderLayout.CENTER);
   add(p1,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_19 frame = new EX16_19();//顯示視窗
   frame.setTitle("EX16_19");//標題
   frame.setSize(600,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}
