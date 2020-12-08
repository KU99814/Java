public final class Name implements Comparable
{
 private String firstName; //�W
 private char mi; //�����W
 private String lastName; //�m

 //�غc�l
 public Name(String firstName,char mi, String lastName)
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
 public char getMi()
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

 //���
 public int compareTo(Object o)
  {
   return lastName.compareTo(((Name)o).getLastName());
  }
}