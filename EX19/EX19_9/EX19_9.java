//updating count

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class EX19_9 extends JFrame
{
 //������
 final static int NAME_SIZE = 32;//�m�W��
 final static int STREET_SIZE = 32;//��D��
 final static int CITY_SIZE = 20; //������
 final static int STATE_SIZE = 2;//����
 final static int ZIP_SIZE = 5;//�l������
 //�`����
 final static int RECORD_SIZE = 
             ( NAME_SIZE + STREET_SIZE + CITY_SIZE + STATE_SIZE + ZIP_SIZE);

 private RandomAccessFile raf;//�ŧi�ɮ�Ū��

 //��J���
 private JTextField jtfName = new JTextField(NAME_SIZE);//�m�W
 private JTextField jtfStreet = new JTextField(STREET_SIZE);//��D
 private JTextField jtfCity = new JTextField(CITY_SIZE);//����
 private JTextField jtfState = new JTextField(STATE_SIZE);//�ϰ�
 private JTextField jtfZip = new JTextField(ZIP_SIZE);//�l����

 //���s
 private JButton jbtAdd = new JButton("Add");//�W�[���
 private JButton jbtFirst = new JButton("First");//�Ĥ@�Ӹ��
 private JButton jbtNext = new JButton("Next");//�U�@��
 private JButton jbtPrevious = new JButton("Previous");//�e�@��
 private JButton jbtLast = new JButton("Last");//�̫�@��
 private JButton jbtUpdate = new JButton("Update");//��s

 long nowPostition = 0;//�{�b��}

 public EX19_9()
  {
   try
    {
     raf = new RandomAccessFile("address.dat","rw");//�w�q�ɮ׿�J
    }
   catch(IOException ex)//�B�zŪ�����~
    {
     System.out.print("Error: "+ex);
     System.exit(0);
    }
   
   //������W��
   JPanel p1 = new JPanel();
   p1.setLayout(new GridLayout(3,1));
   p1.add(new JLabel("Name"));
   p1.add(new JLabel("Street"));
   p1.add(new JLabel("City")); 

   //��J�ϰ����   
   JPanel jpState = new JPanel();
   jpState.setLayout(new BorderLayout());
   jpState.add(new JLabel("State"),BorderLayout.WEST);
   jpState.add(jtfState,BorderLayout.CENTER);

   //��J�l�����
   JPanel jpZip = new JPanel();
   jpZip.setLayout(new BorderLayout());
   jpZip.add(new JLabel("Zip"),BorderLayout.WEST);
   jpZip.add(jtfZip,BorderLayout.CENTER);
 
   //�N�ϰ�P�l����X
   JPanel p2 = new JPanel();
   p2.setLayout(new BorderLayout());
   p2.add(jpState,BorderLayout.WEST);
   p2.add(jpZip,BorderLayout.CENTER);

   //�N������J���P�W����X
   JPanel p3 = new JPanel();
   p3.setLayout(new BorderLayout());
   p3.add(jtfCity,BorderLayout.CENTER);
   p3.add(p2,BorderLayout.EAST);

   //��X�m�W�P��D���
   JPanel p4 = new JPanel();
   p4.setLayout(new GridLayout(3,1));
   p4.add(jtfName);
   p4.add(jtfStreet);
   p4.add(p3);

   //�N�Ҧ���J����X
   JPanel jpAddress = new JPanel(new BorderLayout());
   jpAddress.add(p1,BorderLayout.WEST);
   jpAddress.add(p4,BorderLayout.CENTER);
   
   jpAddress.setBorder(new BevelBorder(BevelBorder.RAISED));//�]�wlayout
   
   //���s���
   JPanel jpButton = new JPanel();
   jpButton.add(jbtAdd);
   jpButton.add(jbtFirst);
   jpButton.add(jbtNext);
   jpButton.add(jbtPrevious);
   jpButton.add(jbtLast);
   jpButton.add(jbtUpdate);

   //�N���s�P��J����X
   add(jpAddress,BorderLayout.CENTER);
   add(jpButton,BorderLayout.SOUTH);

   //�[�J���s�ʧ@

   jbtAdd.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     writeAddress(0);//��J�ɮ�
    }
   });

   jbtFirst.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      //��ܲĤ@���ɮ�
      if(raf.length()>0)
       {
        readAddress(0);
        nowPostition = 0;
       } 
     }
     catch(IOException ex){   //�p�G�S�� ��ܿ��~
      ex.printStackTrace();
     }
    }
   });

   //��ܤU�@���ɮ�
   jbtNext.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     try{
      long currentPostition = raf.getFilePointer();//�ثe���Ь��U�@�ɮ׶}�Y
      if(currentPostition < raf.length())//�p�G�S���ɮת���
       {
        readAddress(currentPostition);//Ū���ɮ�
        nowPostition = currentPostition;//�N���Ч�s
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
      long currentPostition = raf.getFilePointer();//�ثe���Ь��{�b���Ч���
      if(currentPostition - 2*RECORD_SIZE > 0)//��h�`����*2���e�@���Ъ��Y
       {
        readAddress(currentPostition-2*2*RECORD_SIZE);
         nowPostition = currentPostition-2*2*RECORD_SIZE;
       }
      else
       {
        readAddress(0);//�p�G�w��̫e �����Ь��s
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
      long lastPostition = raf.length();//���N���Ы��V�̫� �A���e���@���`���
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

   //��s���
   jbtUpdate.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     nowPostition -= 2*RECORD_SIZE;//�^�h�Y
     writeAddress(1);//�л\�ɮ�
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

 //�g�J�ɮ�
 public void writeAddress(int point)
  {
   try{
    if(point==0)
     raf.seek(raf.length());//���Ы��V
    else
     {
      //�קK��}���X
      if(nowPostition <=0)
       raf.seek(0);
      else
       raf.seek(nowPostition);
     }
    //��J������� �����������ର�Ů�
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

 //Ū���ɮ�
 public void readAddress(long position) throws IOException
  {
   raf.seek(position);
   String name = FixedLengthStringIO.readFixedLengthString(NAME_SIZE,raf);
   String street = FixedLengthStringIO.readFixedLengthString(STREET_SIZE,raf);
   String city = FixedLengthStringIO.readFixedLengthString(CITY_SIZE,raf);
   String state = FixedLengthStringIO.readFixedLengthString(STATE_SIZE,raf);
   String zip = FixedLengthStringIO.readFixedLengthString(ZIP_SIZE,raf);
  
   //�b�U������
   jtfName.setText(name);
   jtfStreet.setText(street);
   jtfCity.setText(city);
   jtfState.setText(state);
   jtfZip.setText(zip);
  }

 public static void main(String args[])
  {
   EX19_9 frame = new EX19_9();//�ŧi����
   frame.pack();//�A�X�j�p
   frame.setTitle("EX19_9");//���D
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}