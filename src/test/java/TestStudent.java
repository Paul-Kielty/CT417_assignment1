import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestStudent{


//    private Student s1 = new Student("Paul Kielty", 21, new DateTime(1999,4,9,0,0), 00001);
    private Student s1 = new Student("Paul Kielty", 21, new DateTime(1999,11, 13,0,0), 00001);
//    private Course c1 =

    private Course c1 = new Course("BP", new DateTime(2020, 9, 28, 0,0),new DateTime(2021, 6, 4, 0,0));
    private Course c2 = new Course("CSIT", new DateTime(2020, 9, 28, 0,0),new DateTime(2021, 6, 4, 0,0));

    private ArrayList<Course> coursesControl = new ArrayList<Course>();
    private ArrayList<Module> modulesControl = new ArrayList<Module>();

    @Before
    public void testSet() {
        coursesControl.add(c1);
        System.out.println("before run");
    }

    @Test
    public void testGetUsername() {
        String usernameControl = "Paul Kielty21";
        assertEquals(s1.getUsername(), usernameControl);
    }

    @Test
    public void testGetAge() {
        int controlAge = 21;
        assertEquals(s1.getAge(), controlAge);
    }

//    public void testAddCourse(){
//        addCourseControl = ;
//    }


}
