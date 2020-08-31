import java.util.Scanner;
// that class takes input(number of milli-seconds) from the user and convert it to seconds, minutes, hours and days
public class Milliseconds
{
    public static void main (String [] args)
    {
        // declaring:
        long days;
        long hours;
        long min;
        long sec;
        final long msInSec = 1000;
        final long secInMin = 60;
        final long minInHours = 60;
        final long hoursInDay = 24;
        
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program reads an integer which " +
            "represents Milliseconds and converts it to days, " +
            "hours, minutes and seconds. ");
        System.out.println ("Please enter the number of Milliseconds");
        long ms = scan.nextLong();
        
        // calculation:
        sec = ( (ms / msInSec)% secInMin ); // find the seconds, the remainder of the input(number of milliseconds) divide the number of milliseconds in one second divide to the number of the seconds in one minute.
        min = ( ((ms / msInSec)/secInMin)% minInHours );
        hours = ( (((ms / msInSec)/secInMin)/ minInHours)% hoursInDay );
        days = ( (((ms / msInSec)/secInMin)/ minInHours)/ hoursInDay );
        
        System.out.println(days +" days " + hours +":"+ min +":"+ sec +" hours");
    }  //end of method main
}  //end of class Milliseconds