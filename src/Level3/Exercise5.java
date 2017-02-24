/**
 * Created by Anna Zdrojewska on 2017-01-02.
 * Created for KM-PROGRAMS
 * http://km-programs.pl/
 */

package Level3;

import java.util.Arrays;
import java.util.Random;

public class Exercise5 {
    public static int howManyProperDivisors(int number){
        int divisor = 0;
        //the proper divisor is when number is divide not for 1 and each other
        for(int i = 2; i <= number/2; ++i){
            if (number % i == 0){
                ++divisor;
            }
        }
        return divisor;
    }
    public static void main(String[] args) {
        //new array with 100 elements
        int[] tab = new int[100];
        Random rnd = new Random();
        //draw numbers 0-20 to an array
        for(int i = 0; i < tab.length; i++){
            tab[i] = rnd.nextInt(21);
        }
        System.out.println("ARRAY OF NUMBERS: ");
        System.out.println(Arrays.toString(tab));

        //new array - element of the index 0 it's for counts elements with value 0
        int[] counts = new int[21];
        //count of elements
        for(int i=0; i < tab.length; i++){
            counts[tab[i]]++;
        }

        int maxValue = counts[0];
        //index max
        int idxMax = 0;
        //count the most common number in the array
        for(int i = 1; i< counts.length; i++){
            //it shifts when the values of counts array is bigger than first element which is  maxValue
            if(counts[i]> maxValue){
                idxMax = i;
                maxValue = counts[i];
            }
        }
        System.out.println("The most common number is: " + idxMax);
        //the number is a leader when it appears more times than half length of an array
        if(maxValue > tab.length/2){
            System.out.println("The number is a leader");
        }
        else{
            //when the number appear many times but it's not a leader
            int result = tab.length / 2 + 1 -  maxValue ;
            System.out.println("Missing " + result + " appearances this number to be a leader.");
        }
        //sum of the common numbers with proper divisors
        int howManyDivisorsHaveMostCommonValue = howManyProperDivisors(idxMax);
        int sum = 0;
        for(int i = 0; i < tab.length; i++){
            if(howManyProperDivisors(tab[i]) > howManyDivisorsHaveMostCommonValue)
            {
                sum += tab[i];
            }

        }
        System.out.println("The sum of elements which have the most divisors than leader " + sum);

    }
}
