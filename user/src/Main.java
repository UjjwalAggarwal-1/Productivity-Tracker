package user.src;

import java.sql.SQLException;
import java.sql.SQLNonTransientException;
import java.sql.SQLSyntaxErrorException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Student s = new Student("Ujjwal", "f20212427@pilani.bits-pilani.ac.in", "2021A7PS2427P");
//        try{s.createTable();}catch(Exception se){System.out.println("Students table already exists!");}
//        s.save();
        System.out.println(s.login("Ujjwal","")); //password lite ; give or not doesnot matter
    }
}