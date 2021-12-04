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
 private JTextField jtfName = new JTextField(32);//�m�W���
 private JTextField jtfStreet = new JTextField(32);//��D���
 private JTextField jtfCity = new JTextField(20);//�������
 private JTextField jtfState = new JTextField(2);//������
 private JTextField jtfZip = new JTextField(5);//�l���}���

 //���s
 private JButton jbtAdd = new JButton("Add");//�[�J�ɮ�
 private JButton jbtFirst = new JButton("First");//��̪ܳ�
 private JButton jbtNext = new JButton("Next");//��ܤU�@��
 private JButton jbtPrevious = new JButton("Previous");//��ܫe�@��
 private JButton jbtLast = new JButton("Last");//��̫ܳ�@��
 
 private boolean goToLast = true;//�P�_�O�_��̫�@��
 private boolean saveDate = true;//�P�_�O�_�s���ɮ�

 private int index = 0;//�ثeindex

 String host = "localhost";

 public EX30_6_Client()
  {
   //�]�m��Jpanel
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

   //�]�m���s
   JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   p5.add(jbtAdd);
   p5.add(jbtFirst);
   p5.add(jbtNext);
   p5.add(jbtPrevious);
   p5.add(jbtLast);

   //��Xpanel   
   JPanel studentPanel = new JPanel(new BorderLayout());
   studentPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
   studentPanel.add(p1,BorderLayout.WEST);
   studentPanel.add(p4,BorderLayout.CENTER);

   add(studentPanel,BorderLayout.CENTER);
   add(p5,BorderLayout.SOUTH);

   //��J���s�ƥ�
   jbtAdd.addActionListener(new AddButtonListener());

   //�j�M���s�ƥ�
   //�Ĥ@��
   jbtFirst.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      index = 0;
      goToLast = false;
      saveDate = false;
      getAddress();
     }
   });

   //��U�@��
   jbtNext.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      index++;
      goToLast = false;
      saveDate = false;
      getAddress();
     }
   });

   //��e�@��
   jbtPrevious.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      index--;
      goToLast = false;
      saveDate = false;
      getAddress();
     }
   });
   
   //��̫�@��
   jbtLast.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      goToLast = true;
      saveDate = false;
      getAddress();
     }
   });
  }

 //��J�ƥ�
 private class AddButtonListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     try{
      Socket socket = new Socket(host,8000);

      goToLast = false;
      saveDate = true;

      //�Vserver��J���      
      ObjectOutputStream toServer =
       new ObjectOutputStream(socket.getOutputStream());

      //����ݭn���
      String name = jtfName.getText().trim();
      String street = jtfStreet.getText().trim();
      String city = jtfCity.getText().trim();
      String state = jtfState.getText().trim();
      String zip = jtfZip.getText().trim();

      StudentAddress s = new StudentAddress(name,street,city,state,zip);//�Ыت���

      //�ǿ骫��      
      toServer.writeBoolean(saveDate);
      toServer.writeObject(s);
      toServer.flush();
     }
     catch(IOException ex){
      System.err.println(ex);
     }
    }
  }

 //�M����ܸ��
 public void getAddress()
  {
   try{
    Socket socket = new Socket(host,8000);

    //�Vserver�ǰe
    ObjectOutputStream toServer =
     new ObjectOutputStream(socket.getOutputStream());
      
    //��server����
    ObjectInputStream fromServer =
     new ObjectInputStream(socket.getInputStream());

    //�ǰe�P�_���ܼ�
    toServer.writeBoolean(saveDate);
    toServer.flush();
    toServer.writeBoolean(goToLast);
    toServer.flush();
    toServer.writeInt(index);
    toServer.flush();

    //�������      
    Object objectData = fromServer.readObject();
    StudentAddress s = (StudentAddress)objectData;
    
    //��ܸ��
    jtfName.setText(s.getName());
    jtfStreet.setText(s.getStreet());
    jtfCity.setText(s.getCity());
    jtfState.setText(s.getState());
    jtfZip.setText(s.getZip());
      
    index = fromServer.readInt();//�����ثeindex
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
   EX30_6_Client frame = new EX30_6_Client();//�Ы�frame
   
   frame.setTitle("StudentClient");//���D
   frame.setSize(500,150);//�j�p
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setVisible(true);//���
  }
}