package EducationModul;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Student extends Group {
    String name;
    int uniqNumber;
    static int counter;
    List<Course>courseList=new ArrayList<Course>();
    Student(String name, int numberGroup,List<Course>courseList) throws IOException, ClassNotFoundException {
        super(numberGroup);
        for (var tempCourse:courseList){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream ous = new ObjectOutputStream(baos);
            ous.writeObject(tempCourse);
            ous.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Course cloneCourse = (Course) ois.readObject();
            this.courseList.add(cloneCourse);
        }

        this.name=name;
        this.uniqNumber=counter;
        counter++;
    }


}
