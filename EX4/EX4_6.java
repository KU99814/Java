//Conversion from miles to kilometers

public class EX4_6
{
 public static void main(String args[])
  {
   System.out.println("Miles\t\tKilometers\t\tKilometer\t    Miles"); //顯示浬與公里的互相轉換
   
   for(int i =1,j=20;i<11;i++,j+=5) //i為浬 j為公里
    {
     double kilo = i*1.609; //浬轉公里
     double mile = j/1.609; //公里轉浬
     System.out.print(i+"\t\t"+kilo+"\t\t\t");
     System.out.printf("%d\t\t%10.3f\n",j,mile);
    }
  }
}