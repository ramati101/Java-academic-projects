/**
 * this class represents the arrays of trips.
 * 
 */
public class IsraelTour
{
    private Trip [] _data;
    private int _noOfTrips;
    
    final int MAX_TRIPS = 100;
    
    /**
     * creates a new trips array.
     * 
     */
    public IsraelTour()
    {
        _data = new Trip[MAX_TRIPS];
    }
    
    /**
     *  the method gets the number of trips in the array.
     *  @Return the number of trips.
     */
    public int getNoOfTrips()
    {
        int NoOfTrips = 0;
        int i ;
        for( i=0; i<100 &&_data[i]!=null; i++ )
            NoOfTrips++;
        return NoOfTrips;
    }
    /**
     * the method add trip to the trips array if there is space.
     * @param newTrip - the trip we want to add.
     * @return true if its added successfully or false if it dosent added.
     */
    public boolean addTrip(Trip newTrip)
    {
        if( newTrip != null )
        {
            if( this.getNoOfTrips() < MAX_TRIPS )
            {
                _data[this.getNoOfTrips()] = new Trip(newTrip);
                return true;
            }
        }    
        return false;
    }
    /**
     * the method remove the trip from the array if it can find it.
     * @param tripToRemove - the trip we want to remove.
     * @return true if its remove successfully or false if it dosent.
     */
    public boolean removeTrip(Trip tripToRemove)
    {
        int i = 0;
        if( tripToRemove != null )
        {
            while( i<this.getNoOfTrips())
            {
                if( _data[i].equals(tripToRemove) )
                {
                    _data[i] = new Trip(_data[this.getNoOfTrips()-1]);
                    _data[this.getNoOfTrips()-1] = null;
                    return true;
                }
                else
                    i++;
            }
        }
        return false;   
    }
    /**
     * the method return the number of travellers of all the trips.
     * @return the number of the travellers of all the trips in the array.
     */
    public int howManyTravellers()
    {
        int i;
        int numOfTravellers = 0;
        for( i=0; i<=this.getNoOfTrips()-1; i++ )
        {
            numOfTravellers+=_data[i].getNoOfTravellers();
        }
        return numOfTravellers;
    }
    /**
     * the method gets date and check how many trips starts at this date.
     * @param depDate - the date we want to check.
     * @return number of trips who start at this date.
     */
    public int howManyTripsDeparture(Date depDate)
    {
        int i;
        int numOfTripsDeparture = 0;
        for( i=0; i<=this.getNoOfTrips()-1; i++ )
        {
            if( (_data[i].getDepartureDate()).equals(depDate) ) 
                numOfTripsDeparture++ ;
        }
        return numOfTripsDeparture;
    }
    /**
     * the method gets the date and check how many cars is needed to all the trips who starts at this date.
     * @param depDate - the date we want to check.
     * @return the number of cars needed for all the trips who start at depDate.
     */
    public int howManyCars(Date depDate)
    {
        int i;
        int numOfCars = 0;
        for( i=0; i<=this.getNoOfTrips()-1; i++ )
        {
            if( (_data[i].getDepartureDate()).equals(depDate) ) 
                numOfCars+=_data[i].howManyCars() ;
        }
        return numOfCars;
    }
    /**
     * the method find the longest trip in the array.
     * @return the longest trip in the array.
     */
    public Trip longestTrip()
    {
        int i;
        Trip longestTripToReturn;
        if( !(_data[0]==null) )
        {
            Trip longestTrip = new Trip( _data[0] );
            for( i=1; i<=this.getNoOfTrips()-1; i++ )
            {
                longestTrip =( longestTrip.tripDuration()>_data[i].tripDuration() )? longestTrip : _data[i] ;
            }
            return longestTripToReturn = new Trip(longestTrip);
        }
        else
            return null;
    }
    /**
     * the method find the most popular guide of all the trips.
     * @return the name of the most popular guide.
     */
    public String mostPopularGuide()
    {
        int i;
        int j;
        String emepty = "";
        if( !(_data[0]==null) )
        {
            //String popularGuide = new String(_data[0].getGuideName());
            String popularGuide = "";
            String guide1 = "";
            String guide2 = "";
            int numOfPopularGuide = 0;
            for( i=0; i<getNoOfTrips(); i++ )
            {
                int numOfGuide1 = 0;
                for( j=0; j<getNoOfTrips(); j++ )
                    {
                        guide1 = _data[i].getGuideName();
                        guide2 = _data[j].getGuideName();
                        if( guide1.equals(guide2) )
                              numOfGuide1++ ;
                    }
                numOfPopularGuide = ( numOfPopularGuide <= numOfGuide1 ) ? numOfGuide1: numOfPopularGuide;
                popularGuide = ( numOfPopularGuide <= numOfGuide1 ) ? guide1 : popularGuide;
            }
            //for( i=0; i<=this.getNoOfTrips()-1; i++ )
            //{
            // numOfPopularGuide=( popularGuide.equals(_data[i].getGuideName()) )? numOfPopularGuide+1 : numOfPopularGuide;
            //}
            //for( i=1; i<=this.getNoOfTrips()-1; i++ )
            //{
            //    guide2 = new String(_data[i].getGuideName());
            //    for( j=0; j<=this.getNoOfTrips()-1; j++ )
            //        numOfGuide2 =( guide2.equals(_data[j].getGuideName()) )? numOfGuide2+1 : numOfGuide2;
            //    if(numOfPopularGuide<numOfGuide2)
            //    {
            //        numOfPopularGuide = numOfGuide2;
            //        popularGuide = guide2;
         
            
            return popularGuide;
        }
        else
            return emepty;
    }
    /**
     * the method find the trip who starts earliest.
     * @return the date of the trip who start earliest.
     */
    public Date earliestTrip()
    {
        int i;
        if( !(_data[0]==null) )
        {
            Date earliestTrip = new Date(_data[0].getDepartureDate());
            for( i=1; i<=this.getNoOfTrips()-1; i++ )
                earliestTrip=( earliestTrip.before(_data[i].getDepartureDate()) )? earliestTrip : new Date(_data[i].getDepartureDate()) ;
            return earliestTrip;
        }
        else
            return null;
    }
    /**
     * the method find the most expensive trip in the array.
     * @return the trip who the most expensive.
     */
    public Trip mostExpensiveTrip()
    {
        int i;
        if( !(_data[0]==null) )
        {
            Trip mostExpTrip = new Trip( _data[0] );
            for( i=1; i<=this.getNoOfTrips()-1; i++ )
                mostExpTrip=( mostExpTrip.calculatePrice()>_data[i].calculatePrice() )? mostExpTrip : new Trip(_data[i]) ;
            return mostExpTrip;
        }
        else
            return null;
    }
}






