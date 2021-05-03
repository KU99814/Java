//Unweighted Graph class

import java.util.*;
import java.io.*;

public class UnweightedGraph extends AbstractGraph implements Serializable
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