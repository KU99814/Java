//Parent reference for BinaryTree

public class EX25_19
{
 public static void main(String args[])
  {
   BinaryTree<Integer> tree = new BinaryTree<Integer>();//binary tree

   //�̧ǥ[�J1~100
   for(int i=1;i<=100;i++)
    tree.insert(i);

   java.util.ArrayList leaf = tree.findLeaf();//tree�Ҧ���leaf
   java.util.ArrayList path;//���|

   //�M�X�Ҧ�leaf
   for(int i=0;i<leaf.size();i++)
    {
     path = tree.getPath((TreeNode)leaf.get(i));//leaf�����|
     for(int j=0;j<path.size();j++)//���
      System.out.print((Integer)((TreeNode)path.get(j)).element+" ");
    }
  }
}