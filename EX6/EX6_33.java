//locker puzzle

public class EX6_33
{ 
 public static void main(String args[])
  {
   int[] lockers = new int[100]; //�]�}�C�x�s�m���d���A 0��1�}

   //��l���A�Ҭ���
   for(int i=0;i<lockers.length;i++)
    lockers[i] = 0;
  
   for(int i=0;i<lockers.length;i++) //�}�l�ާ@ �}�����
      {
       //��n�ӾǥͶ}���C��n����
       //�p��n���]�� �]�ƭӼƥN��Q�X�ӾǥͶ}
       //�ӼƤ������ƫh���p����
        lockers[i] = lockCount(i+1)%2;
      }
   
   for(int i=0;i<lockers.length;i++) //��ܨC�@�Ӷ}�����A
    {
     System.out.print(lockers[i]+" ");
     if((i+1)%10==0)
      System.out.println();
    }
   
   int count = 0;
   for(int i=0;i<lockers.length;i++) //�p��X������
      {
       if(lockers[i] == 0)
        count++;
      }
   System.out.println("There has "+count+" closed"); //���

   System.out.print("The open locker is "); //���
   for(int i=0;i<lockers.length;i++)
      {
       if(lockers[i] == 1)
        System.out.print((i+1)+" ");
      }
  }

 public static int lockCount(int num)
  {
   int count = 0;
   //��1�H�~�̤p�]�ƬO2 �]�����H2
   for(int i=1;i<=num/2;i++)
    {
     if(num%i==0)
      count++;
    }   

   return count+1;//�ۤv�]�n�� �ҥH�^�ǭȥ[1
  }
}