//使用Math計算sin和cos

public class EX5_20
{
 public static void main(String args[])
  {
   System.out.println("Degree\t\tSin\t\tCos");//列表

   for(int i = 0;i<=360;i+=10)
    {
     double s = (int)(Math.sin(Math.toRadians(i))*10000); //sin值 把i轉換成角度
     s /= 10000;//留小數點後四位
     double c = (int)(Math.cos(Math.toRadians(i))*10000); //cos值
     c /= 10000;//留小數點後四位
     System.out.println(i+"\t\t"+s+"\t\t"+c); //顯示
    }
  }
}