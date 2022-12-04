package core.src;

public class ProductiveHour {
    String date ;
    double hours;
    public ProductiveHour(String Date,double hours)
    {
        this.date = Date;
        this.hours = hours;
    }
    public double getProductiveHour(String Date){
        if (this.date.equals(Date))
            return hours;
        return 0;
    }
}
