package EducationModul;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Group {
    List<Student> listStudent=new ArrayList<>();

    List<Course>listCourse=new ArrayList<Course>();

    int numberGroup;

    Group(int numberGroup){
        this.numberGroup=numberGroup;
    }

    boolean addCourse(String name,int alltime){
        for (var tempCourse : listCourse) {
            if(tempCourse.name.contains(name)){
                return true;
            }
        }
        return listCourse.add(new Course(name,alltime));
    }
    boolean addStudent(String name) throws IOException, ClassNotFoundException {
            for (var tempGroup : listStudent) {
                if (tempGroup.name.contains(name)) {
                    return true;
                }
            }
            return listStudent.add(new Student(name, numberGroup,listCourse));

    }

    boolean deleteStudent(String name){
        for (var tempGroup : listStudent) {
            if (tempGroup.name.contains(name)) {
                return listStudent.remove(tempGroup);
            }
        }
        return false;
    }


        // TODO: 14.04.2021 перевірити на відсутність студентів с таким ім'ям в групі

}
