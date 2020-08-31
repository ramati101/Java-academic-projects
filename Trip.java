/**
 * This class represents a Trip object.
 * 
 */
public class Trip
   {
    private String _guideName;  //name of the guide
    private int _noOfCountries;  //number of countries to travel(max 10)
    private Date _departureDate;  //Date of departure to trip
    private Date _returningDate;  //Date of returning
    private int _noOfTravellers;  //number of traveller(max 50)
    final int MAX_NUMBER_OF_COUNTRIES = 10 ;
    final int MIN_NUMBER_OF_COUNTRIES = 1 ;
    final int DEFAULT_NUMBER_OF_COUNTRIES = 1 ;
    final int MAX_NUMBER_OF_TRAVELLERS = 50 ;
    final int MIN_NUMBER_OF_TRAVELLERS = 1 ;
    final int DEFAULT_NUMBER_OF_TRAVELLERS = 10 ;
    private final int PRICE_PER_DAY = 250 ;
    private final int PRICE_PER_COUNTRY = 100 ;
    
    //constructors:
    /**
     * creates a new Trip object
     * @param name - of the guide of the trip
     * @param depDay - the day of the departure date(1-31)
     * @param depMonth - the month of the departure date(1-12)
     * @param depYear - the year of the departure date (4 digits)
     * @param retDay - the day of the return date(1-31)
     * @param retMonth - the month of the return date(1-12)
     * @param retYear - the year of the return date(4 digits)
     * @param noOfCountries - the number of countries to be visited in the trip(1-10)
     * @param noOfTravellers - the number of travellers(1-50)
     */
    public Trip(String name, int depDay, int depMonth, int depYear, int retDay, int retMonth, int retYear, int noOfCountries, int noOfTravellers)
    {
       _noOfCountries = (noOfCountries<= MAX_NUMBER_OF_COUNTRIES&&noOfCountries>=MIN_NUMBER_OF_COUNTRIES ) ? noOfCountries : DEFAULT_NUMBER_OF_COUNTRIES ; //check if the number of countries should be between 1 to 10, otherwise it will be set to default: 1.
       _noOfTravellers = (noOfTravellers<= MAX_NUMBER_OF_TRAVELLERS&&noOfTravellers>=MIN_NUMBER_OF_TRAVELLERS) ? noOfTravellers : DEFAULT_NUMBER_OF_TRAVELLERS ; //check if the number of travellers should be between 1 to 50, otherwise it will be set to default: 10.
       _departureDate = new Date(depDay, depMonth, depYear);
       _returningDate = new Date(retDay, retMonth, retYear);
       _guideName = name ;
       if( _returningDate.before(_departureDate) ) //if the date of returning before the date of deoarture the dates is invalid and both dates sets to 1/1/2000.
       {
           _returningDate.setDay(1);
           _returningDate.setMonth(1);
           _returningDate.setYear(2000);
           _departureDate.setDay(1);
           _departureDate.setMonth(1);
           _departureDate.setYear(2000);
       }
    }
    /**
     * copy constructor.
     * creates a new Trip object
     * @param otherTrip - trip to be copied
     */
    public Trip (Trip other)
    {
        _noOfCountries = other._noOfCountries ;
        _noOfTravellers = other._noOfTravellers ;
        _departureDate = new Date(other._departureDate) ;
        _returningDate = new Date(other._returningDate) ;
        _guideName = other._guideName ;
    }
    /**
     * creates a new Trip object
     * @param name - of the guide of the trip
     * @param departureDate - the date of the departure date
     * @param returningDate - the date of the return date
     * @param noOfCountries - the number of countries to be visited in the trip(1-10)
     * @param noOfTravellers - the number of travellers(1-50)
     */
    public Trip (String name, Date departureDate, Date returningDate, int noOfCountries, int noOfTravellers)
    {
       _noOfCountries = (noOfCountries<= MAX_NUMBER_OF_COUNTRIES) ? noOfCountries : DEFAULT_NUMBER_OF_COUNTRIES ; //check if the number of countries should be between 1 to 10, otherwise it will be set to default: 1.
       _noOfTravellers = (noOfTravellers<= MAX_NUMBER_OF_TRAVELLERS) ? noOfTravellers : DEFAULT_NUMBER_OF_TRAVELLERS ; //check if the number of travellers should be between 1 to 50, otherwise it will be set to default: 10.
       _departureDate = new Date(departureDate);
       _returningDate = new Date(returningDate);
       _guideName = name ;
       if( _returningDate.before(_departureDate) )//if the date of returning before the date of deoarture the dates is invalid and both dates sets to 1/1/2000.
       {
           _returningDate.setDay(1);
           _returningDate.setMonth(1);
           _returningDate.setYear(2000);
           _departureDate.setDay(1);
           _departureDate.setMonth(1);
           _departureDate.setYear(2000);
       }
    }
    //gets methods:
    /**
     * gets the trip departure date.
     * @Return the departure date.
     */
    public Date getDepartureDate()
    {
        return new Date(_departureDate);
    }
    /**
     * gets the trip return date.
     * @Return the return date.
     */
    public Date getReturningDate()
    {
        return new Date(_returningDate);
    }
    /**
     * gets the number of countries to be visit in the trip.
     * @Return the number of countries.
     */
    public int getNoOfCountries()
    {
        return _noOfCountries;
    }
    /**
     * gets the number of travellers in the trip.
     * @return the number of travellers.
     */
    public int getNoOfTravellers()
    {
        return _noOfTravellers;
    }
    /**
     * gets the guide name.
     * @return the guide name.
     */
    public java.lang.String getGuideName()
    {
        return _guideName;
    }
    //sets methods:
    /**
     * sets the trip departure date, the date will change only if the new departure date is before the return date or equal to it.
     * @param newDepDate - the value to be set.
     */
    public void setDepartureDate(Date newDepDate)
    {
        if( !(newDepDate.after(_returningDate)) ) // method before return true only if the date before the other date but not if they equal, so i use the after method and the !. so its true if the date is before and if they equals.
            _departureDate = new Date(newDepDate);
    }
    /**
     * sets the trip return date the date will change only if the new return date is after the departure date or equal to it.
     * @param newRetDate - the value to be set.
     */
    public void setReturningDate(Date newRetDate)
    {
        if( !(newRetDate.before(_departureDate)) ) // method after return true only if the date after the other date but not if they equal, so i use the before method and the !. so its true if the date is after and if they equals.
            _returningDate = new Date(newRetDate);
    }
    /**
     * sets the number of countries (only if valid).
     * @param otherNumberOfCountries - the value to be set.
     */
    public void setNoOfCountries(int otherNoOfCountries)
    {
        if( otherNoOfCountries>=MIN_NUMBER_OF_COUNTRIES && otherNoOfCountries<=MAX_NUMBER_OF_COUNTRIES )
            _noOfCountries = otherNoOfCountries;
    }
    /**
     * sets the number of travellers (only if valid).
     * @param otherNumberOfTravellers - the value to be set.
     */
    public void setNoOfTravellers(int otherNoOfTravellers)
    {
        if( otherNoOfTravellers>=MIN_NUMBER_OF_TRAVELLERS && otherNoOfTravellers<=MAX_NUMBER_OF_TRAVELLERS )
            _noOfTravellers = otherNoOfTravellers;
    }
    /**
     * sets the guide name.
     * @param othername - the value to be set.
     */
    public void setGuideName(java.lang.String otherName)
    {
        _guideName = otherName;
    }
    // other methods:
    /**
     * check if 2 trips are the same.
     * @param other - the trip to compare this trip to.
     * @return true if the trips are the same.
     */
    public boolean equals(Trip other)
    {
        if( _departureDate.equals(other._departureDate) && _returningDate.equals(other._returningDate) && _noOfCountries==other._noOfCountries && _noOfTravellers==other._noOfTravellers && _guideName.equals(other._guideName) )
            return true;
        return false;
    }
    /**
     * check if two trips have the same departure date.
     * @param otherTrip - the trip to compare to.
     * @return true if the two trips have the same departure date otherwise false.
     */
    public boolean sameDepartureDate(Trip otherTrip)
    {
        if( _departureDate.equals(otherTrip._departureDate) )
            return true;
        return false;
    }
    /**
     * check if two trips have the same return date.
     * @param otherTrip - the trip to compare this trip to.
     * @return true if the two trips have the same return date otherwise false.
     */
    public boolean sameReturningDate(Trip otherTrip)
    {
        if( _returningDate.equals(otherTrip._returningDate) )
            return true;
        return false;
    }
    /**
     * check if two trips overlap with their dates.
     * @param otherTrip - the trip to check if overlaps with this trip.
     * @return true if the two trip have overlapping dates otherwise false.
     */
    public boolean overlap(Trip otherTrip)
    {
        if( _returningDate.before(otherTrip._departureDate) || _departureDate.after(otherTrip._returningDate) ) // if the returning date is before the other trip departure date or the departure date is after the other trip returning date so the date are'nt overlap so return false.
            return false;
        return true;
    }
    /**
     * calculates the number of days of the trip.
     * @return the number of days of the trip.
     */
    public int tripDuration()
    {
        return (_departureDate.difference(_returningDate))+1; // +1 because if for example the trip is start and end in the same date its count as 1.
    }
    /**
     * check if trip is loaded.
     * @return true if the number of countries to visit is greater than the trip duration - else return false.
     */
    public boolean isLoaded()
    {
        if( _noOfCountries>this.tripDuration() )
            return true;
        return false;
    }
    /**
     * calculates the minimum number of buses needed for the trip.
     * @return the number of buses needed for the trip.
     */
    public int howManyCars()
    {
        final int MAX_BUS_SEATS = 10;
        int numOfBus;
        if( _noOfTravellers<MAX_BUS_SEATS ) // if number of travellers is less than the number of seats on one bus, so one bus will be enough.
            numOfBus = 1;
        else
            numOfBus = ( _noOfTravellers%MAX_BUS_SEATS==0 ) ? _noOfTravellers/MAX_BUS_SEATS : (_noOfTravellers/MAX_BUS_SEATS)+1 ;
        return numOfBus;
    }
    /**
     * calculates how many weekends occur during the trip.
     * @return the number of weekends occurring during the trip.
     */
    public int howManyWeekends()
    {
        int numOfWeekends;
        final int NUM_OF_DAYS_IN_WEEK = 7;
        int dayOfDeparture = _departureDate.dayInWeek();
        int numberOfTripDays = this.tripDuration();
        numOfWeekends = ( numberOfTripDays % NUM_OF_DAYS_IN_WEEK >= NUM_OF_DAYS_IN_WEEK - dayOfDeparture ) ? (numberOfTripDays / NUM_OF_DAYS_IN_WEEK)+1 : numberOfTripDays / NUM_OF_DAYS_IN_WEEK; 
        if(dayOfDeparture==0)
            numOfWeekends++ ;
        return numOfWeekends;
    }
    /**
     * calculates total price of the trip according to days of the trip and number of countries visited.
     * @return the total price of the trip.
     */
    public int calculatePrice()
    {
        final int PRICE_PER_WEEKEND = 100;
        final int JULY = 7;
        final int AUGUST = 8;
        int monthTrip = _departureDate.getMonth();
        int price = (PRICE_PER_DAY*this.tripDuration()) + (PRICE_PER_COUNTRY*_noOfCountries) + (this.howManyWeekends()*PRICE_PER_WEEKEND);
        return (_departureDate.getMonth()==JULY || _departureDate.getMonth()==AUGUST ) ? (price/100)*120 : price;
    }
    /**
     * calculates the date of first weekend of the trip.
     * @return the date of the first weekend of the trip or null if there is no weekend on the trip.
     */
    public Date firstWeekend()
    {
        final int NUM_OF_DAYS_IN_WEEK = 7;
        final int WEEKEND_DAY_NUM = 0;
        final int MAX_DAYS_IN_LONG_MONTH = 31 ;
        final int MAX_DAYS_IN_SHORT_MONTH = 30 ;
        final int MAX_DAYS_IN_FEB = 28 ;
        final int MAX_DAYS_IN_FEB_LEAP_YEAR = 29 ;
        final int MAX_MONTH = 12;
        int day = _departureDate.getDay();
        int month = _departureDate.getMonth();
        int year = _departureDate.getYear();
        int daysTillWeekend = NUM_OF_DAYS_IN_WEEK - _departureDate.dayInWeek();
        if( _departureDate.dayInWeek() == WEEKEND_DAY_NUM )
            return _departureDate;
        if( daysTillWeekend <= this.tripDuration() ) 
            {
                switch( month )
                {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:    day = ( day+daysTillWeekend <= MAX_DAYS_IN_LONG_MONTH ) ? day+daysTillWeekend : (day+daysTillWeekend)- MAX_DAYS_IN_LONG_MONTH ;
                            month = ( day+daysTillWeekend <= MAX_DAYS_IN_LONG_MONTH ) ? month : month+1 ;
                            month = ( month > MAX_MONTH ) ? 1 : month ;
                            year = ( (day+daysTillWeekend > MAX_DAYS_IN_LONG_MONTH) && month==12 ) ? year+1 : year ;
                                break;

                case 4:
                case 6:
                case 9:
                case 11:    day = ( day+daysTillWeekend <= MAX_DAYS_IN_SHORT_MONTH ) ? day+daysTillWeekend : (day+daysTillWeekend)- MAX_DAYS_IN_SHORT_MONTH ;   
                            month = ( day+daysTillWeekend <= MAX_DAYS_IN_SHORT_MONTH ) ? month : month+1 ;                             
                                break;
                            
                case 2:     if ((( year % 4 == 0 )&&( year % 100 != 0 ))||( year % 400 == 0 ))
                               {
                                day = ( day+daysTillWeekend <= MAX_DAYS_IN_FEB_LEAP_YEAR ) ? day+daysTillWeekend : (day+daysTillWeekend)- MAX_DAYS_IN_FEB_LEAP_YEAR ;
                                month = ( day+daysTillWeekend <= MAX_DAYS_IN_FEB_LEAP_YEAR ) ? month : month+1 ;
                               }
                            else if ( day <= MAX_DAYS_IN_FEB )
                               {
                                day = ( day+daysTillWeekend <= MAX_DAYS_IN_FEB ) ? day+daysTillWeekend : (day+daysTillWeekend)- MAX_DAYS_IN_FEB ;
                                month = ( day+daysTillWeekend <= MAX_DAYS_IN_FEB ) ? month : month+1 ;
                               } 
                               break;
                
                }
                Date firstWeekend=new Date(day, month, year);
                return firstWeekend;
            }
        else   
            return null; 
    }
    /**
     * return a string representation of this trip.
     * @return representation of the trip in the following format: Trip:guide name|departure date-return date|number of countries|number of travellers for example: Trip:Yossi Chen|2/3/1998|10/3/1998|5|25.
     */
    public java.lang.String toString()
    {
        String s = ("TRIP:"+ _guideName +"|"+ _departureDate +"|"+ _returningDate +"|"+ _noOfCountries +"|"+ _noOfTravellers) ;
        return s;
        
    }
    
    
    
    
    }
    