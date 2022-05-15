//Displaying data and time

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;

public class EX31_2 extends JFrame
{
 //日期與時間
 private JTextField jtfDate = new JTextField(15);
 private JTextField jtfTime = new JTextField(15);

 //選擇時區與地區
 private JComboBox jcbLocale = new JComboBox();
 private JComboBox jcbTimeZone = new JComboBox();

 //顯示的style
 private JComboBox jcbDateStyle = new JComboBox();
 private JComboBox jcbTimeStyle = new JComboBox();

 private TimeZone timeZone = TimeZone.getTimeZone("EST"); //時區

 //可顯示時區和地區
 private Locale[] availableLocales = Locale.getAvailableLocales();
 private String[] availableTimeZones = TimeZone.getAvailableIDs();

 public EX31_2()
  {
   //視為不可編輯
   jtfDate.setEditable(false);
   jtfTime.setEditable(false);

   //初始化時區與地區選項
   setAvailableLocales();
   setAvailableTimeZone();

   //顯示時間panel
   JPanel p1 = new JPanel(new FlowLayout());
   p1.add(new JLabel("Date:"));
   p1.add(jtfDate);
   p1.add(new JLabel("Time:"));
   p1.add(jtfTime);

   //選擇時區與地區panel
   JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   p2.add(new JLabel("Locale:"));
   p2.add(jcbLocale);
   p2.add(new JLabel("Time Zone:"));
   p2.add(jcbTimeZone);

   //選擇地區事件
   jcbLocale.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     setLocale(availableLocales[jcbLocale.getSelectedIndex()]);
     setDateAndTime();
    }
   });

   //選擇時區事件
   jcbTimeZone.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     timeZone = TimeZone.getTimeZone(
         availableTimeZones[jcbTimeZone.getSelectedIndex()]);
     setDateAndTime();
    }
   });

   //選擇日期style事件
   jcbDateStyle.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     setDateAndTime();
    }
   });

   //選擇時間style事件
   jcbTimeStyle.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     setDateAndTime();
    }
   });

   //初始化style選項
   setStyle(jcbDateStyle);
   setStyle(jcbTimeStyle);

   //選擇style panel
   JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   p3.add(new JLabel("Date style:"));
   p3.add(jcbDateStyle);
   p3.add(new JLabel("Time style:"));
   p3.add(jcbTimeStyle);

   //排版
   setLayout(new GridLayout(3,1));
   add(p1);
   add(p2);
   add(p3);

   setDateAndTime();//顯示時間與日期
  }

 //放入地區選項
 private void setAvailableLocales()
  {
   for(int i=0;i<availableLocales.length;i++)
    {
     jcbLocale.addItem(availableLocales[i].getDisplayName() + " "
      +availableLocales[i].toString());
    }
  }

 //放入時區選項
 private void setAvailableTimeZone()
  {
   Arrays.sort(availableTimeZones);
   for(int i=0;i<availableLocales.length;i++)
    {
     jcbTimeZone.addItem(availableTimeZones[i]);
    }
  }

 //加入style選項
 private void setStyle(JComboBox jcb)
  {
   jcb.addItem("FULL");
   jcb.addItem("LONG");
   jcb.addItem("MEDIUM");
   jcb.addItem("SHORT");
  }

 //設定日期與時間顯示
 private void setDateAndTime()
  {
   Calendar calendar = new GregorianCalendar(timeZone,getLocale());

   int dateStyle = 0;
   int timeStyle = 0;

   switch(jcbDateStyle.getSelectedIndex())
    {
     case 0:dateStyle = DateFormat.FULL;
            break;
     case 1:dateStyle = DateFormat.LONG;
            break;
     case 2:dateStyle = DateFormat.MEDIUM;
            break;
     case 3:dateStyle = DateFormat.SHORT;
            break;
    }

   switch(jcbTimeStyle.getSelectedIndex())
    {
     case 0:timeStyle = DateFormat.FULL;
            break;
     case 1:timeStyle = DateFormat.LONG;
            break;
     case 2:timeStyle = DateFormat.MEDIUM;
            break;
     case 3:timeStyle = DateFormat.SHORT;
            break;
    }

   DateFormat dateStyleFormat = DateFormat.getDateInstance(dateStyle);
   DateFormat timeStyleFormat = DateFormat.getTimeInstance(timeStyle);

   jtfDate.setText(dateStyleFormat.format(calendar.getTime()));
   jtfTime.setText(timeStyleFormat.format(calendar.getTime()));
  }

 public static void main(String args[])
  {
   EX31_2 frame = new EX31_2();//frame
   frame.setTitle("EX31_2");//標題
   frame.setSize(800,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}