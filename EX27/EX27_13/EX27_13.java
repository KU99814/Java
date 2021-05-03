//Induced subgraph

public class EX27_13
{
 public static void main(String[] args)
  {
   //測試vertices
   String[] vertices = {"Seattle","San Francisco","Losa Angles",
                        "Denver","Kansas City","Chicago","Boston","New York",
                        "Atlanta","Miami","Dallas","Houston"};
   
   //測試edges
   int[][] edges = {{0,1},{0,3},{0,5},
                    {1,0},{1,2},{1,3},
                    {2,1},{2,3},{2,4},{2,10},
                    {3,0},{3,2},{3,4},{3,5},
                    {4,2},{4,3},{4,5},{4,7},{4,8},{4,10},
                    {5,0},{5,3},{5,4},{5,6},{5,7},
                    {6,5},{6,7},
                    {7,4},{7,5},{7,6},{7,8},
                    {8,4},{8,7},{8,9},{8,10},{8,11},
                    {9,8},{9,11},
                    {10,2},{10,4},{10,8},{10,11},
                    {11,8},{11,9},{11,10}};
   
   Graph graph1 = new UnweightedGraph(edges,vertices);//創建graph

   Graph subgraph = AbstractGraph.maxInducedSubgraph(graph1,3);//創建子圖

   //顯示兩圖vertices數量
   System.out.println("graph's vertices: "+graph1.getSize());
   System.out.println("subgraph's vertices: "+subgraph.getSize());

   //若子圖存在 顯示
   if(subgraph!=null)
    {
     Object[] getver = subgraph.getVertices();
    
     for(int i=0;i<getver.length;i++)
      System.out.println((String)(getver[i]));
    }
  }
}