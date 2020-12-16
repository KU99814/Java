import java.util.*;

public class Person
{
 private String name; //�m�W
 private Date birthdate; //�ͤ�
 private Person mother = null; //����
 private Person father = null; //����

 //�غc�l
 public Person()
  {
   name = "null";
   birthdate = new Date();
  }

 public Person(String name,Date birthdate,Person mother,Person father)
  {
   this.name = name;
   this.birthdate = birthdate;
   this.mother = mother;
   this.father = father;
  }

 //�]�w�m�W
 public void setName(String name)
  {
   this.name = name;
  }

 //��ܩm�W
 public String toString()
  {
   return name;
  }

 //���o�Ҧ�����    
 public Set<Person> getAllKnownAncestors()
  {
   Set<Person> set = new LinkedHashSet<Person>();

   if(mother != null)
    {
     set.add(mother);
     set.addAll(mother.getAllKnownAncestors());//���j���o��������
    }

   if(father != null)
    {
     set.add(father);
     set.addAll(father.getAllKnownAncestors());//���j���o��������
    }

   return set;
  }
}