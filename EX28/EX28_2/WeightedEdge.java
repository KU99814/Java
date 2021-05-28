//有值edge

public class WeightedEdge extends Edge implements Comparable<WeightedEdge>
{
 public int weight;//權值

 //constructor
 public WeightedEdge(int u,int v,int weight)
  {
   super(u,v);
   this.weight = weight;
  }

 //比較大小
 public int compareTo(WeightedEdge edge)
  {
   //比較彼此的權值
   if(weight > edge.weight)
    return 1;
   else if(weight == edge.weight)
    return 0;
   else
    return -1;
  }
}