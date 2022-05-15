//Placing the calendar and clock in a panel

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class EX31_3 extends JFrame
{
 private CalendarPanel calendarPanel = new CalendarPanel();//日歷panel
 private WorldClock clock = new WorldClock();//時鐘panel

 public EX31_3()
  {   
   //排版
   JPanel jpCalendar = new JPanel(new BorderLayout());
   jpCalendar.add(calendarPanel,BorderLayout.CENTER);

   setLayout(new GridLayout(1,2));
   add(jpCalendar);
   add(clock);
  }

 public static void main(String args[])
  {
   //frame
   EX31_3 frame = new EX31_3();
   frame.setTitle("EX31_3");//標題
   frame.setSize(500,500);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}