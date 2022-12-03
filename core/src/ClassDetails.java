package core.src;

import java.lang.*;

import user.src.*;

public class ClassDetails {
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
