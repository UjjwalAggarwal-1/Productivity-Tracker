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

    public void createTable(){
        final String CONNECTION = "jdbc:mysql://localhost:3306/ProductivityTracker";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}

        try(Connection conn = DriverManager.getConnection(CONNECTION, "root", "safemysql");
            Statement statement = conn.createStatement()){

            statement.executeUpdate("create table Teachers ( name varchar(100), email varchar(50),"+
                    "teacherType varchar(50));");
            System.out.println("teachers table created successfully");

        }catch(SQLException e){
            System.out.println("HELLO in catch");

            e.printStackTrace();
        }
        return;
    }

    public void save(){
        final String CONNECTION = "jdbc:mysql://localhost:3306/ProductivityTracker";
        try{Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}
        try(Connection conn = DriverManager.getConnection(CONNECTION, "root", "safemysql");
            Statement statement = conn.createStatement()){

            statement.executeUpdate("insert into Teachers values( '"+this.getName()+"', '"+this.getEmail()
                    +"', '" + this.getTeacherType()+"');");

            System.out.println("added successfully");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return;
    }
}
