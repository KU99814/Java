//variation of the nine tail problem

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EX27_9
{
 public static void main(String args[])
  {
   NineTailApp frame = new NineTailApp();//創建frame

   frame.setSize(300,300);//視窗大小
   frame.setTitle("EX27_9");//視窗標題
   frame.setLocationRelativeTo(null);//視窗相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//視窗顯示
  }
}