package tr.edu.gyte.CSE241.HW9.Mustafa.Akilli;

/**
 * HW10_131044017_Mustafa_Akilli
 * 
 * File:   Parenthesis.java
 * 
 * Description:
 * 
 * Class Parenthesis that can keep ( and )
 * 
 * @author Mustafa_Akilli
 * @since Friday 1 January 2015, 20:13 by Mustafa_Akilli
 */
public class Parenthesis 
{
    private final static int ARRAY_LOWER_LIMIT = 0; // for division
    private final static int ZERO = 0;
    private final static int ONE = 1;
    
    private String [] parenthesisSign; // Parenthesis Sign
    private int [] parenthesisSignIndex; // Parenthesis Sign Index
    
    private int openParenthesisNumber; // Open Parenthesis Number
    private int closeParenthesisNumber; // Close Parenthesis Number
    
    public final static String OPEN_PARENTHESIS = "("; // Open Parenthesis
    public final static String CLOSED_PARENTHESIS = ")"; // Closed Parenthesis
    
    /**
     * No parameter constructor
     */
    public Parenthesis()
    {
        setParenthesisSign();
        setParenthesisSignIndex();
        setOpenParenthesisNumber(ZERO);
        setCloseParenthesisNumber(ZERO);
    }//end no parameter constructor
    
    
    /**
     * Set Parenthesis Sign And Parenthesis Sign Index
     * 
     * @param newParenthesisSign // new Parenthesis Sign
     * @param newParenthesisSignIndex // new Parenthesis Sign Index
     * @throws Exception // when argument is not ( or)
     */
    public void setParenthesisSignAndParenthesisSignIndex(
            String newParenthesisSign, int newParenthesisSignIndex) 
            throws Exception
    {         
        if(newParenthesisSign.equals(OPEN_PARENTHESIS) ||
           newParenthesisSign.equals(CLOSED_PARENTHESIS))
        {
            // Temp arrays up to length of Parenthesis Sign
            String [] tempStringArray = new String[parenthesisSign.length];
            int [] tempIntArray = new int[parenthesisSignIndex.length];
            
            // Copy Parenthesis Sign Array
            for(int i=ARRAY_LOWER_LIMIT; i < parenthesisSign.length; ++i)
            {
                tempStringArray[i] = parenthesisSign[i];
            }
            
            // Copy Parenthesis Sign Index Array
            for(int i=ARRAY_LOWER_LIMIT; i < parenthesisSignIndex.length; ++i)
            {
                tempIntArray[i] = parenthesisSignIndex[i];
            }

            // increase the arrays  
            parenthesisSign = new String [parenthesisSign.length+ONE];
            parenthesisSignIndex = new int [parenthesisSignIndex.length+ONE];
            
            // Copy old elemenets
            for(int i=ARRAY_LOWER_LIMIT; i < tempStringArray.length; ++i)
            {
                parenthesisSign[i] = tempStringArray[i];
            }
            
            // Copy old elemenets
            for(int i=ARRAY_LOWER_LIMIT; i < tempIntArray.length; ++i)
            {
                parenthesisSignIndex[i] = tempIntArray[i];
            }
            
            // add expression to arrays
            parenthesisSign[parenthesisSign.length-ONE] = newParenthesisSign;
            parenthesisSignIndex [parenthesisSignIndex.length-ONE] = 
                                                        newParenthesisSignIndex;
            
            if(newParenthesisSign.equals(OPEN_PARENTHESIS))
                setOpenParenthesisNumber(getOpenParenthesisNumber()+ONE);
            
            else
                setCloseParenthesisNumber(getCloseParenthesisNumber()+ONE);
        }
        
        else 
            throw new Exception();
        
    }// end method setParenthesisSignAndParenthesisSignIndex
    
    /**
     * Set Parenthesis Sign
     */
    public void setParenthesisSign()
    {
        parenthesisSign = new String[ARRAY_LOWER_LIMIT];
    }// end method setParenthesisSign
    
    /**
     * Get Parenthesis Sign
     * 
     * @return Parenthesis Sign Array
     */
    public String [] getParenthesisSign()
    {
        return parenthesisSign;
    }// end method getParenthesisSign
    
    /**
     * Get Given Index Of Parenthesis Sign
     * 
     * @param index // Index of Parenthesis Sign
     * @return value of given index of Parenthesis Sign Array
     */
    public String getGivenIndexOfParenthesisSign(int index)
    {
        return parenthesisSign[index];
    }// end method getGivenIndexOfParenthesisSign
    
    /**
     * Set Parenthesis Sign Index
     */
    public void setParenthesisSignIndex()
    {
        parenthesisSignIndex = new int[ARRAY_LOWER_LIMIT];
    }// end method setParenthesisSignIndex
    
    /**
     * Get Parenthesis Sign Index
     * 
     * @return Parenthesis Sign Index Array
     */
    public int [] getParenthesisSignIndex()
    {
        return parenthesisSignIndex;
    }// end method getParenthesisSignIndex
    
    /**
     * Get Given Index Of Parenthesis Sign Index
     * 
     * @param index // Index of Parenthesis Sign Index
     * @return value of given index of Parenthesis Sign Index Array
     */
    public int getGivenIndexOfParenthesisSignIndex(int index)
    {
        return parenthesisSignIndex[index];
    }// end method getGivenIndexOfParenthesisSignIndex
    
    /**
     * Set Open Parenthesis Number
     * 
     * @param newOpenParenthesisNumber // new Open Parenthesis Number
     */
    public void setOpenParenthesisNumber(int newOpenParenthesisNumber)
    {
        openParenthesisNumber = newOpenParenthesisNumber;
    }// end method setOpenParenthesisNumber
    
    /**
     * Get Open Parenthesis Number
     * 
     * @return open Parenthesis Number
     */
    public int getOpenParenthesisNumber()
    {
        return openParenthesisNumber;
    }// end method getOpenParenthesisNumber
    
    /**
     * Set Close Parenthesis Number
     * 
     * @param newCloseParenthesisNumber // new Close Parenthesis Number
     */
    public void setCloseParenthesisNumber(int newCloseParenthesisNumber)
    {
        closeParenthesisNumber = newCloseParenthesisNumber;
    }// end method setCloseParenthesisNumber
    
    /**
     * Get Close Parenthesis Number
     * 
     * @return Close Parenthesis Number
     */
    public int getCloseParenthesisNumber()
    {
        return closeParenthesisNumber;
    }// end method getCloseParenthesisNumber
    
    /**
     * Set Parenthesis Sign For Given Array
     * 
     * @param newParenthesisSignArray // new Parenthesis Sign Array
     */
    public void setParenthesisSignForGivenArray(String [] newParenthesisSignArray)
    {
        parenthesisSign = newParenthesisSignArray;
    }// end method setParenthesisSignForGivenArray
    
    /**
     * Set Parenthesis Sign Index For Given Array
     * 
     * @param newParenthesisSignIndexArray // new Parenthesis Sign Index Array
     */
    public void setParenthesisSignIndexForGivenArray(
                                            int [] newParenthesisSignIndexArray)
    {
        parenthesisSignIndex = newParenthesisSignIndexArray;
    }// end method setParenthesisSignIndexForGivenArray
    
}// end class Parenthesis
