//4X4 16 tail model view

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.io.*;

public class EX27_11
{
 public static void main(String args[]) throws IOException,ClassNotFoundException
  {
   TailApp frame = new TailApp();//�Ы�frame

   frame.setSize(300,300);//�����j�p
   frame.setTitle("EX27_11");//�������D
   frame.setLocationRelativeTo(null);//�����۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//�������
  }
}