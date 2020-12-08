//implement StringBuilder class 2

public class EX8_27
{
 public static void main(String args[])
  {
   MyStringBuilder2 strb = new MyStringBuilder2("String");//宣告MyStringBuilder2
   
   System.out.println("The stringbuilder is "+strb.toString());//顯示內容
   strb = strb.insert(3,new MyStringBuilder2("is"));//插入其他字
   System.out.println(strb.toString());
   strb = strb.reverse();//反轉
   System.out.println(strb.toString());
   strb = strb.toUpperCase();//轉為大寫
   System.out.println(strb.toString());
   strb = strb.substring(3);//分出子字串
   System.out.println(strb.toString());
  }
}

//自作StringBuilder
class MyStringBuilder2
{
 private int size = 0; //儲存字串長度
 private int capacity = 0; //實際可以儲存的容量
 private char[] buffer;   //儲存的字元

 //預設容量16
 //建構子
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

 //插入
 public MyStringBuilder2 insert(int offset,MyStringBuilder2 s)
  {
   char[] newBuffer = new char[size + s.length()];//新字串
   for(int i=0;i<offset;i++)//先寫入插入前的字串
    newBuffer[i] = buffer[i];

   for(int i=0;i<s.length();i++)   //插入
    newBuffer[offset+i] = s.charAt(i);

   for(int i=offset;i < buffer.length;i++)//接著寫入後面的
    newBuffer[i+s.length()] = buffer[i];
   return new MyStringBuilder2(newBuffer);
  }

 //反轉
 public MyStringBuilder2 reverse()
  {
   char[] newBuffer = new char[size];//新字串
   for(int i=0;i<size;i++) //將原字串顛倒放入
     newBuffer[i] = buffer[(size-1)-i];

   return new MyStringBuilder2(newBuffer);
  }

 //長度
 public int length()
  {
   return size;
  }

 //取出字元
 public char charAt(int index)
  {  
   return buffer[index];
  }

 //轉為大寫
 public MyStringBuilder2 toUpperCase()
  {
   for(int i=0;i<size;i++)
    {
     if(buffer[i]>='a' && buffer[i] <= 'z')//若在小寫區間
      buffer[i] = (char)('A'+(buffer[i]-'a'));
    }
   return new MyStringBuilder2(buffer);
  }

 //分出子字串
 public MyStringBuilder2 substring(int begin)
  {
   char[] newBuffer = new char[(size - begin)];
   for(int i=begin,j=0;i<size;i++,j++)
    newBuffer[j] = buffer[i];
   return new MyStringBuilder2(newBuffer);
  }

 //顯示
 public String toString()
  {
   String s = "";
   for(int i=0;i<size;i++)
    s += buffer[i];
   return s;
  }
}
      