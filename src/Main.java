package src;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import Database.Connection;
public class Main {
    public static void main(String[] args) {
        //students table
        Connection.createTable("create table Students (id int primary key not null AUTO_INCREMENT, " +
                "name varchar(100), email varchar(50), bitsid varchar(50), cg float, password varchar(100) );");

        // assignments
        Connection.createTable("create table Assignments(id int primary key not null AUTO_INCREMENT," +
                "name varchar(100), date date, " +
                "course varchar(50), totalmarks int, examtype varchar(50), isgroup boolean);");

        // assignment student many-to-many relation
        Connection.createTable(" create table assignment_student(assignment int, student int);");

        //notes
        Connection.createTable("create table notes(title varchar(50), text text);");

//        Connection.createTable();
//        
//        Connection.createTable();
    }
}