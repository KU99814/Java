//��X�̤p�ƪ��}�C����

public class EX6_10
{
 public static void main(String args[])
  {
   int[] num = {1,2,4,5,10,100,2,-22}; //�]�}�C
   
   System.out.print("The smallest element's index is "+min(num)); //���
  }

 public static int min(int... num) //�B��
  {
   int mIndex = 0;
   int m = num[0];
   //����̤p��
   for(int i=1;i<num.length;i++)
    {
     if(num[i]<m)
      {
       m = num[i];
       mIndex = i;
      }
    }

   return mIndex; //�^�ǳ̤p�Ȫ�����
  }
}