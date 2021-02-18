//Tree clone and equals

public class EX25_21
{
 public static void main(String args[])
  {
   BinaryTree<String> tree = new BinaryTree<String>();//�Ĥ@��binary tree

   //��Jelement
   tree.insert("George");
   tree.insert("Michael");
   tree.insert("Tom");
   tree.insert("Adam");
   tree.insert("Jones");
   tree.insert("Peter");
   tree.insert("Daniel");

   BinaryTree<String> tree2;//�ĤG��tree

   tree2 = tree.clone();//�ƻstree

   //��ܲĤ@�Ӿ𪺱Ƨ�
   //����
   System.out.print("Inorder (tree1):");
   tree.inorder();
   //���
   System.out.print("\n Postorder:");
   tree.postorder();
   //�e��
   System.out.print("\n Preorder:");
   tree.preorder();

   //��ܲĤG�Ӿ𪺱Ƨ�
   //����
   System.out.print("\n\nInorder (tree2):");
   tree2.inorder();
   //�e��
   System.out.print("\n Postorder:");
   tree2.postorder();
   //���
   System.out.print("\n Preorder:");
   tree2.preorder();

   System.out.println("\n"+tree.equals(tree2));//�P�_�O�_�۵�

   tree.delete("Peter");//�Ĥ@��R���@element

   //�A��ܱƧ�
   //�Ĥ@��
   System.out.print("\n\nInorder (tree1):");
   tree.inorder();

   //�ĤG��
   System.out.print("\nInorder (tree2):");
   tree2.inorder();

   //�A�P�_�O�_�۵�
   System.out.println("\n"+tree.equals(tree2));
  }
}