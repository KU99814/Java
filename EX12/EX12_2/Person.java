public class Person implements Comparable
{
 private Name name;//�m�W

 //�غc�l
 public Person()
  {
   name = new Name("Jill",'S',"Barr");
  }

 public Person(Name name)
  {
   this.name = name;
  }

 //���o�m�W
 public Name getName()
  {
   return name;
  }

 //�]�w�m�W
 public void setName(Name name)
  {
   this.name = name;
  }

 //���o���A
 public String toString()
  {
   return "\n" + name.getFullName() + "\n";
  }

 //���
 public int compareTo(Object o)
  {
   return name.compareTo(((Person)o).name);
  }
}