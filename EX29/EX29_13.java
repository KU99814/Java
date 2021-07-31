//sort panel with thread

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX29_13 extends JFrame
{ 
 //顯示排序panel
 private SortPanel selectionSort = new SortPanel("Selection Sort");//selection sort panel
 private SortPanel insertionSort = new SortPanel("Insertion Sort");//Insertion Sort panel
 private SortPanel bubbleSort = new SortPanel("Bubble Sort");//Bubble Sort panel

 private static int sleepTime = 100;

 public EX29_13()
  {
   setLayout(new GridLayout(1,3,1,1));//設定排版

   //加入panel
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
 //顯示排序
 class SortPanel extends JPanel
  {
   private int[] num = new int[50];//數列陣列
   private String title;//標題種類

   //constructor
   public SortPanel(String title)
    {
     this.title = title;

     for(int i=0;i<num.length;i++)
      num[i] = (int)(Math.random()*100+1);
    }

   //回傳陣列
   public synchronized int[] getArray()
    {
     return num;
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //panel 長寬
     int height = getHeight();
     int width = getWidth();
     
     //每一長條的間隔寬
     int wdis = width/50;
     int hdis = height/100;//單位高

     //繪出每一數代表的長條     
     for(int i=0;i<num.length;i++)
      {
       g.drawRect(wdis*i,height-hdis*num[i],wdis,hdis*num[i]);
      }

     //繪出標題
     g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
     g.drawString(title,wdis*20,30);
    }
  }

 //selection sort task
 class SelectionSortTask implements Runnable
  {
   private int[] num;//待排序數列陣列
   private SortPanel p;//顯示panel

   //constructor
   public SelectionSortTask(SortPanel p)
    {
     this.p = p;
     num = p.getArray();
    }

   //執行
   public void run()
    {
     try{
      for(int i=num.length-1;i>0;i--)
       {
        int max = i;//最大數的index

        for(int j=0;j<i;j++)
         {
          //比較出數列的最大數的index
          if(num[j]>num[max])
           max = j;
         }

        //交換
        if(max!=i)
         {
          int temp = num[i];
          num[i] = num[max];
          num[max] = temp;
          p.repaint();//重繪
          Thread.sleep(sleepTime);//休眠
         }
       }
      }
      catch(InterruptedException ex){}
    }
  }

 //insert sort task
 class InsertionSortTask implements Runnable
  {
   private int[] num;//待排序數列陣列
   private SortPanel p;//顯示panel

   //constructor
   public InsertionSortTask(SortPanel p)
    {
     this.p = p;
     num = p.getArray();
    }

   //執行
   public void run()
    {
     try{
      for(int i=1;i<num.length;i++)
       {
        int current = num[i];//目前的數
        int k = i;//目標index

        //若前一項較大 將前一項往後移
        for(int j=i-1;j>=0&&current<num[j];j--)
         {
          num[j+1] = num[j];
          k = j;
         }
        
        num[k] = current;
        p.repaint();//重繪
        Thread.sleep(sleepTime);//休眠
       }
      }
      catch(InterruptedException ex){}
    }
  }

 //bubble sort task
 class BubbleSortTask implements Runnable
  {
   private int[] num;//待排序數列陣列
   private SortPanel p;//顯示panel

   //constructor
   public BubbleSortTask(SortPanel p)
    {
     this.p = p;
     num = p.getArray();
    }

   //執行
   public void run()
    {
     try{
      for(int i=num.length-1;i>0;i--)
       {
        for(int j=0;j<i;j++)
         {
          //相隔兩數互相比較與交換
          if(num[j]>num[j+1])
           {
            int temp = num[j];
            num[j] = num[j+1];
            num[j+1] = temp;
            p.repaint();//重繪
            Thread.sleep(sleepTime);//休眠
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
     EX29_13 frame = new EX29_13();//frame物件
     frame.setTitle("EX29_13");//標題
     frame.setSize(600,400);//視窗大小
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
     frame.setLocationRelativeTo(null);//相對位置
     frame.setVisible(true);//顯示
    }
   });
  }
}