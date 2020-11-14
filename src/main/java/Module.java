import java.util.ArrayList;
public class Module {

    private String moduleName, moduleID;
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Course> courseList = new ArrayList<Course>();

    public Module(String moduleName, String moduleID) { // Module constructor
        this.moduleName = moduleName;
        this.moduleID = moduleID;
    }

    public void addStudent(Student s) { // Method to add a student to this module
        if (!studentList.contains(s)) { // Check if student is NOT already in studentList
            studentList.add(s); // If not a duplicate, add to studentList
        }
        if (!s.getModules().contains(this)) { // Check if module is NOT already in student's module list
            s.addModule(this); // Update student's module list
        }
    }

    public void removeStudent(Student s) { // Method to remove a student from this module
        if (studentList.contains(s)) { // Check if student IS already in studentList
            studentList.remove(s);
        }
        if (s.getModules().contains(this)) { // Check if module IS already in student's module list
            s.removeModule(this); // Update student's module list
        }
    }

    public void addCourse(Course c){ // Method to add a course to this module
        if (!courseList.contains(c)) { // Check if course is NOT already in courseList
            courseList.add(c); // If not a duplicate, add to ArrayList
        }
        if (!c.getModuleList().contains(this)) { // Check if this module is NOT already in course's module list
            c.addModule(this); // If not a duplicate, add this module to course
        }
        for (Student s : c.getEnrolledStudents()){ // For each Student enrolled in course
            if (!studentList.contains(s)){ // If the Student is NOT already in studentList
                studentList.add(s);
            }
        }
    }

    public void removeCourse(Course c){ // Method to remove a course from this module
        if (courseList.contains(c)) { // Check if course IS already in courseList
            courseList.remove(c);
        }
        if (c.getModuleList().contains(this)) { // Check if this module IS already in course's module list
            c.removeModule(this);
        }
        for (Student s : c.getEnrolledStudents()) { // For each student enrolled in course
            if (!studentList.contains(s)) { // If the Student IS already in studentList
                studentList.remove(s);
            }
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
