//updating count

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class EX19_9 extends JFrame
{
 //欄位長度
 final static int NAME_SIZE = 32;//姓名欄
 final static int STREET_SIZE = 32;//街道欄
 final static int CITY_SIZE = 20; //城市欄
 final static int STATE_SIZE = 2;//區欄
 final static int ZIP_SIZE = 5;//郵遞號欄
 //總長度
 final static int RECORD_SIZE = 
             ( NAME_SIZE + STREET_SIZE + CITY_SIZE + STATE_SIZE + ZIP_SIZE);

 private RandomAccessFile raf;//宣告檔案讀取

 //輸入欄位
 private JTextField jtfName = new JTextField(NAME_SIZE);//姓名
 private JTextField jtfStreet = new JTextField(STREET_SIZE);//街道
 private JTextField jtfCity = new JTextField(CITY_SIZE);//城市
 private JTextField jtfState = new JTextField(STATE_SIZE);//區域
 private JTextField jtfZip = new JTextField(ZIP_SIZE);//郵遞號

 //按鈕
 private JButton jbtAdd = new JButton("Add");//增加資料
 private JButton jbtFirst = new JButton("First");//第一個資料
 private JButton jbtNext = new JButton("Next");//下一個
 private JButton jbtPrevious = new JButton("Previous");//前一個
 private JButton jbtLast = new JButton("Last");//最後一個
 private JButton jbtUpdate = new JButton("Update");//更新

 long nowPostition = 0;//現在位址

 public EX19_9()
  {
   try
    {
     raf = new RandomAccessFile("address.dat","rw");//定義檔案輸入
    }
   catch(IOException ex)//處理讀取失誤
    {
     System.out.print("Error: "+ex);
     System.exit(0);
    }
   
   //顯示欄位名稱
   JPanel p1 = new JPanel();
   p1.setLayout(new GridLayout(3,1));
   p1.add(new JLabel("Name"));
   p1.add(new JLabel("Street"));
   p1.add(new JLabel("City")); 

   //輸入區域欄位   
   JPanel jpState = new JPanel();
   jpState.setLayout(new BorderLayout());
   jpState.add(new JLabel("State"),BorderLayout.WEST);
   jpState.add(jtfState,BorderLayout.CENTER);

   //輸入郵遞欄位
   JPanel jpZip = new JPanel();
   jpZip.setLayout(new BorderLayout());
   jpZip.add(new JLabel("Zip"),BorderLayout.WEST);
   jpZip.add(jtfZip,BorderLayout.CENTER);
 
   //將區域與郵遞整合
   JPanel p2 = new JPanel();
   p2.setLayout(new BorderLayout());
   p2.add(jpState,BorderLayout.WEST);
   p2.add(jpZip,BorderLayout.CENTER);

   //將城市輸入欄位與上面整合
   JPanel p3 = new JPanel();
   p3.setLayout(new BorderLayout());
   p3.add(jtfCity,BorderLayout.CENTER);
   p3.add(p2,BorderLayout.EAST);

   //整合姓名與街道欄位
   JPanel p4 = new JPanel();
   p4.setLayout(new GridLayout(3,1));
   p4.add(jtfName);
   p4.add(jtfStreet);
   p4.add(p3);

   //將所有輸入欄位整合
   JPanel jpAddress = new JPanel(new BorderLayout());
   jpAddress.add(p1,BorderLayout.WEST);
   jpAddress.add(p4,BorderLayout.CENTER);
   
   jpAddress.setBorder(new BevelBorder(BevelBorder.RAISED));//設定layout
   
   //按鈕欄位
   JPanel jpButton = new JPanel();
   jpButton.add(jbtAdd);
   jpButton.add(jbtFirst);
   jpButton.add(jbtNext);
   jpButton.add(jbtPrevious);
   jpButton.add(jbtLast);
   jpButton.add(jbtUpdate);

   //將按鈕與輸入欄位整合
   add(jpAddress,BorderLayout.CENTER);
   add(jpButton,BorderLayout.SOUTH);

   //加入按鈕動作

   jbtAdd.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     writeAddress(0);//輸入檔案
    }
   });

   jbtFirst.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      //顯示第一個檔案
      if(raf.length()>0)
       {
        readAddress(0);
        nowPostition = 0;
       } 
     }
     catch(IOException ex){   //如果沒有 顯示錯誤
      ex.printStackTrace();
     }
    }
   });

   //顯示下一個檔案
   jbtNext.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      long currentPostition = raf.getFilePointer();//目前指標為下一檔案開頭
      if(currentPostition < raf.length())//如果沒到檔案長度
       {
        readAddress(currentPostition);//讀取檔案
        nowPostition = currentPostition;//將指標更新
       }
     }
     catch(IOException ex){
      ex.printStackTrace();
     }
    }
   });

   jbtPrevious.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      long currentPostition = raf.getFilePointer();//目前指標為現在指標尾端
      if(currentPostition - 2*RECORD_SIZE > 0)//減去總長度*2為前一指標的頭
       {
        readAddress(currentPostition-2*2*RECORD_SIZE);
         nowPostition = currentPostition-2*2*RECORD_SIZE;
       }
      else
       {
        readAddress(0);//如果已到最前 那指標為零
        nowPostition = 0;
       }
     }
     catch(IOException ex){
      ex.printStackTrace();
     }
    }
   });

   
   jbtLast.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      long lastPostition = raf.length();//先將指標指向最後 再往前挪一次總欄位
      if(lastPostition >0)
       {
        readAddress(lastPostition - 2*RECORD_SIZE);
        nowPostition = lastPostition - 2*RECORD_SIZE;
       }
     }
     catch(IOException ex){
      ex.printStackTrace();
     }
    }
   });

   //更新資料
   jbtUpdate.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     nowPostition -= 2*RECORD_SIZE;//回去頭
     writeAddress(1);//覆蓋檔案
    }
   });


   try{
    if(raf.length()>0)
     readAddress(0);
   }
   catch(IOException ex){
    ex.printStackTrace();
   }
  }

 //寫入檔案
 public void writeAddress(int point)
  {
   try{
    if(point==0)
     raf.seek(raf.length());//指標指向
    else
     {
      //避免位址溢出
      if(nowPostition <=0)
       raf.seek(0);
      else
       raf.seek(nowPostition);
     }
    //輸入個欄位資料 不滿的長度轉為空格
    FixedLengthStringIO.writeFixedLengthString(jtfName.getText(),NAME_SIZE,raf);
    FixedLengthStringIO.writeFixedLengthString(jtfStreet.getText(),STREET_SIZE,raf);
    FixedLengthStringIO.writeFixedLengthString(jtfCity.getText(),CITY_SIZE,raf);
    FixedLengthStringIO.writeFixedLengthString(jtfState.getText(),STATE_SIZE,raf);
    FixedLengthStringIO.writeFixedLengthString(jtfZip.getText(),ZIP_SIZE,raf);
   }
   catch(IOException ex){
    ex.printStackTrace();
   }
  }

 //讀取檔案
 public void readAddress(long position) throws IOException
  {
   raf.seek(position);
   String name = FixedLengthStringIO.readFixedLengthString(NAME_SIZE,raf);
   String street = FixedLengthStringIO.readFixedLengthString(STREET_SIZE,raf);
   String city = FixedLengthStringIO.readFixedLengthString(CITY_SIZE,raf);
   String state = FixedLengthStringIO.readFixedLengthString(STATE_SIZE,raf);
   String zip = FixedLengthStringIO.readFixedLengthString(ZIP_SIZE,raf);
  
   //在各欄位顯示
   jtfName.setText(name);
   jtfStreet.setText(street);
   jtfCity.setText(city);
   jtfState.setText(state);
   jtfZip.setText(zip);
  }

 public static void main(String args[])
  {
   EX19_9 frame = new EX19_9();//宣告視窗
   frame.pack();//適合大小
   frame.setTitle("EX19_9");//標題
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}