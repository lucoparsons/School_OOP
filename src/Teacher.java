/**
 * Created by h205p2 on 9/20/17.
 */
public class Teacher extends Person {
    String subject;

    public Teacher(String first, String last, String subj) {
        super(first, last);
        this.subject = subj;
    }
}
