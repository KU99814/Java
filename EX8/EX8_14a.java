//Summing integers use Command Line

public class EX8_14a
{
 public static void main(String args[])
  {
   int sum = 0;
   for(int i=0;i<args.length;i++)
    sum += Integer.parseInt(args[i]); //�q�R�O�C���� �ରint��[�`
   
   //���
   System.out.print("The total is "+sum);
  }
}
   