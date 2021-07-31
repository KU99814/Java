//Task thread demo by text area

import javax.swing.*;
import java.util.concurrent.*;

public class EX29_1 extends JFrame
{
 private JTextArea jta = new JTextArea();//顯示的text area
 private String s = "";//放入text area的字串

 public EX29_1()
  {
   //設定自動換行
   jta.setWrapStyleWord(true);
   jta.setLineWrap(true);

   add(new JScrollPane(jta));//將text area加入到frame

   //創建並執行thread
   new Thread(new PrintChar('a',200)).start();
   new Thread(new PrintChar('b',200)).start();
   new Thread(new PrintNum(200)).start();
  }

 //印出字母的task
 class PrintChar implements Runnable
  {
   private char c;//印出的字母
   private int time;//印出字母數量
   
   //constructor
   public PrintChar(char c,int time)
    {
     //初始化字母與數量
     this.c = c;
     this.time = time;
    }
   
   //執行
   //將字母加到字串中 並在text area顯示
   public void run()
    {
     //避免互相爭槍 用synchronized控制存取
     synchronized(s){
      for(int i=0;i<time;i++)
       {
        s+=c+" ";
        jta.setText(s);
       }
     }
    }
  }
 
 //從1開始印出數字直到指定的數字
 class PrintNum implements Runnable
  {
   private int num;//指定的目標數字
   
   //constructor
   public PrintNum(int num)
    {
     //初始化num
     this.num = num;
    }

   //執行
   //將數字依序加入text area
   public void run()
    {
     //避免互相爭槍 用synchronized控制存取
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
   //因為使用多重執行緒 將GUI顯示在全部執行完之後
   SwingUtilities.invokeLater(new Runnable(){
     public void run(){
      EX29_1 frame = new EX29_1();//創建frame物件
      frame.setTitle("EX29_1");//標題
      frame.setSize(600,400);//視窗大小
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
      frame.setLocationRelativeTo(null);//相對位置
      frame.setVisible(true);//顯示
     }
    }
   );
  }
}