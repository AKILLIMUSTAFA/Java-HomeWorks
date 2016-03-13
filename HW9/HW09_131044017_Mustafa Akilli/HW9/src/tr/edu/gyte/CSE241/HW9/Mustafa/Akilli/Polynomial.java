package tr.edu.gyte.CSE241.HW9.Mustafa.Akilli;

/**
 * HW09_131044017_Mustafa_Akilli
 * 
 * File:   Polynomial.java
 * 
 * Author: Mustafa_Akilli
 * 
 * Created on Friday 25 December 2015, 14:17 by Mustafa_Akilli
 * 
 * Description:
 * 
 * Polynomial class that represents a polynomial
 * 
 * HW9 Polynomial JAVA
 * 
 * @author Mustafa_Akilli
 */
public class Polynomial 
{
    
    private double [] coefficientsArray;// for keep the coefficients of the 
    private final int ZERO;
    private final int ONE;
    private final double DOUBLE_ZERO;
    private final double DOUBLE_ONE;
    private final char ADD;
    private final char SUBTRACT;
    private final char MULTIPLI;
    
    /**
     * Constructs and initializes coefficients of the polynomial
     * 
     * @param newCoefficientsArray // New Coefficients Array for Coefficients
     */
    public Polynomial(double [] newCoefficientsArray)
    {
        // Set Finals
        DOUBLE_ZERO = 0.0;
        DOUBLE_ONE = 1.0;
        ZERO = 0;
        ONE = 1;
        ADD = '+';
        SUBTRACT = '-';
        MULTIPLI = '*';
        
        //Set Coefficients Array
        setCoefficientsArray(newCoefficientsArray);
    }// end one-parameter Polynomial constructor
    
    
    /**
     * Take a double array to set all of the coefficients
     * 
     * @param newCoefficientsArray // New Coefficients Array for Coefficients
     */
    public void setCoefficientsArray(double [] newCoefficientsArray)
    {
        // New double array for coefficientsArray
        // Size is newCoefficientsArray.length
        coefficientsArray = new double [newCoefficientsArray.length];
        
        // Coefficients are copied
        for(int i=ZERO; i<newCoefficientsArray.length ; ++i)
            coefficientsArray[i]=newCoefficientsArray[i]; 
    }// end method setCoefficientsArray
    
    
    /**
     * Return a double array that contains all of the coefficients
     * 
     * @return coefficientsArray // Return coefficientsArray
     */
    public double [] getCoefficientsArray()
    {
        return coefficientsArray;
    }// end method getCoefficientsArray
    
    /**
     * Set each coefficient separately
     * 
     * @param indexNumber // Index number of coefficientsArray
     * @param newCoefficient // New Coefficient for given index number
     */
    public void setCoefficient(int indexNumber, double newCoefficient)
    {
        // if the indexNumber is true than assignment newCoefficient
        if(indexNumber>=ZERO && indexNumber<coefficientsArray.length)
            coefficientsArray[indexNumber] = newCoefficient;
        
        // if the indexNumber is wrong than print the error message
        else
            System.out.println("Wrong index number!");
    }// end method setCoefficient
    
    
    /**
     * Get each coefficient separately
     * 
     * @param indexNumber // Index number of coefficientsArray
     * @return coefficientsArray[indexNumber] // Return coefficientsArray
     *                                        // for given index Number
     */
    public double getCoefficient(int indexNumber)
    {
        // if the indexNumber is true than return coefficientsArray 
        // for given indexNumber
        if(indexNumber>=ZERO && indexNumber<coefficientsArray.length)
            return coefficientsArray[indexNumber];
        
        // if the indexNumber is wrong than print the error message
        // and return zero
        else
        {
            System.out.println("Wrong index number!");
            return DOUBLE_ZERO;
        }   
    }// end method getCoefficient
    
    
    /**
     * Given an x value, evaluate the polynomial and return the result
     * 
     * @param xValue // x value
     * @return result // result of polynomial for given x value
     */
    public double result(double xValue)
    {
        double result=DOUBLE_ZERO;
        
        for(int i=ZERO; i<getCoefficientsArray().length; ++i)
            result += (getCoefficient(i)*(Math.pow(xValue, i)));
        
        return result;
    }// end method result

    
    /**
     * Take another Polynomial and adds or subtract or multipli 
     * with this polynomial and returns the result
     * 
     * @param otherPolynomial // Other Polynomial
     * @param operation // operation type
     * @return newCoefficientsArray // return new Coefficients Array
     */
    protected double [] operationOtherPolynomial(Polynomial otherPolynomial,
                                              char operation)
    {
        int newSize; //new Size for new Coefficients Array
        
        // if lenght of otherPolynomial bigger than 
        // lenght of this object Polynomial, than 
        // newSize assignment to lenght of otherPolynomial
        if(otherPolynomial.getCoefficientsArray().length 
                > getCoefficientsArray().length)
            newSize = otherPolynomial.getCoefficientsArray().length;
        
        // if not than newSize assignment to lenght of this object Polynomial
        else
            newSize = getCoefficientsArray().length;
        
        double [] newCoefficientsArray = new double [newSize]; // new 
                                                           // Coefficients Array
          
        // All coefficient of newCoefficientsArray are initialization
        for(int i=ZERO; i<newCoefficientsArray.length ; ++i)
            newCoefficientsArray[i]=DOUBLE_ZERO; 
        
        // add/subtract two Polynomial
        for(int i=ZERO; i<newCoefficientsArray.length ; ++i)
        {
            if(i<otherPolynomial.getCoefficientsArray().length)
            {
                if(operation == ADD)
                    newCoefficientsArray[i] += otherPolynomial.getCoefficient(i);
                
                else if(operation == SUBTRACT)
                    newCoefficientsArray[i] -= otherPolynomial.getCoefficient(i);
            }
            
            if(i<getCoefficientsArray().length)
            {
                newCoefficientsArray[i] += getCoefficient(i);
            }  
        }
        
        return newCoefficientsArray;
    }// end method operationOtherPolynomial
    
    
    /**
     * Take another Polynomial and adds with this polynomial 
     * and returns the result
     * 
     * @param otherPolynomial // Other Polynomial
     * @return newCoefficientsArray // return new Coefficients Array
     */
    public double [] addOtherPolynomial(Polynomial otherPolynomial)
    {
        return operationOtherPolynomial(otherPolynomial,ADD);
    }// end method addOtherPolynomial
    
    
    /**
     * Take another Polynomial and subtracts with this polynomial 
     * and returns the result
     * 
     * @param otherPolynomial // Other Polynomial
     * @return newCoefficientsArray // return new Coefficients Array
     */
    public double [] subtractOtherPolynomial(Polynomial otherPolynomial)
    {
        return operationOtherPolynomial(otherPolynomial,SUBTRACT);
    }// end method subtractOtherPolynomial
    
    
    /**
     * Take another Polynomial and multiplies with this polynomial 
     * and returns the result
     * 
     * @param otherPolynomial // Other Polynomial
     * @return newCoefficientsArray // return new Coefficients Array
     */
    public double [] multipliOtherPolynomial(Polynomial otherPolynomial)
    {
        int newSize; //new Size for new Coefficients Array
        
        newSize = (getCoefficientsArray().length-ONE)*
                        (otherPolynomial.getCoefficientsArray().length-ONE)+ONE;
        
        
        double [] newCoefficientsArray = new double [newSize]; // new 
                                                           // Coefficients Array
          
        // All coefficient of newCoefficientsArray are initialization
        for(int i=ZERO; i<newCoefficientsArray.length ; ++i)
                newCoefficientsArray[i]=DOUBLE_ZERO; 
        
        
        // multipli two Polynomial
        for(int i=ZERO; i<getCoefficientsArray().length ; ++i)
            for(int j=ZERO; j<otherPolynomial.getCoefficientsArray().length; ++j)
                newCoefficientsArray[i+j] += otherPolynomial.getCoefficient(j) * 
                                                            getCoefficient(i);
                
        return newCoefficientsArray;
    }// end method multipliOtherPolynomial

    
    /**
     * Override to String for Polynomial Class
     * 
     * @return String.format
     */
    @Override
    public String toString()
    {        
        for(int i=getCoefficientsArray().length-1; i>=0; --i)
        {
            if( getCoefficient(i) != DOUBLE_ZERO)
            {
                if( getCoefficient(i) != DOUBLE_ONE || i == ZERO)
                    System.out.printf("%.2f",getCoefficient(i));
                
                if( i > ZERO)
                    System.out.printf("(x^%d)",i);

                if( i > ZERO && getCoefficient(i-ONE)!=0)
                    System.out.print(" + ");
            }
        }
        
        return String.format(" ");
    }// end method toPolynomialString
    
    
    /**
     * Override to Equals for Polynomial Class
     * 
     * @param otherPolynomial // Other Polynomial
     * @return // If equals with each other than return true, else return false
     */
    @Override
    public boolean equals(Object otherPolynomial)
    {
        //if otherPolynomial is null than return false
        if (otherPolynomial == null) 
            return false;
        
        //if otherPolynomial is this than return true
        else if (otherPolynomial == this)
            return true;
        
        //if otherPolynomial is not a Polynomial than return false
        else if (!(otherPolynomial instanceof Polynomial))
            return false;
        
        //Object otherPolynomial downcasting Polynomial class
        Polynomial polynomialOtherPolynomial = (Polynomial) otherPolynomial;

        // if two lengths are not equals than return false
        if(getCoefficientsArray().length != 
                        polynomialOtherPolynomial.getCoefficientsArray().length)
            return false;
            
        // if coefficients are not equals to each other than return false
        for(int i=ZERO; i<getCoefficientsArray().length ; ++i)
            if(getCoefficient(i)!=polynomialOtherPolynomial.getCoefficient(i))
                return false;
        
        // If equals with each other than return true
        return true;
    }// end method PolynomialEquals
    
}
