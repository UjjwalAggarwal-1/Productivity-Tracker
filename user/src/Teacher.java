package user.src;

import java.lang.*;
import java.lang.Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import core.src.*;

public class Teacher extends User{

    private TeacherType teacherType;

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

    public void save(){
        Database.Connection.save("insert into Teachers values( '"+this.getName()+"', '"+this.getEmail()
                +"', '" + this.getTeacherType()+"');");
    }
}
