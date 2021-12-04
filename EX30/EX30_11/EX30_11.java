//web browser

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import javax.swing.event.*;
import java.io.*;

public class EX30_11 extends JFrame
{
 private JEditorPane jep = new JEditorPane();//��ܺ���

 //��J���}
 private JLabel jlblURL = new JLabel("URL");
 private JTextField jtfURL = new JTextField(32);

 private JButton jbtLocal = new JButton("Local");//���a�귽���s
 private JButton jbtRemote = new JButton("Remote");//���ݸ귽���s

 public EX30_11()
  {
   //�[�Jcomponent
   JPanel jpURL = new JPanel();
   jpURL.setLayout(new BorderLayout());
   jpURL.add(jlblURL,BorderLayout.WEST);
   jpURL.add(jtfURL,BorderLayout.CENTER);

   JScrollPane jspViewer = new JScrollPane();
   jspViewer.getViewport().add(jep,null);

   JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
   btnPanel.add(jbtLocal);
   btnPanel.add(jbtRemote);
   
   //�ƪ�
   add(jspViewer,BorderLayout.CENTER);
   add(jpURL,BorderLayout.NORTH);
   add(btnPanel,BorderLayout.SOUTH);

   jep.setEditable(false);

   //���U
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

   //���U���a���s
   jbtLocal.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      //���o���a�ɮ�URL
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
      //���o����URL
      String urlText = jtfURL.getText().trim();   

      //�Y��www�}�Y �[�Whttp:\\�ӳs�u
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
   frame.setTitle("EX30_11");//���D
   frame.setSize(600,400);//�j�p
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setVisible(true);//���
  }
}