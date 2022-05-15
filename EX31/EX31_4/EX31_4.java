//Finding the available locals and time zone IDs

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EX31_4 extends JFrame
{
 private JTextArea jta = new JTextArea();//��ܤ奻
 
 //��ܮɶ��P�a�ϫ��s
 private JButton jbtLocale = new JButton("All Locales");
 private JButton jbtTimeZone = new JButton("All Time Zones");

 //�i��ܮɰϩM�a��
 private Locale[] availableLocales = Locale.getAvailableLocales();
 private String[] availableTimeZones = TimeZone.getAvailableIDs();

 public EX31_4()
  {
   JScrollPane jsp = new JScrollPane(jta);//����b

   //���spanel
   JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   p2.add(jbtLocale);
   p2.add(jbtTimeZone);

   //�ƪ�
   setLayout(new BorderLayout());
   add(jsp,BorderLayout.CENTER);
   add(p2,BorderLayout.SOUTH);

   //���s�ƥ� �a��
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

   //���s�ƥ� �ɰ�
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
   frame.setTitle("EX31_4");//���D
   frame.setSize(400,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}