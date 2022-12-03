package core.src;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import java.util.regex.*;
import user.src.*;
import java.sql.*;

public class Assignment extends  Evaluative{
    public Assignment (String name,java.sql.Date date, String course, int totalMarks, ExamType type, boolean isGroup)
    {
        super(name, date, course, totalMarks, type);
        this.isGroup = isGroup;
        this.teamMembers = new ArrayList<Student>();
        this.save();
    }
    public boolean isGroup ;
    public ArrayList<Student> teamMembers;
    public ArrayList<Student> addTeamMember (Student student){
        teamMembers.add(student);

        final String CONNECTION = "jdbc:mysql://localhost:3306/ProductivityTracker";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}

        try(Connection conn = DriverManager.getConnection(CONNECTION, "root", "safemysql");
            Statement statement = conn.createStatement()){

            statement.executeUpdate(" insert into assignment_student(assignment , student ) " +
                    "values (" +
                    student.getId() +
                    "," +
                    this.getId() +
                    ");");

            System.out.println("teammember added successfully");

        }catch(SQLException e){
            System.out.println("HELLO in catch, add teammember");

            e.printStackTrace();
        }

        return teamMembers;
    }
    public ArrayList<Student> removeTeamMember(Student student){
        teamMembers.remove(student);

        final String CONNECTION = "jdbc:mysql://localhost:3306/ProductivityTracker";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}

        try(Connection conn = DriverManager.getConnection(CONNECTION, "root", "safemysql");
            Statement statement = conn.createStatement()){
//            System.out.println(this.getId());System.out.println(student.getId());
            statement.executeUpdate("delete from assignment_student where assignment=" +
                    this.getId() +
                    " and student=" +
                    student.getId() +
                    ";");

            System.out.println("teammember removed successfully");

        }catch(SQLException e){
            System.out.println("HELLO in catch, remove teammember");

            e.printStackTrace();
        }

        return teamMembers;
    }

    public void createTable(){
        final String CONNECTION = "jdbc:mysql://localhost:3306/ProductivityTracker";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}

        try(Connection conn = DriverManager.getConnection(CONNECTION, "root", "safemysql");
            Statement statement = conn.createStatement()){

            statement.executeUpdate("create table Assignments(id int primary key not null AUTO_INCREMENT," +
                    "name varchar(100), date date, " +
                    "course varchar(50), totalmarks int, examtype varchar(50), isgroup boolean);");
            statement.executeUpdate(" create table assignment_student(assignment int, student int);");
            System.out.println("tables created successfully");

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

            statement.executeUpdate("insert into assignments (name,date,course, totalmarks, examtype, isgroup)" +
                    " values( '" +
                    this.name +
                    "', date '"+this.getDate()+"', '"+this.course+"', " + this.totalMarks+ ", '"+this.type+"', "+this.isGroup+
                    ");");

            System.out.println("added successfully");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return;
    }

    public int getId(){
        final String CONNECTION = "jdbc:mysql://localhost:3306/ProductivityTracker";
        try{Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}

        boolean res ;

        try(Connection conn = DriverManager.getConnection(CONNECTION, "root", "safemysql");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from assignments where name = '"+this.name+"'")){

            if(resultSet.next()){
                return resultSet.getInt("id");
            }
            System.out.println("unexpected behaviour in id function try");

            return 1;


        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("unexpected behaviour in id function");
        return 1;
    }
}
