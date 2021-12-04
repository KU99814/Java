//student address

public class StudentAddress implements java.io.Serializable
{
 private String name;//姓名
 private String street;//街道
 private String city;//城市
 private String state;//街區
 private String zip;//郵遞地址

 //constructor
 public StudentAddress(String name,String street,String city,
                       String state,String zip)
  {
   this.name = name;
   this.street = street;
   this.city = city;
   this.state = state;
   this.zip = zip;
  }

 //取得姓名
 public String getName()
  {
   return name;
  }

 //取得街道
 public String getStreet()
  {
   return street;
  }

 //取得城市
 public String getCity()
  {
   return city;
  }

 //取得街區
 public String getState()
  {
   return state;
  }

 //取得郵遞地址
 public String getZip()
  {
   return zip;
  }
}