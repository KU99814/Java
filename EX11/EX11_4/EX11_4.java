//Revising the House class

public class EX11_4 extends House
{
 public static void main(String args[])  throws CloneNotSupportedException
  {
   //�ŧi�Ы�
   House h1 = new House(1,2);
   House h2 = (House)h1.clone();
   
   //��ܦ�ɫسy
   System.out.println(h1.getWhenBuilt().toString());
   h1.setWhenBuilt(null);//�Nh1�w��null ���լO�_deep clone
   System.out.println(h2.getWhenBuilt().toString());
  }
}