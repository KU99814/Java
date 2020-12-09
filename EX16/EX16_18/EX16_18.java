//�p��r���W�v

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX16_18 extends JFrame
{
 private JTextArea jta; //��J
 private JButton jbtShowHistogram = new JButton("Show Histogram"); //��ܫ��s
 private Histogram histogram = new Histogram();//������
 
 private JFrame histogramFrame = new JFrame();//��ܪ�����frame
 
 public EX16_18()
  {
   JScrollPane scrollPane = new JScrollPane(jta = new JTextArea());//�奻�[�J�u�ʱ�
   scrollPane.setPreferredSize(new Dimension(300,200));

   //�奻����
   jta.setWrapStyleWord(true);
   jta.setLineWrap(true);
   
   //�[�Jcomponent
   add(scrollPane,BorderLayout.CENTER);
   add(jbtShowHistogram,BorderLayout.SOUTH);
   
   //�[�J���s�ʧ@ ��ܪ����ϵ���
   jbtShowHistogram.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     int[] count = countLetters();//���o��r����
     histogram.showHistogram(count);//���o�W�v
     histogramFrame.setVisible(true);//��ܵ���
    }
   });

   //��Xpanel
   histogramFrame.add(histogram);
   histogramFrame.pack();
   histogramFrame.setTitle("Histogram");
  }

 private int[] countLetters() //�p���r�X�{����
  {
   int[] count = new int[26];
   
   String text = jta.getText();
   
   for(int i=0;i<text.length();i++)
    {
     char character = text.charAt(i);
     
     //�j�p�g�����P�@
     if((character >= 'A') && (character <= 'Z'))
      count[character - 'A']++;
     else if((character >= 'a') && (character <= 'z'))
      count[character - 'a']++;
    }

   return count;
  }

 public static void main(String args[])
  {
   EX16_18 frame = new EX16_18();//�ŧi����
   frame.setTitle("EX16_18");//���D
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.pack();//�վ�ؤo
   frame.setVisible(true);//���
  }
}