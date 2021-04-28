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

    List<Course>courseList=new ArrayList<Course>();



    Teacher(String name){
        this.name=name;
    }
    boolean addCourse(String name){
        for (var tempGroup:groupList){
            for (var tempCourse:tempGroup.listCourse) {
                boolean cheackLesson = isCheckingCourse(name);
                if (tempCourse.name.equals(name) & !cheackLesson) {
                    courseList.add(tempCourse);
                }
            }
        }
        return true;
    }

    boolean addGroup(Group group){
        if(groupList.contains(group)){
            return true;
        }
        return groupList.add(group);
    }
    boolean removeGroup(Group group){
        if(groupList.contains(group)){
            return true;
        }
        return groupList.remove(group);
    }

    public Student searchStudent(String name,int numberGroup) {
        Student result=null;
        for (var tempGroup:groupList) {
            if(tempGroup.numberGroup==numberGroup){
                for(var tempStudent:tempGroup.listStudent){
                    if(tempStudent.name.equals(name)){
                        result = tempStudent;
                    }
                }
            }
        }
        return result;
    }

    void estimateStudentPractice(float assessment,String name,int numberGroup,String courseName) {

        Student tempStudent=searchStudent(name,numberGroup);
        boolean checkingCourse = isCheckingCourse(courseName);
        if(checkingCourse) {
            if (tempStudent != null) {
                addEstimate(assessment,tempStudent,findLesson(courseName));
            } else {
                System.out.println("Student wasn't found");
            }
        }
        else{
            System.out.println("You don't have access to this lesson");
        }
    }

    Course findLesson(String courseName) {
        Course result=null;
        for (var tempGroup : groupList) {
            for (var tempCourse:tempGroup.listCourse) {
                if (tempCourse.name.equals(courseName)) {
                    return tempCourse;
                }
            }
        }
        return result;
    }

    void addEstimate(float assessment, Student tempStudent, Course tempCourse) {
        for (Map.Entry<TypeLesson, Integer> item : tempCourse.divider.entrySet()) {
            if (item.getKey().name().equals("Practic")) {
                for (Map.Entry<Student, Float> tempValue : tempCourse.gradeBook.entrySet()) {
                    if (tempValue.getKey().equals(tempStudent)) {
                        tempValue.setValue(tempValue.getValue() + item.getKey().estimate(assessment));
                    }
                }
            }
        }
    }

    private boolean isCheckingCourse(String courseName) {
        boolean result=false;
        for (var tempCourse : courseList) {
            if (tempCourse.name.equals(courseName)) {
                result = true;
                break;
            }
        }
        return result;
    }

    void delAssessmentPractice(float assessment,String name,int numberGroup,String courseName) {

        Student tempStudent=searchStudent(name,numberGroup);
        boolean checkingCourse = isCheckingCourse(courseName);
        if(checkingCourse) {
            if (tempStudent != null) {
                runInMap(assessment, tempStudent, findLesson(courseName));
            } else {
                System.out.println("Student wasn't found");
            }
        }
        else {
            System.out.println("You don't have access to this lesson");
        }
    }

    private void runInMap(float assessment, Student tempStudent, Course tempCourse) {
        for (Map.Entry<TypeLesson, Integer> item : tempCourse.divider.entrySet()) {
            if (item.getKey().name().equals("Practic")) {
                reduceAsseccment(assessment, tempStudent, tempCourse, item);
            }
        }
    }

    private void reduceAsseccment(float assessment, Student tempStudent, Course tempCourse, Map.Entry<TypeLesson, Integer> item) {
        for (Map.Entry<Student, Float> tempValue : tempCourse.gradeBook.entrySet()) {
            if (tempValue.getKey().equals(tempStudent)) {
                if (tempValue.getValue() >= assessment) {
                    tempValue.setValue(tempValue.getValue() - item.getKey().estimate(assessment));
                }
            }
        }
    }

    List<Course> findGroupCourse(String name){
        List <Course> courses=new ArrayList<>();
        for (var tempGroup:groupList) {
                for (var tempLesson : tempGroup.listCourse) {
                    if (tempLesson.name.equals(name)) {
                        courses.add(tempLesson);
                    }
                }
        }
        return courses;
    }

    void sortStudent(String name) {
        List<Course>tempCourses = findGroupCourse(name);
        Map<Student,Float>tempMap=new HashMap<>();
        if (courseList.size() > 0) {
            for (var tempCourse:tempCourses) {
                tempMap.putAll(tempCourse.gradeBook);
            }
            System.out.println("Course:"+name);
            tempMap.entrySet().stream().sorted(Map.Entry.<Student, Float>comparingByValue().reversed()).forEach((key)->System.out.println("Student"+" "+key.getKey().name+" Assessment: "+key.getValue()));

        }

    }
    }


