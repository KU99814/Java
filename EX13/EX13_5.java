//Displaying labels

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class EX13_5 extends JFrame
{
 public EX13_5()
  {
   JPanel p1 = new JPanel();//第一行文字
   p1.add(new JLabel("Departmant of Computer Science"));
   
   JPanel p2 = new JPanel();//第二行文字
   p2.add(new JLabel("School of Computing"));

   JPanel p3 = new JPanel();//第三行文字
   p3.add(new JLabel("Armstrong Atlantic State University"));

   JPanel p4 = new JPanel();//第四行文字
   p4.add(new JLabel("Tel:(912)921-6440"));

   Border lineBorder = new LineBorder(Color.BLACK,2);//宣告邊框

   //設定邊框   
   p1.setBorder(lineBorder);
   p2.setBorder(lineBorder);
   p3.setBorder(lineBorder);
   p4.setBorder(lineBorder);

   //設定layout
   setLayout(new GridLayout(4,1));

   //加入panel
   add(p1);
   add(p2);
   add(p3);
   add(p4);
  }

 public static void main(String args[])
  {
   JFrame frame = new EX13_5();//宣告視窗
   frame.setTitle("EX13_5");//標題
   frame.setSize(300,150); //大小
   frame.setLocationRelativeTo(null);//位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}