public class EX7_4
{
 public static void main(String args[])
  {
   Stock Stock1 = new Stock("SUNW","Sun Microsystems Inc");//�ŧi�Ѳ�

   //�]�w���L���P�{�b����
   Stock1.setPreviousClosingPrice(100);
   Stock1.setCurrentPrice(90);

   //��ܪѲ����A
   System.out.print("The "+Stock1.getSymbol()+" "+Stock1.getName());
   System.out.print("The percentage is "+(double)((int)(Stock1.getChangePercent()*100))/100+"%");
  }
}