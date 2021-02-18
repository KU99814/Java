//Finding the non-leaves

public class EX25_6
{
 public static void main(String args[])
  {
   BinaryTree<String> tree = new BinaryTree<String>();//宣告二元樹

   //將node插入樹
   tree.insert("George");
   tree.insert("Michael");
   tree.insert("Tom");
   tree.insert("Adam");
   tree.insert("Jones");
   tree.insert("Peter");
   tree.insert("Daniel");

   //反覆刪除與顯示尋訪來表示樹的變化
   System.out.print("postorder (sorted):");
   tree.postorder();//後序尋訪
   System.out.print("\nThe number of leavess is " + tree.countNonLeaves());//顯示非leaf數量
   System.out.print("\n delete George: ");
   tree.delete("George");//刪除
   tree.postorder();
   System.out.print("\nThe number of leavess is " + tree.countNonLeaves());
   System.out.print("\n delete Adam: ");
   tree.delete("Adam");
   tree.postorder();
   System.out.print("\nThe number of leavess is " + tree.countNonLeaves());
   System.out.print("\n delete Michael: ");
   tree.delete("Michael");
   tree.postorder();
   System.out.print("\nThe number of leavess is " + tree.countNonLeaves());
   
  }
}