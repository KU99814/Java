//split a file with a GUI and multithread

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;

public class EX29_15 extends JFrame
{
 private JTextArea jta = new JTextArea();//��ܻ����奻

 private JTextField jtfChooseFile = new JTextField(10);//��J�ɮ׸��|
 private JTextField jtfNumberOfPiece = new JTextField(10);//��J�Q���Τ��q

 private JButton jbBrowse = new JButton("Browse");//�s���ɮ�
 private JButton jbStart = new JButton("Start"); //�}�l����
 
 private JProgressBar jpb = new JProgressBar();
 
 public EX29_15()
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
   JPanel p3 = new JPanel(new GridLayout(2,1));
   p3.add(jbStart);
   p3.add(jpb);

   jpb.setStringPainted(true);
   jpb.setValue(0);
   jpb.setMaximum(100);

   //��X����
   setLayout(new GridLayout(4,1));
   add(p1);
   add(p2_1);
   add(p2_2);
   add(p3);
   //add();

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

     int numberOfPiece = Integer.parseInt(jtfNumberOfPiece.getText())-1;//���Υ���
     SpiltTask task = new SpiltTask(numberOfPiece,jtfChooseFile.getText());//�Ы�thread
     
     
     //�]�wprogress�ܤ�
     task.addPropertyChangeListener(new PropertyChangeListener(){
      public void propertyChange(PropertyChangeEvent e){
       if("progress".equals(e.getPropertyName())){
        jpb.setValue((Integer)e.getNewValue());
       }
      }
     });

     task.execute();//����
    }
   });   
  }

 //�����ɮ�task
 class SpiltTask extends SwingWorker<Integer,Integer>
  {
   private int part;//���Υ���
   private String fileName;//�ɮצW��

   //constructor
   public SpiltTask(int part,String fileName)
    {
     this.part = part;
     this.fileName = fileName;
    }

   protected Integer doInBackground() throws Exception
    {
     //Ū���ɮ�
     RandomAccessFile raf = new RandomAccessFile(fileName,"rw");

     long size = raf.length()/part;//���Ϋ����

     part++;

     //�������ת��B�m
      if(raf.length()%(part-1) == 0)
       {
        size = raf.length()/(part);
       }
   
      int count = 1; //�p�Ƥ��F�X��
      
      long length = raf.length();
      long filePercent = 0;//�ثe�i��
      while(true)
       {
        //�x�s���Ϊ��ɮ�
        RandomAccessFile out = new RandomAccessFile(fileName+"."+count,"rw");
        //�p�G���פj����Ϊ��� �����פ���
        if(raf.length() - raf.getFilePointer()<=size)
         {
          for(long i= raf.getFilePointer();i<raf.length();i++)
           {
            out.write(raf.read());
            filePercent+=4;

            int percent = Integer.parseInt(String.valueOf(filePercent/length));
            setProgress((Integer)(percent)*100);
           }
          out.close();
          break;
         }
        else//�p����Ϊ��� 
         {
          for(long i=0;i<size;i++)
           {
            out.write(raf.read());
            filePercent++;

            int percent = Integer.parseInt(String.valueOf(filePercent/length));
            setProgress((Integer)(percent)*100);
           }
          if(count==part)
           {
            //�N�ѤU����X��̫�@����
            for(long i=raf.getFilePointer();i<raf.length();i++)
             {
              out.write(raf.read());
              filePercent++;

              int percent = Integer.parseInt(String.valueOf(filePercent/length));
              setProgress((Integer)(percent)*100);
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
     return 0;
    }
  }

 public static void main(String args[]) throws IOException
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_15 frame = new EX29_15();//�ŧi����
     frame.pack();//�A�X�j�p
     frame.setTitle("EX29_15");//���D
     frame.setSize(380,300);//�j�p
     frame.setLocationRelativeTo(null);//�۹��m
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
     frame.setVisible(true);//���
    }
   });
  }
} 