//����edge

public class WeightedEdge extends Edge implements Comparable<WeightedEdge>
{
 public int weight;//�v��

 //constructor
 public WeightedEdge(int u,int v,int weight)
  {
   super(u,v);
   this.weight = weight;
  }

 //����j�p
 public int compareTo(WeightedEdge edge)
  {
   //����������v��
   if(weight > edge.weight)
    return 1;
   else if(weight == edge.weight)
    return 0;
   else
    return -1;
  }
}