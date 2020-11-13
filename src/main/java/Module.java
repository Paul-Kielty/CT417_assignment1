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
        if (!studentList.contains(s)) {
            studentList.add(s);
        }
        if (!s.getModules().contains(this)) {
            s.addModule(this); //update student's module list
        }
    }

    public void removeStudent(Student s) {
//        if (studentList.contains(s)) {
            studentList.remove(s);
//        }
        if (s.getModules().contains(this)) {
            s.removeModule(this);
        }
    }

    public void addCourse(Course c){
        if (!courseList.contains(c)) {
            courseList.add(c);
        }
        for (Student s : c.getEnrolledStudents()){ //add students who had this module because they were enrolled in course
            if (!studentList.contains(s)){
                studentList.add(s);
            }
        }
    }

    public void removeCourse(Course c){
//        if (courseList.contains(c)) {
            courseList.remove(c);
//        }
        for (Student s : c.getEnrolledStudents()){ //remove students who had this module because they were enrolled in course
            studentList.remove(s);
        }

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
