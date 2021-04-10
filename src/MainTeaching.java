import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTeaching {
    public static void main(String[]args){
        List listTeachers=new <Teacher> ArrayList();

        List listStudents209=new <Student>ArrayList();

        List listLessons=new <Lessons>ArrayList();
        List listLessons2=new <Lessons>ArrayList();
        listLessons.add(new Lection("OOP",5.0f,5));
        listLessons2.add(new Lection("OOP",5.0f,12));
        listStudents209.add(new Student("Alex Evdokimov",listLessons));
        listStudents209.add(new Student("Smeshnoi Chebyrek",listLessons2));
        Teacher programmTeacher=new Teacher("Ivanov Ivan Ivanovich",listStudents209);

        listTeachers.add(programmTeacher);





        programmTeacher.estimateStudent(5, programmTeacher.searchStudent(listStudents209,"Alex Evdokimov"),(Lessons) listLessons.get(0));
        programmTeacher.sortStudent(programmTeacher.findStudent("OOP"));





    }

}

