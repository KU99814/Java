public final class Name implements Comparable
{
 private String firstName; //名
 private char mi; //中間名
 private String lastName; //姓

 //建構子
 public Name(String firstName,char mi, String lastName)
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
 public char getMi()
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

 //比較
 public int compareTo(Object o)
  {
   return lastName.compareTo(((Name)o).getLastName());
  }
}