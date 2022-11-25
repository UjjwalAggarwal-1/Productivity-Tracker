package user.src;

import java.lang.*;

import core.src.*;

public class Teacher extends User{

    TeacherType teacherType;

    Teacher(String name, String email, TeacherType teacherType){
        super(name, email);
        try {
            this.teacherType = teacherType;
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public TeacherType getTeacherType() {
        return teacherType;
    }
}
