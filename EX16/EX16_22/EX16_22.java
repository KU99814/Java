//��J�ɦW����ɮפ��e �H�ɶ���J���P�ɮ�

import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_22 extends JFrame
{
 private JTextArea jta = new JTextArea(); // ��ܤ��e
 Timer timer = new Timer(1000,new TimerListener()); //�p�ɾ�
 int count = 0;//��ܲĴX�i

 public EX16_22()
  {
   //����
   jta.setWrapStyleWord(true);
   jta.setLineWrap(true);

   //�]������s��
   jta.setEditable(false);

   JScrollPane scrollPane = new JScrollPane(jta);//�[�J�u�ʱ�
   
   add(scrollPane,BorderLayout.CENTER);
   timer.start(); //�}�l
  }

 //�p�ɰʧ@
 class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     if(count>9)//�W�L�̫�@�ƫ�^����I
      count = 0;
     try
      {
       Scanner input = new Scanner(new File("slide"+count+".txt"));//Ū���ɮ�
       String s = "";
       
       //Ū����r
       while(input.hasNext())
        {
         s += input.next()+" ";
        }
       jta.setText(s);//�]�w�奻
       count++;
      }
     catch(Exception ex){}
    }
  }

 public static void main(String args[])
  {
   EX16_22 frame = new EX16_22();//�ŧi����
   frame.setTitle("EX16_22");//���D
   frame.setSize(600,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}
