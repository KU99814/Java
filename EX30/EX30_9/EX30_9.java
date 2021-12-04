//Retrieving remote files

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;

public class EX30_9 extends JFrame
{
 private JButton jbtView = new JButton("View");//��ܫ��s

 private JTextField jtfURL = new JTextField(12);//��J���}
 
 private JEditorPane jep = new JEditorPane();//���HTML

 private JLabel jlblStatus = new JLabel();//���A��

 public EX30_9()
  {
   //��J���}���
   JPanel p1 = new JPanel();
   p1.setLayout(new BorderLayout());
   p1.add(new JLabel("Filename"),BorderLayout.WEST);
   p1.add(jtfURL,BorderLayout.CENTER);
   p1.add(jbtView,BorderLayout.EAST);

   //���HTML���
   JScrollPane jspViewr = new JScrollPane();
   jspViewr.getViewport().add(jep,null);
   jep.setEditable(false);   

   setLayout(new BorderLayout());
   add(jspViewr,BorderLayout.CENTER);
   add(p1,BorderLayout.NORTH);
   add(jlblStatus,BorderLayout.SOUTH);

   //��ܫ��s�ƥ�
   jbtView.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     showFile();
    }
   });
  }

 public static void main(String args[])
  {
   EX30_9 frame = new EX30_9();//�Ы�frame
   
   frame.setTitle("EX30_9");//���D
   frame.setSize(500,200);//�j�p
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setVisible(true);//���
  }

 //��ܱo����
 private void showFile()
  {
   URL url = null;//URL
 
   try{
    url = new URL(jtfURL.getText().trim());//���oURL
    
    InputStream is = url.openStream();//���o�ɮ�
    jep.read(is,null);//��J�ɮ�

    jlblStatus.setText("File loaded successfully");//��ܦ��\���A
   }
   catch(FileNotFoundException e){
    jlblStatus.setText("URL" + url+" not found.");
   }
   catch(IOException e){
    jlblStatus.setText(e.getMessage());
   }
  }
}