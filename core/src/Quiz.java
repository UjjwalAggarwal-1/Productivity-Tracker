package core.src;

import core.src.Evaluative;
import core.src.ExamType;

public class Quiz extends Evaluative {
    public Quiz (String n,java.sql.Date date, String course, int totalMarks, ExamType type) {
        super(n,date, course,  totalMarks, type);
    }

}
