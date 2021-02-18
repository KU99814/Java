//Generic BinaryTree using Comparator

import java.util.Comparator;

public class EX25_16 {
  public static void main(String[] args) {
    BinaryTree<GeometricObject> tree =
      new BinaryTree<GeometricObject>(new GeometricObjectComparator());//binary tree �ϥ�GeometricObjectComparator

    //��Jcircle
    tree.insert(new Circle(3));
    tree.insert(new Circle(5));
    tree.insert(new Circle(1));

    tree.inorder();//��ܤ���
  }

 //�X��comparator
 static class GeometricObjectComparator implements Comparator<GeometricObject>
  {
   //default
   public GeometricObjectComparator()
    {}

   //����j�p
   public int compare(GeometricObject o1, GeometricObject o2)
    {
     return o1.compareTo(o2);
    }
  }
}