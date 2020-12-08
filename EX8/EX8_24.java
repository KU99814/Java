//implement String class 2

public class EX8_24
{
 public static void main(String args[])
  {
   MyString2 s = new MyString2(new char[]{'m','y','s','t','r','i','n','g'});//�ŧiMyString2

   //�P�t�@��MyString2�@���
   System.out.println("The compare s and s2 is "+
                       s.compare(new MyString2(new char[]{'a','y','s','t','r','i','n','g','2'})));
 
   MyString2 subS = s.substring(3);//���X�l�r��
   System.out.print("The substring of begin 3 is ");
   char[] c1 = subS.toChars(); //���
   for(int i=0;i<c1.length;i++)
    System.out.print(c1[i]);
   System.out.println();

   MyString2 upperS = s.toUpperCase();//��ܥ����j�g
   System.out.print("The upper of s is ");
   char[] c2 = upperS.toChars();
   for(int i=0;i<c2.length;i++)
    System.out.print(c2[i]);
   System.out.println();
   
   MyString2 valueS = MyString2.valueOf(true); //�N���L���ର�r��
   
   char[] c3 = valueS.toChars();
   for(int i=0;i<c3.length;i++)
    System.out.print(c3[i]);
   System.out.println();
  }
}

//�ۧ@��String
class MyString2
{
 private char[] ch;//�s��r�����}�C

 public MyString2(char[] chars)//�غc�l
  {
   ch = new char[chars.length];
   System.arraycopy(chars,0,ch,0,chars.length);
  }

 public int compare(MyString2 s)//���
  {
   char[] c2 = s.toChars();

   int max = 0;
   if(c2.length > ch.length)
    max = c2.length;
   else
    max = ch.length; //��X���Ӫ��׸��� �קKIndex ex
   int num = 0;
   //�v�r�۴� �^�ǳ̫�o�X����
   for(int i=0;i<max;i++)
    {
     if(i>=ch.length)
      num-=(int)(c2[i]);
     else if(i>= c2.length)
      num += (int)(ch[i]);
     else
      num += (int)(ch[i] - c2[i]);
    }
   return num;
  }

 //���X�l�r��
 public MyString2 substring(int begin)
  {
   char[] c1 = new char[ch.length - begin];

   for(int i=begin,j=0;i<ch.length;i++,j++)//�qbegin�}�l��̫᭱
    c1[j] = ch[i];
   
   return new MyString2(c1);//�^�Ǥl�r��
  }

 //�^�ǥ����j�g���r��
 public MyString2 toUpperCase()
  {
   char[] c = new char[ch.length];//���o����
   for(int i=0;i<ch.length;i++)
    {
     if(ch[i] >= 'a' && ch[i] <= 'z')  //�v�r�P�_���ഫ
      c[i] = (char)('A'+(ch[i] - 'a'));
     else
      c[i] = ch[i];
    }
   
   return new MyString2(c); //�^��
  }

 //�ର�r���}�C
 public char[] toChars()
  {
   char[] reCh = new char[ch.length];//�t�Ф@�ӷs�}�C�קK�v�T
   for(int i=0;i<ch.length;i++)
    reCh[i] = ch[i];
   return reCh; //�����^�Ǥ��s���}�C
  }

 //���L����r�� 
 public static MyString2 valueOf(boolean b)
  {
   if(b)
    return new MyString2(new char[]{'t','r','u','e'});
   else
    return new MyString2(new char[]{'f','a','l','s','e'});
  }
}
   
      