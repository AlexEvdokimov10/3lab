import java.util.List;

public class Student extends  Group implements Actions{
    public String name;
    protected List<Lessons>listAssessment;


    public Student(String name,List<Lessons>listAssessment) {
        this.name = name;
        this.listAssessment=listAssessment;
    }

    @Override
    public Student searchStudent(List<Student> group, String name) {
        for (var tempGroup:group) {
            if(tempGroup.name.contains(name)){
                return tempGroup;
            }
        }
        return null;
    }
}
