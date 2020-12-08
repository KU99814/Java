import javax.swing.*;

public class EX14_19 extends JFrame
{
 public EX14_19()
  {
   //隨機設定時與分
   int hour = (int)(Math.random()*12);
   int minute = (int)(Math.random()*60);
   
   StillClock c = new StillClock(hour,minute,0);//宣告時鐘panel

   //設定顯示
   c.setHourHandVisible(true);
   c.setMinuteHandVisible(true);

   //加入
   add(c);
  }

 public static void main(String args[])
  {
   EX14_19 frame = new EX14_19();//宣告輸入
   frame.setTitle("EX14_19");//標題
   frame.setSize(400,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}