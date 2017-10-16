
/**
 * Write a description of class Time here.
 *
 * @author Margaret Kilbane
 * @version September 2017
 */
public class Time
{
    // instance variables - replace the example below with your own
    private int hour, minute, second;
    private int format;
    
    public static final int FORMAT_12 = 1;
    public static final int FORMAT_24 = 0;
    
/**
 * no-args constructor sets the time to midnight
   */
    public Time()
    {
        hour = 0;
        minute = 0;
        second = 0;
        format = FORMAT_24;
    }
    
    /** Constructor sets hour, minute, second to value passed through paramaters.
     * @param h The hour
     * @param m The minute
     * @param s The second
     */
    public Time(int h, int m, int s)
    {
        hour = h;
        minute = m;
        second = s;
        format = FORMAT_12;
    }
   
    public Time(int h, int m)
    {
        hour = h;
        minute = m;
        second = 0;
        format = FORMAT_12;  
    }
  
  
    /**
     * @return the Hour
     */
    public int getHour()
    {
        return hour;
    }
    
     /**
     * @return the Minute
     */
    public int getMinute()
    {
        return minute;
    }
    
     /**
     * @return the Second
     */
    public int getSecond()
    {
        return second;
    }
    
     
    public void setFormat (int f)
    {
        format = f;
    }
    
    /*------ Formatting Methods--------*/
   
    public String toString()
    
{
        if (format == FORMAT_24)
        {
            
        return (to2Digits(hour) + 
        ":" + to2Digits(minute) + 
        ":" + to2Digits(second));
    }
    
    else // if (format == FORMAT_12)
    {
        if (hour > 12)
        {
            return ((hour-12) + ":" + 
            to2Digits (minute) + ":" +
            to2Digits(second) + "PM");
        }
        
         else if (hour == 12) 
         
        {
            return  hour + ":" + 
            to2Digits(minute) + ":" +
            to2Digits(second) + "PM";
        }
        
        else if (hour > 0) 
        {
            return (hour) + ":" + 
            to2Digits(minute) + ":" +
            to2Digits(second) + "AM";
        }
          else //if hour == 0)
        {
            return "12" + ":" + 
            to2Digits(minute) + ":" +
            to2Digits(second) + "AM";
        }
        
    }
}
    
    private String to2Digits (int n)
    {
        if (n < 10)
            {
                return "0" + n;
            }
        else
        {
            return "" + n;
        }
    }
    
        
    public void addMinute (int n)
    {
        int newMinute = this.minute + n;
        this.minute = newMinute % 60;
        this.addHour(newMinute / 60);
    }
    
     public void addHour (int n)
    {
        int newHour = this.hour + n;
        this.hour = newHour % 24;
    }
    
       public void addSecond (int n)
    {
        int newSecond = this.second + n;
        this.second = newSecond % 60;
        this.addMinute(newSecond / 60);
    }
    
    /**
     * Precondition: Time other is later than this Time
     */
    public Time elapsedTime (Time other)
    {
        int totalSecThis = this.second + (60 * this.minute) + (3600 + this.hour);
        int totalSecOther = other.getSecond() + (60 * other.getMinute()) + (3600 * other.getHour());
        int elapsedSeconds = totalSecOther - totalSecThis; 
        int newHour = elapsedSeconds / 3600;
        int newMin = (elapsedSeconds % 3600);
        int newSec = elapsedSeconds % 60;
        return new Time(newHour, newMin, newSec);
    }
    
    public static boolean isValidDate (int s, int m, int h)
    {
        if (((s < 1) || (s > 60)) || ((m < 1) || (m > 60)) || ((h < 1) || (h > 24)))
        {
            return false;
        }
    
        else
        {
            return true;
        }
       
    }
}

