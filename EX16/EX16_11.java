//Demonstrating JTextField properties

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_11 extends JFrame
{
 JTextField tf = new JTextField(10);   //框
 JTextField ColumnSize = new JTextField(10); //框長

 //字的輸入位置
 JRadioButton jLeft = new JRadioButton("Left");  //左
 JRadioButton jCenter = new JRadioButton("Center"); //中
 JRadioButton jRight = new JRadioButton("Right"); //右

 public EX16_11()
  {
   JPanel p1 = new JPanel();//輸入文字panel

   JPanel p2 = new JPanel(new GridLayout(1,2));
   JPanel p2_1 = new JPanel();//調整位置panel
   JPanel p2_2 = new JPanel();//大小panel
   
   //加入component
   p1.add(new JLabel("Text Field"));
   p1.add(tf);

   Border lineBorder = new LineBorder(Color.BLACK,2);//宣告框線

   //將點擊按鈕設為一群
   ButtonGroup group = new ButtonGroup();
   group.add(jLeft);
   group.add(jCenter);
   group.add(jRight);

   //加入按鈕
   p2_1.add(jLeft);
   p2_1.add(jCenter);
   p2_1.add(jRight);
   
   //設定框線
   p2_1.setBorder(lineBorder);
   p2_1.setBorder(new TitledBorder("Horizontal Alignment"));

   //加入輸入欄位
   p2_2.add(new JLabel("Column Size "));
   p2_2.add(ColumnSize);

   p2_2.setBorder(lineBorder);

   //左
   jLeft.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     tf.setHorizontalAlignment(SwingConstants.LEFT);
    }
   });

   //中
   jCenter.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     tf.setHorizontalAlignment(SwingConstants.CENTER);
    }
   });

   //右
   jRight.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     tf.setHorizontalAlignment(SwingConstants.RIGHT);
    }
   });

   //加入動作 調整大小
   ColumnSize.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int size = Integer.parseInt(ColumnSize.getText());
     tf.setColumns(size);
     pack();//重新排版
     System.out.println(tf.getColumns());
    }
   });

   //加入panel
   p2.add(p2_1);
   p2.add(p2_2);
   
   //排版
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
  }

 public static void main(String args[])
  {
   EX16_11 frame = new EX16_11();//宣告視窗
   frame.setTitle("EX16_11");//標題
   frame.setSize(400,150);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}