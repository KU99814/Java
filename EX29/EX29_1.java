//Task thread demo by text area

import javax.swing.*;
import java.util.concurrent.*;

public class EX29_1 extends JFrame
{
 private JTextArea jta = new JTextArea();//��ܪ�text area
 private String s = "";//��Jtext area���r��

 public EX29_1()
  {
   //�]�w�۰ʴ���
   jta.setWrapStyleWord(true);
   jta.setLineWrap(true);

   add(new JScrollPane(jta));//�Ntext area�[�J��frame

   //�Ыبð���thread
   new Thread(new PrintChar('a',200)).start();
   new Thread(new PrintChar('b',200)).start();
   new Thread(new PrintNum(200)).start();
  }

 //�L�X�r����task
 class PrintChar implements Runnable
  {
   private char c;//�L�X���r��
   private int time;//�L�X�r���ƶq
   
   //constructor
   public PrintChar(char c,int time)
    {
     //��l�Ʀr���P�ƶq
     this.c = c;
     this.time = time;
    }
   
   //����
   //�N�r���[��r�ꤤ �æbtext area���
   public void run()
    {
     //�קK���۪��j ��synchronized����s��
     synchronized(s){
      for(int i=0;i<time;i++)
       {
        s+=c+" ";
        jta.setText(s);
       }
     }
    }
  }
 
 //�q1�}�l�L�X�Ʀr������w���Ʀr
 class PrintNum implements Runnable
  {
   private int num;//���w���ؼмƦr
   
   //constructor
   public PrintNum(int num)
    {
     //��l��num
     this.num = num;
    }

   //����
   //�N�Ʀr�̧ǥ[�Jtext area
   public void run()
    {
     //�קK���۪��j ��synchronized����s��
     synchronized(s){
      for(int i=1;i<=num;i++)
       {
         s+=""+i+" ";
         jta.setText(s);          
       }
     }
    }
  }

 public static void main(String args[])
  {
   //�]���ϥΦh������� �NGUI��ܦb�������槹����
   SwingUtilities.invokeLater(new Runnable(){
     public void run(){
      EX29_1 frame = new EX29_1();//�Ы�frame����
      frame.setTitle("EX29_1");//���D
      frame.setSize(600,400);//�����j�p
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
      frame.setLocationRelativeTo(null);//�۹��m
      frame.setVisible(true);//���
     }
    }
   );
  }
}