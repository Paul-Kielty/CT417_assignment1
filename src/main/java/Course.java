import java.lang.reflect.Array;
import java.util.ArrayList;
import org.joda.time.DateTime;

public class Course {

    private String courseName;
    private ArrayList<Module> moduleList = new ArrayList<Module>();
    private ArrayList<Student> enrolledStudents = new ArrayList<Student>();
    private DateTime startDate, endDate;// = new DateTime(2020, 9, 28, 0 ,0);
//    = new DateTime(2020, 9, 28, 0 ,0);

    public Course(String courseName, DateTime startDate, DateTime endDate){
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addModule(Module m){
        moduleList.add(m);
    }

    public void enrollStudent(Student s){
        enrolledStudents.add(s);
    }

    public void removeStudent(Student s){
        enrolledStudents.remove(s);
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
