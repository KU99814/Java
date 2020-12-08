//布 class

public class Stock
{
 String symbol; //才腹
 String name; //
 double previousClosingPrice;//ぇ玡Μ絃基
 double currentPrice; //ヘ玡基

 //
 Stock(String newSymbol,String newName)
  {
   symbol = newSymbol;
   name = newName;
  }

 //肚才腹
 String getSymbol()
  {
   return symbol;
  }

 //肚
 String getName()
  {
   return name;
  }

 //肚ぇ玡Μ絃基
 double getPreviousClosingPrice()
  {
   return previousClosingPrice;
  }

 //肚ヘ玡基
 double getCurrentPrice()
  {
   return currentPrice;
  }

 //砞﹚ぇ玡Μ絃基
 void setPreviousClosingPrice(double newPreviousClosingPrice)
  {
   previousClosingPrice = newPreviousClosingPrice;
  }

 //砞﹚ヘ玡基
 void setCurrentPrice(double newCurrentPrice)
  {
   currentPrice = newCurrentPrice;
  }

 //肚э跑κだゑ
 double getChangePercent()
  {
   return (previousClosingPrice/currentPrice)*100;
  }
}