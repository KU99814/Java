//Displaying the ACSII character table

public class EX4_14
{
 public static void main(String args[])
  {
   int count = 0; //�p��ӼƥH����
   for(int i = '!';i <= '~';i++) //�H�j��̧ǿ�X�r��
    {
     if(count > 9)
      {
       System.out.print("\n");
       count = 0;
      }
     char c = (char)(i); 
  
     System.out.print(c+" ");
     count++;
    }
  }
}