package EducationModul;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        listCourse.add(new Course(name,alltime));
        for(var tempStudent:listStudent) {
            for (var tempCourse : listCourse) {
                tempCourse.gradeBook.put(tempStudent, 0.f);
            }
        }
        return false;
    }

    boolean addStudent(String name){
            for (var tempGroup : listStudent) {
                if (tempGroup.name.contains(name)) {
                    return true;
                }
            }
            return listStudent.add(new Student(name, numberGroup));

    }

    boolean deleteStudent(String name){
        for (var tempGroup : listStudent) {
            if (tempGroup.name.contains(name)) {
                return listStudent.remove(tempGroup);
            }
        }
        return false;
    }

}
