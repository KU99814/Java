//�Ѳ� class

public class Stock
{
 String symbol; //�Ÿ�
 String name; //�W�r
 double previousClosingPrice;//���e�����L��
 double currentPrice; //�ثe������

 //�ŧi
 Stock(String newSymbol,String newName)
  {
   symbol = newSymbol;
   name = newName;
  }

 //�^�ǲŸ�
 String getSymbol()
  {
   return symbol;
  }

 //�^�ǦW�r
 String getName()
  {
   return name;
  }

 //�^�Ǥ��e�����L��
 double getPreviousClosingPrice()
  {
   return previousClosingPrice;
  }

 //�^�ǥثe������
 double getCurrentPrice()
  {
   return currentPrice;
  }

 //�]�w���e�����L��
 void setPreviousClosingPrice(double newPreviousClosingPrice)
  {
   previousClosingPrice = newPreviousClosingPrice;
  }

 //�]�w�ثe������
 void setCurrentPrice(double newCurrentPrice)
  {
   currentPrice = newCurrentPrice;
  }

 //�^�ǧ��ܪ��ʤ���
 double getChangePercent()
  {
   return (previousClosingPrice/currentPrice)*100;
  }
}