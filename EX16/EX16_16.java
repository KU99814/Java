//使用Slider調色

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;

public class EX16_16 extends JFrame
{
 //以滑塊調整顏色
 JSlider JRed = new JSlider(JScrollBar.HORIZONTAL,0,255,0);//紅
 JSlider JGreen = new JSlider(JScrollBar.HORIZONTAL,0,255,0);//綠
 JSlider JBlue = new JSlider(JScrollBar.HORIZONTAL,0,255,0);//藍

 MessagePanel p2 = new MessagePanel();//顯示文字panel
 
 public EX16_16()
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
   
   //加入滑動動作
   JRed.addChangeListener(new SetMessageColor());
   JGreen.addChangeListener(new SetMessageColor());
   JBlue.addChangeListener(new SetMessageColor());
   
   //整合panel
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(p3,BorderLayout.SOUTH);
  }
 
 //滑動動作
 class SetMessageColor implements ChangeListener
  {
   public void stateChanged(ChangeEvent e)
    { 
     p2.repaint();
    }
  }

 public static void main(String args[])
  {
   EX16_16 frame = new EX16_16();//宣告視窗
   frame.setTitle("EX16_16");//標題
   frame.setSize(300,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 class MessagePanel extends JPanel  //字幕版面
  {
   
   String message = "";//顯示文字
   boolean centered;//是否置中
   
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
     
     //字型
     FontMetrics fm = g.getFontMetrics();
   
     //從滑塊取得顏色參數
     int R = JRed.getValue();
     int G = JGreen.getValue();
     int B = JBlue.getValue();

     String s = "Red "+R+" Green "+G+" Blue "+B;//顯示文字
     
     //取得文字長寬
     int stringWidth = fm.stringWidth(s);
     int stringAscent = fm.getAscent();

     //設定顏色
     setForeground(new Color(R,G,B));
       
     //文字座標
     int xCoordinate = getWidth() / 2 - stringWidth/2;
     int yCoordinate = getHeight() / 2 + stringAscent/2;
     
     //繪出   
     g.drawString(s,xCoordinate,yCoordinate);
    }
  }
}