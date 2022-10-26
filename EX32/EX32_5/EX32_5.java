//Creating ClockWithAlarm from Clock

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EX32_5 extends JFrame
{
 //時鐘物件
 ClockWithAlarm clock1 = new ClockWithAlarm("2022,10,16","4,3,0");

 public EX32_5()
  {
   add(clock1);
  }

 public static void main(String args[])
  {
   EX32_5 frame = new EX32_5();
   
   frame.setTitle("EX32_5");//標題
   frame.setSize(250,250);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}