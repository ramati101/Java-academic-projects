import java.util.Scanner;
public class Ex14
{
    /**
     * the method finds the longest sub-array that its sum divided by 3 without a remainder.
     * the Time-complexity of the original what method is - O(n^3).
     * my time-complexity - O(n).
     */
    public static int what (int []a)
    {
        int arraySum = 0;
        int arrayDevide;
        for( int i=0; i<a.length; i++ ) // get the sum of the remainders of the numbers in the array.
            arraySum += a[i]%3; 
        arrayDevide = arraySum%3; // get the remainder of the sum of the remainders.
        if(arrayDevide!=0) // if the remainder is 0 so the array divided by three, return the array length.
        {
            int i,j,sum,sum1,sum2 ;
                                                           //  V    BELOW ME    V  - its turn the array remainder from a->b : 1->-2  2->-1  -1->2  -2->1
            for( i=0,sum=0 ; i<a.length && sum!=arrayDevide && (arrayDevide*-2)%3!=sum ; i++ ) // loop from the start to the end, sum up and get the remainder, if the remainder = array remainder OR the other condition stop the loop.
                sum = (sum+a[i])%3;  // sum up the sum of the remainders so far with the next number and divide it all by 3.
            int fromTheEnd = a.length-i;   //  the longest length from the end of the array.
                                                                //  V    BELOW ME    V  - its turn the array remainder from a->b : 1->-2  2->-1  -1->2  -2->1
            for( i=a.length-1,sum=0 ; i>=0 && sum%3!=arrayDevide && (arrayDevide*-2)%3!=sum ; i-- ) // loop from the end to the start, sum up and get the remainder, if the remainder = array remainder OR the other condition stop the loop.
                sum = (sum+a[i])%3;     // sum up the sum of the remainders so far with the next number and divide it all by 3.
            int fromTheStart = i+1;  //  the longest length from the start of the array.
                          // V to the end of array.  
            for( i=0, sum1=0 ; i<a.length && (((arrayDevide==1||arrayDevide==-2)&&(sum1!=2&&sum1!=-1))||((arrayDevide==2||arrayDevide==-1)&&(sum1!=1&&sum1!=-2))) ; i++ )
                sum1 += a[i]%3;  
            for( j=a.length-1, sum2=0; j>i && (sum1+sum2)%3!=arrayDevide && (sum1+sum2)%3!=(arrayDevide*-2)%3 ; j-- )
                sum2 += a[j]%3;
            int between = ( i-1<j+1 && i!=0 && j!=a.length-1 ) ? j-i+1 : 0; // calculate the longest sub-array between if he is longest than 0 and not the original array.
                
            return Math.max( fromTheEnd, Math.max( fromTheStart, between )); // return the biggest value from the three.
            }
            else
                return a.length;
    }
     /**
     * the method gets array who contain the numbers 1 and 0 and replace the 1 numbers to the number of the distance to the nearest 0.
     * @param Array a - the array we want to make the transformation on.
     */
    public static void zeroDistance (int [] a)
    {
        int lastZero = 0;
        int i;
        int j;
        for( i=0; i<a.length && a[i]!=0; i++ ){} // finds the first zero in the array.
        int firstZero = i;
        for( i=0; i<a.length; i++ ) // pass on the array from the start.
        {
            if( a[i]!=0 && i!=0 ) // if the number isnt 0 and it isnt the first number of the array.
                a[i]=a[i-1]+1;    // replace the number with the number of the previous cell + 1.
            if( a[i]==0 ) // finds the last zero in the array.
                lastZero=i;
        }
        for( j=a.length-1; j>=0; j-- ) // pass on the array from the end to the start.
        {
            if( j<lastZero && a[j]!=0 ) // if the number in the cell isnt zero and the number of the cell smaller than the last zero.
                if( a[j]>a[j+1] || j<firstZero ) // and if the number in the cell is bigger than the number in the previous cell + 1, and the cell number smaller than the first zero.
                    a[j]=a[j+1]+1;  // replace the number in the cell with the number in the previous cell + 1.
        }
    }
    /**
     * the method check if the string t is a transformation of string s, transformation is when every charcter in the string s appears in the string t at the same order and at least one time.
     * @param String s - the original string.
     * @param String t - the string we want to check if is transformation of s.
     * @return true if string t is transformation of s, else false.
     */
    public static boolean isTrans (String s, String t)
    {
        if(s.length()==0) // if the string is empty.
        {
            if(t.length()==0) //and the other string also empty they equals, return true.
                return true;
            else
                return false;
        }
        if(t.length()==0)
        {
            if(s.length()==0)
                return true;
            else
                return false;
        }
        if(s.charAt(0)==(t.charAt(0))) // check if the character of two string are equals.
            return (isTrans(s, t.substring(1))||isTrans(s.substring(1), t.substring(1))); // activate the method with to substring promoted and with only t string promoted.
        else
            return false;
    }
    /**
     * the method check if there is a sub-array in the array a, that match to the array pattern by the rules: 
     * if the number in the pattern array is 0 the parallel number in the sub-array will be integer with one or two digit,
     * if the number in the pattern array is 1 the parallel number in the sub-array will be integer with one digit,
     * if the number in the pattern array is 2 the parallel number in the sub-array will be integer with two digit.
     * @param Array a - the regular integer array.
     * @param Array pattern - the 0,1,2 integer array.
     * @return true if legal sub-array is found, else return false.
     */
    public static boolean match (int [] a, int [] pattern)
    {
        return match(a, 0, pattern, 0); //call the method with the assistance ints.
    }
    private static boolean match (int[] a, int aBox, int[] pattern, int patBox )
    {
        if( patBox==pattern.length ) // if the pattern array ends, return true
            return true;
        if( aBox==a.length ) // if a array ends check if pattern array ends, if both true return true.
        {
            if( patBox==pattern.length )
                return true;
            return false;
        }
        if(( pattern[patBox]==0 && (a[aBox]<100&&a[aBox]>-100) )||( pattern[patBox]==1 && (a[aBox]<10&&a[aBox]>-10) )||( pattern[patBox]==2 && (a[aBox]/10>0&&a[aBox]/10<10) )) //check if the rules exists.
            return match(a, aBox+1, pattern, patBox+1)||( patBox==0 && match(a, aBox+1, pattern, patBox) ); // activate the method with two pointers promoted and if the patBox pointer on the first place of the array activate and promote only the abox pointer.
        if( patBox==0 ) // if the rules dosent exists and the patBox pointer on the first place so activate the method and promote only the aBox pointer.
            return match(a, aBox+1, pattern, patBox);
        return false;
    }
}