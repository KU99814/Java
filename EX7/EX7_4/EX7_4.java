public class EX7_4
{
 public static void main(String args[])
  {
   Stock Stock1 = new Stock("SUNW","Sun Microsystems Inc");//布

   //砞﹚Μ絃基籔瞷基窥
   Stock1.setPreviousClosingPrice(100);
   Stock1.setCurrentPrice(90);

   //陪ボ布篈
   System.out.print("The "+Stock1.getSymbol()+" "+Stock1.getName());
   System.out.print("The percentage is "+(double)((int)(Stock1.getChangePercent()*100))/100+"%");
  }
}