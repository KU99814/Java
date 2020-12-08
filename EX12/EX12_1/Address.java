public final class Address
{
 private String street;//街
 private String city; //城市
 private String state; //區
 private String zip; //郵遞區號

 //建構子
 public Address(String street,String city,String state,String zip)
  {
   this.street = street;
   this.city = city;
   this.state = state;
   this.zip = zip;
  }

 //回傳街名
 public String getStreet()
  {
   return street;
  }

 //回傳城市名
 public String getCity()
  {
   return city;
  }

 //回傳區名
 public String getState()
  {
   return state;
  }

 //回傳郵遞區號
 public String getZip()
  {
   return zip;
  }

 //回傳全地址
 public String getFullAddress()
  {
   return street + "\n" + city + ", "+state+ " " + zip + "\n";
  }
}