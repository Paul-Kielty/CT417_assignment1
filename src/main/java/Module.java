import java.util.ArrayList;
public class Module {

    private String moduleName, moduleID;
    private ArrayList<Student> studentList = new ArrayList<Student>();
//    private ArrayList<Course> courseList = new ArrayList<Course>();


    public Module(String moduleName, String moduleID) {
        this.moduleName = moduleName;
        this.moduleID = moduleID;
//        this.studentList = studentList;
    }

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}
