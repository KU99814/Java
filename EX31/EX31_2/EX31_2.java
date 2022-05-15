//Displaying data and time

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;

public class EX31_2 extends JFrame
{
 //����P�ɶ�
 private JTextField jtfDate = new JTextField(15);
 private JTextField jtfTime = new JTextField(15);

 //��ܮɰϻP�a��
 private JComboBox jcbLocale = new JComboBox();
 private JComboBox jcbTimeZone = new JComboBox();

 //��ܪ�style
 private JComboBox jcbDateStyle = new JComboBox();
 private JComboBox jcbTimeStyle = new JComboBox();

 private TimeZone timeZone = TimeZone.getTimeZone("EST"); //�ɰ�

 //�i��ܮɰϩM�a��
 private Locale[] availableLocales = Locale.getAvailableLocales();
 private String[] availableTimeZones = TimeZone.getAvailableIDs();

 public EX31_2()
  {
   //�������i�s��
   jtfDate.setEditable(false);
   jtfTime.setEditable(false);

   //��l�ƮɰϻP�a�Ͽﶵ
   setAvailableLocales();
   setAvailableTimeZone();

   //��ܮɶ�panel
   JPanel p1 = new JPanel(new FlowLayout());
   p1.add(new JLabel("Date:"));
   p1.add(jtfDate);
   p1.add(new JLabel("Time:"));
   p1.add(jtfTime);

   //��ܮɰϻP�a��panel
   JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   p2.add(new JLabel("Locale:"));
   p2.add(jcbLocale);
   p2.add(new JLabel("Time Zone:"));
   p2.add(jcbTimeZone);

   //��ܦa�Ϩƥ�
   jcbLocale.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     setLocale(availableLocales[jcbLocale.getSelectedIndex()]);
     setDateAndTime();
    }
   });

   //��ܮɰϨƥ�
   jcbTimeZone.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     timeZone = TimeZone.getTimeZone(
         availableTimeZones[jcbTimeZone.getSelectedIndex()]);
     setDateAndTime();
    }
   });

   //��ܤ��style�ƥ�
   jcbDateStyle.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     setDateAndTime();
    }
   });

   //��ܮɶ�style�ƥ�
   jcbTimeStyle.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     setDateAndTime();
    }
   });

   //��l��style�ﶵ
   setStyle(jcbDateStyle);
   setStyle(jcbTimeStyle);

   //���style panel
   JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   p3.add(new JLabel("Date style:"));
   p3.add(jcbDateStyle);
   p3.add(new JLabel("Time style:"));
   p3.add(jcbTimeStyle);

   //�ƪ�
   setLayout(new GridLayout(3,1));
   add(p1);
   add(p2);
   add(p3);

   setDateAndTime();//��ܮɶ��P���
  }

 //��J�a�Ͽﶵ
 private void setAvailableLocales()
  {
   for(int i=0;i<availableLocales.length;i++)
    {
     jcbLocale.addItem(availableLocales[i].getDisplayName() + " "
      +availableLocales[i].toString());
    }
  }

 //��J�ɰϿﶵ
 private void setAvailableTimeZone()
  {
   Arrays.sort(availableTimeZones);
   for(int i=0;i<availableLocales.length;i++)
    {
     jcbTimeZone.addItem(availableTimeZones[i]);
    }
  }

 //�[�Jstyle�ﶵ
 private void setStyle(JComboBox jcb)
  {
   jcb.addItem("FULL");
   jcb.addItem("LONG");
   jcb.addItem("MEDIUM");
   jcb.addItem("SHORT");
  }

 //�]�w����P�ɶ����
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
   frame.setTitle("EX31_2");//���D
   frame.setSize(800,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}