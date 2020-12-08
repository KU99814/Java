import javax.swing.*;
import java.awt.*;

public class EX14_18 extends JFrame
{
 public EX14_18()
  {
   setLayout(new GridLayout(1,2));//設定layout

   //加入時鐘panel
   add(new StillClock(4,20,45));
   add(new StillClock(22,46,15));
  }

 public static void main(String args[])
  {
   EX14_18 frame = new EX14_18();//宣告視窗
   frame.setTitle("EX14_18");//標題
   frame.setSize(400,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}
