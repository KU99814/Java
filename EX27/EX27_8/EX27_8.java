//Revising Listing 27.9 MainTailModel.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class EX27_8
{
 public static void main(String args[])
  {
   NineTailApp frame = new NineTailApp();//�Ы�frame

   frame.setSize(300,300);//�����j�p
   frame.setTitle("EX27_8");//�������D
   frame.setLocationRelativeTo(null);//�����۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//�������
  }
}