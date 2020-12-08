//implement StringBuilder class

public class EX8_26
{
 public static void main(String args[])
  {
   MyStringBuilder1 strb = new MyStringBuilder1("String");//宣告MyStringBuilder1 
   System.out.println("The stringbuilder is "+strb.toString()); //顯示字串
   strb = strb.append(new MyStringBuilder1(" is")); //加入新字串
   System.out.println(strb.toString()); 
   strb.append(new MyStringBuilder1(" "));
   strb = strb.append(2);
   System.out.println(strb.toString());
   System.out.println("The length is "+strb.length());//顯示長度
   System.out.println("The 3 char is "+strb.charAt(2)); //顯示指定index字元
   strb = strb.toLowerCase();//轉為小寫
   System.out.println(strb.toString());
   strb = strb.substring(0,3);//分出子字串
   System.out.println(strb.toString());
  }
}

//自作的MyStringBuilder
class MyStringBuilder1
{
 private int size = 0; //儲存字串長度
 private int capacity = 0; //實際可以儲存的容量
 private char[] buffer;   //儲存的字元

 //預設容量16
 public MyStringBuilder1()
  {
   buffer = new char[16];
   capacity = 16;
  }

 public MyStringBuilder1(char[] chars)//建構子
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

 //加入字
 public MyStringBuilder1 append(MyStringBuilder1 s)
  {
   int addSize = s.length();

   //容量不夠的話擴充
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
   for(int i=size,j=0;i<size+addSize;i++,j++)//加到最後面
    buffer[i] = s.charAt(j);

   size = size+addSize;
   
   return new MyStringBuilder1(buffer);
  }

 //加入數字
 public MyStringBuilder1 append(int i)
  {
   return append(new MyStringBuilder1(String.valueOf(i)));
  }

 //長度
 public int length()
  {
   return size;
  }

 //取得字元
 public char charAt(int index)
  {  
   return buffer[index];
  }
  
 //轉為小寫
 public MyStringBuilder1 toLowerCase()
  {
   for(int i=0;i<size;i++)
    {
     if(buffer[i]>='A' && buffer[i] <= 'Z')
      buffer[i] = (char)('a'+(buffer[i]-'A'));
    }
   return new MyStringBuilder1(buffer);
  }

 //分出子字串
 public MyStringBuilder1 substring(int begin,int end)
  {
   char[] newBuffer = new char[end - begin];//新字元陣列
   for(int i=begin,j=0;i<end;i++,j++)
    newBuffer[j] = buffer[i];
   return new MyStringBuilder1(newBuffer);
  }

 //顯示內容
 public String toString()
  {
   String s = "";
   for(int i=0;i<size;i++)
    s += buffer[i];
   return s;
  }
}      