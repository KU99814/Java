//Modifying weight in the nine tail problem

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EX28_4
{
 public static void main(String args[])
  {
   WeightedNineTailApp frame = new WeightedNineTailApp();//創建frame

   frame.setSize(300,300);//視窗大小
   frame.setTitle("EX28_4");//視窗標題
   frame.setLocationRelativeTo(null);//視窗相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//視窗顯示
  }
}