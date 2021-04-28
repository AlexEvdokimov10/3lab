package EducationModul;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Student extends Group {
    String name;
    List<Course>courseList;
    Student(String name, int numberGroup){
        super(numberGroup);
        this.name=name;
    }
}
