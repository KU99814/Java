//implement MyStack using inheritance

import java.util.Scanner;

public class EX10_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   MyStack stack = new MyStack(); //宣告Mystack

   //輸入字串
   String s1 = input.next();
   String s2 = input.next();

   //將輸入字串放入stack
   stack.push(s1);
   stack.push(s2);

   //放出
   stack.pop();

   //再放入
   stack.push(789);

   //顯示目前狀態
   System.out.print(stack.toString());
  }
}
 
//extends ArrayList的MyStack
class MyStack extends java.util.ArrayList
{
 //建構子
 public MyStack()
  {}

 //判斷是否空
 public boolean isEmpty()
  {
   return super.isEmpty();
  }

 //取得大小
 public int getSize()
  {
   return size();
  }

 //顯示最上層
 public Object peek()
  {
   return get(getSize() - 1);
  }

 //排出與顯示最上層
 public Object pop()
  {
   Object o = get(getSize() - 1);//最上層物件
   remove(getSize() - 1); //移除
   return o; //回傳
  }

 public Object push(Object o)//放入
  {
   add(o);
   return o;
  }

 public int search(Object o) //搜尋
  {
   return lastIndexOf(o);
  }

 //顯示
 public String toString()
  {
   return "stack: "+super.toString();
  }
}
