package user.src;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.*;
import java.util.regex.*;
import java.sql.*;
import Database.Connection;

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

    public boolean checkBitsId(String bitsId){
        String regex = "^[0-9]{4}[ABCHPD0-9][ABH0-9]..[0-9]{4}P$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(bitsId);
        return matcher.matches();
    }

    public Student(String name, String email, String bitsId){
        super(name, email);
        if(!checkBitsId(bitsId)){throw new IllegalArgumentException("Invalid BitsId");}
        this.bitsId = bitsId;
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


    public void save(){

        String sql = "insert into Students " +
                "(name, email, bitsid, cg, password)" +
                " values( '"+this.getName()+"', '"+this.getEmail()
                +"', '" + this.getBitsId()+"', 0,'"+ password+"');";

        Connection.save(sql);
        return;
    }

    public boolean login(String username, String Password) {

        String sql = "Select * from students where  name = '" + username + "'";

        try{Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}
        try(java.sql.Connection conn = DriverManager.getConnection(Connection.CONNECTION, Connection.mysqlUser, Connection.mysqlPassword);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            if(resultSet.next()){
                return true;
            }return false;
        }catch(SQLException e){
            e.printStackTrace();
            return true;
        }
    }

    public int getId(){

        String sql = "Select * from students where  bitsid = '"+this.bitsId+"'";

        try{Class.forName("com.mysql.cj.jdbc.Driver");}catch (ClassNotFoundException e){e.printStackTrace();}
        try(java.sql.Connection conn = DriverManager.getConnection(Connection.CONNECTION, Connection.mysqlUser, Connection.mysqlPassword);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            if(resultSet.next()){return resultSet.getInt("Id");}return 1;

        }catch(SQLException e){
            e.printStackTrace();
            return 1;
        }
    }

}

