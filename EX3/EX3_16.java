//Random character

public class EX3_16
{
 public static void main(String args[])
  {
   //�H�����ͦr�� Z-A+1�O���ͽd��
   char chars = (char)('A'+Math.random()*('Z' - 'A' + 1));

   System.out.print(chars);
  }
}
