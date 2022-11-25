import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import java.util.regex.*;

public class WeekSchedule {
    private ArrayList<Class> schedule;

    public ArrayList<Class> getSchedule() {
        return schedule;
    }

    public ArrayList<Class> addClass(Class newClass){
        this.schedule.add(newClass);
        return schedule;
    }

    public ArrayList<Class> addClasses(ArrayList<Class> classesList){
        this.schedule.addAll(classesList);
        return schedule;
    }

}
