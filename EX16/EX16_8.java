import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_8 extends JFrame
{
 GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();//Font class
 String[] FontName = e.getAvailableFontFamilyNames(); //字型
 JComboBox jFN = new JComboBox(FontName); //選擇字型

 String[] fontSize = new String[100];//字型大小陣列
 JComboBox jFS = new JComboBox(); //選擇大小 1~100

 public MessagePanel p2 = new MessagePanel(); //字幕

 //勾選按鈕 
 JCheckBox jchkCentered = new JCheckBox("Centered");//置中
 JCheckBox jchkBold = new JCheckBox("Bold");//加粗
 JCheckBox jchkItalic = new JCheckBox("Italic");//斜體

 public EX16_8()
  {
   JPanel p1 = new JPanel(new FlowLayout()); //操作panel
   JPanel p1_1 = new JPanel(new FlowLayout()); //字型版面
   JPanel p1_2 = new JPanel(new FlowLayout()); //大小版面

   //將定義字型大小陣列並加入下拉選單
   for(int i=0;i<100;i++)
    fontSize[i] = i+1+"";   
   jFS = new JComboBox(fontSize);

   Border lineBorder = new LineBorder(Color.BLACK,2);//宣告框線
   
   //設置框線
   p1.setBorder(lineBorder);
   p1_1.setBorder(lineBorder);
   p1_2.setBorder(lineBorder);
   
   //將component加入panel
   p1_1.add(new JLabel("Font Name "));
   p1_1.add(jFN);
   p1_2.add(new JLabel("Font Size "));
   p1_2.add(jFS);

   //加入選單動作 選擇字型
   jFN.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     setNewFont(); //改變
    }
   });

   jFS.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent e) {
     setNewFont();
    }
   });
   
   //排好操作panel
   p1.add(p1_1);
   p1.add(p1_2);

   //第一個字加底線
   jchkCentered.setMnemonic('C');
   jchkBold.setMnemonic('B');
   jchkItalic.setMnemonic('I');
  
   //勾選panel
   JPanel p3 = new JPanel(new FlowLayout());
   p3.add(jchkCentered);
   p3.add(jchkBold);
   p3.add(jchkItalic);
   
   //加入勾選動作
   jchkCentered.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     p2.setCentered(jchkCentered.isSelected());
    }
   });
   
   jchkBold.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     setNewFont();
    }
   });

   jchkItalic.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     setNewFont();
    }
   });

   jFS.setSelectedIndex(12);

   //設定layout 加入panel
   setLayout(new GridLayout(3,1));
   add(p1);
   add(p2);
   add(p3);
  }

 public static void main(String args[])
  {
   EX16_8 frame = new EX16_8();//顯示視窗
   frame.setTitle("EX16_8");//標題
   frame.setSize(500,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 private void setNewFont()  //改變文字
  {
   //字體造型
   int fontStyle = Font.PLAIN;
   fontStyle += (jchkBold.isSelected() ? Font.BOLD : Font.PLAIN);
   fontStyle += (jchkItalic.isSelected() ? Font.ITALIC : Font.PLAIN);

   int index1 = jFN.getSelectedIndex(); //字型
   int index2 = jFS.getSelectedIndex(); //大小
   p2.setFont(new Font(FontName[index1],fontStyle,index2+1));
  }

 class MessagePanel extends JPanel  //字幕版面
  {
   //文字初始座標
   int xCoordinate = 20;
   int yCoordinate = 20;

   String message = "welcome to Java";//顯示文字
   boolean centered;//判斷是否置中

   //建構子   
   public MessagePanel()
    {}

   public void setCentered(boolean centered) //是否置中
    {
     this.centered = centered;
     repaint();
    }

   //繪圖   
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     FontMetrics fm = g.getFontMetrics();
       
     int stringWidth = fm.stringWidth(message);
     int stringAscent = fm.getAscent();
     
     //判斷是否置中 調整座標
     if(centered)
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