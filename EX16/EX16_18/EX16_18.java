//計算字母頻率

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX16_18 extends JFrame
{
 private JTextArea jta; //輸入
 private JButton jbtShowHistogram = new JButton("Show Histogram"); //顯示按鈕
 private Histogram histogram = new Histogram();//長條圖
 
 private JFrame histogramFrame = new JFrame();//顯示長條圖frame
 
 public EX16_18()
  {
   JScrollPane scrollPane = new JScrollPane(jta = new JTextArea());//文本加入滾動條
   scrollPane.setPreferredSize(new Dimension(300,200));

   //文本分行
   jta.setWrapStyleWord(true);
   jta.setLineWrap(true);
   
   //加入component
   add(scrollPane,BorderLayout.CENTER);
   add(jbtShowHistogram,BorderLayout.SOUTH);
   
   //加入按鈕動作 顯示長條圖視窗
   jbtShowHistogram.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int[] count = countLetters();//取得文字分布
     histogram.showHistogram(count);//取得頻率
     histogramFrame.setVisible(true);//顯示視窗
    }
   });

   //整合panel
   histogramFrame.add(histogram);
   histogramFrame.pack();
   histogramFrame.setTitle("Histogram");
  }

 private int[] countLetters() //計算文字出現次數
  {
   int[] count = new int[26];
   
   String text = jta.getText();
   
   for(int i=0;i<text.length();i++)
    {
     char character = text.charAt(i);
     
     //大小寫視為同一
     if((character >= 'A') && (character <= 'Z'))
      count[character - 'A']++;
     else if((character >= 'a') && (character <= 'z'))
      count[character - 'a']++;
    }

   return count;
  }

 public static void main(String args[])
  {
   EX16_18 frame = new EX16_18();//宣告視窗
   frame.setTitle("EX16_18");//標題
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.pack();//調整尺寸
   frame.setVisible(true);//顯示
  }
}