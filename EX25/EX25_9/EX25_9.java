//Implementing bidirectional iterator

public class EX25_9
{
 public static void main(String args[])
  {
   BinaryTree<String> tree = new BinaryTree<String>();//宣告binary tree

   //加入element
   tree.insert("Red");
   tree.insert("Yellow");
   tree.insert("Green");
   tree.insert("Blue");
   tree.insert("Pink");

   java.util.ListIterator iterator = tree.listIterator();//宣告BidirectionalIterator

   tree.inorder();//顯示中序

   System.out.println();


   //顯示iterator內容
   while(iterator.hasNext())
    {
     System.out.print(iterator.next()+" ");
    }

   System.out.println();

   //倒過來顯示iterator內容
   while(iterator.hasPrevious())
    {
     System.out.print(iterator.previous()+" ");
    }

   iterator.remove();//移除目前index

   System.out.println();

   //顯示變更   
   while(iterator.hasNext())
    {
     System.out.print(iterator.next()+" ");
    }

   iterator.previous();//往前一格

   System.out.println();
   iterator.set("RED");//變更

   //顯示變更   
   while(iterator.hasNext())
    {
     System.out.print(iterator.next()+" ");
    }

  }
}