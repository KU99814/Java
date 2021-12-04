//student address

public class StudentAddress implements java.io.Serializable
{
 private String name;//�m�W
 private String street;//��D
 private String city;//����
 private String state;//���
 private String zip;//�l���a�}

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

 //���o�m�W
 public String getName()
  {
   return name;
  }

 //���o��D
 public String getStreet()
  {
   return street;
  }

 //���o����
 public String getCity()
  {
   return city;
  }

 //���o���
 public String getState()
  {
   return state;
  }

 //���o�l���a�}
 public String getZip()
  {
   return zip;
  }
}