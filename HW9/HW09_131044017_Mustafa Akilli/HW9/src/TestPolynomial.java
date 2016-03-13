
import tr.edu.gyte.CSE241.HW9.Mustafa.Akilli.Polynomial;

/**
 * HW09_131044017_Mustafa_Akilli
 * 
 * File:   TestPolynomial.java
 * 
 * Author: Mustafa_Akilli
 * 
 * Created on Friday 25 December 2015, 18:14 by Mustafa_Akilli
 * 
 * Description:
 * 
 * Test for Polynomial class
 * 
 * HW9 TestPolynomial JAVA
 * 
 * @author Mustafa_Akilli
 */


public class TestPolynomial {
    
    /**
     * Test your Polynomial class with many examples
     * 
     * @param args // command line
     */
    public static void main(String args [])
    {
        double [] firstArray = {1, 2, 4, -8, 1.4, 8.8 ,5}; // size is 7
        double [] sameFirstArray = {1, 2, 4, -8, 1.4, 8.8 ,5}; // size is 7
        double [] secondArray = {3.4, -15, 20, -5.4, 0, 1,}; // size is 6
        
        // take a double array to set all of the coefficients
        Polynomial firstPolynomial = new Polynomial(firstArray);
        Polynomial sameFirstPolynomial = new Polynomial(sameFirstArray);
        Polynomial secondPolynomial = new Polynomial(secondArray);
        
        // return a double array that contains all of the coefficients
        double [] copyfirstArray = firstPolynomial.getCoefficientsArray();
        
        // take a double array to set all of the coefficients
        Polynomial copyfirstPolynomial = new Polynomial(copyfirstArray);
        
        // toString
        System.out.println("First Polynomial: ");
        firstPolynomial.toString();
        System.out.println();
        
        // get coefficient
        System.out.printf("\nGet 3. Coefficient for firstPolynomial (x^2): %.2f \n",
                firstPolynomial.getCoefficient(2));
        
        // set coefficient
        firstPolynomial.setCoefficient(2,2.7);
        sameFirstPolynomial.setCoefficient(2,2.7);
        copyfirstPolynomial.setCoefficient(2,2.7);
        
        // toString
        System.out.println("\nAfter Set First Polynomial: ");
        firstPolynomial.toString();
        System.out.println("");
        
        //get coefficient
        System.out.printf("\nGet 3. Coefficient for firstPolynomial (x^2): %.2f \n",
                firstPolynomial.getCoefficient(2));
        
        System.out.println("\n*********************************************\n");
        
        
        // Given an x value, it can evaluate the polynomial and return the result
        System.out.printf("\nFirst Polynomial For x=0 result: %.2f \n", 
                                                    firstPolynomial.result(0));
        System.out.printf("\nFirst Polynomial For x=1 result: %.2f \n", 
                                                    firstPolynomial.result(1));
        System.out.printf("\nFirst Polynomial For x=5 result: %.2f \n", 
                                                    firstPolynomial.result(5));
        
        
        
        System.out.println("\n*********************************************\n");
        

        System.out.println("First Polynomial: ");
        firstPolynomial.toString();
        System.out.println("\n");
        
        System.out.println("Second Polynomial: ");
        secondPolynomial.toString();
        System.out.println("\n");
        
        // take another Polynomial and adds
        double [] firstAndSecondAddsArray = 
                        firstPolynomial.addOtherPolynomial(secondPolynomial);
                
        Polynomial firstAndSecondAddsPolynomial = 
                                        new Polynomial(firstAndSecondAddsArray);        
        
        System.out.println("First Polynomial + Second Polynomial: ");
        firstAndSecondAddsPolynomial.toString();
        System.out.println("\n");
        
        // take another Polynomial and subtract
        double [] firstAndSecondSubtractsArray = 
                        firstPolynomial.subtractOtherPolynomial(secondPolynomial);
                
        Polynomial firstAndSecondSubtractsPolynomial = 
                                        new Polynomial(firstAndSecondSubtractsArray);        
        
        System.out.println("First Polynomial - Second Polynomial: ");
        firstAndSecondSubtractsPolynomial.toString();
        System.out.println("\n");
        
        
        // take another Polynomial and multiplies 
        double [] firstAndSecondMultipliesArray = 
                        firstPolynomial.multipliOtherPolynomial(secondPolynomial);
                
        Polynomial firstAndSecondMultipliesPolynomial = 
                                        new Polynomial(firstAndSecondMultipliesArray);        
        
        
        System.out.println("First Polynomial * Second Polynomial: ");
        firstAndSecondMultipliesPolynomial.toString();
        System.out.println("\n");
        
        
        System.out.println("\n*********************************************\n");
        
        
        //equals
        System.out.printf("Is it equal First Polynomial "
                + "and Second Polynomial: %b \n", 
                firstPolynomial.equals(secondPolynomial));
        
        System.out.printf("Is it equal First Polynomial "
                + "and Copy First Polynomial: %b \n", 
                firstPolynomial.equals(copyfirstPolynomial));
        
        System.out.printf("Is it equal First Polynomial "
                + "and Same First Polynomial: %b \n", 
                firstPolynomial.equals(sameFirstPolynomial));

        System.out.println("\n*********************************************\n");
        
        //toString
        System.out.println("First Polynomial: ");
        System.out.println(firstPolynomial);
        System.out.println();
        System.out.println("\nSecond Polynomial: ");
        System.out.println(secondPolynomial);
        System.out.println();
        System.out.println("\nSame First Polynomial: ");
        System.out.println(sameFirstPolynomial);
        System.out.println();
        System.out.println("\nCopy First Polynomial: ");
        System.out.println(copyfirstPolynomial);
        System.out.println();
        
        
        System.out.println("\n*********************************************\n");
        
        
        //simple multipli
        double [] a = {4, 3, 2}; // size is 3
        double [] b = {0, 5, 1}; // size is 3
        double [] c;
        
        // take a double array to set all of the coefficients
        Polynomial a1 = new Polynomial(a);
        Polynomial b1 = new Polynomial(b);
        
        System.out.println("\nSimple Multiplies: \n");
        
        System.out.println("\na1: ");
        System.out.println(a1);
        System.out.println();
        
        System.out.println("\nb1: ");
        System.out.println(b1);
        System.out.println();
        
        c=a1.multipliOtherPolynomial(b1);
        Polynomial c1 = new Polynomial(c);

        System.out.println("\na1*b1: ");
        System.out.println(c1);
        System.out.println();
        
    }// end main
    
}// end class TestPolynomial
