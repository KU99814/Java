//using Icon

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class EX13_6 extends JFrame
{
 //讀取圖片
 private ImageIcon i1 = new ImageIcon("flag4.gif");
 private ImageIcon i2 = new ImageIcon("flag5.gif");
 private ImageIcon i3 = new ImageIcon("flag6.gif");
 private ImageIcon i4 = new ImageIcon("flag9.gif");
   
 public EX13_6()
  {
   Border lineBorder = new LineBorder(Color.BLACK,2);//宣告邊框

   //宣告放置圖片  
   JLabel l1 = new JLabel(i1);
   JLabel l2 = new JLabel(i2);
   JLabel l3 = new JLabel(i3);
   JLabel l4 = new JLabel(i4);

   //設定邊框
   l1.setBorder(lineBorder);
   l2.setBorder(lineBorder);
   l3.setBorder(lineBorder);
   l4.setBorder(lineBorder);

   //設定版面
   setLayout(new GridLayout(2,2,5,5));
   
   //加入panel
   add(l1);
   add(l2);
   add(l3);
   add(l4);
  }

  public static void main(String args[])
  {
   JFrame frame = new EX13_6();//宣告視窗
   frame.setTitle("EX13_6");//宣告標題
   frame.setSize(400,400); //宣告大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}