//��������

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class WorldClockControl extends JFrame
{
 //�a�ϻP�ɰ� (�k�� �w�� ���� �饻)
 private Locale[] availableLocales = {Locale.FRENCH,Locale.GERMAN,
                                      Locale.CHINESE,Locale.JAPANESE};
 private String[] availableTimeZones = {"Europe/Paris","Europe/Berlin",
                                        "Asia/Taipei","Asia/Tokyo"};

 //��ܪ��U�Ԧ����
 private JComboBox jcbLocales = new JComboBox();
 private JComboBox jcbTimeZones = new JComboBox();
 
 private WorldClock clock = new WorldClock();//����

 //constructor 
 public WorldClockControl()
  {
   //���o�ɰϻP�a��
   setAvailableLocales();
   setAvailableTimeZones();

   //�]�w�����ɰϻP�a��   
   clock.setLocale(availableLocales[jcbLocales.getSelectedIndex()]);
   clock.setTimeZone(TimeZone.getTimeZone(
    availableTimeZones[jcbTimeZones.getSelectedIndex()]));
   
   //�a�ϭ��O
   JPanel panel1 = new JPanel();
   panel1.setLayout(new GridLayout(1,2));
   panel1.add(new JLabel("Locale"));
   panel1.add(jcbLocales,BorderLayout.CENTER);
   

   //�ɰϭ��O
   JPanel panel2 = new JPanel();
   panel2.setLayout(new GridLayout(1,2));
   panel2.add(new JLabel("Time Zone"));
   panel2.add(jcbTimeZones,BorderLayout.CENTER);

   //�ާ@���O
   JPanel panel3 = new JPanel();
   panel3.setLayout(new BorderLayout());
   panel3.add(panel1, BorderLayout.NORTH);
   panel3.add(panel2,BorderLayout.CENTER);

   //��X   
   setLayout(new BorderLayout());
   add(panel3,BorderLayout.NORTH);
   add(clock,BorderLayout.CENTER);

   //�a�ϰʧ@
   jcbLocales.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     clock.setLocale(availableLocales[jcbLocales.getSelectedIndex()]);
    }
   });
   
   //�ɰϰʧ@
   jcbTimeZones.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     clock.setTimeZone(TimeZone.getTimeZone(
      availableTimeZones[jcbTimeZones.getSelectedIndex()]));
    }
   });
  }

 //�]�w�a��
 private void setAvailableLocales()
  {
   for(int i=0;i<availableLocales.length;i++)
    {
     jcbLocales.addItem(availableLocales[i].getDisplayName()+" "
      +availableLocales[i].toString());
    }
  }

 //�]�w�ɰ� 
 private void setAvailableTimeZones()
  {
   Arrays.sort(availableTimeZones);
   for(int i=0;i<availableTimeZones.length;i++)
    {
     jcbTimeZones.addItem(availableTimeZones[i]);
    }
  }
}