//Finging ancestors

import java.util.*;

public class EX23_7
{
 public static void main(String args[])
  {
   //�Ыس\�hPerson
   Person p1 = new Person();
   p1.setName("p1");

   Person p2 = new Person();
   p2.setName("p2");

   Person p3 = new Person("p3",new Date(),p1,p2);

   Person p4 = new Person();
   p4.setName("p4");

   Person p5 = new Person("p5",new Date(),p4,p2);

   Person p6 = new Person();
   p6.setName("p6");

   Person p7 = new Person("p7",new Date(),p5,p6);

   Person p8 = new Person("p8",new Date(),p7,p3);//�o��Person�~�өҦ��H

   System.out.println("The "+p8.toString()+" ancestor is "+p8.getAllKnownAncestors());//���p8������ �����Ҧ��H
  }
}