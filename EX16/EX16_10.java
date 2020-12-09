//Adding new features into EX16_1

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class EX16_10 extends JFrame
{
 //點擊按鈕 選擇顏色
 private JRadioButton jRed = new JRadioButton("Red");//紅
 private JRadioButton jYellow = new JRadioButton("Yellow");//黃
 private JRadioButton jWhite = new JRadioButton("White");//白
 private JRadioButton jGray = new JRadioButton("Gray");//灰
 private JRadioButton jGreen = new JRadioButton("Green");//綠

 //下拉選單 背景顏色
 private JComboBox selectFore = new JComboBox(new Object[]{"black","blue"});

 //勾選按鈕
 JCheckBox jchkCentered = new JCheckBox("Centered");//置中
 JCheckBox jchkBold = new JCheckBox("Bold");//加粗
 JCheckBox jchkItalic = new JCheckBox("Italic");//斜體

 JTextField jtf = new JTextField(6);//輸入文字

 MessagePanel p2 = new MessagePanel(); //顯示文字

 public EX16_10()
  {
   setLayout(new BorderLayout());//設定layout

   Border lineBorder = new LineBorder(Color.BLACK,2);//宣告框線

   //操作panel
   JPanel p1 = new JPanel(new FlowLayout());
   p1.setBorder(lineBorder);//設定框線
   p1.setBorder(new TitledBorder("Select the Options"));

   //加入component
   p1.add(new JLabel("Select a foreground color"));
   p1.add(selectFore);
   p1.add(new JLabel("Select a background color "));

   //加入按鈕
   p1.add(jRed);
   p1.add(jYellow);
   p1.add(jWhite);
   p1.add(jGray);
   p1.add(jGreen);
   p1.add(jchkCentered);
   p1.add(jchkBold);
   p1.add(jchkItalic);

   //將點擊按鈕歸為一群
   ButtonGroup group1 = new ButtonGroup();
   group1.add(jRed);
   group1.add(jYellow);
   group1.add(jWhite);
   group1.add(jGray);
   group1.add(jGreen);

   JPanel p3 = new JPanel();//輸入文字panel

   //加入component
   p3.add(new JLabel("Enter a new message"));
   p3.add(jtf);

   //加入按鈕動作 設定顏色
   //紅色
   jRed.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.red);
    }
   });

   //黃色
   jYellow.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.yellow);
    }
   });

   //白色
   jWhite.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.white);
    }
   });

   //灰色
   jGray.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.gray);
    }
   });

   //綠色
   jGreen.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.green);
    }
   });
   
   //加入按鈕動作 設定字體
   //置中
   jchkCentered.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     p2.setCentered(jchkCentered.isSelected());
    }
   });
   
   //加粗
   jchkBold.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     setNewFont();
    }
   });

   //斜體
   jchkItalic.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     setNewFont();
    }
   });

   //選擇forebround
   selectFore.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     int index = selectFore.getSelectedIndex();
     if(index == 0)
      p2.setForeground(Color.black);
     else if(index == 1)
      p2.setForeground(Color.blue);
    }
   });   

   //加入動作 輸入文字並顯示
   jtf.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     p2.setMessage(jtf.getText());
     jtf.requestFocusInWindow();
    }
   });

   //將所有panel加入
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(p3,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_10 frame = new EX16_10();//宣告視窗
   frame.setTitle("EX16_10");//標題
   frame.setSize(1000,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 private void setNewFont()  //改變文字
  {
   int fontStyle = Font.PLAIN;
   fontStyle += (jchkBold.isSelected() ? Font.BOLD : Font.PLAIN);
   fontStyle += (jchkItalic.isSelected() ? Font.ITALIC : Font.PLAIN);

   Font font = p2.getFont();
   p2.setFont(new Font(font.getName(),fontStyle,font.getSize()));
  }

 class MessagePanel extends JPanel  //字幕版面
  {
   //文字座標
   int xCoordinate = 20;
   int yCoordinate = 20;

   String message = "";//顯示文字
   boolean centered;//是否置中
   
   //建構子
   public MessagePanel()
    {}

   public void setMessage(String message)
    {
     this.message = message;
     repaint();
    } 

   public void setCentered(boolean centered) //是否置中
    {
     this.centered = centered;
     repaint();
    }
   
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     FontMetrics fm = g.getFontMetrics();
     
     //找出字寬和長
     int stringWidth = fm.stringWidth(message);
     int stringAscent = fm.getAscent();     

     if(centered)//依是否置中改變位置
      {
       xCoordinate = getWidth() / 2 - stringWidth/2;
       yCoordinate = getHeight() / 2 + stringAscent/2;
      }

     else
      {
       xCoordinate = 20;
       yCoordinate = 20;
      }
     
     g.drawString(message,xCoordinate,yCoordinate);//顯示文字
    }
  }
}
   