//Parent reference for BinaryTree

public class EX25_19
{
 public static void main(String args[])
  {
   BinaryTree<Integer> tree = new BinaryTree<Integer>();//binary tree

   //依序加入1~100
   for(int i=1;i<=100;i++)
    tree.insert(i);

   java.util.ArrayList leaf = tree.findLeaf();//tree所有的leaf
   java.util.ArrayList path;//路徑

   //尋訪所有leaf
   for(int i=0;i<leaf.size();i++)
    {
     path = tree.getPath((TreeNode)leaf.get(i));//leaf的路徑
     for(int j=0;j<path.size();j++)//顯示
      System.out.print((Integer)((TreeNode)path.get(j)).element+" ");
    }
  }
}