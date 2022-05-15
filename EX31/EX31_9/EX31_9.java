//Using resource bundle

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.NumberFormat;

public class EX31_9 extends JFrame
{
 private JComboBox jcboLocale = new JComboBox();//�U�Կﶵ
 private ResourceBundle res = ResourceBundle.getBundle("MyResource");//resource
 private JLabel label = new JLabel(res.getString("Hello_World"));//���

 private Locale locale = Locale.getDefault();//�w�]�w��

 private Locale locales[] = Calendar.getAvailableLocales();//�i��a��

 //��l�ƿﶵ
 public void initializeCombox()
  {
   for(int i=0;i<locales.length;i++)
    {
     jcboLocale.addItem(locales[i].getDisplayName());
    }
  }

 //�ھڿﶵ�ܤ����
 private void updateStrings()
  {
   res = ResourceBundle.getBundle("MyResource",locale);
   label.setText(res.getString("Hello_World"));

   repaint();
  }

 public EX31_9()
  {
   initializeCombox();
   JPanel p1 = new JPanel(new FlowLayout());
   p1.add(jcboLocale);
   p1.add(label);
   
   setLayout(new BorderLayout());
   add(p1,BorderLayout.CENTER);

   //�U�Կ��ʧ@
   jcboLocale.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     locale = locales[jcboLocale.getSelectedIndex()];
     updateStrings();
    }
   });
  }

 public static void main(String args[])
  {
   EX31_9 frame = new EX31_9();//frame

   frame.setSize(400,100);//�j�p
   frame.setTitle("EX31_9");//���D
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����
   frame.setVisible(true);//���
  }
}