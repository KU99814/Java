//Finding the leaves

public class EX25_5
{
 public static void main(String args[])
  {
   BinaryTree<String> tree = new BinaryTree<String>();//�ŧi�G����

   //�Nnode���J��
   tree.insert("George");
   tree.insert("Michael");
   tree.insert("Tom");
   tree.insert("Adam");
   tree.insert("Jones");
   tree.insert("Peter");
   tree.insert("Daniel");

   //���ЧR���P��ܴM�X�Ӫ�ܾ��ܤ�
   System.out.print("postorder (sorted):");
   tree.postorder();//��ǴM�X
   System.out.print("\nThe number of leavess is " + tree.countLeaves());//���leaf�ƶq
   System.out.print("\n delete George: ");
   tree.delete("George");//�R��
   tree.postorder();
   System.out.print("\nThe number of leavess is " + tree.countLeaves());
   System.out.print("\n delete Adam: ");
   tree.delete("Adam");
   tree.postorder();
   System.out.print("\nThe number of leavess is " + tree.countLeaves());
   System.out.print("\n delete Michael: ");
   tree.delete("Michael");
   tree.postorder();
   System.out.print("\nThe number of leavess is " + tree.countLeaves());
   
  }
}