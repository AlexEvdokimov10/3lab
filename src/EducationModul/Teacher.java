package EducationModul;

import java.util.*;

/*
Створіть наступну модель: є Викладачі, які ведуть певні навчальні курси, кожен курс має загальну кількість годин,
які розподілені по різним типам занять (лекції, практичні заняття). Ці заняття проводяться зі студентами.
Модель повинна давати можливість проводити заняття зі студентськими групами, виставляти бали,
надавати звіти викладачу з успішності  груп або конкретних студентів.
Модель повинна надавати можливість будувати рейтинг успішності студентів з дисципліни.
 */
public class Teacher {
    String name;
    List<Group> groupList=new ArrayList<Group>();
    Teacher(String name){
        this.name=name;
    }
    boolean addGroup(Group group){
        if(groupList.contains(group)){
            return true;
        }
        return groupList.add(group);
    }
    public Student searchStudent(String name,int numberGroup) {
        for (var tempGroup:groupList) {
            if(tempGroup.numberGroup==numberGroup){
                for(var tempStudent:tempGroup.listStudent){
                    if(tempStudent.name.contains(name)){
                        return tempStudent;
                    }
                }
            }
        }
        return null;
    }

    public Course searchLesson(String name,int numberGroup) {
        for (var tempGroup:groupList) {
            if(tempGroup.numberGroup==numberGroup){
                for (var tempCourse:tempGroup.listCourse) {
                    if(tempCourse.name.contains(name)){
                        return tempCourse;
                    }
                }
            }
        }
        return null;
    }


    void estimateStudentPractice(float assessment,String name,int numberGroup,String courseName) {

            Student tempStudent=searchStudent(name,numberGroup);

            if(tempStudent!=null){
                for (var tempCourse:tempStudent.courseList)
                {
                    if(tempCourse.name.contains(courseName)) {
                        for (Map.Entry<TypeLesson,Integer>item:tempCourse.divider.entrySet()) {
                            if(item.getKey().name()=="Practic") {
                                tempCourse.currentAssessment += item.getKey().estimate(assessment);
                            }
                        }
                    }
                }
            } else{
            System.out.println("Student wasn't found");
        }
    }

    void delAssessmentPractice(float assessment,String name,int numberGroup,String courseName) {

        Student tempStudent=searchStudent(name,numberGroup);

        if(tempStudent!=null){
            for (var tempCourse:tempStudent.courseList)
            {
                if(tempCourse.name.contains(courseName)) {
                    for (Map.Entry<TypeLesson,Integer>item:tempCourse.divider.entrySet()) {
                        if(item.getKey().name()=="Practic") {
                            if(tempCourse.currentAssessment>=assessment) {
                                tempCourse.currentAssessment -= item.getKey().estimate(assessment);
                            }
                        }
                    }
                }
            }
        } else{
            System.out.println("Student wasn't found");
        }
    }

    List<Student>findStudentCourse(String name){
        List <Student>students=new ArrayList<Student>();
        for (var tempGroup:groupList) {
            for (var tempCourse:tempGroup.listCourse){
                if(tempCourse.name.contains(name)){
                    students.addAll(tempGroup.listStudent);
                }
            }
        }
        return students;
    }
    void sortStudent(String name) {
        List<Student> temporaryStudent = findStudentCourse(name);
        if (temporaryStudent != null) {
            Student temp = null;
            Comparator<Float> raiting = new Comparator<Float>() {
                @Override
                public int compare(Float o1, Float o2) {
                    return (int) (o2 - o1);
                }
            };

            for (int i = 0; i < temporaryStudent.size(); i++) {
                for (int j = 0; j < temporaryStudent.size() - i - 1; j++) {
                    if (raiting.compare(temporaryStudent.get(j).courseList.get(i).getCurrentAssessment(), temporaryStudent.get(j+1).courseList.get(i).getCurrentAssessment()) > 0) {
                        temp = temporaryStudent.get(j);
                        temporaryStudent.set(j, temporaryStudent.get(j + 1));
                        temporaryStudent.set(j + 1, temp);
                    }

                }
            }
            int i=0;
            for (var tempStudent:temporaryStudent) {
                System.out.println(tempStudent.name+" "+tempStudent.courseList.get(i).name+" "+tempStudent.courseList.get(i).currentAssessment);
            }

        }
    }

}
