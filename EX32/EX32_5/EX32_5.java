//Creating ClockWithAlarm from Clock

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EX32_5 extends JFrame
{
 //��������
 ClockWithAlarm clock1 = new ClockWithAlarm("2022,10,16","4,3,0");

 public EX32_5()
  {
   add(clock1);
  }

 public static void main(String args[])
  {
   EX32_5 frame = new EX32_5();
   
   frame.setTitle("EX32_5");//���D
   frame.setSize(250,250);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}