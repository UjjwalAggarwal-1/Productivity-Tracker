package core.src;

import java.lang.Class;
import java.util.*;
import java.lang.*;

public class WeekSchedule {
    private ArrayList<java.lang.Class> schedule;

    public ArrayList<java.lang.Class> getSchedule() {
        return schedule;
    }

    public ArrayList<java.lang.Class> addClass(java.lang.Class newClass){
        this.schedule.add(newClass);
        return schedule;
    }

    public ArrayList<java.lang.Class> addClasses(ArrayList<Class> classesList){
        this.schedule.addAll(classesList);
        return schedule;
    }

}
