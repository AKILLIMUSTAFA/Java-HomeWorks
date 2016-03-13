package tr.edu.gyte.CSE241.HW9.Mustafa.Akilli;

/**
 * HW10_131044017_Mustafa_Akilli
 * 
 * File:   Operator.java
 * 
 * Description:
 * 
 * Class Operator that can keep the operators such as *,+,-,/
 * 
 * @author Mustafa_Akilli
 * @since Friday 1 January 2015, 18:33 by Mustafa_Akilli
 */
public class Operator 
{
    private final static int ARRAY_LOWER_LIMIT = 0; // for division
    private final static int ONE = 1;
    
    private String [] operatorSign; // Operator Sign
    private int [] operatorSignIndex; // Operator Sign Index
    
    public final static String MULTIPLICATION_SIGN = "*"; // for multiplication
    public final static String ADDITION_SIGN = "+"; // for addition
    public final static String SUBTRACTION_SIGN = "-"; // for subtraction
    public final static String DIVISION_SIGN = "/"; // for division
    
    /**
     * No Parameter Constructor
     */
    public Operator()
    {
        setOperatorSign();
        setOperatorSignIndex();
    }// end No Parameter Constructor
    
    /**
     * Set Operator Sign And Set Operator Sign Index
     * 
     * @param newOperatorSign // new Operator Sign
     * @param newOperatorSignIndex // new Operator Sign Index
     * @throws Exception // when argument is not *,+,-,/
     */
    public void setOperatorSignAndSetOperatorSignIndex(String newOperatorSign, 
                                                    int newOperatorSignIndex) 
            throws Exception
    {   
        if(newOperatorSign.equals(MULTIPLICATION_SIGN) ||
           newOperatorSign.equals(ADDITION_SIGN) ||     
           newOperatorSign.equals(SUBTRACTION_SIGN) ||     
           newOperatorSign.equals(DIVISION_SIGN))
        { 
            // Temp arrays up to length of Operator Sign
            String [] tempStringArray = new String[operatorSign.length];
            int [] tempIntArray = new int[operatorSignIndex.length];
            
            // Copy operator Sign Array
            for(int i=ARRAY_LOWER_LIMIT; i < operatorSign.length; ++i)
            {
                tempStringArray[i] = operatorSign[i];
            }
            
            // Copy operator Sign Index Array
            for(int i=ARRAY_LOWER_LIMIT; i < operatorSignIndex.length; ++i)
            {
                tempIntArray[i] = operatorSignIndex[i];
            }
            
            // increase the arrays  
            operatorSign = new String [operatorSign.length+ONE];
            operatorSignIndex = new int [operatorSignIndex.length+ONE];
            
            // Copy old elemenets
            for(int i=ARRAY_LOWER_LIMIT; i < tempStringArray.length; ++i)
            {
                operatorSign[i] = tempStringArray[i];
            }
            
            // Copy old elemenets
            for(int i=ARRAY_LOWER_LIMIT; i < tempIntArray.length; ++i)
            {
                operatorSignIndex[i] = tempIntArray[i];
            }
            
            // add expression to arrays
            operatorSign[operatorSign.length-ONE] = newOperatorSign;
            operatorSignIndex [operatorSignIndex.length-ONE] = 
                                                           newOperatorSignIndex;      
        }

        else 
            throw new Exception();
    }// end method setOperatorSignAndSetOperatorSignIndex
    
    /**
     * Set Operator Sign
     */
    public void setOperatorSign()
    {
        operatorSign = new String[ARRAY_LOWER_LIMIT];
    }// end method setOperatorSign
    
    /**
     * Get Operator Sign
     * 
     * @return operator Sign Array
     */
    public String [] getOperatorSign()
    {
        return operatorSign;
    }// end method getOperatorSign
    
    /**
     * Get Given Index Of Operator Sign
     * 
     * @param index // Index of Operator Sign
     * @return value of given index of Operator Sign Array
     */
    public String getGivenIndexOfOperatorSign(int index)
    {
        return operatorSign[index];
    }// end method getGivenIndexOfOperatorSign
    
    /**
     * Set Operator Sign Index
     */
    public void setOperatorSignIndex()
    {
        operatorSignIndex = new int[ARRAY_LOWER_LIMIT];
    }// end method setOperatorSignIndex
    
    /**
     * Get Operator Sign Index
     * 
     * @return operator Sign Index Array
     */
    public int [] getOperatorSignIndex()
    {
        return operatorSignIndex;
    }// end method getOperatorSignIndex
    
    /**
     * Get Given Index Of Operator Sign Index
     * 
     * @param index // Index of Operator Sign Index
     * @return value of given index of Operator Sign index Array 
     */
    public int getGivenIndexOfOperatorSignIndex(int index)
    {
        return operatorSignIndex[index];
    }// end method getGivenIndexOfOperatorSignIndex
    
    /**
     * Set Operator Sign For Given Array
     * 
     * @param newOperatorSignArray // new Operator Sign Array
     */
    public void setOperatorSignForGivenArray(String [] newOperatorSignArray)
    {
        operatorSign = newOperatorSignArray;
    }// end method setOperatorSignForGivenArray
    
    /**
     * Set Operator Sign Index For Given Array
     * 
     * @param newOperatorSignIndexArray // new Operator Sign Index Array
     */
    public void setOperatorSignIndexForGivenArray(int [] newOperatorSignIndexArray)
    {
        operatorSignIndex = newOperatorSignIndexArray;
    }// end method setOperatorSignIndexForGivenArray
    
}// end class Operator