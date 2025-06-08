
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** comaprator - if we wants to compare based on any logic written in the compare method */
/** comparable is giving that power to class to compare its object to itself by check in compareTo method */
class Student1{
    int age;
    String name;

    public Student1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Age - " + age + " & "  + " Name - " + name;
    }   
}

public class ComparatorStudentDemo {
    public static void main(String[] args) {
        
        /*
        Comparator<Student1> compStudent = new Comparator<Student1>() {

            @Override
            public int compare(Student1 s1, Student1 s2) {
                if(s1.age > s2.age)
                    return 1;
                else if(s1.age < s2.age)
                    return  -1;
                else return 0;       
            }
            
        };
        */

        // with lambda
        Comparator<Student1> compStudent =  (s1, s2) -> s1.age > s2.age?1:-1;
                       

        List<Student1> studs = new ArrayList<>();
        studs.add(new Student1(27, "Navin"));
        studs.add(new Student1(17, "Vinod"));
        studs.add(new Student1(19, "Sumit"));
        studs.add(new Student1(30, "Ashish"));
        studs.add(new Student1(31, "Manoj"));

        Collections.sort(studs,compStudent);

        for(Student1 s : studs){
            System.out.println(s);
        }
    }
}
