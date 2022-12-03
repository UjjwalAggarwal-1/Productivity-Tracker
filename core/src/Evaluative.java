package core.src;


import java.lang.*;
import java.util.Date;

public abstract class Evaluative
{
    String name;
    java.sql.Date date;
    String course;
    Grade grade;
    int totalMarks;
    int yourMarks;
    ExamType type;

    public int getYourMarks() {
        return yourMarks;
    }

    public void setYourMarks(int yourMarks) {
        this.yourMarks = yourMarks;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }
    Evaluative (String name, java.sql.Date date, String course, int totalMarks, ExamType type)
    {
        this.name = name;
        this.date = date;
        this.course = course;
        this.totalMarks = totalMarks;
        this.type = type;
    }
    public Evaluative ()
    {
        this.name = "Trial Eval";
        this.date = java.sql.Date.valueOf("2022-12-4");
        this.course = null;
        this.grade = Grade.NA;
        this.type = ExamType.ClosedBook;
        this.totalMarks = 20;
    }
}
