package tr.edu.gyte.CSE241.HW9.Mustafa.Akilli;

import java.util.InputMismatchException;

/**
 * HW10_131044017_Mustafa_Akilli
 * 
 * File:   Operand.java
 * 
 * Description:
 * 
 * Class Operand that can keep the integer operands only
 * 
 * @author Mustafa_Akilli
 * @since Friday 1 January 2015, 18:38 by Mustafa_Akilli
 */
public class Operand 
{
    private final static int ARRAY_LOWER_LIMIT = 0; // for division
    private final static int ONE = 1;
    
    private int [] integerArray; // Integer Sign
    private int [] integerArrayIndex; // Integer Sign Index
    
    /**
     * No parameter constructor
     */
    public Operand()
    {
        setIntegerArray();
        setIntegerArrayIndex();
    }//end no parameter constructor
    
    /**
     * Set Integer Array And Integer Array Index
     * 
     * @param newOperand // new Operand String 
     * @param newOperandIndex // new Operand Index
     */
    public void setIntegerArrayAndIntegerArrayIndex(String newOperand,
                                                    int newOperandIndex)
    {
        int newOperandInteger = Integer.parseInt(newOperand);
            
        // Temp arrays up to length of integer Array
        int [] tempIntArray = new int[integerArray.length];
        int [] tempIntIndexArray = new int[integerArrayIndex.length];
            
        // Copy Parenthesis Sign Array
        for(int i=ARRAY_LOWER_LIMIT; i < integerArray.length; ++i)
        {
            tempIntArray[i] = integerArray[i];
        }
            
        // Copy Parenthesis Sign Index Array
        for(int i=ARRAY_LOWER_LIMIT; i < integerArrayIndex.length; ++i)
        {
            tempIntIndexArray[i] = integerArrayIndex[i];
        }

        // increase the arrays  
        integerArray = new int [integerArray.length+ONE];
        integerArrayIndex = new int [integerArrayIndex.length+ONE];
            
        // Copy old elemenets
        for(int i=ARRAY_LOWER_LIMIT; i < tempIntArray.length; ++i)
        {
            integerArray[i] = tempIntArray[i];
        }
            
        // Copy old elemenets
        for(int i=ARRAY_LOWER_LIMIT; i < tempIntIndexArray.length; ++i)
        {
            integerArrayIndex[i] = tempIntIndexArray[i];
        }
            
        // add expression to arrays
        integerArray[integerArray.length-ONE] = newOperandInteger;
        integerArrayIndex [integerArrayIndex.length-ONE] = newOperandIndex;

    }//end method setIntegerArrayAndIntegerArrayIndex
    
    /**
     * Set Integer Array
     */
    public void setIntegerArray()
    {
        integerArray = new int[ARRAY_LOWER_LIMIT];
    }// end method setIntegerArray
    
    /**
     * Get Integer Array
     * 
     * @return get Integer Array
     */
    public int [] getIntegerArray()
    {
        return integerArray;
    }//end method getIntegerArray
    
    /**
     * Get Given Index Of Integer Array
     * 
     * @param index // Index of Integer Array
     * @return value of given index of Integer Array
     */
    public int getGivenIndexOfIntegerArray(int index)
    {
        return integerArray[index];
    }//end method getGivenIndexOfIntegerArray
    
    /**
     * Set Integer Array Index
     */
    public void setIntegerArrayIndex()
    {
        integerArrayIndex = new int[ARRAY_LOWER_LIMIT];
    }// end method setIntegerArrayIndex
    
    /**
     * Get Integer Array Index
     * 
     * @return get Integer Array Index
     */
    public int [] getIntegerArrayIndex()
    {
        return integerArrayIndex;
    }//end method getIntegerArrayIndex
    
    /**
     * Get Given Index Of Integer Array Index
     * 
     * @param index // Index of Integer Array Index
     * @return value of given index of Integer Array Index
     */
    public int getGivenIndexOfIntegerArrayIndex(int index)
    {
        return integerArrayIndex[index];
    }//end method getGivenIndexOfIntegerArrayIndex
    
    /**
     * Set Integer Array For Given Array
     * 
     * @param newIntegerArray // new Integer Array
     */
    public void setIntegerArrayForGivenArray(int [] newIntegerArray)
    {
        integerArray = newIntegerArray;
    }//end method setIntegerArrayForGivenArray
    
    /**
     * Set Integer Array Index For Given Array 
     * 
     * @param newIntegerArrayIndex // new Integer Array Index
     */
    public void setIntegerArrayIndexForGivenArray(int [] newIntegerArrayIndex)
    {
        integerArrayIndex = newIntegerArrayIndex;
    }//end method setIntegerArrayIndexForGivenArray
    
}// end class Operand
