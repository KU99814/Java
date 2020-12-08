//implement character class 

public class EX8_25
{
 public static void main(String args[])
  {
   MyCharacter ch = new MyCharacter('a');//宣告MyCharacter
   
   System.out.println("The char is "+ch.charValue()); //顯示值
   System.out.println("Thm compare to b is "+ch.compareTo(new MyCharacter('b')));//比較
   System.out.println("Is the char equal to b ? "+ch.equals(new MyCharacter('b')));//判斷是否相等
   System.out.println("Is b a digit ? " +MyCharacter.isDigit('b'));//判斷是否數字
   System.out.println("Is b a letter ? " +MyCharacter.isLetter('b'));//判斷是否文字
   System.out.println("Is C is a letter or digit ? "+MyCharacter.isLetterOrDigit('b'));//判斷是數字或文字
   System.out.println("Is b a lower case ? " + MyCharacter.isLowerCase('b'));//判斷是否小寫
   System.out.println("Is b a upper case ? " + MyCharacter.isUpperCase('b'));//判斷是否大寫
   System.out.println("what is B in lower case ? " + MyCharacter.toLowerCase('B')); //轉為小寫
   System.out.println("what is b in upper case ? " + MyCharacter.toUpperCase('b')); //轉為大寫
  }
}

//自作Character
class MyCharacter
{
 private char c;//字元
 
 public MyCharacter(char value)//建構子
  {
   c = value;
  }

 public char charValue()//裡面儲存的字元
  {
   return c;
  }

 public int compareTo(MyCharacter ano)//比較
  {
   int num = (int)(c - ano.charValue()); //相減後轉為數字

   return num; //回傳
  }

 //判斷是否相等
 public boolean equals(char ch)
  {
   if(c == ch)//可用等號判斷
    return true;
   else
    return false;
  }

 //判斷是否數字
 public static boolean isDigit(char ch)
  {
   if(ch >= '1' && ch <= '9')//判斷是否在0~9的區間
    return true;
   
   return false;
  }

 //判斷是否文字
 public static boolean isLetter(char ch)
  {
   //判斷是否在大 小寫字母區間
   if(ch >= 'a' && ch <= 'z')
    return true;
   if(ch >= 'A' && ch <= 'Z')
    return true;
   
   return false;
  }

 //判斷數字或文字
 public static boolean isLetterOrDigit(char ch)
  {
   //利用前面的method
   if(isLetter(ch) || isDigit(ch))
    return true;
   
   return false;
  }

 //判斷是否小寫字母
 public static boolean isLowerCase(char ch)
  {
   if(ch >= 'a' && ch <= 'z')//判斷是否在小寫字母區間
    return true;

   return false;
  }

 //判斷是否大寫字母
 public static boolean isUpperCase(char ch)
  {
   if(ch >= 'A' && ch <= 'Z') //判斷是否在大寫字母區間
    return true;

   return false;
  }

 public static char toLowerCase(char ch)//輸出小寫
  {
   if(ch >= 'A' && ch <= 'Z')
    return (char)('a' + (ch - 'A'));
   else
    return ch;
  }

 //輸出大寫
 public static char toUpperCase(char ch)
  {
   if(ch >= 'a' && ch <= 'z')
    return (char)('A' + (ch - 'a'));
   else
    return ch;
  }
}