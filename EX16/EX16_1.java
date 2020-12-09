//Using two radio button groups

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX16_1 extends JFrame
{
 //點選按鈕集 選擇顏色
 private JRadioButton jRed = new JRadioButton("Red");//紅
 private JRadioButton jYellow = new JRadioButton("Yellow");//黃
 private JRadioButton jWhite = new JRadioButton("White");//白
 private JRadioButton jGray = new JRadioButton("Gray");//灰
 private JRadioButton jGreen = new JRadioButton("Green");//綠

 //點選按鈕集 選擇形狀
 private JRadioButton jRect = new JRadioButton("Rectangle");//長方形
 private JRadioButton jOval = new JRadioButton("Oval"); //圓形

 public EX16_1()
  {
   setLayout(new BorderLayout());//設定layout

   JPanel p1 = new JPanel(); //radio panel
   final GraphicsPanel p2 = new GraphicsPanel(); //graphic panel
   JPanel p3 = new JPanel(); // geometry panel

   //加入顏色鈕
   p1.add(jRed);
   p1.add(jYellow);
   p1.add(jWhite);
   p1.add(jGray);
   p1.add(jGreen);

   //將顏色按鈕歸為一集
   ButtonGroup group1 = new ButtonGroup();
   group1.add(jRed);
   group1.add(jYellow);
   group1.add(jWhite);
   group1.add(jGray);
   group1.add(jGreen);

   //每個按鈕加入動作 點選到改變顏色
   jRed.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.red);
    }
   });

   jYellow.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.yellow);
    }
   });

   jWhite.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.white);
    }
   });

   jGray.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.gray);
    }
   });

   jGreen.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setBackground(Color.green);
    }
   });

   //將形狀按鈕加入panel
   p3.add(jRect);
   p3.add(jOval);

   //將按鈕歸為一集
   ButtonGroup group2 = new ButtonGroup();
   group2.add(jRect);
   group2.add(jOval);

   //形狀按鈕加入動作
   jRect.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setPaint(true);
    }
   });

   jOval.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p2.setPaint(false);
    }
   });

   //設定初始狀態
   jRed.setSelected(true);
   p2.setBackground(Color.red);
   jRect.setSelected(true);
   p2.setPaint(true);

   //將各個panel加入frame
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(p3,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_1 frame = new EX16_1();//宣告視窗
   frame.setTitle("EX16_1");//標題
   frame.setSize(500,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //繪圖panel
 class GraphicsPanel extends JPanel
  {
   boolean thePaint = false;//形狀判斷
   
   //設定形狀
   public void setPaint(boolean thePaint)
    {
     this.thePaint = thePaint;
     repaint();
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //決定長寬
     int w = (int)(getWidth()*0.8);
     int h = (int)(getHeight()*0.8);

     //根據thePaint判斷該繪哪種形狀
     if(thePaint)
      g.drawRect(getWidth()/2-w/2,getHeight()/2-h/2,w,h);
     else
      g.drawOval(getWidth()/2-h/2,getHeight()/2-h/2,h/2,h/2);
    }
  }
}
   