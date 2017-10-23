import java.util.ArrayList;

/**
 * Created by h205p2 on 9/20/17.
 */
public class Section {
    String name;
    int maxSize;
    int currentSize;
    ArrayList<Student> students = new ArrayList<Student>();
    Teacher teacher;

    public Section(String name, int max, Teacher teachy) {
        this.name = name;
        this.maxSize = max;
        this.currentSize = 0;
        this.teacher = teachy;
    }

    public Section(String name, int max) {
        this.name = name;
        this.maxSize = max;
        this.currentSize = 0;
    }

    public void addStudent(Student s) {
        students.add(s);
        currentSize++;
    }

    public void removeStudent(int id) {
        for(int i=0; i<students.size(); i++) {
            if(students.get(i).personalID == id) {
                students.remove(i);
                currentSize--;
            }
        }
    }

    public int sectionSeatsRemaining() {
        return maxSize - currentSize;
    }

}
