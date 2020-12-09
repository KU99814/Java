//Combining a file with a GUI

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EX19_13 extends JFrame
{
 private JTextArea jta = new JTextArea();//��ܻ����奻

 private JTextField jtfBaseFile = new JTextField(10);//��J�ɮ�
 private JTextField jtfNumberOfPiece = new JTextField(10);//��J����

 private JButton jbStart = new JButton("Start");//�}�l���s
 
 public EX19_13()
  {
   String text = "If you base file is named temp.txt with three piecea,temp.txt.1,\n"+
                 "temp.txt.2,temp.txt.3 are combined into temp.txt";//�����奻
   jta.setText(text);
   jta.setEditable(false);

   //�奻panel
   JPanel p1 = new JPanel(new BorderLayout());
   p1.add(jta,BorderLayout.CENTER);

   //��J�ɮ�
   JPanel p2_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   p2_1.add(new JLabel("Enter a base file:"));
   p2_1.add(jtfBaseFile);

   //��J�ƶq
   JPanel p2_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   p2_1.add(new JLabel("Specify the number of smaller files:"));
   p2_1.add(jtfNumberOfPiece);

   //��X��Japnel
   JPanel p2 = new JPanel(new GridLayout(2,1));
   p2.add(p2_1);
   p2.add(p2_2);

   //��X
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(jbStart,BorderLayout.SOUTH);

   //�}�l�ʧ@ �PEX19_12
   jbStart.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      RandomAccessFile raf = new RandomAccessFile(jtfBaseFile.getText(),"rw");

      int num = Integer.parseInt(jtfNumberOfPiece.getText());

      for(int i=1;i<=num;i++)
       {
        RandomAccessFile in = new RandomAccessFile(jtfBaseFile.getText()+"."+i,"rw");
     
        for(long j=0;j<=in.length();j++)
         {
          raf.write(in.read());
         }
        in.close();
       }
     }
     catch(Exception ex){
      ex.printStackTrace();
     }
    }
   });   
  }    

 public static void main(String args[]) throws IOException
  {
   EX19_13 frame = new EX19_13();//�ŧi����
   frame.pack();//�A�X�j�p
   frame.setTitle("EX19_13");//���D
   frame.setSize(400,250);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
} 