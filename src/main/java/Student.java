import java.util.ArrayList;

public class Student {

    private String name, DOB, username;
    private int age, ID;
    private ArrayList<Module> modules = new ArrayList<Module>();
    private ArrayList<Course> courses = new ArrayList<Course>();

    public Student(String name, int age, String DOB, int ID){
        this.name = name;
        this.age = age;
        this.DOB = DOB;
        this.username = getUsername();
    }

    public String getUsername() {
        return name+age;
    }

    public void addCourse(Course c) {
        courses.add(c);
        for (Module m: c.getModuleList()){ //Add modules if student enrolled in new course
            addModule(m);
        }
    }

    public void removeCourse(Course c) {
        courses.remove(c);
        for (Module m: c.getModuleList()){ //Remove modules if student removed course
            removeModule(m);
        }
    }

    public void addModule(Module m) {
        modules.add(m);
        m.addStudent(this);
    }
    public void removeModule(Module m) {
        modules.remove(m);
        m.removeStudent(this);
    }

    public ArrayList<Module> getModules() { return modules; }
    public void setModules(ArrayList<Module> modules) { this.modules = modules; }


    public ArrayList<Course> getCourses() { return courses; }
    public void setCourses(ArrayList<Course> courses) { this.courses = courses; }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public String getDOB() { return DOB; }
    public void setDOB(String DOB) { this.DOB = DOB; }


    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }


    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
}
