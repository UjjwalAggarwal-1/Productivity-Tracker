import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import java.util.regex.*;
import java.security.*;

public abstract class User {
    private String name;
    private String email;

    public boolean check_email(String email){
        String regex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    User(String name, String email){
        if(name.length() == 0 ){
            throw new IllegalArgumentException("Invalid Name");
        }

        if (!check_email(email)){
            throw new IllegalArgumentException("Invalid email");
        };

        this.name = name;
        this.email = email;

    }

    public String getName(){
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}