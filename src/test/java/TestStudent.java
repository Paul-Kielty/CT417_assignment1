//import org.junit.Test;
import junit.framework.TestCase;

public class TestStudent extends TestCase{

    private Student student1 = new Student("Paul.Kielty", 21, "9-4-1999", 00001);

//    @Test
    public void testGetUsername() {
        System.out.println(student1.getUsername());
    }
//    public static void main(String[] args) {
//        Student s1 = new Student("Paul", 21, "9-4-1999", 6);
//        System.out.println(s1.getUsername());
//    }
}
