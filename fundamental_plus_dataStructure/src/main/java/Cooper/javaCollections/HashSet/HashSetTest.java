package Cooper.javaCollections.HashSet;

import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {

        HashSet<Person> set = new HashSet<>();

        set.add(new Person("1",24));
        set.add(new Person("2",56));
        set.add(new Person("2",56));

        for (Person p:
                set ) {
            System.out.println(p.toString());
        }
    }
}
