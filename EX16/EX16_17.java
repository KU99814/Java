//顯示日歷

import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class EX16_17 extends JFrame
{
 public EX16_17()
  {
   Calendar calendar = new GregorianCalendar(); //獲得日歷

   JPanel p1 = new JPanel();//顯示月與年

   int year = calendar.get(Calendar.YEAR);//取得年分
   int month = calendar.get(Calendar.MONTH)+1;//取得月份

   p1.add(new JLabel(month+"/"+year));

   //顯示日期panel   
   JPanel p2 = new JPanel(new BorderLayout());
   JPanel p2_1 = new JPanel(new GridLayout(1,7));//顯示星期一~日
   JPanel p2_2 = new JPanel(new GridLayout(6,1));//顯示天數

   //宣告並設定框線
   Border line = new LineBorder(Color.BLACK,2);
   p2_1.setBorder(line);
   
   //星期
   p2_1.add(new JLabel("  Sunday"));
   p2_1.add(new JLabel(" Monday"));
   p2_1.add(new JLabel(" Tuesday"));
   p2_1.add(new JLabel(" Wednesday"));
   p2_1.add(new JLabel("    Thursday"));
   p2_1.add(new JLabel("     Friday"));
   p2_1.add(new JLabel("     Saturday"));
   
   //整合
   p2.add(p2_1,BorderLayout.NORTH);
   p2.add(p2_2,BorderLayout.CENTER);


   Calendar calendar2 = new GregorianCalendar(year,month-1,1);//宣告日曆
   
   
   int first = calendar2.get(Calendar.DAY_OF_WEEK);//取得第一天星期幾
   int maxDay = calendar.getActualMaximum(Calendar.DATE);//取得本月天數

   int day = 1 - first;//因為輸入重禮拜天開始 所以要減去上月底星期
   int weeknumber = 0;//代表星期幾

   //輸入天數
   while(day<=maxDay)
    {
     JPanel pWeek = new JPanel(new GridLayout(1,7));//一次輸入一禮拜

     for(int i= 0;i<7;i++)
      {
       JPanel p = new JPanel();

       if(day<0 || day>=maxDay)//如果到月底 或還沒到這個月第一天
        p = new JPanel(); 
       else 
        {
         //定義含天數panel
         p = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,20));
         p.add(new JLabel((day+1)+""));
         p.setBorder(line);
        }
       //加入week panel
       pWeek.add(p);
       day++;
      }
    
     p2_2.add(pWeek);//加入panel
     weeknumber++;
    }

   //整合
   p2_2.setLayout(new GridLayout(weeknumber,1));
     
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
  }

 public static void main(String args[])
  {
   EX16_17 frame = new EX16_17();//宣告視窗
   frame.setTitle("EX16_17");//標題
   frame.setSize(700,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}