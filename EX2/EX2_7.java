//Converting a lowercase letter to an uppercase

public class EX2_7
{
 public static void main(String args[])
  {
   int lowercase1 = 'h'; //�n�ഫ���r��

   int offset = 'a' - 'A'; //�p�g��j�g���t�Z(�j�g�b�p�g���e)
   char uppercase = (char)(lowercase1 - offset); //��h�t�Z

   System.out.print("The uppercase is "+uppercase); //��X���G
  }
}   