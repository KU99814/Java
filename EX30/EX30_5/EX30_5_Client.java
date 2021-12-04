//Creating a stock ticker in an client

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class EX30_5_Client extends JFrame
{
 JLabel label = new JLabel(new ImageIcon("redTicker.gif"));//顯示圖片label
 int labelStatus = 0;//label狀態

 StockTicker ST = new StockTicker();//顯示股價panel
 Timer timer = new Timer(1000,new TimeAction());//計時器

 public EX30_5_Client()
  {
   //加入滑鼠事件
   addMouseListener(new MouseAdapter(){
    //按下事件
    public void mousePressed(MouseEvent e){
     timer.stop();
    }

    public void mouseReleased(MouseEvent e){
     //釋放事件
     timer.start();
    }
   });

   setLayout(new GridLayout(2,1));//設定排版
   //加入元件
   add(label);
   add(ST);
   timer.start();//開始計時
  }

 public static void main(String args[])
  {
   EX30_5_Client frame = new EX30_5_Client();//宣告frame

   frame.setTitle("EX30_5_Client");//標題
   frame.setSize(600,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //計時器class
 class TimeAction implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     //按狀態每次改變label圖片
     if(labelStatus==0)
      {
       label.setIcon(new ImageIcon("redTicker.gif"));
       labelStatus = 1;
      }
     else
      {
       label.setIcon(new ImageIcon("blackTicker.gif"));
       labelStatus = 0;
      }
    }
  }

 //股價panel
 class StockTicker extends JPanel
  {
   //文字長寬
   private int textW = 300;
   private int textH = getHeight();

   //顯示屬性
   private double[] change = new double[5];//漲跌
   private String[] name = new String[5];//名字
   private String[] currentTime = new String[5];//現在時間
   private double[] previousDay = new double[5];//前日股價

   public StockTicker()
    {
     try{
      Socket socket = new Socket("localhost",8000);//socket
      
      //接收檔案
      DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
   
      //接收檔案
      for(int i=0;i<5;i++)
       {
        name[i] = inputFromServer.readUTF();
        currentTime[i] = inputFromServer.readUTF();
        previousDay[i] = inputFromServer.readDouble();
        change[i] = inputFromServer.readDouble();
       }
     }
     catch(IOException ex){
      System.err.println(ex);
     }
    }

   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //將接收的檔案繪出
     for(int i=0;i<5;i++)
      {
       String s;

       //漲跌標誌
       if(change[i]>=0)
        {
         s = "↑";
         g.setColor(Color.red);
        }
       else
        {
         s = "↓";
         g.setColor(Color.green);
        }

       //繪出文字
       g.drawString(name[i]+" "+currentTime[i]+" " ,textW+(i-3)*100,90);
       g.drawString(previousDay[i]+" "+Math.abs(change[i])+" "+s+" ",
                    textW+(i-3)*100,100);
      }
    }
  }
}