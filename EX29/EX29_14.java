import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.io.*;

public class EX29_14 extends JFrame
{
 private JProgressBar jpb = new JProgressBar();//進度條
 private JTextField jtfInput = new JTextField(50);//輸入要複製檔案路徑
 private JTextField jtfOutput = new JTextField(50);//輸出要複製檔案路徑
 private JButton jbtCopy = new JButton("Copy");//開始複製按鈕

 static boolean start = false;//判斷複製是否開始 避免重複複製

 //constructor
 public EX29_14()
  {
   //進度條設定
   jpb.setStringPainted(true);//繪出百分比
   jpb.setValue(0);//起始設為零
   jpb.setMaximum(100);//最大值設為100
   
   //輸入檔案的panel
   JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   p1.setBorder(BorderFactory.createTitledBorder("From"));//框線
   p1.add(jtfInput);//加入textfield

   //輸出檔案的panel
   JPanel p2 = new JPanel();
   p2.add(jtfOutput);
   p2.setBorder(BorderFactory.createTitledBorder("To"));//框線

   //按鈕panel
   JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   p3.add(jbtCopy);

   //放入frame
   setLayout(new GridLayout(4,1,5,5));
   add(jpb);
   add(p1);
   add(p2);
   add(p3);

   //按鈕動作
   jbtCopy.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
     {
      //若還沒開始 開始複製
      if(!start)
       {
        //取得檔案路徑
        String input = jtfInput.getText();
        String output = jtfOutput.getText();

        //狀態設為開始
        start = true;
        CopyTask task = new CopyTask(input,output);//創建thread task

        //當狀態變動時 讓進度條能夠顯示進度        
        task.addPropertyChangeListener(new PropertyChangeListener(){
         public void propertyChange(PropertyChangeEvent e){
          if("progress".equals(e.getPropertyName()))
           {
            jpb.setValue((Integer)e.getNewValue());//顯示進度
           }
         }
        });

        task.execute();//開始執行
       }
     }
    });
  }

 static class CopyTask extends SwingWorker<Integer,Integer>
  {
   //檔案路徑
   private String input;//輸入
   private String output;//輸出

   //file stream
   private BufferedInputStream fileInput;//輸入
   private BufferedOutputStream fileOutput;//輸出

   //constructor
   public CopyTask(String input,String output)
    {
     //取得檔案路徑
     this.input = input;
     this.output = output;
    }

   protected Integer doInBackground() throws Exception
    {
     File iFile = new File(input);
     File oFile = new File(output);
 
     //若檔案不存在 顯示錯誤資訊欄
     if(!iFile.exists())
      {
       JOptionPane.showMessageDialog(null,"檔案不存在",
                                  "錯誤", JOptionPane.ERROR_MESSAGE);
       start = false;
       return 0;
      }

     //建立IO stream
     fileInput = new BufferedInputStream(new FileInputStream(iFile));
     fileOutput = new BufferedOutputStream(new FileOutputStream(oFile));
         
     int max = fileInput.available();//檔案大小(byte)
     int count = 0;//目前複製大小(byte)

     int r;
     
     //複製資料
     while((r=fileInput.read())!=-1)
      {
       fileOutput.write((byte)r);//將input檔案讀取 寫入output檔案
       count++;//目前byte數
       setProgress(100*count/max);//顯示百分比
      }

     //讀取結束後關閉檔案
     fileInput.close();
     fileOutput.close();
     
     return 0;  
    }
   
   //完成後動作
   protected void done()
    {
     if(start)
      {
       //顯示資訊欄 表示完成
       JOptionPane.showMessageDialog(null,"複製完成","訊息",JOptionPane.INFORMATION_MESSAGE);
       start = false;
      }
    } 
   
  }

 public static void main(String args[])
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_14 frame = new EX29_14();//frame物件
     frame.setTitle("EX29_14");//標題
     frame.setSize(600,280);//大小
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
     frame.setLocationRelativeTo(null);//相對動作
     frame.setVisible(true);//顯示
    }
   });
  }
}