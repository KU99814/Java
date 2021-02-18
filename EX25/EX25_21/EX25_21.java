//Tree clone and equals

public class EX25_21
{
 public static void main(String args[])
  {
   BinaryTree<String> tree = new BinaryTree<String>();//第一個binary tree

   //放入element
   tree.insert("George");
   tree.insert("Michael");
   tree.insert("Tom");
   tree.insert("Adam");
   tree.insert("Jones");
   tree.insert("Peter");
   tree.insert("Daniel");

   BinaryTree<String> tree2;//第二個tree

   tree2 = tree.clone();//複製tree

   //顯示第一個樹的排序
   //中序
   System.out.print("Inorder (tree1):");
   tree.inorder();
   //後序
   System.out.print("\n Postorder:");
   tree.postorder();
   //前序
   System.out.print("\n Preorder:");
   tree.preorder();

   //顯示第二個樹的排序
   //中序
   System.out.print("\n\nInorder (tree2):");
   tree2.inorder();
   //前序
   System.out.print("\n Postorder:");
   tree2.postorder();
   //後序
   System.out.print("\n Preorder:");
   tree2.preorder();

   System.out.println("\n"+tree.equals(tree2));//判斷是否相等

   tree.delete("Peter");//第一樹刪除一element

   //再顯示排序
   //第一樹
   System.out.print("\n\nInorder (tree1):");
   tree.inorder();

   //第二樹
   System.out.print("\nInorder (tree2):");
   tree2.inorder();

   //再判斷是否相等
   System.out.println("\n"+tree.equals(tree2));
  }
}