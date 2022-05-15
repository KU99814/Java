//時鐘控制

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class WorldClockControl extends JFrame
{
 //地區與時區 (法國 德國 中國 日本)
 private Locale[] availableLocales = {Locale.FRENCH,Locale.GERMAN,
                                      Locale.CHINESE,Locale.JAPANESE};
 private String[] availableTimeZones = {"Europe/Paris","Europe/Berlin",
                                        "Asia/Taipei","Asia/Tokyo"};

 //選擇的下拉式選單
 private JComboBox jcbLocales = new JComboBox();
 private JComboBox jcbTimeZones = new JComboBox();
 
 private WorldClock clock = new WorldClock();//時鐘

 //constructor 
 public WorldClockControl()
  {
   //取得時區與地區
   setAvailableLocales();
   setAvailableTimeZones();

   //設定時鐘時區與地區   
   clock.setLocale(availableLocales[jcbLocales.getSelectedIndex()]);
   clock.setTimeZone(TimeZone.getTimeZone(
    availableTimeZones[jcbTimeZones.getSelectedIndex()]));
   
   //地區面板
   JPanel panel1 = new JPanel();
   panel1.setLayout(new GridLayout(1,2));
   panel1.add(new JLabel("Locale"));
   panel1.add(jcbLocales,BorderLayout.CENTER);
   

   //時區面板
   JPanel panel2 = new JPanel();
   panel2.setLayout(new GridLayout(1,2));
   panel2.add(new JLabel("Time Zone"));
   panel2.add(jcbTimeZones,BorderLayout.CENTER);

   //操作面板
   JPanel panel3 = new JPanel();
   panel3.setLayout(new BorderLayout());
   panel3.add(panel1, BorderLayout.NORTH);
   panel3.add(panel2,BorderLayout.CENTER);

   //整合   
   setLayout(new BorderLayout());
   add(panel3,BorderLayout.NORTH);
   add(clock,BorderLayout.CENTER);

   //地區動作
   jcbLocales.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     clock.setLocale(availableLocales[jcbLocales.getSelectedIndex()]);
    }
   });
   
   //時區動作
   jcbTimeZones.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     clock.setTimeZone(TimeZone.getTimeZone(
      availableTimeZones[jcbTimeZones.getSelectedIndex()]));
    }
   });
  }

 //設定地區
 private void setAvailableLocales()
  {
   for(int i=0;i<availableLocales.length;i++)
    {
     jcbLocales.addItem(availableLocales[i].getDisplayName()+" "
      +availableLocales[i].toString());
    }
  }

 //設定時區 
 private void setAvailableTimeZones()
  {
   Arrays.sort(availableTimeZones);
   for(int i=0;i<availableTimeZones.length;i++)
    {
     jcbTimeZones.addItem(availableTimeZones[i]);
    }
  }
}