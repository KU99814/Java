//Implementing bidirectional iterator

public class EX25_9
{
 public static void main(String args[])
  {
   BinaryTree<String> tree = new BinaryTree<String>();//�ŧibinary tree

   //�[�Jelement
   tree.insert("Red");
   tree.insert("Yellow");
   tree.insert("Green");
   tree.insert("Blue");
   tree.insert("Pink");

   java.util.ListIterator iterator = tree.listIterator();//�ŧiBidirectionalIterator

   tree.inorder();//��ܤ���

   System.out.println();


   //���iterator���e
   while(iterator.hasNext())
    {
     System.out.print(iterator.next()+" ");
    }

   System.out.println();

   //�˹L�����iterator���e
   while(iterator.hasPrevious())
    {
     System.out.print(iterator.previous()+" ");
    }

   iterator.remove();//�����ثeindex

   System.out.println();

   //����ܧ�   
   while(iterator.hasNext())
    {
     System.out.print(iterator.next()+" ");
    }

   iterator.previous();//���e�@��

   System.out.println();
   iterator.set("RED");//�ܧ�

   //����ܧ�   
   while(iterator.hasNext())
    {
     System.out.print(iterator.next()+" ");
    }

  }
}