
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** comaprator - if we wants to compare based on any logic written in the compare method */
/** comparable is giving that power to class to compare its object to itself by check in compareTo method */
class Student implements Comparable<Student>{
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Age - " + age + " & "  + " Name - " + name;
    }

    @Override
    public int compareTo(Student that) {
            if(this.age> that.age)
                return 1;
            else if(this.age< that.age)
                return -1;
            else return 0;
        }
        
}

public class ComparableStudentDemo {
    public static void main(String[] args) {
    List<Student> studs = new ArrayList<>();
        studs.add(new Student(27, "Navin"));
        studs.add(new Student(17, "Vinod"));
        studs.add(new Student(19, "Sumit"));
        studs.add(new Student(30, "Ashish"));
        studs.add(new Student(31, "Manoj"));

        Collections.sort(studs);

        for(Student s : studs){
            System.out.println(s);
        }
    }
}
