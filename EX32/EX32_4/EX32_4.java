//The Clock source component

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EX32_4 extends JFrame
{
 //��������
 Clock clock1 = new Clock();
 Clock clock2 = new Clock(); 
 Clock clock3 = new Clock();
 Clock clock4 = new Clock(); 

 public EX32_4()
  {
   clock1.setHeader("London");
   clock1.setTimeZoneID("Europe/London");

   clock2.setHeader("Paris");
   clock2.setTimeZoneID("MIT");

   clock3.setHeader("Savannah");
   clock3.setTimeZoneID("GMT");

   clock3.setHeader("Chicago");
   clock3.setTimeZoneID("CST");

   setLayout(new GridLayout(1,4));
   add(clock1);
   add(clock2);
   add(clock3);
   add(clock4);
  }

 public static void main(String args[])
  {
   EX32_4 frame = new EX32_4();
   
   frame.setTitle("EX32_4");//���D
   frame.setSize(800,250);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}