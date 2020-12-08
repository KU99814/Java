public class Person
{
 private String name; //姓名
 private String address; //地址
 private String phone; //電話
 private String eAddress; //e-mail

 //建構子
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

 public void setName(String name)//設定姓名
  {
   this.name = name;
  }

 //回傳姓名
 public String getName()
  {
   return name;
  }

 //顯示資訊
 public String toString()
  {
   return "Person" + name;
  }
}