//��J�ɦW����ɮפ��e

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX16_19 extends JFrame
{
 private JTextArea jta = new JTextArea(); // ��ܤ��e
 private JTextField jtfile = new JTextField(13); //��J�ɦW
 private JButton view = new JButton("View"); //����

 public EX16_19()
  {
   //�]�w����
   jta.setWrapStyleWord(true);
   jta.setLineWrap(true);

   //�]�w����s��奻
   jta.setEditable(false);

   JScrollPane scrollPane = new JScrollPane(jta);//�[�J�u�ʱ�
   
   //��J�ɮ�panel
   JPanel p1 = new JPanel();
   p1.add(new JLabel("Filename"));
   p1.add(jtfile);
   p1.add(view);
   
   ///�[�J�ʧ@ ����ɮפ奻
   view.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try
     {
      Scanner input = new Scanner(new File(jtfile.getText())); //Ū��
     
      String s = "";//��ܦr��

      while(input.hasNext()) 
       {
        s += input.next();//��J�奻
       }
    
      jta.setText(s);//���
     }
     catch(Exception ex){
     //�p�G����
     jta.setText("error");}
    }
   });

   //��X
   add(scrollPane,BorderLayout.CENTER);
   add(p1,BorderLayout.SOUTH);
  }

 public static void main(String args[])
  {
   EX16_19 frame = new EX16_19();//��ܵ���
   frame.setTitle("EX16_19");//���D
   frame.setSize(600,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}
