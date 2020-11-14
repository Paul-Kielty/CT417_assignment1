import org.junit.Before;
import org.junit.Test;
import org.joda.time.DateTime;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestCourse{
    private Course c1 = new Course("BP", new DateTime(2020, 9, 28, 0,0),new DateTime(2021, 6, 4, 0,0));
//    private Course c2 = new Course("CSIT", new DateTime(2020, 9, 28, 0,0),new DateTime(2021, 6, 4, 0,0));

    private Module m1 = new Module("Software Engineering III", "CT417");
//    private Module m2 = new Module("Digital Signal Processing", "EE445");
//    private Module m3 = new Module("Advanced Professional Skills", "CT436");

    private Student s1 = new Student("Paul Kielty", new DateTime(1999,4,9,0,0), 10001);
//    private Student s2 = new Student("Maya", new DateTime(1998,4,9,0,0), 10002);
//    private Student s3 = new Student("Enda", new DateTime(2000,4,9,0,0), 10003);

    ArrayList<Module> moduleListControl = new ArrayList<Module>();
    ArrayList<Student> studentListControl = new ArrayList<Student>();

    @Before
    public void testCourseSetup() {
        studentListControl.add(s1);
        moduleListControl.add(m1);
    }

    @Test
    public void testAddModule() {
        c1.addModule(m1);
        assertEquals(moduleListControl, c1.getModuleList());
    }

    @Test
    public void testRemoveModule() {
        c1.addModule(m1);
        c1.removeModule(m1);
        moduleListControl.remove(m1);
        assertEquals(moduleListControl, c1.getModuleList());
    }

    @Test
    public void testEnrollStudent() {
        c1.enrollStudent(s1);
        assertEquals(studentListControl, c1.getEnrolledStudents());
    }

    @Test
    public void testRemoveStudent() {
        c1.enrollStudent(s1);
        c1.removeStudent(s1);
        studentListControl.remove(s1);
        assertEquals(studentListControl, c1.getEnrolledStudents());
    }
//
//    @Test
//    public void testToString(){

//        c1.addModule(m1);
//        c1.addModule(m2);
//        c1.addModule(m3);
//        c1.enrollStudent(s1);
//        c1.enrollStudent(s2);
//
//        m1.addStudent(s3);
////        m1.removeStudent(s1);
//
//        c1.removeModule(m1);
////        c1.removeStudent(s2);
//        s3.addCourse(c2);
//        s2.removeCourse(c1);
//        s3.removeCourse(c1);
//
//        System.out.println(c1);
//        System.out.println(c2);
//
//        System.out.println("\nModule 1 students:\n"+m1.getStudentListString());
//        System.out.println("\nModule 2 students:\n"+m2.getStudentListString());
//        System.out.println("\nModule 3 students:\n"+m3.getStudentListString());
//
//        System.out.println("\nStudent 1 courses & modules\n"+s1.getCourseListString()+s1.getModuleListString());
//        System.out.println("\nStudent 2 courses & modules\n"+s2.getCourseListString()+s2.getModuleListString());
//        System.out.println("\nStudent 3 courses & modules\n"+s3.getCourseListString()+s3.getModuleListString());

//    }
}
