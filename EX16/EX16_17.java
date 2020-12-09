//��ܤ��

import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class EX16_17 extends JFrame
{
 public EX16_17()
  {
   Calendar calendar = new GregorianCalendar(); //��o���

   JPanel p1 = new JPanel();//��ܤ�P�~

   int year = calendar.get(Calendar.YEAR);//���o�~��
   int month = calendar.get(Calendar.MONTH)+1;//���o���

   p1.add(new JLabel(month+"/"+year));

   //��ܤ��panel   
   JPanel p2 = new JPanel(new BorderLayout());
   JPanel p2_1 = new JPanel(new GridLayout(1,7));//��ܬP���@~��
   JPanel p2_2 = new JPanel(new GridLayout(6,1));//��ܤѼ�

   //�ŧi�ó]�w�ؽu
   Border line = new LineBorder(Color.BLACK,2);
   p2_1.setBorder(line);
   
   //�P��
   p2_1.add(new JLabel("  Sunday"));
   p2_1.add(new JLabel(" Monday"));
   p2_1.add(new JLabel(" Tuesday"));
   p2_1.add(new JLabel(" Wednesday"));
   p2_1.add(new JLabel("    Thursday"));
   p2_1.add(new JLabel("     Friday"));
   p2_1.add(new JLabel("     Saturday"));
   
   //��X
   p2.add(p2_1,BorderLayout.NORTH);
   p2.add(p2_2,BorderLayout.CENTER);


   Calendar calendar2 = new GregorianCalendar(year,month-1,1);//�ŧi���
   
   
   int first = calendar2.get(Calendar.DAY_OF_WEEK);//���o�Ĥ@�ѬP���X
   int maxDay = calendar.getActualMaximum(Calendar.DATE);//���o����Ѽ�

   int day = 1 - first;//�]����J��§���Ѷ}�l �ҥH�n��h�W�멳�P��
   int weeknumber = 0;//�N��P���X

   //��J�Ѽ�
   while(day<=maxDay)
    {
     JPanel pWeek = new JPanel(new GridLayout(1,7));//�@����J�@§��

     for(int i= 0;i<7;i++)
      {
       JPanel p = new JPanel();

       if(day<0 || day>=maxDay)//�p�G��멳 ���٨S��o�Ӥ�Ĥ@��
        p = new JPanel(); 
       else 
        {
         //�w�q�t�Ѽ�panel
         p = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,20));
         p.add(new JLabel((day+1)+""));
         p.setBorder(line);
        }
       //�[�Jweek panel
       pWeek.add(p);
       day++;
      }
    
     p2_2.add(pWeek);//�[�Jpanel
     weeknumber++;
    }

   //��X
   p2_2.setLayout(new GridLayout(weeknumber,1));
     
   setLayout(new BorderLayout());
   add(p1,BorderLayout.NORTH);
   add(p2,BorderLayout.CENTER);
  }

 public static void main(String args[])
  {
   EX16_17 frame = new EX16_17();//�ŧi����
   frame.setTitle("EX16_17");//���D
   frame.setSize(700,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}