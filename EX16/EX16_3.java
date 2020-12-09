//Lights

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX16_3 extends JFrame
{
 //點集按鈕群 選擇顯示燈號
 private JRadioButton jRed = new JRadioButton("Red");//紅
 private JRadioButton jYellow = new JRadioButton("Yellow");//黃
 private JRadioButton jGreen = new JRadioButton("Green");//綠
 private JRadioButton jAll = new JRadioButton("All");//全部

 public EX16_3()
  {
   final FigurePanel p1 = new FigurePanel();//顯示燈panel
   JPanel p2 = new JPanel(new FlowLayout());//按鈕panel
   
   //加入按鈕
   p2.add(jRed);
   p2.add(jYellow);
   p2.add(jGreen);
   p2.add(jAll);

   //將按鈕歸為一群   
   ButtonGroup group= new ButtonGroup();
   group.add(jRed);
   group.add(jYellow);
   group.add(jGreen);
   group.add(jAll);

   //加入按鈕動作 顯示燈號
   jRed.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p1.setRedLight();
    }
   });

   jYellow.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p1.setYellowLight();
    }
   });

   jGreen.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p1.setGreenLight();
    }
   });

   jAll.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
     p1.setAllLight();
    }
   });

   //第一個字加底線
   jRed.setMnemonic('R');
   jYellow.setMnemonic('Y');
   jGreen.setMnemonic('G');
   jAll.setMnemonic('A');
   
   jRed.setSelected(true);//初始狀態

   setLayout(new BorderLayout());//設定layout

   //加入panel
   add(p1,BorderLayout.CENTER);
   add(p2,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_3 frame = new EX16_3();//宣告視窗
   frame.setTitle("EX16_3");//標題
   frame.setSize(300,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 class FigurePanel extends JPanel
  {
   //顯示狀態變數
   final int RED = 1;
   final int YELLOW = 2;
   final int GREEN = 3;
   final int ALL = 4;
   
   int light = 1;//現在的狀態

   public void setRedLight() //紅燈
    {
     light = RED;
     repaint();
    }
   
   public void setYellowLight() //黃燈
    {
     light = YELLOW;
     repaint();
    }
   
   public void setGreenLight()  //綠燈
    {
     light = GREEN;
     repaint();
    }

   public void setAllLight() //全亮
    {
     light = ALL;
     repaint();
    }

   //繪圖   
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //起始座標
     int x = getWidth()/2;
     int y = 5;

     //三個燈 空格
     g.setColor(Color.black);
     g.drawRect(x-10,y,20,20);
     g.drawRect(x-10,y+20,20,20);
     g.drawRect(x-10,y+40,20,20);
     //根據狀態繪圖   
     switch(light)
      {
       case RED :   g.setColor(Color.red);
                    g.fillRect(x-10,y,20,20);//點亮紅燈
                    break;            
       case YELLOW :g.setColor(Color.yellow);
                    g.fillRect(x-10,y+20,20,20);//點亮黃燈
                    g.setColor(Color.black);
                    g.drawLine(x-10,y+20,x+10,y+20);
                    break;
       case GREEN : g.setColor(Color.green);
                    g.fillRect(x-10,y+40,20,20);//點亮綠燈
                    g.setColor(Color.black);
                    g.drawLine(x-10,y+40,x+10,y+40);
                    break;

       case ALL :   g.setColor(Color.red);
                    g.fillRect(x-10,y,20,20);
                    g.setColor(Color.yellow);
                    g.fillRect(x-10,y+20,20,20);
                    g.setColor(Color.green);
                    g.fillRect(x-10,y+40,20,20);
                    g.setColor(Color.black);
                    g.drawRect(x-10,y,20,20);
                    g.drawRect(x-10,y+20,20,20); break;
      }
     g.setColor(Color.black);
     g.drawRect(x-10,y,20,60); //整體長方形
    }
  }
}      