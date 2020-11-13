import java.util.ArrayList;
public class Module {

    private String moduleName, moduleID;
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Course> courseList = new ArrayList<Course>();

    public Module(String moduleName, String moduleID) {
        this.moduleName = moduleName;
        this.moduleID = moduleID;
    }

    public void addStudent(Student s) {
        studentList.add(s);
        s.addModule(this);
    }

    public void removeStudent(Student s) {
        studentList.remove(s);
        s.removeModule(this);
    }

    public void addCourse(Course c){
        courseList.add(c);
    }

    public void removeCourse(Course c){
        courseList.remove(c);
    }

    @Override
    public String toString(){
        return String.format("Module Name: %s\tID: %s", moduleName, moduleID);
    }

    public String arrayListToString(ArrayList al) {
        String list = "";
        for (Object o : al) {
            list += o + "\n";
        }
    return list;
    }

    public String getCourseListString(){
        return arrayListToString(courseList);
    }

    public String getStudentListString(){
        return arrayListToString(studentList);
    }

    public ArrayList<Course> getCourseList() { return courseList; }
    public void setCourseList(ArrayList<Course> courseList) { this.courseList = courseList; }


    public String getModuleName() { return moduleName; }
    public void setModuleName(String moduleName) { this.moduleName = moduleName; }


    public String getModuleID() { return moduleID; }
    public void setModuleID(String moduleID) { this.moduleID = moduleID; }


    public ArrayList<Student> getStudentList() { return studentList; }
    public void setStudentList(ArrayList<Student> studentList) { this.studentList = studentList; }
}
