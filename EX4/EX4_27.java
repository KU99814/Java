//Displaying leap year 

public class EX4_27
{
 public static void main(String args[])
  {
   int count = 0; //����p��
   
   //���21�@���Ҧ��|�~
   for(int year = 2001;year<=2100;year++)
    {
     if(count == 10)
      {
       System.out.println();
       count = 0;
      }
     if((year % 4 == 0 && year % 100 !=0) || (year % 400 == 0) )//�P�_�O�_�|�~
      {
       System.out.print(year+ " ");
       count++;
      }
    }
  }
}