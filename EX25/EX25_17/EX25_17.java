//Counting nodes with depth k

public class EX25_17
{
 public static void main(String args[])
  {
   BinaryTree<Integer> tree = new BinaryTree<Integer>();//�Ы�binary tree

   //��Jelement
   tree.insert(50);
   tree.insert(25);
   tree.insert(75);
   tree.insert(12);
   tree.insert(30);
   tree.insert(70);
   tree.insert(80);
   tree.insert(10);
   tree.insert(110);

   //��ܱƧ�
   System.out.print("Inorder (sorted):");
   tree.inorder();//����

   System.out.println("\nThe number of nodes is " + tree.getSize());//node�Ӽ�
   
   java.util.Scanner input = new java.util.Scanner(System.in);//�ŧi��J

   //��J���w�`��
   System.out.println("Enter depth: ");
   int depth = input.nextInt();

   System.out.println("The depth "+depth+" has "+tree.countDepth(depth)+" node.");//��ܫ��w�`�׭Ӽ�
  }
}