import java.util.ArrayList;
import org.joda.time.DateTime;
import org.joda.time.Period;

public class Student {

    private String name, username;
    private int age, ID;
    private DateTime DOB;
    private ArrayList<Module> modules = new ArrayList<Module>();
    private ArrayList<Course> courses = new ArrayList<Course>();

    public Student(String name, int age, DateTime DOB, int ID){
        this.name = name;
        this.age = age;
        this.DOB = DOB;
        this.ID = ID;
        this.username = getUsername();
    }

    public String getUsername() {
        return name+age;
    }

    public int getAge() {
        DateTime currentDate = new DateTime();
        Period period = new Period(DOB, currentDate);
        return period.getYears();
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void addCourse(Course c) {
        if (!courses.contains(c)) {
            courses.add(c);
        }
        for (Module m : c.getModuleList()){ //add all course modules
            addModule(m);
        }
        if (!c.getEnrolledStudents().contains(this)) {
            c.enrollStudent(this); //update student list in course object
        }
    }

    public void removeCourse(Course c) {
        courses.remove(c); //remove course from student

        for (Module m : c.getModuleList()){ //remove all course modules
            removeModule(m);
        }
        if(c.getEnrolledStudents().contains(this)) {
            c.removeStudent(this); //update student list in course object
        }
    }

    public void addModule(Module m) {
        if (!modules.contains(m)) {
            modules.add(m);
        }
        if (!m.getStudentList().contains(this)){
            m.addStudent(this); //update student list in module class
        }
    }
    public void removeModule(Module m) {
        if (modules.contains(m)) {
            modules.remove(m);
        }
        if (m.getStudentList().contains(this)) {
            m.removeStudent(this); //update student list in module class
        }
    }

    public String arrayListToString(ArrayList al) {
        String list = "";
        for (Object o : al) {
            list += o + "\n";
        }
        return list;
    }

    public String getModuleListString(){
        return arrayListToString(modules);
    }
    public String getCourseListString(){
        String courseListString = "";
        for (Course c : courses) {
            courseListString += c.getCourseName() + "\n";
        }
        return courseListString;
    }

    @Override
    public String toString(){
        return String.format("Username: %s\tID: %s\tDOB: %s", username, ID, DOB);
    }

    public ArrayList<Module> getModules() { return modules; }
    public void setModules(ArrayList<Module> modules) { this.modules = modules; }


    public ArrayList<Course> getCourses() { return courses; }
    public void setCourses(ArrayList<Course> courses) { this.courses = courses; }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public DateTime getDOB() { return DOB; }
    public void setDOB(DateTime DOB) { this.DOB = DOB; }


//    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }


    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
}
