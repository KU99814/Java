//Unweighted Graph class

import java.util.*;

public class UnweightedGraph extends AbstractGraph
{
 //contructor
 //��J�}�C
 public UnweightedGraph(int[][] edges,Object[] vertices)
  {
   super(edges,vertices);
  }

 //contructor
 //��Jlist
 public UnweightedGraph(List<Edge> edges,List vertices)
  {
   super(edges,vertices);
  }

 //contructor
 //�Ӷ��ǳХXvertex
 public UnweightedGraph(List<Edge> edges,int numberOfVertices)
  {
   super(edges,numberOfVertices);
  }

 //contructor
 //��J��}�C
 //�Ӷ��ǳХXvertex
 public UnweightedGraph(int[][] edges,int numberOfVertices)
  {
   super(edges,numberOfVertices);
  }
}