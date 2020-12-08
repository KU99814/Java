public class Person
{
 private Name name; //�m�W
 private Address address; //�a�}

 //�غc�l
 public Person()
  {
   this(new Name("Jill","S","Barr"),
        new Address("100 Main","Savannah","GA","31411"));
  }

 public Person(Name name,Address address)
  {
   this.name = name;
   this.address = address;
  }

 //�^�ǩm�W
 public Name getName()
  {
   return name;
  }

 //�]�w�m�W
 public void setName(Name name)
  {
   this.name = name;
  }

 //�^�Ǧa�}
 public Address getAddress()
  {
   return address;
  }

 //�]�w�a�}
 public void setAddress(Address address)
  {
   this.address = address;
  }

 //��ܸ�T
 public String toString()
  {
   return "\n" + name.getFullName() + "\n"+
          address.getFullAddress() + "\n";
  }
}