//import java.util.ArrayList;

public class Student {
    private String name, DOB, username;
    private int age, ID;

    public Student(String name, int age, String DOB, int ID, String username){
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
