public final class Name
{
 private String firstName;//�W
 private String mi; //�����W
 private String lastName; //�m

 //�غc�l
 public Name(String firstName,String mi, String lastName)
  {
   this.firstName = firstName;
   this.mi = mi;
   this.lastName = lastName;
  }

 //�^�ǦW
 public String getFirstName()
  {
   return firstName;
  }

 //�^�Ǥ����W
 public String getMi()
  {
   return mi;
  }

 //�^�ǩm
 public String getLastName()
  {
   return lastName;
  }

 //�^�ǥ��W
 public String getFullName()
  {
   return firstName + " " + mi + " " + lastName;
  }
}