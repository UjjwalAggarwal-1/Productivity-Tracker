package core.src;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import java.util.regex.*;

import Database.Connection;
import user.src.*;
import java.sql.*;


public class Assignment extends  Evaluative{
    public Assignment (String name,java.sql.Date date, String course, int totalMarks, ExamType type, boolean isGroup)
    {
        super(name, date, course, totalMarks, type);
        this.isGroup = isGroup;
        this.teamMembers = new ArrayList<Student>();

    }
    public boolean isGroup ;
    public ArrayList<Student> teamMembers;
    public ArrayList<Student> addTeamMember (Student student){
        teamMembers.add(student);

        Connection.save(" insert into assignment_student(assignment , student ) " +
                "values (" +
                student.getId() +
                "," +
                this.getId() +
                ");");

        return teamMembers;
    }
    public ArrayList<Student> removeTeamMember(Student student){
        teamMembers.remove(student);

        Connection.save("delete from assignment_student where assignment=" +
                this.getId() +
                " and student=" +
                student.getId() +
                ";");

        return teamMembers;
    }

    public void save(){
        Connection.save("insert into assignments (name,date,course, totalmarks, examtype, isgroup)" +
                " values( '" +
                this.name +
                "', date '"+this.getDate()+"', '"+this.course+"', " + this.totalMarks+ ", '"+this.type+"', "+this.isGroup+
                ");");
        return;
    }

    public int getId(){
        String sql = "Select * from assignments where name = '"+this.name+"'";
        try{Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}
        try(java.sql.Connection conn = DriverManager.getConnection(Connection.CONNECTION, Connection.mysqlUser, Connection.mysqlPassword);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            if(resultSet.next()){return resultSet.getInt("Id");}return 1;

        }catch(SQLException e){
            e.printStackTrace();
            return 1;
        }
   }
}
