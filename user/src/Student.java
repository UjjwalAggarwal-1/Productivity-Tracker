package user.src;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import java.util.regex.*;


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
        String regex = "^[0-9]{4}[ABCHPD0-9][ABH0-9]..[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(bitsId);
        return matcher.matches();
    }

    Student(String name, String email, String bitsId){
        super(name, email);
        if(!check_bitsId(bitsId)){throw new IllegalArgumentException("Invalid BitsId");}
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


}

