//Finding the available locals and time zone IDs

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EX31_4 extends JFrame
{
 private JTextArea jta = new JTextArea();//顯示文本
 
 //顯示時間與地區按鈕
 private JButton jbtLocale = new JButton("All Locales");
 private JButton jbtTimeZone = new JButton("All Time Zones");

 //可顯示時區和地區
 private Locale[] availableLocales = Locale.getAvailableLocales();
 private String[] availableTimeZones = TimeZone.getAvailableIDs();

 public EX31_4()
  {
   JScrollPane jsp = new JScrollPane(jta);//放卷軸

   //按鈕panel
   JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   p2.add(jbtLocale);
   p2.add(jbtTimeZone);

   //排版
   setLayout(new BorderLayout());
   add(jsp,BorderLayout.CENTER);
   add(p2,BorderLayout.SOUTH);

   //按鈕事件 地區
   jbtLocale.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     jta.setText("");
    
     StringBuilder str = new StringBuilder();
     for(int i=0;i<availableLocales.length;i++)
      {
       str.append(availableLocales[i]+"\n");
      }
     jta.setText(str.toString());
    }
   });

   //按鈕事件 時區
   jbtTimeZone.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     jta.setText("");
    
     StringBuilder str = new StringBuilder();
     for(int i=0;i<availableTimeZones.length;i++)
      {
       str.append(availableTimeZones[i]+"\n");
      }
     jta.setText(str.toString());
    }
   });
  }

 public static void main(String args[])
  {
   EX31_4 frame = new EX31_4();//frame
   frame.setTitle("EX31_4");//標題
   frame.setSize(400,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}