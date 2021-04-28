package EducationModul;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Створіть наступну модель: є Викладачі, які ведуть певні навчальні курси, кожен курс має загальну кількість годин,
які розподілені по різним типам занять (лекції, практичні заняття). Ці заняття проводяться зі студентами.
Модель повинна давати можливість проводити заняття зі студентськими групами, виставляти бали,
надавати звіти викладачу з успішності  груп або конкретних студентів.
Модель повинна надавати можливість будувати рейтинг успішності студентів з дисципліни.
 */
public class MainTeaching {
    public static void main(String[]args){
        Group group1=new Group(101);
        Group group2=new Group(102);

        group1.addStudent("Alex Evdokimov");
        group1.addStudent("Alex Rachok");

        group1.addStudent("Petro Lifa");
        group2.addStudent("Biba Boba");

        group1.addCourse("OOP",5);
        group1.addCourse("OBD",3);

        group2.addCourse("OOP",5);

        Teacher programTeacher=new Teacher("Yrii Nezdolii");
        Teacher programTeacher2=new Teacher("Evgiy Davidenko");

        programTeacher.addGroup(group1);

        programTeacher.addGroup(group2);

        programTeacher.addCourse("OOP");

        programTeacher2.addGroup(group1);

        programTeacher2.addCourse("OBD");

        programTeacher.addCourse("OBD");

        programTeacher.estimateStudentPractice(6,"Alex Rachok",101,"OOP");
        programTeacher.estimateStudentPractice(5,"Alex Evdokimov",101,"OOP");
        programTeacher.delAssessmentPractice(0,"Alex Evdokimov",101,"OOP");
        programTeacher.estimateStudentPractice(4,"Biba Boba",102,"OOP");
        programTeacher.estimateStudentPractice(4,"Alex Evdokimov",101,"OBD");

        programTeacher.sortStudent("OOP");
        programTeacher.sortStudent("OBD");
        programTeacher2.addCourse("OOP");

        programTeacher2.estimateStudentPractice(10,"Alex Evdokimov",101,"OOP");


    }


}

