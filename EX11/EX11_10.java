import java.util.*;

public class EX11_10
{
 public static void main(String args[])
  {
   //�ŧi���
   Calendar calendar = new GregorianCalendar();
 
   int year = calendar.get(Calendar.YEAR); //���o�~
   int month = calendar.get(Calendar.MONTH); //���o��
   Calendar calendar2 = new GregorianCalendar(year,month,1); //�ŧi�s���

   //���
   System.out.println("     MONTH "+(calendar.get(Calendar.MONTH)+1));
   System.out.println("-----------------------------------------");
   System.out.println("SUN   MON   TUS   WED   THU   FRI   SAT");

   int first = calendar2.get(Calendar.DAY_OF_WEEK);//���Ĥ@�Ѫ��P��
   int maxDay = calendar.getActualMaximum(Calendar.DATE); //�o�릳�X��
   int count = 0; //����p��
   
   //�Ĥ@�檺�ť�
   for(int i= first;i>1;i--)
    {
     System.out.print("   ");
     System.out.print("   ");
     count++;
    }

   //��ܤ��
   for(int i=1;i<=maxDay;i++)
    {
     if(count%7==0 && count!=0)//�_��
      System.out.println();
     System.out.print(" "+i);
     if(i<10)
      System.out.print("    ");
     else 
      System.out.print("   ");
     count++;
    }
  }
}