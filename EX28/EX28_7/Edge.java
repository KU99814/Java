//edge
//要輸出成檔案 序列化

import java.io.*;

public class Edge implements Serializable
{
 int u;//vertex 1
 int v;//vertex 2

 //constructor
 public Edge(int u,int v)
  {
   //取得vertex
   this.u = u;
   this.v = v;
  }
}