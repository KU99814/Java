//Knight's tour cycle

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EX27_15
{
 public static void main(String args[])
  {
   //視窗object
   KnightTourApp frame = new KnightTourApp();

   frame.setSize(500,500);//大小
   frame.setTitle("EX27_15");//標題
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示視窗
  }
}