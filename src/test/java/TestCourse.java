import org.junit.Before;
import org.junit.Test;
import org.joda.time.DateTime;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestCourse{
    private Course c1 = new Course("BP", new DateTime(2020, 9, 28, 0,0),new DateTime(2021, 6, 4, 0,0));

    private Module m1 = new Module("Software Engineering III", "CT417");

    private Student s1 = new Student("Paul Kielty", new DateTime(1999,4,9,0,0), 10001);

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
}
