//Implementing postorder without using recusion

public class EX25_4
{
 public static void main(String args[])
  {
   BinaryTree<String> tree = new BinaryTree<String>();//�ŧi�@binary tree

   //���Jnode
   tree.insert("George");
   tree.insert("Michael");
   tree.insert("Tom");
   tree.insert("Adam");
   tree.insert("Jones");
   tree.insert("Peter");
   tree.insert("Daniel");

   //��ܱƧ�
   System.out.print("Inorder (sorted):");
   tree.inorder();//����
   System.out.print("\n Postorder:");
   tree.postorder();//���
   System.out.print("\n Preorder:");
   tree.preorder();//�e��
  }
}