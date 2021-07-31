//split a file with a GUI and multithread

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;

public class EX29_15 extends JFrame
{
 private JTextArea jta = new JTextArea();//顯示說明文本

 private JTextField jtfChooseFile = new JTextField(10);//輸入檔案路徑
 private JTextField jtfNumberOfPiece = new JTextField(10);//輸入想分割片段

 private JButton jbBrowse = new JButton("Browse");//瀏覽檔案
 private JButton jbStart = new JButton("Start"); //開始分割
 
 private JProgressBar jpb = new JProgressBar();
 
 public EX29_15()
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
   JPanel p3 = new JPanel(new GridLayout(2,1));
   p3.add(jbStart);
   p3.add(jpb);

   jpb.setStringPainted(true);
   jpb.setValue(0);
   jpb.setMaximum(100);

   //整合介面
   setLayout(new GridLayout(4,1));
   add(p1);
   add(p2_1);
   add(p2_2);
   add(p3);
   //add();

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

     int numberOfPiece = Integer.parseInt(jtfNumberOfPiece.getText())-1;//分割份數
     SpiltTask task = new SpiltTask(numberOfPiece,jtfChooseFile.getText());//創建thread
     
     
     //設定progress變化
     task.addPropertyChangeListener(new PropertyChangeListener(){
      public void propertyChange(PropertyChangeEvent e){
       if("progress".equals(e.getPropertyName())){
        jpb.setValue((Integer)e.getNewValue());
       }
      }
     });

     task.execute();//執行
    }
   });   
  }

 //分割檔案task
 class SpiltTask extends SwingWorker<Integer,Integer>
  {
   private int part;//分割份數
   private String fileName;//檔案名稱

   //constructor
   public SpiltTask(int part,String fileName)
    {
     this.part = part;
     this.fileName = fileName;
    }

   protected Integer doInBackground() throws Exception
    {
     //讀取檔案
     RandomAccessFile raf = new RandomAccessFile(fileName,"rw");

     long size = raf.length()/part;//分割後長度

     part++;

     //不滿長度的處置
      if(raf.length()%(part-1) == 0)
       {
        size = raf.length()/(part);
       }
   
      int count = 1; //計數分了幾份
      
      long length = raf.length();
      long filePercent = 0;//目前進度
      while(true)
       {
        //儲存分割的檔案
        RandomAccessFile out = new RandomAccessFile(fileName+"."+count,"rw");
        //如果長度大於分割長度 按長度分割
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
        else//小於分割長度 
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
            //將剩下的整合到最後一部分
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
     EX29_15 frame = new EX29_15();//宣告視窗
     frame.pack();//適合大小
     frame.setTitle("EX29_15");//標題
     frame.setSize(380,300);//大小
     frame.setLocationRelativeTo(null);//相對位置
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
     frame.setVisible(true);//顯示
    }
   });
  }
} 