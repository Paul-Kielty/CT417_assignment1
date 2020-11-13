//import java.util.ArrayList;

public class Student {
//
//    public static void main(String[] args) {
//        Student s1 = new Student("Paul", 21, "9-4-1999", 6);
//        System.out.println(s1.getUsername());
//    }

    private String name, DOB, username;
    private int age, ID;

    public Student(String name, int age, String DOB, int ID){
        this.name = name;
        this.age = age;
        this.DOB = DOB;
        this.username = getUsername();
    }

    public String getUsername(){
        return name+age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
