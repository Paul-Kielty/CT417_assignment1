import junit.framework.TestCase; //make junit test
import java.util.ArrayList;

public class TestModule extends TestCase {
    private Module m1 = new Module("Software Engineering III", "CT417");

    private Student s1 = new Student("Paul.Kielty", 21, "9-4-1999", 00001);
    private Student s2 = new Student("Maya", 22, "9-4-1998", 00002);
//    private Student s3 = new Student("Enda", 20, "9-4-2000", 00003);

    //add more tests
    public void testAddStudent() {
        m1.addStudent(s1);
        m1.addStudent(s2);
        ArrayList<Student> studentListControl = new ArrayList<Student>();
        studentListControl.add(s1);
        studentListControl.add(s2);
        assertEquals(m1.getStudentList(), studentListControl);
    }
}
