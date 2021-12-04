//Display and adding address
//client

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class EX30_6_Client extends JFrame
{
 private JTextField jtfName = new JTextField(32);//姓名欄位
 private JTextField jtfStreet = new JTextField(32);//街道欄位
 private JTextField jtfCity = new JTextField(20);//城市欄位
 private JTextField jtfState = new JTextField(2);//街區欄位
 private JTextField jtfZip = new JTextField(5);//郵件位址欄位

 //按鈕
 private JButton jbtAdd = new JButton("Add");//加入檔案
 private JButton jbtFirst = new JButton("First");//顯示最初
 private JButton jbtNext = new JButton("Next");//顯示下一個
 private JButton jbtPrevious = new JButton("Previous");//顯示前一個
 private JButton jbtLast = new JButton("Last");//顯示最後一個
 
 private boolean goToLast = true;//判斷是否到最後一個
 private boolean saveDate = true;//判斷是否存取檔案

 private int index = 0;//目前index

 String host = "localhost";

 public EX30_6_Client()
  {
   //設置輸入panel
   JPanel p1 = new JPanel();
   p1.setLayout(new GridLayout(3,1));
   p1.add(new JLabel("Name"));
   p1.add(new JLabel("Street"));
   p1.add(new JLabel("City"));

   JPanel jpState = new JPanel();
   jpState.setLayout(new BorderLayout());
   jpState.add(new JLabel("State"),BorderLayout.WEST);
   jpState.add(jtfState,BorderLayout.CENTER);

   JPanel jpZip = new JPanel();
   jpZip.setLayout(new BorderLayout());
   jpZip.add(new JLabel("Zip"),BorderLayout.WEST);
   jpZip.add(jtfZip,BorderLayout.CENTER);

   JPanel p2 = new JPanel();
   p2.setLayout(new BorderLayout());
   p2.add(jpState,BorderLayout.WEST);
   p2.add(jpZip,BorderLayout.CENTER);

   JPanel p3 = new JPanel();
   p3.setLayout(new BorderLayout());
   p3.add(jtfCity,BorderLayout.CENTER);
   p3.add(p2,BorderLayout.EAST);

   JPanel p4 = new JPanel();
   p4.setLayout(new GridLayout(3,1));
   p4.add(jtfName);
   p4.add(jtfStreet);
   p4.add(p3);

   //設置按鈕
   JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   p5.add(jbtAdd);
   p5.add(jbtFirst);
   p5.add(jbtNext);
   p5.add(jbtPrevious);
   p5.add(jbtLast);

   //整合panel   
   JPanel studentPanel = new JPanel(new BorderLayout());
   studentPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
   studentPanel.add(p1,BorderLayout.WEST);
   studentPanel.add(p4,BorderLayout.CENTER);

   add(studentPanel,BorderLayout.CENTER);
   add(p5,BorderLayout.SOUTH);

   //輸入按鈕事件
   jbtAdd.addActionListener(new AddButtonListener());

   //搜尋按鈕事件
   //第一個
   jbtFirst.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      index = 0;
      goToLast = false;
      saveDate = false;
      getAddress();
     }
   });

   //找下一個
   jbtNext.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      index++;
      goToLast = false;
      saveDate = false;
      getAddress();
     }
   });

   //找前一個
   jbtPrevious.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      index--;
      goToLast = false;
      saveDate = false;
      getAddress();
     }
   });
   
   //找最後一個
   jbtLast.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      goToLast = true;
      saveDate = false;
      getAddress();
     }
   });
  }

 //輸入事件
 private class AddButtonListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     try{
      Socket socket = new Socket(host,8000);

      goToLast = false;
      saveDate = true;

      //向server輸入資料      
      ObjectOutputStream toServer =
       new ObjectOutputStream(socket.getOutputStream());

      //物件需要資料
      String name = jtfName.getText().trim();
      String street = jtfStreet.getText().trim();
      String city = jtfCity.getText().trim();
      String state = jtfState.getText().trim();
      String zip = jtfZip.getText().trim();

      StudentAddress s = new StudentAddress(name,street,city,state,zip);//創建物件

      //傳輸物件      
      toServer.writeBoolean(saveDate);
      toServer.writeObject(s);
      toServer.flush();
     }
     catch(IOException ex){
      System.err.println(ex);
     }
    }
  }

 //尋找顯示資料
 public void getAddress()
  {
   try{
    Socket socket = new Socket(host,8000);

    //向server傳送
    ObjectOutputStream toServer =
     new ObjectOutputStream(socket.getOutputStream());
      
    //自server接收
    ObjectInputStream fromServer =
     new ObjectInputStream(socket.getInputStream());

    //傳送判斷用變數
    toServer.writeBoolean(saveDate);
    toServer.flush();
    toServer.writeBoolean(goToLast);
    toServer.flush();
    toServer.writeInt(index);
    toServer.flush();

    //接收資料      
    Object objectData = fromServer.readObject();
    StudentAddress s = (StudentAddress)objectData;
    
    //顯示資料
    jtfName.setText(s.getName());
    jtfStreet.setText(s.getStreet());
    jtfCity.setText(s.getCity());
    jtfState.setText(s.getState());
    jtfZip.setText(s.getZip());
      
    index = fromServer.readInt();//接收目前index
   }
   catch(IOException ex){
    System.err.println(ex);
   }
   catch(ClassNotFoundException ex){
    System.err.println(ex);
   }
  }

 public static void main(String args[])
  {
   EX30_6_Client frame = new EX30_6_Client();//創建frame
   
   frame.setTitle("StudentClient");//標題
   frame.setSize(500,150);//大小
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setLocationRelativeTo(null);//相對位置
   frame.setVisible(true);//顯示
  }
}