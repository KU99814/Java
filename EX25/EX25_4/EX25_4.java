//Implementing postorder without using recusion

public class EX25_4
{
 public static void main(String args[])
  {
   BinaryTree<String> tree = new BinaryTree<String>();//宣告一binary tree

   //插入node
   tree.insert("George");
   tree.insert("Michael");
   tree.insert("Tom");
   tree.insert("Adam");
   tree.insert("Jones");
   tree.insert("Peter");
   tree.insert("Daniel");

   //顯示排序
   System.out.print("Inorder (sorted):");
   tree.inorder();//中序
   System.out.print("\n Postorder:");
   tree.postorder();//後序
   System.out.print("\n Preorder:");
   tree.preorder();//前序
  }
}