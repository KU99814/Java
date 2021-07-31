//sort panel with thread

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX29_13 extends JFrame
{ 
 //��ܱƧ�panel
 private SortPanel selectionSort = new SortPanel("Selection Sort");//selection sort panel
 private SortPanel insertionSort = new SortPanel("Insertion Sort");//Insertion Sort panel
 private SortPanel bubbleSort = new SortPanel("Bubble Sort");//Bubble Sort panel

 private static int sleepTime = 100;

 public EX29_13()
  {
   setLayout(new GridLayout(1,3,1,1));//�]�w�ƪ�

   //�[�Jpanel
   add(selectionSort);
   add(insertionSort);
   add(bubbleSort);

   ExecutorService executor = Executors.newFixedThreadPool(3);//thread pool

   //thread
   executor.execute(new SelectionSortTask(selectionSort));
   executor.execute(new InsertionSortTask(insertionSort));
   executor.execute(new BubbleSortTask(bubbleSort));

   executor.shutdown();
  }

 //sort panel 
 //��ܱƧ�
 class SortPanel extends JPanel
  {
   private int[] num = new int[50];//�ƦC�}�C
   private String title;//���D����

   //constructor
   public SortPanel(String title)
    {
     this.title = title;

     for(int i=0;i<num.length;i++)
      num[i] = (int)(Math.random()*100+1);
    }

   //�^�ǰ}�C
   public synchronized int[] getArray()
    {
     return num;
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //panel ���e
     int height = getHeight();
     int width = getWidth();
     
     //�C�@���������j�e
     int wdis = width/50;
     int hdis = height/100;//��찪

     //ø�X�C�@�ƥN������     
     for(int i=0;i<num.length;i++)
      {
       g.drawRect(wdis*i,height-hdis*num[i],wdis,hdis*num[i]);
      }

     //ø�X���D
     g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
     g.drawString(title,wdis*20,30);
    }
  }

 //selection sort task
 class SelectionSortTask implements Runnable
  {
   private int[] num;//�ݱƧǼƦC�}�C
   private SortPanel p;//���panel

   //constructor
   public SelectionSortTask(SortPanel p)
    {
     this.p = p;
     num = p.getArray();
    }

   //����
   public void run()
    {
     try{
      for(int i=num.length-1;i>0;i--)
       {
        int max = i;//�̤j�ƪ�index

        for(int j=0;j<i;j++)
         {
          //����X�ƦC���̤j�ƪ�index
          if(num[j]>num[max])
           max = j;
         }

        //�洫
        if(max!=i)
         {
          int temp = num[i];
          num[i] = num[max];
          num[max] = temp;
          p.repaint();//��ø
          Thread.sleep(sleepTime);//��v
         }
       }
      }
      catch(InterruptedException ex){}
    }
  }

 //insert sort task
 class InsertionSortTask implements Runnable
  {
   private int[] num;//�ݱƧǼƦC�}�C
   private SortPanel p;//���panel

   //constructor
   public InsertionSortTask(SortPanel p)
    {
     this.p = p;
     num = p.getArray();
    }

   //����
   public void run()
    {
     try{
      for(int i=1;i<num.length;i++)
       {
        int current = num[i];//�ثe����
        int k = i;//�ؼ�index

        //�Y�e�@�����j �N�e�@�����Ჾ
        for(int j=i-1;j>=0&&current<num[j];j--)
         {
          num[j+1] = num[j];
          k = j;
         }
        
        num[k] = current;
        p.repaint();//��ø
        Thread.sleep(sleepTime);//��v
       }
      }
      catch(InterruptedException ex){}
    }
  }

 //bubble sort task
 class BubbleSortTask implements Runnable
  {
   private int[] num;//�ݱƧǼƦC�}�C
   private SortPanel p;//���panel

   //constructor
   public BubbleSortTask(SortPanel p)
    {
     this.p = p;
     num = p.getArray();
    }

   //����
   public void run()
    {
     try{
      for(int i=num.length-1;i>0;i--)
       {
        for(int j=0;j<i;j++)
         {
          //�۹j��Ƥ��ۤ���P�洫
          if(num[j]>num[j+1])
           {
            int temp = num[j];
            num[j] = num[j+1];
            num[j+1] = temp;
            p.repaint();//��ø
            Thread.sleep(sleepTime);//��v
           }
         }
       }
      }
      catch(InterruptedException ex){}
    }
  }

 public static void main(String args[])
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_13 frame = new EX29_13();//frame����
     frame.setTitle("EX29_13");//���D
     frame.setSize(600,400);//�����j�p
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
     frame.setLocationRelativeTo(null);//�۹��m
     frame.setVisible(true);//���
    }
   });
  }
}