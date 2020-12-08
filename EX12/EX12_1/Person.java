public class Person
{
 private Name name; //姓名
 private Address address; //地址

 //建構子
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

 //回傳姓名
 public Name getName()
  {
   return name;
  }

 //設定姓名
 public void setName(Name name)
  {
   this.name = name;
  }

 //回傳地址
 public Address getAddress()
  {
   return address;
  }

 //設定地址
 public void setAddress(Address address)
  {
   this.address = address;
  }

 //顯示資訊
 public String toString()
  {
   return "\n" + name.getFullName() + "\n"+
          address.getFullAddress() + "\n";
  }
}