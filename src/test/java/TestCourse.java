import org.junit.Test;
import org.joda.time.DateTime;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestCourse{
    private Course c1 = new Course("BP", new DateTime(2020, 9, 28, 0,0),new DateTime(2021, 6, 4, 0,0));
//    private Course c2 = new Course("CSIT", new DateTime(2020, 9, 28, 0,0),new DateTime(2021, 6, 4, 0,0));

    private Module m1 = new Module("Software Engineering III", "CT417");
    private Module m2 = new Module("Digital Signal Processing", "EE445");
    private Module m3 = new Module("Advanced Professional Skills", "CT436");

    private Student s1 = new Student("Paul", 21, "9-4-1999", 10001);
    private Student s2 = new Student("Maya", 22, "9-4-1998", 10002);
    private Student s3 = new Student("Enda", 20, "9-4-2000", 10003);

    @Test
    public void testAddModule() {
        c1.addModule(m1);
        c1.addModule(m2);
        ArrayList<Module> addModuleControl = new ArrayList<Module>();
        addModuleControl.add(m1);
        addModuleControl.add(m2);
        assertEquals(c1.getModuleList(),addModuleControl);
    }

    @Test
    public void testRemoveModule() {
        c1.addModule(m1);
        c1.addModule(m2);
        c1.removeModule(m1);
        ArrayList<Module> removeModuleControl = new ArrayList<Module>();
        removeModuleControl.add(m2);
        assertEquals(c1.getModuleList(),removeModuleControl);
    }

    @Test
    public void testEnrollStudent() {
        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        ArrayList<Student> enrollStudentControl = new ArrayList<Student>();
        enrollStudentControl.add(s1);
        enrollStudentControl.add(s2);
        assertEquals(c1.getEnrolledStudents(),enrollStudentControl);
    }

    @Test
    public void testRemoveStudent() {
        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        c1.removeStudent(s1);
        ArrayList<Student> removeStudentControl = new ArrayList<Student>();
        System.out.println(c1.getEnrolledStudents());
        removeStudentControl.add(s2);
        assertEquals(c1.getEnrolledStudents(),removeStudentControl);
    }

    @Test
    public void testToString(){
        c1.addModule(m1);
        c1.addModule(m2);
        c1.addModule(m3);
        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        m1.addStudent(s3);
        System.out.println(c1);
        System.out.println("\nModule 1 students:\n"+ m1.getStudentListString());
        System.out.println("\nModule 2 students:\n"+m2.getStudentListString());

        System.out.println("\nStudent 1 courses & modules\n"+s1.getCourseListString()+s1.getModuleListString());
        System.out.println("\nStudent 2 courses & modules\n"+s2.getCourseListString()+s2.getModuleListString());
        System.out.println("\nStudent 3 courses & modules\n"+s3.getCourseListString()+s3.getModuleListString());

    }
}
