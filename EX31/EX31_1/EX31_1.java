//Unicode viewer

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class EX31_1 extends JFrame
{
 private JTextField jtfUnicode = new JTextField(5);//輸入unicode
 private TitledBorder inputTitle = new TitledBorder("Specify Unicode");//標題框
 
 private JTextArea jta = new JTextArea();//顯示訊息

 public EX31_1()
  {
   //輸入panel
   JPanel p1 = new JPanel(new FlowLayout());
   p1.add(jtfUnicode);
   p1.setBorder(inputTitle);

   //顯示panel
   JPanel p2 = new JPanel(new BorderLayout());
   JScrollPane jsp = new JScrollPane(jta);

   p2.add(jsp,BorderLayout.CENTER);

   //排版
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);

   //事件
   jtfUnicode.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      //將字碼轉為數字
      int num = Integer.parseInt(jtfUnicode.getText(),16);
      StringBuilder str = new StringBuilder();
      for(int i=0;i<20;i++)
       {
        String c = Integer.toHexString(num);
        str.append(c+"   ");//加入字碼
        for(int j=0;j<16;j++)
         {
          //轉為字元
          String unicode = unicode2String(("\\u"+Integer.toHexString(num)));
          str.append(unicode+"   ");
          num++;
         }
        str.append("\n");
       }

      jta.setText(str.toString());//顯示
     }
   });
  }

 public String unicode2String(String unicode) 
  {
   StringBuffer string = new StringBuffer();
   String[] hex = unicode.split("\\\\u");

   for (int i = 1; i < hex.length; i++) 
    {
     // 轉換出每一個程式碼點
     int data = Integer.parseInt(hex[i], 16);
     // 追加成string
     string.append((char) data);
    }
 
   return string.toString();
  }

 public static void main(String args[])
  {
   EX31_1 frame = new EX31_1();
   
   frame.setTitle("EX31_1");
   frame.setSize(400,300);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setLocationRelativeTo(null);
   frame.setVisible(true);
  }
}