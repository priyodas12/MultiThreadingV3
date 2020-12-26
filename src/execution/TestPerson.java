package execution;

public class TestPerson {

    public static void main(String[] args) {
        Person p1=new Person(1,"abc");
        Person p2=new Person(1,"abc");

        System.out.println(p1.equals(p2)+" p1: "+p1.hashCode()+" p2: "+p2.hashCode()+""+Integer.MAX_VALUE);
    }
}
