import java.lang.reflect.Array;
import java.util.ArrayList;
import org.joda.time.DateTime;

public class Course {

    private String courseName;
    private ArrayList<Module> moduleList = new ArrayList<Module>();
    private ArrayList<Student> enrolledStudents = new ArrayList<Student>();
    private DateTime startDate, endDate;// = new DateTime(2020, 9, 28, 0 ,0);
//    = new DateTime(2020, 9, 28, 0 ,0);

    public Course(String courseName, DateTime startDate, DateTime endDate) {
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addModule(Module m) {
        if (!moduleList.contains(m)) {
            moduleList.add(m);
        }
        m.addCourse(this);
        for (Student s : enrolledStudents) {
            s.addModule(m);
        }
    }

    public void removeModule(Module m){
        if (moduleList.contains(m)) {
            moduleList.remove(m);
        }
        m.removeCourse(this);
        for (Student s : enrolledStudents) {
            s.removeModule(m);
        }
    }

    public void enrollStudent(Student s){
        if(!enrolledStudents.contains(s)) {
            enrolledStudents.add(s);
        }
        for (Module m: this.getModuleList()){ //Add modules if student enrolled in new course
            s.addModule(m);
            m.addStudent(s);
        }
        if(!s.getCourses().contains(this)) {
            s.addCourse(this);
        }
    }

    public void removeStudent(Student s){
        enrolledStudents.remove(s);
        s.removeCourse(this);

    }

    public String arrayListToString(ArrayList al) {
        String list = "";
        for (Object o : al) {
            list += o + "\n";
        }
        return list;
    }

    public String getModuleListString(){
        return arrayListToString(moduleList);
    }

    public String getStudentListString(){
        return arrayListToString(enrolledStudents);
    }

    @Override
    public String toString() {
        return String.format("Course Name: %s\n\nModule(s):\n%s\nEnrolled Student(s):\n%s",
                courseName, getModuleListString(), getStudentListString());
    }

    public String getCourseName() { return courseName; }

    public void setCourseName(String courseName) { this.courseName = courseName; }

    public ArrayList<Module> getModuleList() { return moduleList; }

    public void setModuleList(ArrayList<Module> moduleList) { this.moduleList = moduleList; }

    public ArrayList<Student> getEnrolledStudents() { return enrolledStudents; }

    public void setEnrolledStudents(ArrayList<Student> enrolledStudents) { this.enrolledStudents = enrolledStudents; }

    public DateTime getStartDate() { return startDate; }

    public void setStartDate(DateTime startDate) { this.startDate = startDate; }

    public DateTime getEndDate() { return endDate; }

    public void setEndDate(DateTime endDate) { this.endDate = endDate; }
}
