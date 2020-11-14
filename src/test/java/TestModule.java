import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestModule {
    private Module m1 = new Module("Software Engineering III", "CT417");

    private Student s1 = new Student("Paul Kielty", new DateTime(1999,4,9,0,0), 10001);
    private Student s2 = new Student("Maya McDevitt", new DateTime(1998,4,9,0,0), 10002);

    private Course c1 = new Course("BP", new DateTime(2020, 9, 28, 0,0),new DateTime(2021, 6, 4, 0,0));

    private ArrayList<Student> studentListControl = new ArrayList<Student>();
    private ArrayList<Course> courseListControl = new ArrayList<Course>();

    @Before
    public void testModuleSetup() {
        studentListControl.add(s1);
        courseListControl.add(c1);
    }

    @Test
    public void testAddStudent() {
        m1.addStudent(s1);
        assertEquals(studentListControl, m1.getStudentList());
    }

    @Test
    public void testRemoveStudent() {
        m1.removeStudent(s1);
        studentListControl.remove(s1);
        assertEquals(studentListControl,m1.getStudentList());
    }

    @Test
    public void testAddCourse() {
        m1.addCourse(c1);
        assertEquals(courseListControl, m1.getCourseList());

        c1.enrollStudent(s1);
        m1.removeStudent(s1);
    }

    @Test
    public void testRemoveCourse() {
        m1.addCourse(c1);
        m1.removeCourse(c1);
        courseListControl.remove(c1);
        assertEquals(courseListControl, m1.getCourseList());
    }
}
