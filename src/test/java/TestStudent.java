import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStudent{

    private Student student1 = new Student("Paul Kielty", 21, "9-4-1999", 00001);

    @Test
    public void testGetUsername() {
        String usernameControl = "Paul Kielty21";
        assertEquals(student1.getUsername(), usernameControl);
    }


}
