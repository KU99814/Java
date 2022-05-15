//Using resource bundle

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.NumberFormat;

public class EX31_9 extends JFrame
{
 private JComboBox jcboLocale = new JComboBox();//下拉選項
 private ResourceBundle res = ResourceBundle.getBundle("MyResource");//resource
 private JLabel label = new JLabel(res.getString("Hello_World"));//顯示

 private Locale locale = Locale.getDefault();//預設定區

 private Locale locales[] = Calendar.getAvailableLocales();//可選地區

 //初始化選項
 public void initializeCombox()
  {
   for(int i=0;i<locales.length;i++)
    {
     jcboLocale.addItem(locales[i].getDisplayName());
    }
  }

 //根據選項變化顯示
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

   //下拉選單動作
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

   frame.setSize(400,100);//大小
   frame.setTitle("EX31_9");//標題
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉
   frame.setVisible(true);//顯示
  }
}