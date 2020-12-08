public final class Address
{
 private String street;//��
 private String city; //����
 private String state; //��
 private String zip; //�l���ϸ�

 //�غc�l
 public Address(String street,String city,String state,String zip)
  {
   this.street = street;
   this.city = city;
   this.state = state;
   this.zip = zip;
  }

 //�^�ǵ�W
 public String getStreet()
  {
   return street;
  }

 //�^�ǫ����W
 public String getCity()
  {
   return city;
  }

 //�^�ǰϦW
 public String getState()
  {
   return state;
  }

 //�^�Ƕl���ϸ�
 public String getZip()
  {
   return zip;
  }

 //�^�ǥ��a�}
 public String getFullAddress()
  {
   return street + "\n" + city + ", "+state+ " " + zip + "\n";
  }
}