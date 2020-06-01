package ex1;

public class Main {
public static void main(String[] args) {
Person p = new Person("Hoa", 25);
p.setAge(-1);
p.setName("Ho");
System.out.println(p.toString());
Person c = new Child("Minh", 14, 140);
c.setAge(13);
c.setName("Mi");
System.out.println(c.toString());




}
}
