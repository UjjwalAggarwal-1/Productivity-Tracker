package core.src;
import java.sql.Date;
import user.src.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

    Assignment assignment = new Assignment("OOP lab",Date.valueOf("2022-12-4"), "CS F213", 30,
            ExamType.OpenBook, true);
    Student s = new Student("Ujjwal", "f20212427@pilani.bits-pilani.ac.in", "2021A7PS2427P");
//
    assignment.removeTeamMember(s);

    System.out.println("done");

    }
}