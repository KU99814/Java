//implement String class

public class EX8_23
{
 public static void main(String args[])
  {
   MyString1 s = new MyString1(new char[]{'M','y','S','t','r','i','n','g'});//宣告MyString

   System.out.println("The char at 2 is "+s.charAt(2)); //顯示第幾個字元
   System.out.println("The length of s are "+s.length()); //顯示字串長度

   MyString1 subString = s.subString(0,5); //分出子字串

   System.out.print("The substring of s is ");//顯示子字串

   for(int i=0;i<subString.length();i++) 
    System.out.print(subString.charAt(i));
   System.out.println();

   char[] ch = s.toChars(); //將字串轉為字元陣列
   System.out.print("The character of s is "); //顯示陣列內容
   for(int i=0;i<ch.length;i++)
    System.out.print(ch[i]+" ");
   System.out.println();

   MyString1 lowerString = s.toLowerCase();//全轉為小寫
   System.out.print("The s to lower case is ");
   for(int i=0;i<lowerString.length();i++)
    System.out.print(lowerString.charAt(i));
   System.out.println();

   System.out.println("String is equal to s ? " +
                        s.equals(new MyString1(new char[]{'s','u','b'})));

   MyString1 value = MyString1.valueOf(-500); //將int轉為MyString1
   for(int i=0;i<value.length();i++)
    System.out.print(value.charAt(i));
  }
}

//自作的String
class MyString1
{
 char[] ch; //儲存字元

 public MyString1(char[] chars)//宣告建構
  {
   ch = new char[chars.length];
   System.arraycopy(chars,0,ch,0,chars.length);
  }

 public char charAt(int index)//回傳第幾個字
  {
   return ch[index];
  }

 public int length() //回傳字串長度
  {
   return ch.length;
  }

 public MyString1 subString(int begin,int end) //分出子字串
  {
   char[] newC = new char[end - begin];//創新的字元陣列
   
   for(int i=begin,j=0;i<end;i++,j++)//從指定的index開始放入
    newC[j] = ch[i];
   
   return new MyString1(newC);//回傳
  }

 public char[] toChars()//回傳字元陣列
  {
   //因為是新的陣列 複製新的回傳
   char[] reCh = new char[ch.length];
   System.arraycopy(ch,0,reCh,0,ch.length);
   return reCh;
  }

 public MyString1 toLowerCase()//回傳全部小寫
  {
   char[] lower = new char[ch.length];//創新陣列

   for(int i=0;i<ch.length;i++)
    {
     if(ch[i]>='A' && ch[i] <= 'Z')//判斷是否大寫
      lower[i] = (char)('a' + (ch[i] - 'A'));
     else
      lower[i] = ch[i];
    }
  
   return new MyString1(lower);//回傳
  }

 public boolean equals(MyString1 s)//判斷是否相等
  {
   if(s.length()!=ch.length)
    return false;
   for(int i=0;i<ch.length;i++)//逐字比較
    {
     if(ch[i] != s.charAt(i))
      return false;//有一處不同就
    }
   
   return true;//回傳結果
  }

 //將int轉為MyString
 public static MyString1 valueOf(int i)
  {
   int plus = 0;//判斷正負0為正 1為負

   if(i < 0)//負數的話
    {
     i*=-1;//負轉正方便計算
     plus++;
    }
   
   int digit = 0;//數字位數
   int num = i;
 
   //算出位數來決定字串長度
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

   num = i;//重新放入i

   for(int k=digit-1;k>=plus;k--)//以倒敘方式放入陣列
    {
     int j = (num%10);
     reInt[k] = (char)('0'+j);
     num/=10;
    }
   
   return new MyString1(reInt);//回傳
  }
} 