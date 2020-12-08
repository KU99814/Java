import javax.swing.*;
import java.awt.*;

public class EX14_20 extends JFrame
{
 public EX14_20()
  {
   StillClock clock = new StillClock();//宣告時鐘class物件
   MessagePanel message = new MessagePanel(clock.getHour() + ":" + clock.getMinute()+":"+
                                           clock.getSecond() + " GMT ");//宣告訊息面板
   //設定面板狀態
   message.setCentered(true);
   message.setForeground(Color.blue);
   message.setFont(new Font("Courie",Font.BOLD,16));


   add(clock);//加入時鐘
   add(message,BorderLayout.SOUTH);//加入面板
  }

 public static void main(String args[])
  {
   EX14_20 frame = new EX14_20();//宣告
   frame.setTitle("EX14_20");//標題
   frame.setSize(400,300);//大小
   frame.setLocationRelativeTo(null);//位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setVisible(true);//顯示
  }
}