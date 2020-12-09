import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class EX16_9 extends JFrame
{
 ImageIcon grapes = new ImageIcon("grapes.gif");//顯示圖片

 JButton jbt = new JButton("Grapes",grapes);//顯示圖片的按鈕

 //圖片位置選單
 JComboBox JHorizontal = new JComboBox(new Object[]{"LEADING","LEFT","CENTER","RIGHT",
                                                    "TRAILING"});//水平位置選單

 JComboBox JVertical = new JComboBox(new Object[]{"TOP","CENTER","BOTTOM"});//垂直位置選單

 //文字位置選單
 JComboBox JHorizontalText = new JComboBox(new Object[]{"LEADING","LEFT","CENTER","RIGHT",
                                                    "TRAILING"});//水平位置選單

 JComboBox JVerticalText = new JComboBox(new Object[]{"TOP","CENTER","BOTTOM"});//垂直位置選單

 public EX16_9()
  {
   //排版
   JPanel p1 = new JPanel(new BorderLayout());
   p1.add(jbt,BorderLayout.CENTER);
   
   Border lineBorder = new LineBorder(Color.BLACK,2);//宣告框線

   JPanel p2 = new JPanel(new GridLayout(1,2));  //位置版面

   JPanel p2_1 = new JPanel(new GridLayout(1,2)); //圖片位置

   JPanel p2_1_1 = new JPanel(new GridLayout(2,1)); //文字
   JPanel p2_1_2 = new JPanel(new GridLayout(2,1)); //選單

   JPanel p2_2 = new JPanel(new GridLayout(1,2));  //文字位置
   JPanel p2_2_1 = new JPanel(new GridLayout(2,1)); //文字
   JPanel p2_2_2 = new JPanel(new GridLayout(2,1)); //選單

   p2.setBorder(lineBorder); //設定框線
   p2_1.setBorder(lineBorder);
   p2_1.setBorder(new TitledBorder("Horizontal Alignment"));
   
   p2_1_1.setBorder(lineBorder);
   p2_1_2.setBorder(lineBorder);

   //加入component
   p2_1_1.add(new JLabel("Horizontal"));
   p2_1_1.add(new JLabel("Vertical"));
   
   //選單
   p2_1_2.add(JHorizontal);
   p2_1_2.add(JVertical);
   
   p2_1.add(p2_1_1);
   p2_1.add(p2_1_2);

   //文字位置版面
   p2_2.setBorder(lineBorder);
   p2_2.setBorder(new TitledBorder("Text Position"));
   
   p2_2_1.setBorder(lineBorder);
   p2_2_2.setBorder(lineBorder);

   //加入component
   p2_2_1.add(new JLabel("Horizontal"));
   p2_2_1.add(new JLabel("Vertical"));

   p2_2_2.add(JHorizontalText);
   p2_2_2.add(JVerticalText);
   
   p2_2.add(p2_2_1);
   p2_2.add(p2_2_2);

   //彙整
   p2.add(p2_1);
   p2.add(p2_2);
   
   setLayout(new GridLayout(2,1));
   add(p1);
   add(p2);
   
   //加入選單動作 調整圖片水平位置
   JHorizontal.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     int index = JHorizontal.getSelectedIndex();
     switch(index) {
      case 0: jbt.setHorizontalAlignment(SwingConstants.LEADING);
              break;
      case 1: jbt.setHorizontalAlignment(SwingConstants.LEFT);
              break;
      case 2: jbt.setHorizontalAlignment(SwingConstants.CENTER);
              break;
      case 3: jbt.setHorizontalAlignment(SwingConstants.RIGHT);
              break;
      case 4: jbt.setHorizontalAlignment(SwingConstants.TRAILING);
              break;
     }
    } 
   });

   //調整圖片垂直位置
   JVertical.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     int index = JVertical.getSelectedIndex();
     
     switch(index) {
      case 0: jbt.setVerticalAlignment(SwingConstants.TOP);
              break;
      case 1: jbt.setVerticalAlignment(SwingConstants.CENTER);
              break;
      case 2: jbt.setVerticalAlignment(SwingConstants.BOTTOM);
              break;
     }
    }
   });

   //調整文字水平位置
   JHorizontalText.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     int index = JHorizontalText.getSelectedIndex();
     switch(index) {
      case 0: jbt.setHorizontalTextPosition(SwingConstants.LEADING);
              break;
      case 1: jbt.setHorizontalTextPosition(SwingConstants.LEFT);
              break;
      case 2: jbt.setHorizontalTextPosition(SwingConstants.CENTER);
              break;
      case 3: jbt.setHorizontalTextPosition(SwingConstants.RIGHT);
              break;
      case 4: jbt.setHorizontalTextPosition(SwingConstants.TRAILING);
              break;
     }
    }
   });

   //調整文字垂直位置
   JVerticalText.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     int index = JVerticalText.getSelectedIndex();
     switch(index) {
      case 0: jbt.setVerticalTextPosition(SwingConstants.TOP);
              break;
      case 1: jbt.setVerticalTextPosition(SwingConstants.CENTER);
              break;
      case 2: jbt.setVerticalTextPosition(SwingConstants.BOTTOM);
              break;
     }
    }
   });
  }

 public static void main(String args[])
  {
   EX16_9 frame = new EX16_9();//宣告視窗
   frame.setTitle("EX16_9");//標題
   frame.setSize(400,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}