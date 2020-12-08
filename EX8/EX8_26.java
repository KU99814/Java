//implement StringBuilder class

public class EX8_26
{
 public static void main(String args[])
  {
   MyStringBuilder1 strb = new MyStringBuilder1("String");//�ŧiMyStringBuilder1 
   System.out.println("The stringbuilder is "+strb.toString()); //��ܦr��
   strb = strb.append(new MyStringBuilder1(" is")); //�[�J�s�r��
   System.out.println(strb.toString()); 
   strb.append(new MyStringBuilder1(" "));
   strb = strb.append(2);
   System.out.println(strb.toString());
   System.out.println("The length is "+strb.length());//��ܪ���
   System.out.println("The 3 char is "+strb.charAt(2)); //��ܫ��windex�r��
   strb = strb.toLowerCase();//�ର�p�g
   System.out.println(strb.toString());
   strb = strb.substring(0,3);//���X�l�r��
   System.out.println(strb.toString());
  }
}

//�ۧ@��MyStringBuilder
class MyStringBuilder1
{
 private int size = 0; //�x�s�r�����
 private int capacity = 0; //��ڥi�H�x�s���e�q
 private char[] buffer;   //�x�s���r��

 //�w�]�e�q16
 public MyStringBuilder1()
  {
   buffer = new char[16];
   capacity = 16;
  }

 public MyStringBuilder1(char[] chars)//�غc�l
  {
   buffer = new char[chars.length];
   capacity = chars.length;
   
   for(int i=0;i<capacity&&chars[i]!='\u0000';i++)
    {
     buffer[i] = chars[i];
     size++;
    }
 }

 public MyStringBuilder1(String s)
  {
   buffer = new char[s.length()];
   size = s.length();
   capacity = size;
   for(int i=0;i<s.length();i++)
    buffer[i] = s.charAt(i);
  }

 //�[�J�r
 public MyStringBuilder1 append(MyStringBuilder1 s)
  {
   int addSize = s.length();

   //�e�q���������X�R
   if((size+addSize)>capacity)
    {
     while(capacity<size+addSize)
      {
       capacity = capacity*2+1;
      }
     char[] newBuffer = new char[capacity];
     for(int i=0;i<size;i++)
      newBuffer[i] = buffer[i];
     buffer = newBuffer;
    }
   for(int i=size,j=0;i<size+addSize;i++,j++)//�[��̫᭱
    buffer[i] = s.charAt(j);

   size = size+addSize;
   
   return new MyStringBuilder1(buffer);
  }

 //�[�J�Ʀr
 public MyStringBuilder1 append(int i)
  {
   return append(new MyStringBuilder1(String.valueOf(i)));
  }

 //����
 public int length()
  {
   return size;
  }

 //���o�r��
 public char charAt(int index)
  {  
   return buffer[index];
  }
  
 //�ର�p�g
 public MyStringBuilder1 toLowerCase()
  {
   for(int i=0;i<size;i++)
    {
     if(buffer[i]>='A' && buffer[i] <= 'Z')
      buffer[i] = (char)('a'+(buffer[i]-'A'));
    }
   return new MyStringBuilder1(buffer);
  }

 //���X�l�r��
 public MyStringBuilder1 substring(int begin,int end)
  {
   char[] newBuffer = new char[end - begin];//�s�r���}�C
   for(int i=begin,j=0;i<end;i++,j++)
    newBuffer[j] = buffer[i];
   return new MyStringBuilder1(newBuffer);
  }

 //��ܤ��e
 public String toString()
  {
   String s = "";
   for(int i=0;i<size;i++)
    s += buffer[i];
   return s;
  }
}      