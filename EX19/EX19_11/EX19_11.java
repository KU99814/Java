//split a file with a GUI

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EX19_11 extends JFrame
{
 private JTextArea jta = new JTextArea();//��ܻ����奻

 private JTextField jtfChooseFile = new JTextField(10);//��J�ɮ׸��|
 private JTextField jtfNumberOfPiece = new JTextField(10);//��J�Q���Τ��q

 private JButton jbBrowse = new JButton("Browse");//�s���ɮ�
 private JButton jbStart = new JButton("Start"); //�}�l����
 
 public EX19_11()
  {
   String text = "If you split a file named temp.txt into 3 smaller files,the\n"+
                 " three smaller files are temp.txt.1 ,temp.txt.2,temp.txt.3.";//�����奻
   jta.setText(text);
   jta.setEditable(false);//�]�����i�s��

   //����panel
   JPanel p1 = new JPanel(new BorderLayout());
   p1.add(jta,BorderLayout.CENTER);

   //��J�ɮ�panel
   JPanel p2_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   p2_1.add(new JLabel("Enter or choose a file:"));
   p2_1.add(jtfChooseFile);
   p2_1.add(jbBrowse);

   //���Υ���panel   
   JPanel p2_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   p2_1.add(new JLabel("Specify the number of smaller files:"));
   p2_1.add(jtfNumberOfPiece);

   //��X�ɮ׾ާ@
   JPanel p2 = new JPanel(new GridLayout(2,1));
   p2.add(p2_1);
   p2.add(p2_2);

   //��X����
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(jbStart,BorderLayout.SOUTH);

   //�[�J���s�ʧ@ �ɮ��s��
   jbBrowse.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     JFileChooser fileChooser = new JFileChooser();//���ɮ��s���������o�ɮ�
     if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
      {
       File file = fileChooser.getSelectedFile();
     
       jtfChooseFile.setText(file.getName());//�N���|��ܦb���
      }
    }
   });

   //�}�l���� �U�PEX19_10
   jbStart.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     JFileChooser fileChooser = new JFileChooser();
     try{
      RandomAccessFile raf = new RandomAccessFile(jtfChooseFile.getText(),"rw");

      int numberOfPiece = Integer.parseInt(jtfNumberOfPiece.getText())-1;

      long size = raf.length()/numberOfPiece;
      
      numberOfPiece++;

      if(raf.length()%(numberOfPiece-1) == 0)
       {
        size = raf.length()/(numberOfPiece);
       }
   
      int count = 1;
      while(true)
       {
        RandomAccessFile out = new RandomAccessFile(jtfChooseFile.getText()+"."+count,"rw");
        if(raf.length() - raf.getFilePointer()<=size)
         {
          for(long i= raf.getFilePointer();i<raf.length();i++)
           {
            out.write(raf.read());
           }
          out.close();
          break;
         }
        else
         {
          for(long i=0;i<size;i++)
           {
            out.write(raf.read());
           }
          if(count==numberOfPiece)
           {
            for(long i=raf.getFilePointer();i<raf.length();i++)
             {
              out.write(raf.read());
             }
            out.close();
            break;
           }
          out.close();
          if(raf.length() - raf.getFilePointer()==0)
           break;
         }
        count++;
       }
      raf.close();
     }
     catch(Exception ex){
      ex.printStackTrace();
     }
    }
   });   
  }    

 public static void main(String args[]) throws IOException
  {
   EX19_11 frame = new EX19_11();//�ŧi����
   frame.pack();//�A�X�j�p
   frame.setTitle("EX19_11");//���D
   frame.setSize(400,250);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
} 