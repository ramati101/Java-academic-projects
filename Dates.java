import java.util.Scanner;
public class Dates
{
    public static void main (String [] args)
    {
        // declaring:
        final int MIN_DAYS_IN_MONTH = 1 ;
        final int MAX_DAYS_IN_LONG_MONTH = 31 ;
        final int MAX_DAYS_IN_SHORT_MONTH = 30 ;
        final int MAX_DAYS_IN_FEB = 28 ;
        final int MAX_DAYS_IN_FEB_LEAP_YEAR = 29 ;
        final int MIN_MONTH = 1 ;
        final int MAX_MONTH = 12;
        final int MIN_YEAR = 1 ;
        final int JAN = 1 ;
        final int FEB = 2 ;
        final int MAR = 3 ;
        final int APR = 4 ;
        final int MAY = 5 ;
        final int JUN = 6 ;
        final int JUL = 7 ;
        final int AUG = 8 ;
        final int SEP = 9 ;
        final int OCT = 10 ;
        final int NOV = 11 ;
        final int DEC = 12 ;
        int newDay = 2 ;
        int newMonth = 2  ; 
        int newYear = 2 ;
        
        //scan the date:
        Scanner scan = new Scanner (System.in);
        System.out.println ("Please enter 3 integers to represent a valid date:");
        int day = scan.nextInt();
        int month = scan.nextInt();
        int year = scan.nextInt();
        
        if (( year >= MIN_YEAR )&&( month >= MIN_MONTH )&&( month <= MAX_MONTH )&&( day >= MIN_DAYS_IN_MONTH )&&( day <= MAX_DAYS_IN_LONG_MONTH )) // check if year bigger than 1, if month between 1-12 and days between 1-31.
            {
            if ((( month == APR )||( month == JUN )||( month == SEP )||( month == NOV ))&&( day <= MAX_DAYS_IN_SHORT_MONTH )) // check if the month is 30 days long and if the user type a valid number of days.
                {
                 System.out.println ("Please enter an integer which represents the number of days:");   
                 int num = scan.nextInt();
                 if ( num <= -1 )
                    System.out.println("The number of days must be positive.");
                 else
                    if ( num >= 11 )
                        System.out.println("The number of days must be between 1 to 10.");
                    else
                        newDay = ( day+num <= MAX_DAYS_IN_SHORT_MONTH ) ? day+num : (day+num)- MAX_DAYS_IN_SHORT_MONTH ;  // if the day the user type + the number of days is bigger than the number of days in the month, so we need to 
                        newMonth = ( day+num <= MAX_DAYS_IN_SHORT_MONTH ) ? month : month+1 ;                             // continue to the next month.
                        System.out.println("The original date is "+day+"/"+month+"/"+year+".");
                        System.out.println("After "+num+" days the date is "+newDay+"/"+newMonth+"/"+year+".");
                }
                
            else 
                if (( month == JAN )||( month == MAR )||( month == MAY )||( month == JUL )||( month == AUG )||( month == OCT )||( month == DEC )) // check if the month is 31 days long and we already check if the user type day between 1-31.
                    {
                    System.out.println ("Please enter an integer which represents the number of days:");
                    int num = scan.nextInt();
                    if ( num <= -1 )
                        System.out.println("The number of days must be positive.");
                    else
                        if ( num >= 11 )
                            System.out.println("The number of days must be between 1 to 10.");
                        else
                            newDay = ( day+num <= MAX_DAYS_IN_LONG_MONTH ) ? day+num : (day+num)- MAX_DAYS_IN_LONG_MONTH ;
                            newMonth = ( day+num <= MAX_DAYS_IN_LONG_MONTH ) ? month : month+1 ;
                            newMonth = ( newMonth > MAX_MONTH ) ? JAN : newMonth ;
                            newYear = ( (day+num > MAX_DAYS_IN_LONG_MONTH) && month==DEC ) ? year+1 : year ;
                            System.out.println("The original date is "+day+"/"+month+"/"+year+".");
                            System.out.println("After "+num+" days the date is "+newDay+"/"+newMonth+"/"+newYear+".");
                    }
                else
                    if (( month == FEB )&&((( year % 4 == 0 )&&( year % 100 != 0 ))||( year % 400 == 0 ))) // check if its february and if its a leap year. if its true, there is 29 days in this month.
                        {
                         System.out.println ("Please enter an integer which represents the number of days:");   
                         int num = scan.nextInt();
                         if ( num <= -1 )
                            System.out.println("The number of days must be positive.");
                         else
                            if ( num >= 11 )
                                System.out.println("The number of days must be between 1 to 10.");
                            else
                                newDay = ( day+num <= MAX_DAYS_IN_FEB_LEAP_YEAR ) ? day+num : (day+num)- MAX_DAYS_IN_FEB_LEAP_YEAR ;
                                newMonth = ( day+num <= MAX_DAYS_IN_FEB_LEAP_YEAR ) ? month : month+1 ;
                                System.out.println("The original date is "+day+"/"+month+"/"+year+".");
                                System.out.println("After "+num+" days the date is "+newDay+"/"+newMonth+"/"+year+".");
                        }
                    else   
                        if (( month == FEB )&&( day <= MAX_DAYS_IN_FEB )) // its not a leap year but its february, there is 28 days in this month.
                            {
                             System.out.println ("Please enter an integer which represents the number of days:");   
                             int num = scan.nextInt();
                             if ( num <= -1 )
                                System.out.println("The number of days must be positive.");
                             else
                                if ( num >= 11 )
                                    System.out.println("The number of days must be between 1 to 10.");
                                else
                                    newDay = ( day+num <= MAX_DAYS_IN_FEB ) ? day+num : (day+num)- MAX_DAYS_IN_FEB ;
                                    newMonth = ( day+num <= MAX_DAYS_IN_FEB ) ? month : month+1 ;
                                    System.out.println("The original date is "+day+"/"+month+"/"+year+".");
                                    System.out.println("After "+num+" days the date is "+newDay+"/"+newMonth+"/"+year+".");
                            }
                        else // none of the condions is true so the date is invalid.
                        System.out.println ("The original date "+day+"/"+month+"/"+year+" is invalid.");
                
            }
        
        else
            System.out.println ("The original date "+day+"/"+month+"/"+year+" is invalid.");
        
    }
}