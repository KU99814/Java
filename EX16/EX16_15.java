import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_15 extends JFrame
{
 //宣告滾動條以調整顏色
 JScrollBar JRed = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);//紅
 JScrollBar JGreen = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);//綠
 JScrollBar JBlue = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255);//藍

 MessagePanel p2 = new MessagePanel();//顯示文字panel
 
 public EX16_15()
  {
   //標題panel
   JPanel p1 = new JPanel();
   p1.add(new JLabel("Show Colors"));
   
   //操作panel
   JPanel p3 = new JPanel(new GridLayout(3,2));
   
   //宣告並設定框線
   Border line = new LineBorder(Color.BLACK,2);
   p3.setBorder(line);
   p3.setBorder(new TitledBorder("Choose colors"));
   
   //加入component
   p3.add(new JLabel("Red"));
   p3.add(JRed);
   p3.add(new JLabel("Green"));
   p3.add(JGreen);
   p3.add(new JLabel("Blue"));
   p3.add(JBlue);

   
   //加入動作 改變顏色變數
   JRed.addAdjustmentListener(new SetMessageColor());
   JGreen.addAdjustmentListener(new SetMessageColor());
   JBlue.addAdjustmentListener(new SetMessageColor());
   
   //整合版面
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(p3,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_15 frame = new EX16_15();//宣告視窗
   frame.setTitle("EX16_15");//標題
   frame.setSize(300,400);//大小
   frame.setLocationRelativeTo(null);//相關位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //滾動條動作
 class SetMessageColor implements AdjustmentListener
  {
   public void adjustmentValueChanged(AdjustmentEvent e)
    { 
     p2.repaint();//重繪
    }
  }

 class MessagePanel extends JPanel  //字幕版面
  {
   
   String message = "";//顯示文字
   boolean centered;  //是否置中
   
   //建構子
   public MessagePanel()
    {}

   //設定文字
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
   
   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //設定字型
     FontMetrics fm = g.getFontMetrics();
   
     //從滾動條取得顏色參數
     int R = JRed.getValue();
     int G = JGreen.getValue();
     int B = JBlue.getValue();

     String s = "Red "+R+" Green "+G+" Blue "+B;//顯示的文字
       
     int stringWidth = fm.stringWidth(s);
     int stringAscent = fm.getAscent();

     
     setForeground(new Color(R,G,B));//背景顏色
       
     int xCoordinate = getWidth() / 2 - stringWidth/2;
     int yCoordinate = getHeight() / 2 + stringAscent/2;
     
     //繪出文字   
     g.drawString(s,xCoordinate,yCoordinate);
    }
  }
}