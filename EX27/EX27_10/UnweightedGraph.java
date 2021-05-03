//Unweighted Graph class

import java.util.*;
import java.io.*;

public class UnweightedGraph extends AbstractGraph implements Serializable
{
 //contructor
 //輸入陣列
 public UnweightedGraph(int[][] edges,Object[] vertices)
  {
   super(edges,vertices);
  }

 //contructor
 //輸入list
 public UnweightedGraph(List<Edge> edges,List vertices)
  {
   super(edges,vertices);
  }

 //contructor
 //照順序創出vertex
 public UnweightedGraph(List<Edge> edges,int numberOfVertices)
  {
   super(edges,numberOfVertices);
  }

 //contructor
 //輸入邊陣列
 //照順序創出vertex
 public UnweightedGraph(int[][] edges,int numberOfVertices)
  {
   super(edges,numberOfVertices);
  }
}