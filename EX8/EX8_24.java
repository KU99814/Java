//implement String class 2

public class EX8_24
{
 public static void main(String args[])
  {
   MyString2 s = new MyString2(new char[]{'m','y','s','t','r','i','n','g'});//宣告MyString2

   //與另一個MyString2作比較
   System.out.println("The compare s and s2 is "+
                       s.compare(new MyString2(new char[]{'a','y','s','t','r','i','n','g','2'})));
 
   MyString2 subS = s.substring(3);//分出子字串
   System.out.print("The substring of begin 3 is ");
   char[] c1 = subS.toChars(); //顯示
   for(int i=0;i<c1.length;i++)
    System.out.print(c1[i]);
   System.out.println();

   MyString2 upperS = s.toUpperCase();//顯示全部大寫
   System.out.print("The upper of s is ");
   char[] c2 = upperS.toChars();
   for(int i=0;i<c2.length;i++)
    System.out.print(c2[i]);
   System.out.println();
   
   MyString2 valueS = MyString2.valueOf(true); //將布林值轉為字串
   
   char[] c3 = valueS.toChars();
   for(int i=0;i<c3.length;i++)
    System.out.print(c3[i]);
   System.out.println();
  }
}

//自作的String
class MyString2
{
 private char[] ch;//存放字元的陣列

 public MyString2(char[] chars)//建構子
  {
   ch = new char[chars.length];
   System.arraycopy(chars,0,ch,0,chars.length);
  }

 public int compare(MyString2 s)//比較
  {
   char[] c2 = s.toChars();

   int max = 0;
   if(c2.length > ch.length)
    max = c2.length;
   else
    max = ch.length; //找出哪個長度較長 避免Index ex
   int num = 0;
   //逐字相減 回傳最後得出的數
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

 //分出子字串
 public MyString2 substring(int begin)
  {
   char[] c1 = new char[ch.length - begin];

   for(int i=begin,j=0;i<ch.length;i++,j++)//從begin開始到最後面
    c1[j] = ch[i];
   
   return new MyString2(c1);//回傳子字串
  }

 //回傳全部大寫的字串
 public MyString2 toUpperCase()
  {
   char[] c = new char[ch.length];//取得長度
   for(int i=0;i<ch.length;i++)
    {
     if(ch[i] >= 'a' && ch[i] <= 'z')  //逐字判斷並轉換
      c[i] = (char)('A'+(ch[i] - 'a'));
     else
      c[i] = ch[i];
    }
   
   return new MyString2(c); //回傳
  }

 //轉為字元陣列
 public char[] toChars()
  {
   char[] reCh = new char[ch.length];//另創一個新陣列避免影響
   for(int i=0;i<ch.length;i++)
    reCh[i] = ch[i];
   return reCh; //直接回傳內存的陣列
  }

 //布林值轉字串 
 public static MyString2 valueOf(boolean b)
  {
   if(b)
    return new MyString2(new char[]{'t','r','u','e'});
   else
    return new MyString2(new char[]{'f','a','l','s','e'});
  }
}
   
      