//Displaying an addition table

import javax.swing.*;
import java.awt.*;

public class EX14_4 extends JFrame
{
 public EX14_4()
  {
   JPanel p1 = new AdditionalTable();//宣告加法表
   add(p1);//加入
  }
 
 public static void main(String args[])
  {
   EX14_4 frame = new EX14_4();//宣告視窗
   frame.setSize(400,400);//大小
   frame.setTitle("EX14_4");//標題
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//加法表
class AdditionalTable extends JPanel
{
 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   String title = "Addition Table";//標題

   int x = (getWidth() - 100)/25; //調整行數
   int y = (getHeight()-120)/25;

   g.setFont(new Font("Courie",Font.BOLD,30));  //設定字型、大小
   g.setColor(Color.red); //設定顏色
   g.drawString(title,90,70);

   g.setColor(Color.black);
   g.drawRect(90,100,getWidth() - 100,getHeight()-120);//繪製邊框

   g.setFont(new Font("Courie",Font.BOLD,15));

   for(int i=0;i<x;i++)//行
    {
     g.drawString((i+1)+"",100+25*i,90);
    }
    
   for(int i=0;i<y;i++)//列
    {
     g.drawString((i+1)+"",70,120+25*i);
    }

    g.setColor(Color.red);
    //繪出數字盤
    for(int i=0;i<x;i++)
     for(int j=0;j<y;j++)
      g.drawString(((i+1)+(j+1))+"",100+i*25,120+j*25);
  }
}   
   