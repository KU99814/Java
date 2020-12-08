//displaying a checkerbroad

import javax.swing.*;
import java.awt.*;

public class EX13_10 extends JFrame
{
 public EX13_10()
  {
   setLayout(new GridLayout(7,8));//設為7*8的格式
   
   int count = 0;//換行
   int j=0;//切換黑白
   for(int i=0;i<56;i++,j++)
    {
     JButton b = new JButton();//按鈕
     if(count%8==0&&count!=0)//因為要黑白相間 下一行要換顏色
      j++;
     if(j%2==0)
      b.setBackground(Color.white);//白色
     else
      b.setBackground(Color.black);//黑色
     
     add(b);//加入
     count++;
    }
  }

 public static void main(String args[])
  {
   JFrame frame = new EX13_10();//宣告視窗
   frame.setTitle("EX13_10");//標題
   frame.setSize(400,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}