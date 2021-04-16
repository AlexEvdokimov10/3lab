package EducationModul;

import java.io.Serializable;
import java.util.EnumMap;

enum TypeLesson{
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
public class Course implements Serializable {
    String name;
    int allTime;
    float currentAssessment;
    TypeLesson typeLesson=TypeLesson.Practic;

    EnumMap<TypeLesson,Integer>divider=new EnumMap<TypeLesson, Integer>(TypeLesson.class);
    Course(String name,int allTime){
        this.allTime=allTime;
        this.name=name;
        divider.put(TypeLesson.Lection,allTime/2);
        divider.put(TypeLesson.Practic,allTime/2);

    }

    public void setCurrentAssessment(float currentAssessment) {
        this.currentAssessment = currentAssessment;
    }

    public float getCurrentAssessment() {
        return currentAssessment;
    }
}
