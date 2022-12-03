package user.src;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import java.util.regex.*;
import java.sql.*;


public class Student extends User{
    private String bitsId;
    private double cg;
    private String password;

    protected String encrypt(String password){
        String encryptedpassword = null;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            // Add plain-text password bytes to digest using MD5 update() method.
            m.update(password.getBytes());
            /* Convert the hash value into bytes */
            byte[] bytes = m.digest();
            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            /* Complete hashed password in hexadecimal format */
            encryptedpassword = s.toString();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return encryptedpassword;
    }

    public boolean check_bitsId(String bitsId){
        String regex = "^[0-9]{4}[ABCHPD0-9][ABH0-9]..[0-9]{4}P$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(bitsId);
        return matcher.matches();
    }

    public Student(String name, String email, String bitsId){
        super(name, email);
        if(!check_bitsId(bitsId)){throw new IllegalArgumentException("Invalid BitsId");}
        this.bitsId = bitsId;
        this.save();
    }

    public double getCg() {
        return cg;
    }

    public String getBitsId() {
        return bitsId;
    }

    public void setBitsId(String bitsId) {
        this.bitsId = bitsId;
    }

    public void setCg(double cg) {
        this.cg = cg;
    }

    public void setPassword(String password) {
        this.password = encrypt(password);
    }

    public void createTable(){
        final String CONNECTION = "jdbc:mysql://localhost:3306/ProductivityTracker";
        try{Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}
        try(Connection conn = DriverManager.getConnection(CONNECTION, "root", "safemysql");
            Statement statement = conn.createStatement()){

            statement.executeUpdate("create table Students (id int primary key not null AUTO_INCREMENT, " +
                    "name varchar(100), email varchar(50), bitsid varchar(50), cg float, password varchar(100) );");
            System.out.println("created successfully");

        }catch(SQLException e){
            System.out.println("HELLO in catch");

            e.printStackTrace();
        }
        return;
    }

    public void save(){
        final String CONNECTION = "jdbc:mysql://localhost:3306/ProductivityTracker";
        try{Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}
        try(Connection conn = DriverManager.getConnection(CONNECTION, "root", "safemysql");
            Statement statement = conn.createStatement()){

            statement.executeUpdate("insert into Students " +
                    "(name, email, bitsid, cg, password)" +
                    " values( '"+this.getName()+"', '"+this.getEmail()
                    +"', '" + this.getBitsId()+"', 0,'"+ password+"');");

            System.out.println("added successfully");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return;
    }

    public boolean login(String username, String Password){
        final String CONNECTION = "jdbc:mysql://localhost:3306/ProductivityTracker";
        try{Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}

        boolean res ;

        try(Connection conn = DriverManager.getConnection(CONNECTION, "root", "safemysql");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from students where  name = '"+username+"'")){

            if(resultSet.next()){
                return true;
            }
            return false;


        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("unexpected behaviour in login function");
        return false;
    }

    public int getId(){
        final String CONNECTION = "jdbc:mysql://localhost:3306/ProductivityTracker";
        try{Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}

        boolean res ;

        try(Connection conn = DriverManager.getConnection(CONNECTION, "root", "safemysql");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from students where  bitsid = '"+this.bitsId+"'")){

            if(resultSet.next()){
                return resultSet.getInt("id");
            }
            System.out.println("unexpected behaviour in id function try");

            return 1;


        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("unexpected behaviour in id function");
        return 1;
    }

}

