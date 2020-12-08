//creating a rational number calculator in cmd

public class EX12_6
{
 public static void main(String args[])
  {
   //���j��
   String[] toke1 = args[0].split("/");
   String[] toke2 = args[2].split("/");

   //���o���l����
   int n1 = Integer.parseInt(toke1[0]);
   int d1 = Integer.parseInt(toke1[1]);

   int n2 = Integer.parseInt(toke2[0]);
   int d2 = Integer.parseInt(toke2[1]);

   //�ŧi����
   Rational r1 = new Rational(n1,d1);
   Rational r2 = new Rational(n2,d2);

   //�p��
   if(args[1].equals("+"))
    System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
   else if(args[1].equals("-"))
    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
   else if(args[1].equals("*"))
    System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
   else if(args[1].equals("/"))
    System.out.println(r1 + " - " + r2 + " = " + r1.divide(r2));
  }
}