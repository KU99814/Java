public class Person
{
 private String name; //�m�W
 private String address; //�a�}
 private String phone; //�q��
 private String eAddress; //e-mail

 //�غc�l
 public Person()
  {
   this("john","home","123456789","123654@789");
  }

 public Person(String name,String address,String phone,String eAddress)
  {
   this.name = name;
   this.address = address;
   this.phone = phone;
   this.eAddress = eAddress;
  }

 public void setName(String name)//�]�w�m�W
  {
   this.name = name;
  }

 //�^�ǩm�W
 public String getName()
  {
   return name;
  }

 //��ܸ�T
 public String toString()
  {
   return "Person" + name;
  }
}