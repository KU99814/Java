//knight tour model

import java.util.*;

public class KnightTourModel
{
 private ArrayList<Edge> edges = new ArrayList<Edge>();//edge���Y
 private UnweightedGraph graph;//�H�M�h�B��N��m�۳s����graph
 int num = 6;//�@�檺���

 //default
 public KnightTourModel()
  {
   createEdges();//�гy�����Y
   
   graph = new UnweightedGraph(edges,num*num);//�Ы�graph object
  }

 //��XHamiltonian Cycle
 public List<Integer> getHamiltonianCycle()
  {
   //�I�sgraph��method
   return graph.getHamiltonianCycle();
  }

 //��XHamiltonian Path
 public List<Integer> getHamiltonianPath(int v)
  {
   //�I�sgraph��method
   return graph.getHamiltonianPath(v);
  }

 //�N�ϥH�M�h�B��Ӭ۳s
 public void createEdges()
  {
   //�M�X�C�@vertex�ñN�U�@�B����l�@���F�~�۳s
   for(int i=0;i<num;i++)//��
    for(int j=0;j<num;j++)//�C
     {
      int u=i*num+j;//�ثe����l
      
      //�P�_�Ӥ�V���k�O�_���U�@�B �إ������Y
      if(i-1 >= 0 && j-2 >= 0)
       {
        int v1 = (i-1)*num+(j-2);
        edges.add(new Edge(u,v1));
       }
    
      if(i-2 >= 0 && j-1 >= 0)
       {
        int v2 = (i-2)*num+(j-1);
        edges.add(new Edge(u,v2));
       }
    
      if(i-2 >= 0 && j+1 <= num-1)
       {
        int v3 = (i-2)*num+(j+1);
        edges.add(new Edge(u,v3));
       }   
      
      if(i-1 >= 0 && j+2 <= num-1)
       {
        int v4 = (i-1)*num+(j+2);
        edges.add(new Edge(u,v4));
       }
      
      if(i+1 <= num-1 && j+2 <= num-1)
       {
        int v5 = (i+1)*num+(j+2);
        edges.add(new Edge(u,v5));
       }
      
      if(i+2 <= num-1 && j+1 <= num-1)
       {
        int v6 = (i+2)*num+(j+1);
        edges.add(new Edge(u,v6));
       }   
   
      if(i+2 <= num-1 && j-1 >= 0)
       {
        int v7 = (i+2)*num+(j-1);
        edges.add(new Edge(u,v7));
       } 
    
      if(i+1 <= num-1 && j-2 >= 0)
       {
        int v8 = (i+1)*num+(j-2);
        edges.add(new Edge(u,v8));
       }
     }
  }
}