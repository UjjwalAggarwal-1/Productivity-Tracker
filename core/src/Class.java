import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import java.util.regex.*;

public class Class {
    private ClassType classType;
    private String time;
    private String room;
    private Teacher teacher;
    private String Course;
    private Day day;

    public String getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }

    public Day getDay() {
        return day;
    }

    public String getCourse() {
        return Course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ClassType getClassType() {
        return classType;
    }

}
