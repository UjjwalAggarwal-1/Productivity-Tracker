package core.src;


import java.lang.*;

public abstract class Evaluative
{
    String date;
    String course;
    Grade grade;
    String time;
    int totalMarks;
    int yourMarks;
    ExamType type;
    public String getTime() {
        return time;
    }

    public int getYourMarks() {
        return yourMarks;
    }

    public void setYourMarks(int yourMarks) {
        this.yourMarks = yourMarks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    Evaluative (String date, String course, String time, int totalMarks, ExamType type)
    {
        this.date = date;
        this.course = course;
        this.time = time;
        this.totalMarks = totalMarks;
        this.type = type;
    }
    public Evaluative ()
    {
        this.date = "1/1/22";
        this.course = null;
        this.time = "12:00 AM";
        this.grade = Grade.NA;
        this.type = ExamType.ClosedBook;
        this.totalMarks = 20;
    }
}
