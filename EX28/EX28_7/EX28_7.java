//Weighted 4X4 16 tail view
//讀取EX28_6輸出的檔案並顯示

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.io.*;

public class EX28_7
{
 public static void main(String args[]) throws IOException,ClassNotFoundException
  {
   WeightedTailApp16 frame = new WeightedTailApp16();//創建

   frame.setSize(300,300);//視窗大小
   frame.setTitle("EX28_7");//視窗標題
   frame.setLocationRelativeTo(null);//視窗相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//視窗顯示
  }
}