import java.util.ArrayList;

/**
 * Created by h205p2 on 9/20/17.
 */
public class Student extends Person {
    int grade;
    int rand = (int) Math.floor(Math.random() * 2);
    boolean awesome;

    public boolean isAwesome() {
        if (rand == 1) {
            return true;
        } else {
            return false;
        }
    }
    //static ArrayList<Student> allStudents = new ArrayList<Student>();

    public Student(String first, String last, int grade) {
        super(first, last);
        this.grade = grade;
        this.awesome = isAwesome();
    }
}
