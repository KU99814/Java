//GCD use commeand-Line

public class EX8_13
{
 public static void main(String args[])
  {
   int[] arg = new int[args.length]; //�N��r�����Ʀr

   for(int i=0;i<args.length;i++)
    arg[i] = Integer.parseInt(args[i]);//�q�R�O�C��r�ର�Ʀr

   int min = arg[0];

   for(int i=1;i<arg.length;i++) //��X�̤p��
   {
    if(arg[i] < min)
      min = arg[i];
   }

   int gcd = 1;

   for(int i=1;i<=min;i++) //��XGCD
    {
     boolean ok = true;

     for(int j=0;j<arg.length;j++)
      {
       if(arg[j]%i != 0)
        {
         ok = false;
         break;
        }
      }

     if(ok)
      gcd = i;
    }
   System.out.print("The GCD is "+gcd); //���
  }
}       