/**
 * Represents Date - day/month/year.
 * Coordinates cannot be negative.
 * 
 */
public class Date
{
    private int _day;
    private int _month;
    private int _year;
    
    int nMonth;
    int nYear;
    
    private final int MIN_DAY = 1 ;
    private final int MAX_DAY_IN_SHORT_MONTH = 30 ;
    private final int MAX_DAY_IN_LONG_MONTH = 31 ;
    private final int MAX_DAY_IN_FEB_NOT_LEAP_YEAR = 28 ;
    private final int MAX_DAY_IN_FEB_LEAP_YEAR = 29 ;
    private final int JAN = 1 ;
    private final int FEB = 2 ;
    private final int MAR = 3 ;
    private final int APR = 4 ;
    private final int MAY = 5 ;
    private final int JUN = 6 ;
    private final int JUL = 7 ;
    private final int AUG = 8 ;
    private final int SEP = 9 ;
    private final int OCT = 10 ;
    private final int NOV = 11 ;
    private final int DEC = 12 ;
    private final int MIN_YEAR = 1000 ;
    private final int MAX_YEAR = 9999 ;
    private final int DEFAULT_DAY = 1 ;
    private final int DEFAULT_MONTH = 1 ;
    private final int DEFAULT_YEAR = 2000 ;
    // constructors:
    /**
     * constructs a Date object
     * construct a new date with instance with the specified day, month and year.
     * the year should be between 1000 to 9999.
     * the month should be between 1 to 12.
     * the day should be between 1 to 31 if its a long month, 1 to 30 if its a short month and 1 to 28 if its february and 1 to 29 if its february in a leap-year.
     * otherwise if the date is  invalid, the date will be set to default:  1/1/2000.
     * @param year
     * @param month
     * @param day
     */
    public Date (int day, int month, int year)
    {
      if ( validDate(day, month, year) ) 
       {
           _year = year ;
           _month = month ;
           _day = day ; 
       }  
      else
        {
         _year = DEFAULT_YEAR;
         _month = DEFAULT_MONTH;
         _day = DEFAULT_DAY;
        }    
     }
    /**
     * Copy constructor for Date.
     * Construct a date with the same variables as another date.
     * @param other The date object from which to construct the new date.
     * 
     */
    public Date (Date other) 
    {
        _year = other._year ;
        _month = other._month ;
        _day = other._day ;
        
    }
    //gets method:
    /**
     * Return the year of the date.
     * @return the year of the date.
     * 
     */
    public int getYear()
    {
        return _year ;
    } 
    /**
     * Return the month of the date.
     * @return the month of the date.
     * 
     */
    public int getMonth()
    {
        return _month ;
    }
    /**
     * Return the day of the date.
     * @return the day of the date.
     * 
     */
    public int getDay()
    {
        return _day ;
    }
    //sets method:
    /**
     * Changes the year of the date.
     * If illegal number is received, year will be unchanged.
     * @param yearToSet The new year.
     */
    public void setYear ( int yearToSet )
    {
        if ( validDate(_day, _month, yearToSet) )
            _year = yearToSet ;
        else
            {
            _year = DEFAULT_YEAR;
            _month = DEFAULT_MONTH;
            _day = DEFAULT_DAY;
            }
    }
    /**
     * Changes the month of the date.
     * If illegel number is recived, month will be unchanged.
     * @param monthToSet the new month.
     */
    public void setMonth ( int monthToSet )
    {
        if ( validDate(_day, monthToSet, _year) )
            _month = monthToSet ;
        else
            {
            _year = DEFAULT_YEAR;
            _month = DEFAULT_MONTH;
            _day = DEFAULT_DAY;
            }
    }
    /**
     * Changes the day of the date.
     * If illegel number of day recived, day will be unchanged.
     * @param dayToSet the new day.
     */
    public void setDay ( int dayToSet )
    {
        if ( validDate( dayToSet, _month, _year ))
            _day = dayToSet ;
        else
            {
            _year = DEFAULT_YEAR;
            _month = DEFAULT_MONTH;
            _day = DEFAULT_DAY;
            }
    }
    //other methods:
    /**
     * Check if the received date is equal to this date.
     * @param other The date to be compared with this date
     * @return True if the received date is equal to this date.
     */
    public boolean equals ( Date other )
    {
        if ((_year==other._year)&&(_month==other._month)&&(_day==other._day))
            return true;
        return false;
    }
    /**
     * Check if this date is before a received date.
     * @param other The date to check if this point is before.
     * @return True if this date is before other date.
     */
    public boolean before ( Date other )
    {
        if ( _year>other._year )
            return false;
        if ( _year<other._year )
            return true;
        if ( _month>other._month )
            return false;
        if ( _month<other._month )
            return true;
        if ( _day>other._day )
            return false;
        if ( _day<other._day )
            return true;
            
        return false;
    }
    /**
     * Check if this date is after a received date.
     * @param other the date to check if this point is after.
     * @return True if this date is after other date.
     */
    public boolean after ( Date other )
    {
        return other.before(this);
    }
    // computes the day number since the beginning of the Christian counting of years:
    private int calculateDate ( int day, int month, int year) 
    {
        if (month < 3) 
        {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }
    
    /**
     * Calculates the difference (in days) between two dates.
     * @param other The date to check the difference to. 
     * @return int difference in days
     */
    public int difference ( Date other )
    {
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year)) ;
    }
    
    /**
     * Return a string representation of this date (day / month / year).
     * @return String representation of this date (day / month / year).
     */
    public String toString()
    {
        String s = _day+"/"+_month+"/"+_year ;
        return s ;
    }
    
    /**
     * Calculates the day in the week of the date.
     * @retuen int who represents the day in the week. 1 is sunday, 6 is friday and 0 its saterday.
     */
    public int dayInWeek()
    {
        if (_month < 3) 
        {
            nYear = _year - 1;
            nMonth = _month + 12;
        }
        int D = _day;
        int M = nMonth;
        int C = nYear / 100 ;
        int Y = nYear % 100 ;
        
        return (D + (26*(M+1))/10 + Y + Y/4 + C/4 - 2*C) % 7 ;
    }
        
    /**
     * Check if this Date is valid.
     * the year should be between 1000 to 9999.
     * the month should be between 1 to 12.
     * the day should be between 1 to 31 if its a long month, 1 to 30 if its a short month and 1 to 28 if its february and 1 to 29 if its february in a leap-year.
     * @param year.
     * @param month.
     * @param day.
     * @return true if the Date is valid.
     * 
     */
    private boolean validDate (int day, int month, int year)
    {
        if ( year>=MIN_YEAR && year<=MAX_YEAR )
        {
            switch ( month )
           {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: if( day<=MAX_DAY_IN_LONG_MONTH && day>=MIN_DAY )
                         return true;
                         else
                         return false;

                case 4:
                case 6:
                case 9:
                case 11: if( day<=MAX_DAY_IN_SHORT_MONTH && day>=MIN_DAY ) 
                         return true;
                         else
                         return false;
                        
                case 2:  if ( day>=MIN_DAY && day<=MAX_DAY_IN_FEB_LEAP_YEAR && ((( year % 4 == 0 )&&( year % 100 != 0 ))||( year % 400 == 0 )) )  // check if the day between 1 to 29 and if the year is a leap year.
                         return true; 
                        
                         if ( day>=MIN_DAY && day<=MAX_DAY_IN_FEB_NOT_LEAP_YEAR ) //check if the day between 1 to 28
                         return true;
                         else
                        return false;    
                        
                        
                default: return false;
                         
                        }//end of switch
                    }
       else
           return false;
    }
}