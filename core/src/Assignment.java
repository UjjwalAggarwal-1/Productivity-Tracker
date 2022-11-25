package core.src;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import java.util.regex.*;
import user.src.*;

public class Assignment extends  Evaluative{
    public Assignment (String date, String course, String time, int totalMarks, ExamType type)
    {
        super(date, course, time, totalMarks, type);
    }
    public boolean isGroup ;
    public ArrayList<Student> teamMembers;
    public ArrayList<Student> addTeamMember (Student student){
        teamMembers.add(student);
        return teamMembers;
    }
    public ArrayList<Student> removeTeamMember(Student student){
        teamMembers.remove(student);
        return teamMembers;
    }
}
