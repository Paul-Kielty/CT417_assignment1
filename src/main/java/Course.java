import java.lang.reflect.Array;
import java.util.ArrayList;
import org.joda.time.DateTime;

public class Course {

    private String courseName;
    private ArrayList<Module> moduleList = new ArrayList<Module>();
    private ArrayList<Student> enrolledStudents = new ArrayList<Student>();
    private DateTime startDate, endDate;

    public Course(String courseName, DateTime startDate, DateTime endDate) { // Course constructor
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addModule(Module m) { // Method to add a module to this course
        if (!moduleList.contains(m)) { // Check if module is NOT already in moduleList
            moduleList.add(m);
        }
        if (!m.getCourseList().contains(this)) { // Check if this course is NOT already in module's course list
            m.addCourse(this);
        }
        for (Student s : enrolledStudents) { // For each student enrolled in this course
            s.addModule(m); // Update the student's course (and module) list
        }
    }

    public void removeModule(Module m) { // Method to remove a module from this course
        if (moduleList.contains(m)) { // If the course IS already in moduleList
            moduleList.remove(m);
        }
        if (m.getCourseList().contains(this)) { // If this course is already in the module's courseList
            m.removeCourse(this);
        }
        for (Student s : enrolledStudents) { // For each student enrolled in this course
            s.removeModule(m); // Remove the module from the student's module list
        }
    }

    public void enrollStudent(Student s){ // Method to enroll a student in this course
        if(!enrolledStudents.contains(s)) { // If the student is NOT already in enrolledStudents
            enrolledStudents.add(s);
        }
        for (Module m: this.getModuleList()){ // For each module in this course
            s.addModule(m); // Add the module to the student's module list
            m.addStudent(s); // Add the student to the module's student list
        }
        if(!s.getCourses().contains(this)) { // If this course is NOT already in the student's course list
            s.addCourse(this); // Add the course to the student's course list
        }
    }

    public void removeStudent(Student s){ // Method to remove a student from this course
        if(enrolledStudents.contains(s)) { // If the student IS already in enrolledStudents
            enrolledStudents.remove(s); // Remove the student from this course's enrolledStudents
            s.removeCourse(this); // Remove the course from the student's course list
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
