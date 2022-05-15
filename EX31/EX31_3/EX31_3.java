//Placing the calendar and clock in a panel

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class EX31_3 extends JFrame
{
 private CalendarPanel calendarPanel = new CalendarPanel();//���panel
 private WorldClock clock = new WorldClock();//����panel

 public EX31_3()
  {   
   //�ƪ�
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
   frame.setTitle("EX31_3");//���D
   frame.setSize(500,500);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}