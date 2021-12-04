//Retrieving remote files

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;

public class EX30_9 extends JFrame
{
 private JButton jbtView = new JButton("View");//顯示按鈕

 private JTextField jtfURL = new JTextField(12);//輸入網址
 
 private JEditorPane jep = new JEditorPane();//顯示HTML

 private JLabel jlblStatus = new JLabel();//狀態欄

 public EX30_9()
  {
   //輸入網址欄位
   JPanel p1 = new JPanel();
   p1.setLayout(new BorderLayout());
   p1.add(new JLabel("Filename"),BorderLayout.WEST);
   p1.add(jtfURL,BorderLayout.CENTER);
   p1.add(jbtView,BorderLayout.EAST);

   //顯示HTML欄位
   JScrollPane jspViewr = new JScrollPane();
   jspViewr.getViewport().add(jep,null);
   jep.setEditable(false);   

   setLayout(new BorderLayout());
   add(jspViewr,BorderLayout.CENTER);
   add(p1,BorderLayout.NORTH);
   add(jlblStatus,BorderLayout.SOUTH);

   //顯示按鈕事件
   jbtView.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     showFile();
    }
   });
  }

 public static void main(String args[])
  {
   EX30_9 frame = new EX30_9();//創建frame
   
   frame.setTitle("EX30_9");//標題
   frame.setSize(500,200);//大小
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setLocationRelativeTo(null);//相對位置
   frame.setVisible(true);//顯示
  }

 //顯示得到文件
 private void showFile()
  {
   URL url = null;//URL
 
   try{
    url = new URL(jtfURL.getText().trim());//取得URL
    
    InputStream is = url.openStream();//取得檔案
    jep.read(is,null);//輸入檔案

    jlblStatus.setText("File loaded successfully");//顯示成功狀態
   }
   catch(FileNotFoundException e){
    jlblStatus.setText("URL" + url+" not found.");
   }
   catch(IOException e){
    jlblStatus.setText(e.getMessage());
   }
  }
}