//Counting nodes with depth k

public class EX25_17
{
 public static void main(String args[])
  {
   BinaryTree<Integer> tree = new BinaryTree<Integer>();//創建binary tree

   //放入element
   tree.insert(50);
   tree.insert(25);
   tree.insert(75);
   tree.insert(12);
   tree.insert(30);
   tree.insert(70);
   tree.insert(80);
   tree.insert(10);
   tree.insert(110);

   //顯示排序
   System.out.print("Inorder (sorted):");
   tree.inorder();//中序

   System.out.println("\nThe number of nodes is " + tree.getSize());//node個數
   
   java.util.Scanner input = new java.util.Scanner(System.in);//宣告輸入

   //輸入指定深度
   System.out.println("Enter depth: ");
   int depth = input.nextInt();

   System.out.println("The depth "+depth+" has "+tree.countDepth(depth)+" node.");//顯示指定深度個數
  }
}