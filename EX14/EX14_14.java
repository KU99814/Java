//Displaying a horizontal chart

import javax.swing.*;
import java.awt.*;

public class EX14_14 extends JFrame
{
 public EX14_14()
  {
   add(new Score());//加入panel
  }

 public static void main(String args[])
  {
   EX14_14 frame = new EX14_14();//宣告視窗
   frame.setTitle("EX14_14");//標題
   frame.setSize(400,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//顯示得分並繪製長條圖
class Score extends JPanel
{
 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   g.drawLine(5,10,5,getHeight()-10);

   g.setColor(Color.red);
   g.drawString("Project -- 20%",10,15);
   g.fillRect(10,15,(int)((getWidth()-20)*0.2),10);

   g.setColor(Color.blue);
   g.drawString("Quizzes -- 10%",10,45);
   g.fillRect(10,45,(int)((getWidth()-20)*0.1),10);

   g.setColor(Color.pink);
   g.drawString("Midtems -- 30%",10,75);
   g.fillRect(10,75,(int)((getWidth()-20)*0.3),10);

   g.setColor(Color.gray);
   g.drawString("Final -- 40%",10,105);
   g.fillRect(10,105,(int)((getWidth()-20)*0.4),10);
  }
}