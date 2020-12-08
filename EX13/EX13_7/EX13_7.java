import javax.swing.*;
import java.awt.*;

public class EX13_7 extends JFrame
{
 private ImageIcon cross = new ImageIcon("x.gif");   //載入X圖
 private ImageIcon not = new ImageIcon("o.gif");     //載入O圖

 public EX13_7()
  {
   setLayout(new GridLayout(3,3));                 //設定layout
   
   for(int i = 0;i<9;i++)                          //隨機出現OX、空格
    {
     int r = (int)(Math.random()*3);            

     if(r == 1)
      add(new JLabel(cross));//放置X
     else if(r == 2) //放置O
      add(new JLabel(not));
     else //空白
      add(new JLabel());
    }
  }
 public static void main(String args[])
  {
   EX13_7 frame = new EX13_7();//宣告視窗
   frame.setTitle("frame");//標題
   frame.setSize(300,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true); //顯示
  }
}