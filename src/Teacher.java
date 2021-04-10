import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Teacher extends Lessons  implements Actions,Comparator<Student> {
    String name;
    protected Lessons lessons;
    List<Student> students;

    Teacher(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    void estimateStudent(float assessment, Student student, Lessons lessons) {
        if (student != null) {
            lessons.assessmentCurrent += assessment;
        }
    }

    @Override
    public Student searchStudent(List<Student> group, String name) {
        for (var tempGroup : group) {
            if (tempGroup.name.contains(name)) {
                return tempGroup;
            }
        }
        return null;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }

    List<Student> findStudent(String name){


        List tempList=new <Student>ArrayList();
                    for (var tempStudent : students) {
                        for(var tempName:tempStudent.listAssessment) {
                            if(tempName.nameLesson.contains(name)){
                                tempList.add(tempStudent);
                            }
                        }

                    }
        return tempList;
    }
    void sortStudent(List <Student> students){
        Student temp=null;
        Comparator<Float>raiting=new Comparator<Float>() {
            @Override
            public int compare(Float o1, Float o2) {
                return (int)(o2-o1);
            }
        };

            for (int i=0;i<students.size();i++){
                for(int j=0;j<students.size()-i-1;j++){
                    if(raiting.compare(students.get(j).listAssessment.get(i).assessmentCurrent,students.get(j+1).listAssessment.get(i).assessmentCurrent)>0)
                    {
                        temp=students.get(j);
                        students.set(j,students.get(j+1));
                        students.set(j+1,temp);
                    }

                }
            }

    }





}
