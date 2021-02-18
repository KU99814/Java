//Generic BinaryTree using Comparator

import java.util.Comparator;

public class EX25_16 {
  public static void main(String[] args) {
    BinaryTree<GeometricObject> tree =
      new BinaryTree<GeometricObject>(new GeometricObjectComparator());//binary tree 使用GeometricObjectComparator

    //放入circle
    tree.insert(new Circle(3));
    tree.insert(new Circle(5));
    tree.insert(new Circle(1));

    tree.inorder();//顯示中序
  }

 //幾何comparator
 static class GeometricObjectComparator implements Comparator<GeometricObject>
  {
   //default
   public GeometricObjectComparator()
    {}

   //比較大小
   public int compare(GeometricObject o1, GeometricObject o2)
    {
     return o1.compareTo(o2);
    }
  }
}