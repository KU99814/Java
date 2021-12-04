//Looking up IP information with InetAddress

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.net.*;
import java.io.*;

public class EX30_4 extends JFrame
{
 private JTextField jtfIP = new JTextField(20);//顯示本地IP
 private JTextField jtfLocalHost = new JTextField(20);//顯示本地名稱
 
 private JTextField jtfInputHost = new JTextField(15);//輸入host name
 private JButton jbLookUp = new JButton("Lookup");//執行取得IP

 private JLabel jIPAddress = new JLabel();//address label
 private JLabel jReachable = new JLabel();//reachable

 private JButton jbExit = new JButton("Exit");//離開按鈕
 
 public EX30_4()
  {
   //Local Host Information panel
   JPanel pLocal = new JPanel(new GridLayout(3,2));

   //加入元件
   pLocal.add(new JLabel("Local Host IP  "));
   pLocal.add(jtfIP);//加入顯示IP
   pLocal.add(new JLabel(""));//排版用
   pLocal.add(new JLabel(""));//排版用
   pLocal.add(new JLabel("Local Host Name "));
   pLocal.add(jtfLocalHost);//加入顯示host name

   //設定Local邊框
   pLocal.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1),"Local Host Information"));
   
   JPanel pRemote = new JPanel(new BorderLayout());//Remote panel
   JPanel pInput = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));//輸入panel
   JPanel pOutput = new JPanel(new GridLayout(2,2));//輸出panel

   //輸入panel設定
   pInput.add(new JLabel("Input host name "));
   pInput.add(jtfInputHost);//加入輸入欄
   pInput.add(jbLookUp);//加入按鈕
   
   //輸出panel設定
   pOutput.add(new JLabel("Host IP Address: "));
   pOutput.add(jIPAddress);//加入顯示IP
   pOutput.add(new JLabel("Host is reachable: "));
   pOutput.add(jReachable);//加入顯示reachable

   pRemote.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1),"Remote Host Information"));

   //Remote panel設定
   pRemote.setLayout(new BorderLayout());
   pRemote.add(pInput,BorderLayout.NORTH);
   pRemote.add(pOutput,BorderLayout.CENTER);   

   //離開按鈕panel
   JPanel pExit = new JPanel(new FlowLayout(FlowLayout.RIGHT));
   pExit.add(jbExit);//加入按鈕

   //設定版面
   setLayout(new BorderLayout());
   add(pLocal,BorderLayout.NORTH);
   add(pRemote,BorderLayout.CENTER);
   add(pExit,BorderLayout.SOUTH);

   try{
    InetAddress localAddress = InetAddress.getLocalHost();//本地位址
    jtfIP.setText(localAddress.getHostAddress());//本地IP
    jtfLocalHost.setText(localAddress.getHostName());//本地名稱
   }
   catch(UnknownHostException ex)
   {
    System.err.println("Unknown host IP address");
   }
   
   //搜尋位址按鈕事件
   jbLookUp.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      InetAddress hostAddress = InetAddress.getByName(jtfInputHost.getText());//主機位址

      //設定若5秒內取得 顯示
      if(hostAddress.isReachable(5000))
       {
        jIPAddress.setText(hostAddress.getHostAddress());
        jReachable.setText("host reached");
       }
      else
       {
        jIPAddress.setText("Not get IP");
        jReachable.setText("host did not repond within 5 seconds");//超過5秒出現
       }
     }
     catch(UnknownHostException ex){
      jIPAddress.setText("Not get IP");//未取得會出現例外事件
     }
     catch(IOException ex){
      jReachable.setText("host did not repond within 5 seconds");//超過5秒出現例外事件
     }
    }
   });

   //離開按鈕事件
   jbExit.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     setVisible(false); //you can't see me!
     dispose(); //Destroy the JFrame object
    }
   });
  }

 public static void main(String args[])
  {
   EX30_4 frame = new EX30_4();//frame物件
   
   frame.setTitle("EX30_4");//標題
   frame.setSize(400,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}