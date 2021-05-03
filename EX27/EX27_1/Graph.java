//Graph interface

import java.util.*;

public interface Graph
{
 public int getSize();//���o�j�p

 public Object[] getVertices();//���overtex�}�C

 public Object getVertex(int index);//���o���windex��vertex

 public int getIndex(Object v);//���o���wvertex��index

 public java.util.List getNeighbors(int v);//���o�۳s��}�C

 public int getDegree(int v);//���o���windex vertex���۳s��

 public int[][] getAdjacencyMatrix();//���o�۾F�}�C

 public void printAdjacencyMatrix();//��ܬ۾F�}�C

 public void printEdges();//��ܩҦ���

 //AbstractGraph
 public AbstractGraph.Tree dfs(int v);//���ospinner tree��depth first search(�HV��root)

 public AbstractGraph.Tree bfs(int v);//���ospinner tree��breath first search(�HV��root)

 public List<Integer> getHamiltonianPath(Object vertex);//���o���windex��Hamiltonian Path

 public List<Integer> getHamiltonianPath(int v);//���o���wvertex��Hamiltonian Path

}