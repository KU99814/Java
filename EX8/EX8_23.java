//implement String class

public class EX8_23
{
 public static void main(String args[])
  {
   MyString1 s = new MyString1(new char[]{'M','y','S','t','r','i','n','g'});//�ŧiMyString

   System.out.println("The char at 2 is "+s.charAt(2)); //��ܲĴX�Ӧr��
   System.out.println("The length of s are "+s.length()); //��ܦr�����

   MyString1 subString = s.subString(0,5); //���X�l�r��

   System.out.print("The substring of s is ");//��ܤl�r��

   for(int i=0;i<subString.length();i++) 
    System.out.print(subString.charAt(i));
   System.out.println();

   char[] ch = s.toChars(); //�N�r���ର�r���}�C
   System.out.print("The character of s is "); //��ܰ}�C���e
   for(int i=0;i<ch.length;i++)
    System.out.print(ch[i]+" ");
   System.out.println();

   MyString1 lowerString = s.toLowerCase();//���ର�p�g
   System.out.print("The s to lower case is ");
   for(int i=0;i<lowerString.length();i++)
    System.out.print(lowerString.charAt(i));
   System.out.println();

   System.out.println("String is equal to s ? " +
                        s.equals(new MyString1(new char[]{'s','u','b'})));

   MyString1 value = MyString1.valueOf(-500); //�Nint�ରMyString1
   for(int i=0;i<value.length();i++)
    System.out.print(value.charAt(i));
  }
}

//�ۧ@��String
class MyString1
{
 char[] ch; //�x�s�r��

 public MyString1(char[] chars)//�ŧi�غc
  {
   ch = new char[chars.length];
   System.arraycopy(chars,0,ch,0,chars.length);
  }

 public char charAt(int index)//�^�ǲĴX�Ӧr
  {
   return ch[index];
  }

 public int length() //�^�Ǧr�����
  {
   return ch.length;
  }

 public MyString1 subString(int begin,int end) //���X�l�r��
  {
   char[] newC = new char[end - begin];//�зs���r���}�C
   
   for(int i=begin,j=0;i<end;i++,j++)//�q���w��index�}�l��J
    newC[j] = ch[i];
   
   return new MyString1(newC);//�^��
  }

 public char[] toChars()//�^�Ǧr���}�C
  {
   //�]���O�s���}�C �ƻs�s���^��
   char[] reCh = new char[ch.length];
   System.arraycopy(ch,0,reCh,0,ch.length);
   return reCh;
  }

 public MyString1 toLowerCase()//�^�ǥ����p�g
  {
   char[] lower = new char[ch.length];//�зs�}�C

   for(int i=0;i<ch.length;i++)
    {
     if(ch[i]>='A' && ch[i] <= 'Z')//�P�_�O�_�j�g
      lower[i] = (char)('a' + (ch[i] - 'A'));
     else
      lower[i] = ch[i];
    }
  
   return new MyString1(lower);//�^��
  }

 public boolean equals(MyString1 s)//�P�_�O�_�۵�
  {
   if(s.length()!=ch.length)
    return false;
   for(int i=0;i<ch.length;i++)//�v�r���
    {
     if(ch[i] != s.charAt(i))
      return false;//���@�B���P�N
    }
   
   return true;//�^�ǵ��G
  }

 //�Nint�ରMyString
 public static MyString1 valueOf(int i)
  {
   int plus = 0;//�P�_���t0���� 1���t

   if(i < 0)//�t�ƪ���
    {
     i*=-1;//�t�ॿ��K�p��
     plus++;
    }
   
   int digit = 0;//�Ʀr���
   int num = i;
 
   //��X��ƨӨM�w�r�����
   while(true)
    {
     num/=10;     
     digit++;
     
     if(num==0)
      break;
    }

   digit+=plus;
   char[] reInt = new char[digit];

   if(plus>0)
    {
     reInt[0] = '-';
    }

   num = i;//���s��Ji

   for(int k=digit-1;k>=plus;k--)//�H�˱Ԥ覡��J�}�C
    {
     int j = (num%10);
     reInt[k] = (char)('0'+j);
     num/=10;
    }
   
   return new MyString1(reInt);//�^��
  }
} 