//implement StringBuilder class 2

public class EX8_27
{
 public static void main(String args[])
  {
   MyStringBuilder2 strb = new MyStringBuilder2("String");//�ŧiMyStringBuilder2
   
   System.out.println("The stringbuilder is "+strb.toString());//��ܤ��e
   strb = strb.insert(3,new MyStringBuilder2("is"));//���J��L�r
   System.out.println(strb.toString());
   strb = strb.reverse();//����
   System.out.println(strb.toString());
   strb = strb.toUpperCase();//�ର�j�g
   System.out.println(strb.toString());
   strb = strb.substring(3);//���X�l�r��
   System.out.println(strb.toString());
  }
}

//�ۧ@StringBuilder
class MyStringBuilder2
{
 private int size = 0; //�x�s�r�����
 private int capacity = 0; //��ڥi�H�x�s���e�q
 private char[] buffer;   //�x�s���r��

 //�w�]�e�q16
 //�غc�l
 public MyStringBuilder2()
  {
   buffer = new char[16];
   capacity = 16;
  }

 public MyStringBuilder2(char[] chars)
  {
   buffer = new char[chars.length];
   capacity = chars.length;
   
   for(int i=0;i<capacity&&chars[i]!='\u0000';i++)
    {
     buffer[i] = chars[i];
     size++;
    }
 }

 public MyStringBuilder2(String s)
  {
   buffer = new char[s.length()];
   size = s.length();
   capacity = size;
   for(int i=0;i<s.length();i++)
    buffer[i] = s.charAt(i);
  }

 //���J
 public MyStringBuilder2 insert(int offset,MyStringBuilder2 s)
  {
   char[] newBuffer = new char[size + s.length()];//�s�r��
   for(int i=0;i<offset;i++)//���g�J���J�e���r��
    newBuffer[i] = buffer[i];

   for(int i=0;i<s.length();i++)   //���J
    newBuffer[offset+i] = s.charAt(i);

   for(int i=offset;i < buffer.length;i++)//���ۼg�J�᭱��
    newBuffer[i+s.length()] = buffer[i];
   return new MyStringBuilder2(newBuffer);
  }

 //����
 public MyStringBuilder2 reverse()
  {
   char[] newBuffer = new char[size];//�s�r��
   for(int i=0;i<size;i++) //�N��r���A�˩�J
     newBuffer[i] = buffer[(size-1)-i];

   return new MyStringBuilder2(newBuffer);
  }

 //����
 public int length()
  {
   return size;
  }

 //���X�r��
 public char charAt(int index)
  {  
   return buffer[index];
  }

 //�ର�j�g
 public MyStringBuilder2 toUpperCase()
  {
   for(int i=0;i<size;i++)
    {
     if(buffer[i]>='a' && buffer[i] <= 'z')//�Y�b�p�g�϶�
      buffer[i] = (char)('A'+(buffer[i]-'a'));
    }
   return new MyStringBuilder2(buffer);
  }

 //���X�l�r��
 public MyStringBuilder2 substring(int begin)
  {
   char[] newBuffer = new char[(size - begin)];
   for(int i=begin,j=0;i<size;i++,j++)
    newBuffer[j] = buffer[i];
   return new MyStringBuilder2(newBuffer);
  }

 //���
 public String toString()
  {
   String s = "";
   for(int i=0;i<size;i++)
    s += buffer[i];
   return s;
  }
}
      