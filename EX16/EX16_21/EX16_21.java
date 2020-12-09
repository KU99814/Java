//�p��r���W�v �ɮ׿�J

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX16_21 extends JFrame
{
 private Histogram histogram = new Histogram();//������panel
 private JTextField jtf = new JTextField(15);//��J�ɮ�
 
 public EX16_21()
  {
   //��J�ɦWpanel
   JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));

   //�[�Jcomponent
   p1.add(new JLabel("Text file"));
   p1.add(jtf);

   //��X
   add(histogram,BorderLayout.CENTER);
   add(p1,BorderLayout.SOUTH);
   
   //�[�J�ʧ@ 
   jtf.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int[] count = countLetters(jtf.getText());//���o�W�v
     histogram.showHistogram(count);//��ܪ�����
    }
   });
  }

 private int[] countLetters(String file) //�p�⦸��
  {
   String text = "";
   int[] count = new int[26];
   try
    {
     Scanner input = new Scanner(new File(file));
     while(input.hasNext())
      {
       text += input.next();
      }
    }
   catch(Exception ex){}
   
   for(int i=0;i<text.length();i++)
    {
     char character = text.charAt(i);
     
     //�j�p�g�����P�@�r
     if((character >= 'A') && (character <= 'Z'))
     count[character - 'A']++;
     else if((character >= 'a') && (character <= 'z'))
      count[character - 'a']++;
    }

   return count;
  }

 public static void main(String args[])
  {
   EX16_21 frame = new EX16_21();//�ŧi����
   frame.setTitle("EX16_21");//���D
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.pack();//�t�X
   frame.setVisible(true);//���
  }
}