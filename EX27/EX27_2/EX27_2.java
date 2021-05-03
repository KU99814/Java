//find connectedComponents

public class EX27_2
{
 public static void main(String args[])
  {
   //測試vertices
   String[] vertices = {"Seattle","San Francisco","Losa Angles",
                        "Denver","Kansas City","Chicago","Boston","New York",
                        "Atlanta","Miami","Dallas","Houston"};

   //測試edge 省略一部分分為多個component
   int[][] edges = {{0,1},{0,3},/*{0,5},*/
                    {1,0},{1,2},{1,3},
                    {2,1},{2,3}/*,{2,4},{2,10}*/,
                    {3,0},{3,2},/*{3,4},{3,5},*/
                    //{4,2},{4,3},{4,5},{4,7},{4,8},{4,10},
                    //{5,0},{5,3},/*{5,4},*/{5,6},
                    //{5,7},
                    //{6,5},{6,7},
                    //{7,4},{7,5},{7,6},
                    {7,8},
                    /*{8,4},*/{8,7},{8,9},/*{8,10},*/{8,11},
                    {9,8},{9,11},
                    //{10,2},{10,4},{10,8},{10,11},
                    {11,8},{11,9}/*,{11,10}*/};

   Graph graph = new UnweightedGraph(edges,vertices);//創建graph

   //component list
   java.util.List<AbstractGraph.Tree> list = graph.getConnectComponent();

   System.out.println(list.size()+" element");//顯示分為幾個component
   
   //依序顯示各component包含的vertex
   for(int i=0;i<list.size();i++)
    {
     AbstractGraph.Tree tree = (AbstractGraph.Tree)(list.get(i));//component
     java.util.List<Integer> number = tree.getSearchOrders();//包含vertices
     
     //顯示
     for(int j=0;j<number.size();j++)
       System.out.print(vertices[number.get(j)]+" ");
     System.out.println();
    }
  }
}