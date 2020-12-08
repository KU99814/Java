//Displaying nine rectangles as a grid using an array

import javax.swing.*;
import java.awt.*;

public class EX14_2 extends JFrame 
{
 public EX14_2()
  {
   JPanel p = new NineRectangle();//宣告
   
   add(p);
  }

 public static void main(String args[])
  {
   EX14_2 frame = new EX14_2();//宣告視窗
   frame.setSize(300,150);//宣告大小
   frame.setTitle("EX14_2");//標題
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//繪製長方形panel
class NineRectangle extends JPanel
{
 //建構子
 public NineRectangle()
  {}

 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //長方形長寬
   int width = getSize().width/3;   //畫面長/3
   int height = getSize().height/3; //畫面寬/3

 
   //九個長方形顏色
   Color[] color = {Color.red,Color.blue,Color.white,
                    Color.yellow,Color.green,Color.gray,
                    Color.pink,Color.orange,Color.black};

   int c = 0;//顏色index
   for(int i=0;i<3;i++)
    {
     for(int j=0;j<3;j++)
      {   
       g.setColor(color[c]);//設定顏色
       g.fillRect(width*i,height*j,width,height); //繪製長方形
       c++;//下一個index
      }
    }
  }
}