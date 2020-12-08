//implement character class 

public class EX8_25
{
 public static void main(String args[])
  {
   MyCharacter ch = new MyCharacter('a');//�ŧiMyCharacter
   
   System.out.println("The char is "+ch.charValue()); //��ܭ�
   System.out.println("Thm compare to b is "+ch.compareTo(new MyCharacter('b')));//���
   System.out.println("Is the char equal to b ? "+ch.equals(new MyCharacter('b')));//�P�_�O�_�۵�
   System.out.println("Is b a digit ? " +MyCharacter.isDigit('b'));//�P�_�O�_�Ʀr
   System.out.println("Is b a letter ? " +MyCharacter.isLetter('b'));//�P�_�O�_��r
   System.out.println("Is C is a letter or digit ? "+MyCharacter.isLetterOrDigit('b'));//�P�_�O�Ʀr�Τ�r
   System.out.println("Is b a lower case ? " + MyCharacter.isLowerCase('b'));//�P�_�O�_�p�g
   System.out.println("Is b a upper case ? " + MyCharacter.isUpperCase('b'));//�P�_�O�_�j�g
   System.out.println("what is B in lower case ? " + MyCharacter.toLowerCase('B')); //�ର�p�g
   System.out.println("what is b in upper case ? " + MyCharacter.toUpperCase('b')); //�ର�j�g
  }
}

//�ۧ@Character
class MyCharacter
{
 private char c;//�r��
 
 public MyCharacter(char value)//�غc�l
  {
   c = value;
  }

 public char charValue()//�̭��x�s���r��
  {
   return c;
  }

 public int compareTo(MyCharacter ano)//���
  {
   int num = (int)(c - ano.charValue()); //�۴���ର�Ʀr

   return num; //�^��
  }

 //�P�_�O�_�۵�
 public boolean equals(char ch)
  {
   if(c == ch)//�i�ε����P�_
    return true;
   else
    return false;
  }

 //�P�_�O�_�Ʀr
 public static boolean isDigit(char ch)
  {
   if(ch >= '1' && ch <= '9')//�P�_�O�_�b0~9���϶�
    return true;
   
   return false;
  }

 //�P�_�O�_��r
 public static boolean isLetter(char ch)
  {
   //�P�_�O�_�b�j �p�g�r���϶�
   if(ch >= 'a' && ch <= 'z')
    return true;
   if(ch >= 'A' && ch <= 'Z')
    return true;
   
   return false;
  }

 //�P�_�Ʀr�Τ�r
 public static boolean isLetterOrDigit(char ch)
  {
   //�Q�Ϋe����method
   if(isLetter(ch) || isDigit(ch))
    return true;
   
   return false;
  }

 //�P�_�O�_�p�g�r��
 public static boolean isLowerCase(char ch)
  {
   if(ch >= 'a' && ch <= 'z')//�P�_�O�_�b�p�g�r���϶�
    return true;

   return false;
  }

 //�P�_�O�_�j�g�r��
 public static boolean isUpperCase(char ch)
  {
   if(ch >= 'A' && ch <= 'Z') //�P�_�O�_�b�j�g�r���϶�
    return true;

   return false;
  }

 public static char toLowerCase(char ch)//��X�p�g
  {
   if(ch >= 'A' && ch <= 'Z')
    return (char)('a' + (ch - 'A'));
   else
    return ch;
  }

 //��X�j�g
 public static char toUpperCase(char ch)
  {
   if(ch >= 'a' && ch <= 'z')
    return (char)('A' + (ch - 'a'));
   else
    return ch;
  }
}