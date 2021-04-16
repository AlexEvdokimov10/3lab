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
    public static void main(String[]args) throws IOException, ClassNotFoundException {
        Group group=new Group(101);
        Group group2=new Group(102);
        group.addCourse("OOP",5);
        group.addStudent("Alex Evdokimov");
        group2.addCourse("OOP",5);
        group2.addStudent("Biba Boba");
        Teacher programTeacher=new Teacher("Yrii Nezdolii");
        programTeacher.addGroup(group);
        programTeacher.addGroup(group2);
        programTeacher.estimateStudentPractice(5,"Alex Evdokimov",101,"OOP");
        programTeacher.delAssessmentPractice(2,"Alex Evdokimov",101,"OOP");
        programTeacher.estimateStudentPractice(4,"Biba Boba",102,"OOP");
        programTeacher.sortStudent("OOP");


    }


}

