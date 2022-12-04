package user.src;

import java.lang.*;
import java.util.regex.*;

public abstract class User {
    private String name;
    private String email;

    public boolean checkEmail(String email){
        String regex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    User(String name, String email){
        if(name.length() == 0 ){
            throw new IllegalArgumentException("Invalid Name");
        }

        if (!checkEmail(email)){
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