package core.src;

public class Exam extends Evaluative {
    public Exam (String name, java.sql.Date date, String course, int totalMarks, ExamType type) {
        super(name, date, course, totalMarks, type);
    }
    int duration;

}
