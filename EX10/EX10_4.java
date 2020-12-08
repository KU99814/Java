//implement MyStack using inheritance

import java.util.Scanner;

public class EX10_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   MyStack stack = new MyStack(); //�ŧiMystack

   //��J�r��
   String s1 = input.next();
   String s2 = input.next();

   //�N��J�r���Jstack
   stack.push(s1);
   stack.push(s2);

   //��X
   stack.pop();

   //�A��J
   stack.push(789);

   //��ܥثe���A
   System.out.print(stack.toString());
  }
}
 
//extends ArrayList��MyStack
class MyStack extends java.util.ArrayList
{
 //�غc�l
 public MyStack()
  {}

 //�P�_�O�_��
 public boolean isEmpty()
  {
   return super.isEmpty();
  }

 //���o�j�p
 public int getSize()
  {
   return size();
  }

 //��̤ܳW�h
 public Object peek()
  {
   return get(getSize() - 1);
  }

 //�ƥX�P��̤ܳW�h
 public Object pop()
  {
   Object o = get(getSize() - 1);//�̤W�h����
   remove(getSize() - 1); //����
   return o; //�^��
  }

 public Object push(Object o)//��J
  {
   add(o);
   return o;
  }

 public int search(Object o) //�j�M
  {
   return lastIndexOf(o);
  }

 //���
 public String toString()
  {
   return "stack: "+super.toString();
  }
}
