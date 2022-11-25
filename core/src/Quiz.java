package core.src;

import core.src.Evaluative;
import core.src.ExamType;

public class Quiz extends Evaluative {
    public Quiz (String date, String course, String time, int totalMarks, ExamType type) {
        super(date, course, time, totalMarks, type);
    }

}
