import java.util.ArrayList;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Student {

    private String name, username;
    private int age, ID;
    private DateTime DOB;
    private ArrayList<Module> modules = new ArrayList<Module>();
    private ArrayList<Course> courses = new ArrayList<Course>();
    private DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/YYYY");

    public Student(String name, DateTime DOB, int ID){ // Student constructor
        this.name = name;
        this.age = getAge();
        this.DOB = DOB;
        this.ID = ID;
        this.username = getUsername();
    }

    public String getUsername() { return name+getAge(); }
    public void setUsername(String username) { this.username = username; }


    public int getAge() {
        DateTime currentDate = new DateTime();
        Period period = new Period(DOB, currentDate);
        return period.getYears();
    }
    public void setAge(int age) { this.age = age; }


    public void addModule(Module m) { // Method to add a module to this student's modules
        if (!modules.contains(m)) { // Check if module is NOT already in ArrayList
            modules.add(m); // If not a duplicate, add to ArrayList
        }
        if (!m.getStudentList().contains(this)){ // Check if student is NOT already in module's student list
            m.addStudent(this); // Update module's student list
        }
    }

    public void removeModule(Module m) { // Method to remove a module from this student's modules
        if (modules.contains(m)) { // Check if module IS already in modules ArrayList
            modules.remove(m);
        }
        if (m.getStudentList().contains(this)) { // Check if student IS already in module's student list
            m.removeStudent(this); // Remove student from student list in module class
        }
    }


    public void addCourse(Course c) { // Method to add a course to this student's courses
        if (!courses.contains(c)) { // Check if course is NOT already in ArrayList
            courses.add(c); // If not a duplicate, add to ArrayList
        }
        for (Module m : c.getModuleList()){ // Call addModule for each module in course
            addModule(m); // (addModule blocks duplicates and updates module's student list)
        }
        if (!c.getEnrolledStudents().contains(this)) { // Check if student is NOT already in course's student list
            c.enrollStudent(this); // Update course's student list
        }
    }

    public void removeCourse(Course c) { // Method to remove a course from this student's courses
        if (courses.contains(c)) { // Check if course IS already in ArrayList
            courses.remove(c);
        }
        for (Module m : c.getModuleList()){ // Call removeModule for each module in course
            removeModule(m); // (removeModule updates student lists)
        }
        if(c.getEnrolledStudents().contains(this)) { // Check if student IS already in course's student list
            c.removeStudent(this); // Update course's student list
        }
    }

    public String arrayListToString(ArrayList al) { // Convert ArrayList to String, with each element separated by a newline
        String list = "";
        for (Object o : al) {
            list += o + "\n";
        }
        return list;
    }

    public String getModuleListString(){ // Get modules ArrayList as String
        return arrayListToString(modules);
    }

    public String getCourseListString(){ // Get courses names listed in String
        String courseListString = ""; // (arrayListToString isn't used as the Course toString contains more info than desired)
        for (Course c : courses) {
            courseListString += c.getCourseName() + "\n";
        }
        return courseListString;
    }

    @Override
    public String toString(){
        return String.format("Username: %s\tID: %s\tDOB: %s", username, ID, dtf.print(DOB));
    }


    public ArrayList<Module> getModules() { return modules; }
    public void setModules(ArrayList<Module> modules) { this.modules = modules; }


    public ArrayList<Course> getCourses() { return courses; }
    public void setCourses(ArrayList<Course> courses) { this.courses = courses; }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public DateTime getDOB() { return DOB; }
    public void setDOB(DateTime DOB) { this.DOB = DOB; }


    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
}
