//計算字母頻率 檔案輸入

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX16_21 extends JFrame
{
 private Histogram histogram = new Histogram();//長條圖panel
 private JTextField jtf = new JTextField(15);//輸入檔案
 
 public EX16_21()
  {
   //輸入檔名panel
   JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));

   //加入component
   p1.add(new JLabel("Text file"));
   p1.add(jtf);

   //整合
   add(histogram,BorderLayout.CENTER);
   add(p1,BorderLayout.SOUTH);
   
   //加入動作 
   jtf.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int[] count = countLetters(jtf.getText());//取得頻率
     histogram.showHistogram(count);//顯示長條圖
    }
   });
  }

 private int[] countLetters(String file) //計算次數
  {
   String text = "";
   int[] count = new int[26];
   try
    {
     Scanner input = new Scanner(new File(file));
     while(input.hasNext())
      {
       text += input.next();
      }
    }
   catch(Exception ex){}
   
   for(int i=0;i<text.length();i++)
    {
     char character = text.charAt(i);
     
     //大小寫視為同一字
     if((character >= 'A') && (character <= 'Z'))
     count[character - 'A']++;
     else if((character >= 'a') && (character <= 'z'))
      count[character - 'a']++;
    }

   return count;
  }

 public static void main(String args[])
  {
   EX16_21 frame = new EX16_21();//宣告視窗
   frame.setTitle("EX16_21");//標題
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.pack();//配合
   frame.setVisible(true);//顯示
  }
}