//web browser

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import javax.swing.event.*;
import java.io.*;

public class EX30_11 extends JFrame
{
 private JEditorPane jep = new JEditorPane();//顯示網頁

 //輸入網址
 private JLabel jlblURL = new JLabel("URL");
 private JTextField jtfURL = new JTextField(32);

 private JButton jbtLocal = new JButton("Local");//本地資源按鈕
 private JButton jbtRemote = new JButton("Remote");//遠端資源按鈕

 public EX30_11()
  {
   //加入component
   JPanel jpURL = new JPanel();
   jpURL.setLayout(new BorderLayout());
   jpURL.add(jlblURL,BorderLayout.WEST);
   jpURL.add(jtfURL,BorderLayout.CENTER);

   JScrollPane jspViewer = new JScrollPane();
   jspViewer.getViewport().add(jep,null);

   JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
   btnPanel.add(jbtLocal);
   btnPanel.add(jbtRemote);
   
   //排版
   add(jspViewer,BorderLayout.CENTER);
   add(jpURL,BorderLayout.NORTH);
   add(btnPanel,BorderLayout.SOUTH);

   jep.setEditable(false);

   //註冊
   jep.addHyperlinkListener(new HyperlinkListener(){
    public void hyperlinkUpdate(HyperlinkEvent e){
     try{
      jep.setPage(e.getURL());
     }
     catch(IOException ex){
      System.out.println(ex);
     }
    }
   });

   //註冊本地按鈕
   jbtLocal.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      //取得本地檔案URL
      URL url = new File(jtfURL.getText().trim()).toURI().toURL();
      
      jep.setPage(url);
     }
     catch(IOException ex){
      System.out.println(ex);
     }
    }
   });

   jbtRemote.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      //取得遠端URL
      String urlText = jtfURL.getText().trim();   

      //若為www開頭 加上http:\\來連線
      if(urlText.substring(0,4).equals("www."))
       {
        urlText = "http://" + urlText;
       }
      
      URL url = new URL(urlText);
      jep.setPage(url);
     }
     catch(IOException ex){
      System.out.println(ex);
     }
    }
   });
  }

 public static void main(String args[])
  {
   EX30_11 frame = new EX30_11();//frame
   frame.setTitle("EX30_11");//標題
   frame.setSize(600,400);//大小
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setLocationRelativeTo(null);//相對位置
   frame.setVisible(true);//顯示
  }
}