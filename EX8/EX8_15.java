//Ordering the numbers

public class EX8_15
{
 public static void main(String args[])
  {
   int[] num = new int[args.length]; //�ഫ���Ʀr

   for(int i=0;i<args.length;i++)
    num[i] = Integer.parseInt(args[i]);
   
   for(int i=0;i<num.length;i++) //�ƦC ��selection sort
    {
     for(int j = i+1;j<num.length;j++)
      {
       if(num[i] > num[j])
        {
         int temp = num[i];
         num[i] = num[j];
         num[j] = temp;
        }
      }
    }

   System.out.print("The order is "); //��X
   for(int i=0;i<num.length;i++)
    System.out.print(num[i] + " ");
  }
}