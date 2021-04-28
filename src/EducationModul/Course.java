package EducationModul;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

enum TypeLesson {
    Lection{
        public float estimate(float assessment){

                return assessment;

        }
    },
    Practic{
        public float estimate(float assessment){

                return assessment;


        }
    };
    public abstract float estimate(float assessment);
}
public class Course {
    String name;
    int allTime;
    TypeLesson typeLesson=TypeLesson.Practic;
    Map<Student,Float> gradeBook=new HashMap<>();

    EnumMap<TypeLesson,Integer>divider=new EnumMap<TypeLesson, Integer>(TypeLesson.class);

    Course(String name,int allTime){
        this.allTime=allTime;
        this.name=name;
        divider.put(TypeLesson.Lection,allTime/2);
        divider.put(TypeLesson.Practic,allTime/2);

    }
}
