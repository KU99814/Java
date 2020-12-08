//��ܥ��T�ɶ�

public class EX5_24
{
 public static void main(String args[])
  {
   long totalMilliseconds = System.currentTimeMillis(); //�D�X�q1970�~1/1��{�b�@���

   long totalSeconds = totalMilliseconds/1000;//�ন�`���
   long seconds = totalSeconds%60;//�D�X�{�b���
   
   long totalMinutes = totalSeconds/60;
   long Minutes = totalMinutes%60;//�D�X�{�b����

   long totalHours = totalMinutes/60;
   long hours = (totalHours+8)%24;//�D�X�{�b�p�� +8�O���ɮt
   
   
   long totalDays = (totalHours+8)/24; //+8�O���ɮt
   int today = (int)(totalDays) +1;
   
   int totalYear = (int)(totalDays/365);
   int year = totalYear+1970; //�D�X�{�b�~��

   int month = 1;//��l���

   //�`�ѼƹE�~��h ����ѤU���~�w�L�Ѽ�
   for(int i = 1970;i<year;i++)
    {
     if(isLeapYear(i))
      today -= 366;
     else
      today -= 365;
    }

   while(true) //�D�X�{�b���
    {
     //�����ѼƧk�X�Y����
     if((month == 1 || month == 3 || month == 5 || month == 7 ||
         month == 8 || month == 10 || month == 12) && today <= 31)
      break;
     else if((month == 4 || month == 6 || month == 9 || month == 11) && today <= 30)
      break;
     else if(month == 2 )
      {
       if(isLeapYear(year) && today <= 29)
        break;
       else if(!isLeapYear(year) && today <= 28)
        break;
      }

     today -= getNumberOfDaysInMonth(year,month);//���~�w�L�Ѽ� ��h��������Ѽ�
     month++;//����e�i
     
     //����X
     if(month>12)
      {
       month -= 12;
       year++;
      }
    }

   //���
   System.out.print("The current time is "+hours+":"+Minutes+":"+seconds+" "+year+"/"+month+"/"+today+" GMT");    
  }

 //�ˬd�O�_�|�~
 static boolean isLeapYear(int year)
  {
   return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }

 //�^�ǸӦ~��������Ѽ�
 static int getNumberOfDaysInMonth(int year,int month)
  {
   //�j��
   if(month == 1 || month == 3 || month == 5 || month == 7 ||
      month == 8 || month == 10 || month == 12)
    return 31;
   //�p��
   if(month == 4 || month == 6 || month == 9 || month == 11)
    return 30;
   //2��
   if(month == 2 )
    return isLeapYear(year) ? 29 : 28;
   return 0;
  }
}