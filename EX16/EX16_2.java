//Selecting geometrics figures

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class EX16_2 extends JFrame
{
 //點擊按鈕群 選擇形狀
 private JRadioButton jLine = new JRadioButton("Line");//線
 private JRadioButton jRect = new JRadioButton("Rectangle");//長方形
 private JRadioButton jOval = new JRadioButton("Oval");//圓形

 //選取按鈕
 private JCheckBox jFill = new JCheckBox("Filled");//是否填滿

 public EX16_2()
  {
   final FigurePanel p1 = new FigurePanel();//繪圖panel
   p1.setBorder(new LineBorder(Color.BLACK,1));//邊框

   JPanel p2 = new JPanel(new FlowLayout());//按鈕panel

   //加入按鈕
   p2.add(jLine);
   p2.add(jRect);
   p2.add(jOval);
   p2.add(jFill);

   //將選擇按鈕歸為一群
   ButtonGroup group = new ButtonGroup();
   group.add(jLine);
   group.add(jRect);
   group.add(jOval);

   //選擇按鈕加入動作 繪出指定圖形
   jLine.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     p1.selectGraphic(1);
    }
   });

   jRect.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     p1.selectGraphic(2);
    }
   });

   jOval.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     p1.selectGraphic(3);
    }
   });

   //加入動作 勾選即填滿
   jFill.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     p1.setFill(jFill.isSelected());
    }
   });
  
   setLayout(new BorderLayout(10,10));//設定layout

   //加入panel
   add(p1,BorderLayout.CENTER);
   add(p2,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_2 frame = new EX16_2();//宣告視窗
   frame.setTitle("EX16_2");//標題
   frame.setSize(500,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 class FigurePanel extends JPanel
  {
   //狀態變數 決定要繪哪種圖
   final int LINE = 1;//線
   final int RECT = 2;//長方形
   final int OVAL = 3;//圓

   int select = 1;//現在狀態
   boolean fill;//是否填滿

   public void selectGraphic(int select) //選擇圖片
    {
     this.select = select;
     repaint();
    }
   
   public void setFill(boolean fill)  //是否填滿
    {
     this.fill = fill;
     repaint();
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //中心座標
     int x = getWidth()/2;
     int y = getHeight()/2;

     //長寬
     int w = (int)(getWidth()*0.8);
     int h = (int)(getHeight()*0.8);

     if(fill)//判斷是否填滿
      {
       switch(select)//根據狀態繪圖
        {
         case LINE: g.drawLine(x-w/2,y-h/2,x+w/2,y+h/2);break;
         case RECT: g.fillRect(x-w/2,y-h/2,w,h);break;
         case OVAL: g.fillOval(x-w/2,y-h/2,w,h);break;
        }
      }
       
     else//不填滿
      {
       switch(select)
        {
         case LINE: g.drawLine(x-w/2,y-h/2,x+w/2,y+h/2);break;
         case RECT: g.drawRect(x-w/2,y-h/2,w,h);break;
         case OVAL: g.drawOval(x-w/2,y-h/2,w,h);break;
        }
      } 
    }
  }
}