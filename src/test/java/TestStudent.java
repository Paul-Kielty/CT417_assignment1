import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestStudent{


    private Student s1 = new Student("Paul Kielty", new DateTime(1999,4,9,0,0), 10001);
    private Module m1 = new Module("Software Engineering III", "CT417");
    private Course c1 = new Course("BP", new DateTime(2020, 9, 28, 0,0),new DateTime(2021, 6, 4, 0,0));

    private ArrayList<Module> modulesControl = new ArrayList<Module>();
    private ArrayList<Course> coursesControl = new ArrayList<Course>();

    @Before
    public void testStudentSetup() {
        modulesControl.add(m1);
        coursesControl.add(c1);
    }

    @Test
    public void testGetUsername() {
        String usernameControl = "Paul Kielty21";
        assertEquals(usernameControl, s1.getUsername());
    }

    @Test
    public void testGetAge() {
        int controlAge = 21;
        assertEquals(controlAge,s1.getAge());
    }

    @Test
    public void testAddModule() {
        s1.addModule(m1);
        assertEquals(modulesControl,s1.getModules());
    }

    @Test
    public void testRemoveModule() {
        s1.removeModule(m1);
        modulesControl.remove(m1);
        assertEquals(modulesControl,s1.getModules());
    }

    @Test
    public void testAddCourse(){
        s1.addCourse(c1);
        assertEquals(coursesControl, s1.getCourses());
        System.out.println(coursesControl);
    }

    @Test
    public void testRemoveCourse(){
        s1.removeCourse(c1);
        coursesControl.remove(c1);
        assertEquals(coursesControl, s1.getCourses());
    }

}
