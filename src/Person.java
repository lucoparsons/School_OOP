/**
 * Created by h205p2 on 9/20/17.
 */
public class Person {
    static int id = 100;
    int personalID;
    String firstName;
    String lastName;

    public Person(String first, String last) {
        this.firstName = first;
        this.lastName = last;
        this.personalID = idGenerate();
    }

    public int idGenerate() {
        return id++;
    }


}
