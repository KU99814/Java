//Creating a stock ticker in an client

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class EX30_5_Client extends JFrame
{
 JLabel label = new JLabel(new ImageIcon("redTicker.gif"));//��ܹϤ�label
 int labelStatus = 0;//label���A

 StockTicker ST = new StockTicker();//��ܪѻ�panel
 Timer timer = new Timer(1000,new TimeAction());//�p�ɾ�

 public EX30_5_Client()
  {
   //�[�J�ƹ��ƥ�
   addMouseListener(new MouseAdapter(){
    //���U�ƥ�
    public void mousePressed(MouseEvent e){
     timer.stop();
    }

    public void mouseReleased(MouseEvent e){
     //����ƥ�
     timer.start();
    }
   });

   setLayout(new GridLayout(2,1));//�]�w�ƪ�
   //�[�J����
   add(label);
   add(ST);
   timer.start();//�}�l�p��
  }

 public static void main(String args[])
  {
   EX30_5_Client frame = new EX30_5_Client();//�ŧiframe

   frame.setTitle("EX30_5_Client");//���D
   frame.setSize(600,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�p�ɾ�class
 class TimeAction implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     //�����A�C������label�Ϥ�
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

 //�ѻ�panel
 class StockTicker extends JPanel
  {
   //��r���e
   private int textW = 300;
   private int textH = getHeight();

   //����ݩ�
   private double[] change = new double[5];//���^
   private String[] name = new String[5];//�W�r
   private String[] currentTime = new String[5];//�{�b�ɶ�
   private double[] previousDay = new double[5];//�e��ѻ�

   public StockTicker()
    {
     try{
      Socket socket = new Socket("localhost",8000);//socket
      
      //�����ɮ�
      DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
   
      //�����ɮ�
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

     //�N�������ɮ�ø�X
     for(int i=0;i<5;i++)
      {
       String s;

       //���^�лx
       if(change[i]>=0)
        {
         s = "��";
         g.setColor(Color.red);
        }
       else
        {
         s = "��";
         g.setColor(Color.green);
        }

       //ø�X��r
       g.drawString(name[i]+" "+currentTime[i]+" " ,textW+(i-3)*100,90);
       g.drawString(previousDay[i]+" "+Math.abs(change[i])+" "+s+" ",
                    textW+(i-3)*100,100);
      }
    }
  }
}