//split a file with a GUI

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EX19_11 extends JFrame
{
 private JTextArea jta = new JTextArea();//顯示說明文本

 private JTextField jtfChooseFile = new JTextField(10);//輸入檔案路徑
 private JTextField jtfNumberOfPiece = new JTextField(10);//輸入想分割片段

 private JButton jbBrowse = new JButton("Browse");//瀏覽檔案
 private JButton jbStart = new JButton("Start"); //開始分割
 
 public EX19_11()
  {
   String text = "If you split a file named temp.txt into 3 smaller files,the\n"+
                 " three smaller files are temp.txt.1 ,temp.txt.2,temp.txt.3.";//說明文本
   jta.setText(text);
   jta.setEditable(false);//設為不可編輯

   //說明panel
   JPanel p1 = new JPanel(new BorderLayout());
   p1.add(jta,BorderLayout.CENTER);

   //輸入檔案panel
   JPanel p2_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   p2_1.add(new JLabel("Enter or choose a file:"));
   p2_1.add(jtfChooseFile);
   p2_1.add(jbBrowse);

   //分割份數panel   
   JPanel p2_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   p2_1.add(new JLabel("Specify the number of smaller files:"));
   p2_1.add(jtfNumberOfPiece);

   //整合檔案操作
   JPanel p2 = new JPanel(new GridLayout(2,1));
   p2.add(p2_1);
   p2.add(p2_2);

   //整合介面
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
   add(jbStart,BorderLayout.SOUTH);

   //加入按鈕動作 檔案瀏覽
   jbBrowse.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     JFileChooser fileChooser = new JFileChooser();//用檔案瀏覽介面取得檔案
     if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
      {
       File file = fileChooser.getSelectedFile();
     
       jtfChooseFile.setText(file.getName());//將路徑顯示在欄位
      }
    }
   });

   //開始分割 下同EX19_10
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
   EX19_11 frame = new EX19_11();//宣告視窗
   frame.pack();//適合大小
   frame.setTitle("EX19_11");//標題
   frame.setSize(400,250);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
} 