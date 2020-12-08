//The MyDateTime class

public class EX9_1
{
 public static void main(String args[])
  {
   MyDateTime Ctime = new MyDateTime();  //�ŧiMyDateTime
   MyDateTime Stime = new MyDateTime(555550000); //�q1970 1/1�}�l�⪺���

   System.out.print("The current time is ");
   System.out.println(Ctime.getYear()+"Y "+Ctime.getMonth()+"M "+Ctime.getDay()+"D "+
                      Ctime.getHour()+"H "+Ctime.getMin()+"M "+Ctime.getSec()+"S"); //�{�b

   System.out.print("The specified time is ");
   System.out.println(Stime.getYear()+"Y "+Stime.getMonth()+"M "+Stime.getDay()+"D "+
                      Stime.getHour()+"H "+Stime.getMin()+"M "+Stime.getSec()+"S");

   Stime.setYear(1);//�]�w�~
   Stime.setMonth(2);//�]�w��
   Stime.setDay(3);//�]�w���
   Stime.setHour(4); //�]�w�p��
   Stime.setMin(5); //�]�w��
   Stime.setSec(6); //�]�w��

   System.out.print("The new set time is ");
   System.out.println(Stime.getYear()+"Y "+Stime.getMonth()+"M "+Stime.getDay()+"D "+
                      Stime.getHour()+"H "+Stime.getMin()+"M "+Stime.getSec()+"S");
  }
}

class MyDateTime
{
 private int day; //��
 private int month; //��
 private int year; //�~
 private int hour; //�p��
 private int minute; //��
 private int second; //��
 private long millSecond;//�@�� �̪���o���ɶ�
 private long total;//�`��� �NmillSecond�ର��

 //�غc�l
 //no-arg
 public MyDateTime()
  {
   millSecond = System.currentTimeMillis();
   setTime();
  }

 public MyDateTime(long millSecond)
  {
   this.millSecond = millSecond;
   setTime();
  }

 public MyDateTime(int year,int month,int day,int hour,int minute,int second)
  {
   this.year = year;
   this.month = month;
   this.day = day;
   this.hour = hour;
   this.minute = minute;
   this.second = second;
  } 
   
   
 public void setTime() //�D�X���
  {
   total = millSecond/1000;

   //�D�X��
   second = (int)(total%60);
   total /= 60;

   //�D�X��
   minute = (int)(total%60);
   total /= 60;

   //�D�X��
   hour = (int)(total%24);
   total /=24; //�ѤU���O���

   int count = 2; 
   day = (int)(total);
   //�D�X���
   while(day > 365)
    {
     if(count%4 == 0 && count != 400)
      day -= 366;
     else
      day -= 365;
     count++;
    }

   int i;//�N����
   //��h�C��Ѽ�
   for(i=1;day > 28;i++)
    {
     if(i<8)//8��e�_�ƬO�j��
      {
       if(i%2==1)
        day -= 31;
       else if(i%2==0 && i!=2)
        day -= 30;
       else
        {
         if(count%4 == 0 && count != 400)
          day -= 29;
         else
          day -= 28;
        }
      }
     else 
      {
       if(i%2==1)
        day -= 30;
       else if(i%2==0)
        day -= 31;
      }
    }
   total /= 365;
   month = i;
   year = 1970 + (int)(total); //�~��
  }

 //�H�U���^���ܼ�

 public int getSec()//��
  {
   return second;
  }

 public int getMin()//��
  {
   return minute;
  }

 public int getHour()//��
  {
   return hour;
  }

 public int getDay()//���
  {
   return day;
  }

 public int getMonth()//��
  {
   return month;
  }

 public int getYear()//�~
  {
   return year;
  }
 
 //�H�U���]�w�ܼ�

 public void setSec(int second)//��
  {
   this.second = second;
  }

 public void setMin(int minute)//��
  {
   this.minute = minute;
  }

 public void setHour(int hour)//��
  {
   this.hour = hour;
  }

 public void setDay(int day)//��
  {
   this.day = day;
  }

 public void setMonth(int month)//��
  {
   this.month = month;
  }

 public void setYear(int year)//�~
  {
   this.year = year;
  }
}