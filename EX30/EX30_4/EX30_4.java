//Looking up IP information with InetAddress

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.net.*;
import java.io.*;

public class EX30_4 extends JFrame
{
 private JTextField jtfIP = new JTextField(20);//��ܥ��aIP
 private JTextField jtfLocalHost = new JTextField(20);//��ܥ��a�W��
 
 private JTextField jtfInputHost = new JTextField(15);//��Jhost name
 private JButton jbLookUp = new JButton("Lookup");//������oIP

 private JLabel jIPAddress = new JLabel();//address label
 private JLabel jReachable = new JLabel();//reachable

 private JButton jbExit = new JButton("Exit");//���}���s
 
 public EX30_4()
  {
   //Local Host Information panel
   JPanel pLocal = new JPanel(new GridLayout(3,2));

   //�[�J����
   pLocal.add(new JLabel("Local Host IP  "));
   pLocal.add(jtfIP);//�[�J���IP
   pLocal.add(new JLabel(""));//�ƪ���
   pLocal.add(new JLabel(""));//�ƪ���
   pLocal.add(new JLabel("Local Host Name "));
   pLocal.add(jtfLocalHost);//�[�J���host name

   //�]�wLocal���
   pLocal.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1),"Local Host Information"));
   
   JPanel pRemote = new JPanel(new BorderLayout());//Remote panel
   JPanel pInput = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));//��Jpanel
   JPanel pOutput = new JPanel(new GridLayout(2,2));//��Xpanel

   //��Jpanel�]�w
   pInput.add(new JLabel("Input host name "));
   pInput.add(jtfInputHost);//�[�J��J��
   pInput.add(jbLookUp);//�[�J���s
   
   //��Xpanel�]�w
   pOutput.add(new JLabel("Host IP Address: "));
   pOutput.add(jIPAddress);//�[�J���IP
   pOutput.add(new JLabel("Host is reachable: "));
   pOutput.add(jReachable);//�[�J���reachable

   pRemote.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1),"Remote Host Information"));

   //Remote panel�]�w
   pRemote.setLayout(new BorderLayout());
   pRemote.add(pInput,BorderLayout.NORTH);
   pRemote.add(pOutput,BorderLayout.CENTER);   

   //���}���spanel
   JPanel pExit = new JPanel(new FlowLayout(FlowLayout.RIGHT));
   pExit.add(jbExit);//�[�J���s

   //�]�w����
   setLayout(new BorderLayout());
   add(pLocal,BorderLayout.NORTH);
   add(pRemote,BorderLayout.CENTER);
   add(pExit,BorderLayout.SOUTH);

   try{
    InetAddress localAddress = InetAddress.getLocalHost();//���a��}
    jtfIP.setText(localAddress.getHostAddress());//���aIP
    jtfLocalHost.setText(localAddress.getHostName());//���a�W��
   }
   catch(UnknownHostException ex)
   {
    System.err.println("Unknown host IP address");
   }
   
   //�j�M��}���s�ƥ�
   jbLookUp.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      InetAddress hostAddress = InetAddress.getByName(jtfInputHost.getText());//�D����}

      //�]�w�Y5�����o ���
      if(hostAddress.isReachable(5000))
       {
        jIPAddress.setText(hostAddress.getHostAddress());
        jReachable.setText("host reached");
       }
      else
       {
        jIPAddress.setText("Not get IP");
        jReachable.setText("host did not repond within 5 seconds");//�W�L5��X�{
       }
     }
     catch(UnknownHostException ex){
      jIPAddress.setText("Not get IP");//�����o�|�X�{�ҥ~�ƥ�
     }
     catch(IOException ex){
      jReachable.setText("host did not repond within 5 seconds");//�W�L5��X�{�ҥ~�ƥ�
     }
    }
   });

   //���}���s�ƥ�
   jbExit.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     setVisible(false); //you can't see me!
     dispose(); //Destroy the JFrame object
    }
   });
  }

 public static void main(String args[])
  {
   EX30_4 frame = new EX30_4();//frame����
   
   frame.setTitle("EX30_4");//���D
   frame.setSize(400,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}