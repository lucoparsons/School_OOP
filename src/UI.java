import java.util.Scanner;
import java.util.ArrayList;


 /* Created by h205p2 on 9/21/17.
 */

public class UI {
    static Scanner sc = new Scanner(System.in).useDelimiter("\\n");
    static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    static ArrayList<Section> sections = new ArrayList<Section>();
    static ArrayList<Student> allStudents = new ArrayList<Student>();
    static Student stud;
    static Section sec;


    public static Teacher createT() {
        System.out.println("enter teacher first name:");
        String TFirst = sc.next();
        System.out.println("enter last name:");
        String TLast = sc.next();
        System.out.println("enter this teacher's subject matter:");
        String TSubj = sc.next();
        Teacher T = new Teacher(TFirst, TLast, TSubj);
        teachers.add(T);
        return T;
    }

    public static Section createS() {
        System.out.println("enter formal section title:");
        String STitle = sc.next();
        System.out.println("enter total student capacity of the class:");
        int SSize = Integer.parseInt(sc.next());
        Section S = new Section(STitle, SSize);
        return S;
    }

    public static Student createSt() {
        System.out.println("enter student first name:");
        String StFirst = sc.next();
        System.out.println("enter student last name:");
        String StLast = sc.next();
        System.out.println("enter student grade level:");
        int StGrade = sc.nextInt();
        Student St = new Student(StFirst, StLast, StGrade);
        allStudents.add(St);
        System.out.println(St.grade + "th grader " + St.firstName + " " + St.lastName + " has student ID " + St.personalID + ".");
        if(St.awesome) {
            System.out.println(St.firstName + " will be bringin' it to all their classes; they're super awesome!");
        }
        else {
            System.out.println(St.firstName + " isn't that awesome...");
        }
        return St;
    }

    public static void enrolled(Section S, Student St) {
        if (St.awesome) {
            System.out.println("student " + St.firstName + " " + St.lastName + " who is Awesome (ID: " + St.personalID + ") is enrolled in " + S.name + " with the lovely " + S.teacher.firstName + " " + S.teacher.lastName + ", and " + S.sectionSeatsRemaining() + " seat(s) remain.");
        }
        else {
            System.out.println("student " + St.firstName + " " + St.lastName + " who is not Awesome (ID: " + St.personalID + ") is enrolled in " + S.name + " with the lovely " + S.teacher.firstName + " " + S.teacher.lastName + ", and " + S.sectionSeatsRemaining() + " seat(s) remain.");
        }
        int a = 0;
        int n = 0;
        for(int i=0; i<S.students.size(); i++) {
            if (S.students.get(i).awesome) {
                a++;
            }
            else {
                n++;
            }
        }
        if(a>n) {
            System.out.println("section " + S.name + " is currently AWESOME.");
        }
        else {
            System.out.println("section " + S.name + " isn't awesome :(");
        }
    }

    public static void unenrolled(Section S, Student St ) {
        if (St.awesome) {
            System.out.println("student " + St.firstName + " " + St.lastName + " who is awesome (ID: " + St.personalID + ") was successfully removed from " + S.name + ", and " + S.sectionSeatsRemaining() + " seat(s) remain");
        }
        else {
            System.out.println("student " + St.firstName + " " + St.lastName + " who is not awesome (ID: " + St.personalID + ") was successfully removed from " + S.name + ", and " + S.sectionSeatsRemaining() + " seat(s) remain");
        }
        int a = 0;
        int n = 0;
        for(int i=0; i<S.students.size(); i++) {
            if (S.students.get(i).awesome) {
                a++;
            }
            else {
                n++;
            }
        }
        if(a>n) {
            System.out.println("section " + S.name + " is currently AWESOME.");
        }
        else {
            System.out.println("section " + S.name + " isn't awesome :(");
        }
    }

    public static void main(String[] args) {

        System.out.println("hi there! what's your name?");
        String user = sc.next();
        System.out.println("well hello " + user + ", let's get started building our school.");
        int hi = 0;
        while (hi == 0) {
            System.out.println("what would you like to do now?");
            System.out.println("type t to create a teacher, s to create a section, st to create a student, a to add a student to an existing section, r to remove a student from an existing section. you can also type search to look up a student. type done to end the program.");
            String next = sc.next();

            if(next.equals("t")) {
                Teacher t = createT();
                System.out.println("teacher " + t.firstName + " " + t.lastName + " teaches subject " + t.subject + ".");
            }

            else if(next.equals("s")) {
                Section s = createS();
                System.out.println("Who will teach the new section? type 'new' to create a new teacher, or type 'old' to assign an old teacher.");
                String newOld = sc.next();
                if(newOld.equals("new")) {
                    Teacher t = createT();
                    s.teacher = t;
                    sections.add(s);
                    System.out.println("great! teacher " + s.teacher.firstName + " " + s.teacher.lastName + " is teaching " + s.name + ", with " + s.sectionSeatsRemaining() + " seats remaining.");
                }
                else if(newOld.equals("old")) {
                    int count = 0;
                    while(count == 0) {
                        System.out.println("type the desired teacher's last name:");
                        String n = sc.next();
                        for(int i = 0; i < teachers.size(); i++) {
                            Teacher t = teachers.get(i);
                            if(t.lastName.equals(n)) {
                                count++;
                                s.teacher = t;
                                sections.add(s);
                                System.out.println("great! teacher " + s.teacher.firstName + " " + s.teacher.lastName + " is teaching " + s.name + ", with " + s.sectionSeatsRemaining() + " seats remaining.");
                            }
                        }
                        if(count == 0) {
                            System.out.println("sorry, there exists no teacher by that name, try again.");
                        }
                    }
                }
            }

            else if(next.equals("st")) {
                Student st = createSt();
            }

            else if(next.equals("a")) {
                int count1 = 0;
                int count2 = 0;
//                Student stud;
//                Section sec;
                while(count1 == 0) {
                    System.out.println("enter the existing student's first name:");
                    String f = sc.next();
                    System.out.println("enter student's last name:");
                    String l = sc.next();
                    for (int i = 0; i < allStudents.size(); i++) {
                        Student st = allStudents.get(i);
                        if (st.firstName.equals(f) && st.lastName.equals(l)) {
                            count1++;
                            stud = st;
                        }
                    }
                    if (count1 == 0) {
                        System.out.println("no such student exists, try again.");
                    }
                }
                System.out.println("which section will this student be added to?");
                while(count2 == 0) {
                    String sTitle = sc.next();
                    for(int i = 0; i < sections.size(); i++) {
                        Section s = sections.get(i);
                        if (s.name.equals(sTitle)) {
                            count2++;
                            sec = s;
                            sec.addStudent(stud);
                        }
                    }
                    if(count2 == 0) {
                        System.out.println("no such section exists, try again.");
                    }
                }
                //System.out.println("student " + stud.firstName + " " + stud.lastName + " was added to " + sec.name + ", and " + sec.sectionSeatsRemaining() + " seats remain");
                enrolled(sec, stud);
            }

            else if(next.equals("r")) {
                int countA = 0;
                int countB = 0;
//                Student stud;
//                Section sec;
                while(countB == 0) {
                    System.out.println("which section will this student be removed from?");
                    String sTitle = sc.next();
                    for(int i = 0; i < sections.size(); i++) {
                        Section s = sections.get(i);
                        if (s.name.equals(sTitle)) {
                            countB++;
                            sec = s;
                        }
                    }
                    if(countB == 0) {
                        System.out.println("no such section exists, try again.");
                    }
                }
                while(countA == 0) {
                    System.out.println("enter the id number of the student to be removed:");
                    int stID = sc.nextInt();
                    for (int i = 0; i < sec.students.size(); i++) {
                        Student st = sec.students.get(i);
                        if (st.personalID == stID) {
                            countA++;
                            stud = st;
                            sec.removeStudent(stud.personalID);
                        }
                    }
                    if (countA == 0) {
                        System.out.println("this student is not enrolled in " + sec.name + ", try again.");
                    }
                }
                unenrolled(sec, stud);
            }

            else if(next.equals("search")) {
                search();
            }

            else if(next.equals("done")) {
                System.out.println("thank you for using the program, " + user + ".");
                hi++;
            }

            else {
                System.out.println("that is not a possible action.");
            }

        }


    }

    public static void search() {
        System.out.println("enter the student ID of the student you wish to find");
        int j = 0;
        while (j==0) {
            int a = Integer.parseInt(sc.next());
            for (int i = 0; i < allStudents.size(); i++) {
                Student s = allStudents.get(i);
                if (s.personalID == a) {
                    j++;
                    System.out.println(s.firstName + " " + s.lastName + "; " + "ID: " + a + "; Grade " + s.grade);
                }
            }
            if (j==0) {
                System.out.println("There exists no student with that ID, please try again");
            }
        }

    }

}
