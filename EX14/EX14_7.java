//Displayint TicTacToe board

import javax.swing.*;
import java.awt.*;

public class EX14_7 extends JFrame
{
 public EX14_7()
  {
   add(new TicTacToe());
  }

 public static void main(String args[])
  {
   EX14_7 frame = new EX14_7();//宣告視窗
   frame.setTitle("EX14_7");//標題
   frame.setSize(400,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//井字遊戲class
class TicTacToe extends JPanel
{
 //常數
 public static final int NOTHING = 0;//代表空格
 public static final int X = 1; //代表X
 public static final int O = 2; //代表O

 //建構子
 public TicTacToe()
  {}

 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //每格長寬
   int w = (getWidth()-30)/3;
   int h = (getHeight()-30)/3;
   
   for(int i=0;i<3;i++)
    {
     for(int j=0;j<3;j++)
      {
       int type = (int)(Math.random()*3);//隨機選定顯示
       if(type==X)//顯示X
        {
         g.drawLine(10*(i+1)+w*i,10*(j+1)+h*j,10*(i+1)+w*(i+1),10*(j+1)+h*(j+1));
         g.drawLine(10*(i+1)+w*(i+1),10*(j+1)+h*j,10*(i+1)+w*i,10*(j+1)+h*(j+1));
        }
        else if(type==O)//顯示O
        {
         g.drawOval(10*(i+1)+w*i,10*(j+1)+h*j,w,h);
        }
      }
    }
  }
}