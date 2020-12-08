public final class Name
{
 private String firstName;//名
 private String mi; //中間名
 private String lastName; //姓

 //建構子
 public Name(String firstName,String mi, String lastName)
  {
   this.firstName = firstName;
   this.mi = mi;
   this.lastName = lastName;
  }

 //回傳名
 public String getFirstName()
  {
   return firstName;
  }

 //回傳中間名
 public String getMi()
  {
   return mi;
  }

 //回傳姓
 public String getLastName()
  {
   return lastName;
  }

 //回傳全名
 public String getFullName()
  {
   return firstName + " " + mi + " " + lastName;
  }
}