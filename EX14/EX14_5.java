//Displaying numbers in a triangular pattern

import javax.swing.*;
import java.awt.*;

public class EX14_5 extends JFrame
{
 public EX14_5()
  {
   add(new TriangularPattern());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX14_5 frame = new EX14_5();//宣告視窗
   frame.setSize(400,400);//大小
   frame.setTitle("EX14_5"); //標題
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//倒三角形數列panel
class TriangularPattern extends JPanel
{
 //繪製
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   g.setFont(new Font("Courie",Font.BOLD,15));//設定字形

   int x = (getHeight()-20)/25;//長除以字距得到字的個數

   for(int i=0;i<x;i++)
    for(int j=0;j<i;j++)
     g.drawString((j+1)+"",10+j*25,20+(x-i)*25);
  }
}