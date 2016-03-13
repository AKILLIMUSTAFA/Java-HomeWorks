package tr.edu.gyte.CSE241.HW9.Mustafa.Akilli;

import static java.lang.System.exit;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * HW10_131044017_Mustafa_Akilli
 * 
 * File:   Expression.java
 * 
 * Description:
 * 
 * class Expression that keeps an array of expression elements and evaluates
 * the array of expression elements              
 * 
 * @author Mustafa_Akilli
 * @since Friday 1 January 2015, 23:32 by Mustafa_Akilli
 */
public class Expression 
{
    private Operator operator; // keep the operators
    private Operand operand; // keep the integer operands only
    private Parenthesis parenthesis; // keep ( and )
    private String [] expressionElementsArray; // keeps an array of expression elements
    private String [] backUpForExpressionElementsArray; // keeps back up
    private final static int ARRAY_LOWER_LIMIT = 0; // for division
    private final static int ZERO = 0;
    private final static int ONE = 1;
    private final static int TWO = 2;
    private final static int HALF = 2;
    private final static int DEFAULT_RESULT = 0;

    /**
     * Check Errors for Expression
     * 
     */
    private void checkErrors()
    {
        //Setters
        setOperator();
        setOperand();
        setParenthesis();
        
        for(int i=ARRAY_LOWER_LIMIT; i<getExpressionElementsArray().length-ONE ;++i)
        {
            try// throw an exception from Operator and immediately catch it
            {
                getOperator().setOperatorSignAndSetOperatorSignIndex
                    (getGivenIndexOfExpressionElementsArray(i), i);
            }// end try for Operator
            catch(Exception exceptionOperator )
            {
                try// throw an exception from Parenthesis and immediately catch it
                {
                    getParenthesis().setParenthesisSignAndParenthesisSignIndex
                            (getGivenIndexOfExpressionElementsArray(i), i);
                    
                    // if Close Parenthesis come before Open Parenthesis
                    if(getParenthesis().getCloseParenthesisNumber()>
                       getParenthesis().getOpenParenthesisNumber())
                    {
                        System.err.println( "Close Parenthesis come before "
                                + "Open Parenthesis."
                                + " \nThe program ended unsuccessfully");
                        exit(1);
                    }
                        
                }// end try Parenthesis
                catch(Exception exceptionParenthesis)
                {
                    try // throw an exception from Operand and immediately catch it
                    {
                        getOperand().setIntegerArrayAndIntegerArrayIndex
                        (getGivenIndexOfExpressionElementsArray(i), i);
                    }// end try Operand
                    catch(NumberFormatException numberFormatException)
                    {
                        System.err.println( "Unexpected Item: " 
                                + numberFormatException 
                                + "\nThe program ended unsuccessfully");
                        exit(1);
                        
                    } // end catch for Operand
                    
                }// end catch for Parenthesis
                
            }// end catch for Operator
            
        }// end for loop
        
        // if Open Parenthesis Number and Close Parenthesis Number not equal
        if(getParenthesis().getOpenParenthesisNumber() != 
           getParenthesis().getCloseParenthesisNumber())
        {
            System.err.println( "Open Parenthesis Number and "
                    + "Close Parenthesis Number not equal."
                    + " \nThe program ended unsuccessfully");
            exit(1);
        }

    }// end method checkErrors
    
    /**
     * Make Operation
     * 
     * @param indexOperand // index Operand
     * @param indexOperator // index Operator
     * @param operationType // operation Type
     */
    private void makeOperation(int indexOperand, int indexOperator, String operationType)
    {       
        //For Expression
        String [] tempExpressionElementsArray;
        
        //Result Of Operation
        int ResultOfOperation = DEFAULT_RESULT;
        
        //Calculate Result Of Operation   
        if(operationType.equals(Operator.MULTIPLICATION_SIGN))
            ResultOfOperation=getOperand().getGivenIndexOfIntegerArray(indexOperand)*
            getOperand().getGivenIndexOfIntegerArray(indexOperand+ONE);
        
        else if(operationType.equals(Operator.DIVISION_SIGN))
            ResultOfOperation=getOperand().getGivenIndexOfIntegerArray(indexOperand)/
            getOperand().getGivenIndexOfIntegerArray(indexOperand+ONE);   
            
        else if(operationType.equals(Operator.ADDITION_SIGN))
            ResultOfOperation=getOperand().getGivenIndexOfIntegerArray(indexOperand)+
            getOperand().getGivenIndexOfIntegerArray(indexOperand+ONE);
            
        else if(operationType.equals(Operator.SUBTRACTION_SIGN))
            ResultOfOperation=getOperand().getGivenIndexOfIntegerArray(indexOperand)-
            getOperand().getGivenIndexOfIntegerArray(indexOperand+ONE);
                
        //For Expression
        tempExpressionElementsArray = new String [getExpressionElementsArray().length-TWO];
                                  
        //Make New Array Expression
        int forExpression = ARRAY_LOWER_LIMIT;
       
        while(forExpression < getOperand().getGivenIndexOfIntegerArrayIndex(indexOperand))
        {
            tempExpressionElementsArray[forExpression] = getGivenIndexOfExpressionElementsArray(forExpression);
            ++forExpression;
        }
                                       
        tempExpressionElementsArray[forExpression] = Integer.toString(ResultOfOperation);
        ++forExpression;
                                       
        while(forExpression < tempExpressionElementsArray.length)
        {
            tempExpressionElementsArray[forExpression] = getGivenIndexOfExpressionElementsArray(forExpression+TWO);
            ++forExpression;
        }
          
        // set Expression Elements Array
        setExpressionElementsArrayForGivenArray(tempExpressionElementsArray);
        
        //Check Errors
        checkErrors();
                                       
    }// end method makeOperation
    
    /**
     * No parameter constructor
     * 
     */
    public Expression()
    {
        setOperator();
        setOperand();
        setParenthesis();
        setExpressionElementsArray();
        addExpressionElementsArray();
    }// end no parameter constructor
    
    /**
     * Add Expression Elements Array
     * 
     */
    public void addExpressionElementsArray()
    {
        Scanner scanner = new Scanner(System.in);
        String newExpression; // new Expression
        String continueLoop = "."; // for continue Loop
        String [] tempStringArray; //temp String Array for keep elemenets
        
        //First Message
        System.out.println("Enter your expression, after each operator or "
                + "operand press enter, to end the expression press =");
        
        do
        {
            // Give one expression
            System.out.println( "Enter your expression element: " );
            newExpression =  scanner.nextLine();
            continueLoop = newExpression;
            
            // New String up to length of expression Elements Array 
            tempStringArray = new String[expressionElementsArray.length];
            
            // Copy Expression Elements Array
            for(int i=ARRAY_LOWER_LIMIT; i < expressionElementsArray.length; ++i)
            {
                tempStringArray[i] = expressionElementsArray[i];
            }
            
            // increase the array  
            expressionElementsArray = new String [expressionElementsArray.length
                                                                        +ONE];
            // Copy old elemenets
            for(int i=ARRAY_LOWER_LIMIT; i < tempStringArray.length; ++i)
            {
                expressionElementsArray[i] = tempStringArray[i];
            }
            
            // add expression to array
            expressionElementsArray[expressionElementsArray.length-ONE] = 
                                                                newExpression;
        } while ( !"=".equals(continueLoop)); // end do...while
        
        //catch ekle nextline() ten gelen
        
        //Check Errors
        checkErrors();

        // Find the result
        try // throw an exception
        {
            newExpression = evaluates();
        }
        catch(Exception exception)
        {
            System.err.println( "Clerical Error : " 
                                + "\nThe program ended unsuccessfully");
            exit(1);         
        }// end catch
        
        // Print Result
        System.out.printf( "Results is: %s \n", newExpression);
        
        // New String up to length of expression Elements Array 
        tempStringArray = new String[expressionElementsArray.length];
            
        // Copy Expression Elements Array
        for(int i=ARRAY_LOWER_LIMIT; i < expressionElementsArray.length; ++i)
        {
            tempStringArray[i] = expressionElementsArray[i];
        }
            
        // increase the array  
        expressionElementsArray = new String [expressionElementsArray.length
                                                                        +ONE];
        // Copy old elemenets
        for(int i=ARRAY_LOWER_LIMIT; i < tempStringArray.length; ++i)
        {
            expressionElementsArray[i] = tempStringArray[i];
        }
            
        // add expression to array
        expressionElementsArray[expressionElementsArray.length-ONE] = 
                                                                newExpression;
    }// end method addExpressionElementsArray
    
    /**
     * Set Expression Elements Array
     */
    public void setExpressionElementsArray()
    {
        expressionElementsArray= new String[ARRAY_LOWER_LIMIT];
    }// end method setExpressionElementsArray
    
    /**
     * Set Expression Elements Array For Given Array
     * 
     * @param newExpressionElementsArray // new Expression Elements Array
     */
    public void setExpressionElementsArrayForGivenArray
                                        (String [] newExpressionElementsArray)
    {
        expressionElementsArray= new String[newExpressionElementsArray.length];
        
        for(int i=ARRAY_LOWER_LIMIT; i<newExpressionElementsArray.length; ++i)
            expressionElementsArray[i] = newExpressionElementsArray[i];
        
    }// end method setExpressionElementsArrayForGivenArray
    
    /**
     * Get Expression Elements Array
     * 
     * @return Expression Elements Array
     */
    public String [] getExpressionElementsArray()
    {
        return expressionElementsArray;
    }// end method getExpressionElementsArray
    

    /**
     * Set Given index of Expression Elements Array
     * 
     * @param index // index of Expression Elements Array
     * @param newExpressionElements // new Expression Elements
     * @throws Exception // if newExpressionElements have error
     */
    public void setGivenIndexOfExpressionElementsArray(int index, 
                String newExpressionElements) throws Exception
    {
        if(index >=ARRAY_LOWER_LIMIT && index < expressionElementsArray.length)
        {
            String newExpression; // new Expression
            String [] tempStringArray; //temp String Array for keep elemenets

            expressionElementsArray[index] = newExpressionElements;

            // Find the result
            newExpression = evaluates();

            // Print Result
            System.out.printf( "Results is: %s \n", newExpression);

            // New String up to length of expression Elements Array 
            tempStringArray = new String[expressionElementsArray.length];

            // Copy Expression Elements Array
            for(int i=ARRAY_LOWER_LIMIT; i < expressionElementsArray.length; ++i)
            {
                tempStringArray[i] = expressionElementsArray[i];
            }

            // increase the array  
            expressionElementsArray = new String [expressionElementsArray.length
                                                                        +ONE];
            // Copy old elemenets
            for(int i=ARRAY_LOWER_LIMIT; i < tempStringArray.length; ++i)
            {
                expressionElementsArray[i] = tempStringArray[i];
            }

            // add expression to array
            expressionElementsArray[expressionElementsArray.length-ONE] = 
                                                                newExpression;
        }
        
        else
        {
            //Do not nothing
        }
    }// end method setGivenIndexOfExpressionElementsArray
    
    /**
     * Get Given Index Of Expression Elements Array
     * 
     * @param index // index of Expression Elements Array
     * @return value of given index of Expression Elements Array
     */
    public String getGivenIndexOfExpressionElementsArray(int index)
    {
        return expressionElementsArray[index];
    }// end method getGivenIndexOfExpressionElementsArray
    
    /**
     * Set Operator
     */
    public void setOperator()
    {
        operator = new Operator();
    }// end method setOperator
    
    /**
     * Get Operator
     * 
     * @return operator
     */
    public Operator getOperator()
    {
        return operator;
    }// end method getOperator
    
    /**
     * Set Operand
     */
    public void setOperand()
    {
        operand = new Operand();
    }// end method setOperand
    
    /**
     * Get Operand
     * 
     * @return Operand
     */
    public Operand getOperand()
    {
        return operand;
    }// end method getOperand
    
    /**
     * Set Parenthesis
     */
    public void setParenthesis()
    {
        parenthesis = new Parenthesis();
    }// end method setParenthesis
    
    /**
     * Get Parenthesis
     * 
     * @return Parenthesis
     */
    public Parenthesis getParenthesis()
    {
        return parenthesis;
    }// end method getParenthesis
    
    /**
     * Evaluates the array of expresion elements
     * 
     * @return result of array
     * @throws Exception // if array have error
     */
    public String evaluates() throws Exception
    {
        Integer result = DEFAULT_RESULT; //result of string
        boolean checkException = true; // for Exception
        boolean checkOperation = true; // for Operation 
        int expressionCounter = DEFAULT_RESULT; //expression Counter
        
        //For Expression
        String [] tempExpressionElementsArray;
        
        //For Expression
        tempExpressionElementsArray = new String [getExpressionElementsArray().length+TWO];

        //Make New Array Expression
        int forAddParantesisExpression = ARRAY_LOWER_LIMIT;

        //Add OPEN_PARENTHESIS
        tempExpressionElementsArray[forAddParantesisExpression] = Parenthesis.OPEN_PARENTHESIS;
            
        for(forAddParantesisExpression=ARRAY_LOWER_LIMIT; 
                forAddParantesisExpression<getExpressionElementsArray().length ; 
                ++forAddParantesisExpression )
            tempExpressionElementsArray[forAddParantesisExpression+ONE] = 
            getGivenIndexOfExpressionElementsArray(forAddParantesisExpression);

        //Add CLOSED_PARENTHESIS
        tempExpressionElementsArray[forAddParantesisExpression] = Parenthesis.CLOSED_PARENTHESIS;
            
        // set Expression Elements Array
        setExpressionElementsArrayForGivenArray(tempExpressionElementsArray);

        //Check Errors
        checkErrors();

        //Destroyed Parenthes
        boolean destroyedParenthes;
        
        //for Process Priority
        boolean processPriority = true;
            
        //For All Parenthesis 
        for(int indexParenthesis=ARRAY_LOWER_LIMIT; 
                indexParenthesis<getParenthesis().getParenthesisSign().length; 
                ++indexParenthesis)
        {
            processPriority = true; 
            
            //if parenthes is closed
            if(getParenthesis().getGivenIndexOfParenthesisSign(indexParenthesis).equals
                                        (Parenthesis.CLOSED_PARENTHESIS))
            {
                checkOperation =true;
                destroyedParenthes = true;

                // lower Limit index
                int lowerLimit= 
                getParenthesis().getGivenIndexOfParenthesisSignIndex(indexParenthesis-ONE);

                // upper Limit index
                int upperLimit=
                    getParenthesis().getGivenIndexOfParenthesisSignIndex(indexParenthesis);
                    
                // Evaluates the operators MULTIPLICATION and 
                // DIVISION in Parenthesis
                for(int indexOperator=ARRAY_LOWER_LIMIT; 
                        indexOperator<getOperator().getOperatorSign().length; 
                        ++indexOperator)
                {
                    //if operator is in the parenthes
                    if(getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)> 
                            lowerLimit &&
                        getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)
                               < upperLimit) 
                    {
                        //if operator is MULTIPLICATION_SIGN
                        if(getOperator().getGivenIndexOfOperatorSign(indexOperator).
                                        equals(Operator.MULTIPLICATION_SIGN))
                        {
                            checkException = true;
                               
                            //Check the all operand
                            for(int indexOperand=ARRAY_LOWER_LIMIT; 
                                indexOperand<getOperand().getIntegerArray().length; ++indexOperand)
                            {                                
                                //if MULTIPLICATION_SIGN 
                                //have left and right side numbers 
                                if(getOperand().getGivenIndexOfIntegerArrayIndex(indexOperand) == 
                                        getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)-ONE &&
                                    getOperand().getGivenIndexOfIntegerArrayIndex(indexOperand+ONE) ==
                                        getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)+ONE)
                                {                            
                                    //Make Operation
                                    makeOperation(indexOperand,indexOperator,Operator.MULTIPLICATION_SIGN);
                                       
                                    //do not throw Exception
                                    checkException = false;
                                       
                                    //do not destroyed Parenthes
                                    destroyedParenthes = false;
                                       
                                    //Return of the begin of the array
                                    indexParenthesis=ARRAY_LOWER_LIMIT;
                                    indexOperator=getOperator().getOperatorSign().length;
                                    indexOperand=getOperand().getIntegerArray().length;
                                       
                                    checkOperation = false;
                                    
                                    processPriority = false;
                                    
                                    ++expressionCounter;
                                    System.out.printf("%d: ",expressionCounter);  
                                    System.out.println(toString()); 
                                }
                            }
                               
                            if(checkException)
                                throw new Exception();
                        }
                           
                        if(checkOperation)
                        {
                            //if operator is DIVISION_SIGN
                            if(getOperator().getGivenIndexOfOperatorSign(indexOperator)
                                        .equals(Operator.DIVISION_SIGN))
                            {
                                //true Exception
                                checkException = true;

                                //Check the all operand
                                for(int indexOperand=ARRAY_LOWER_LIMIT; 
                                indexOperand<getOperand().getIntegerArray().length; ++indexOperand)
                                {
                                    //if MULTIPLICATION_SIGN 
                                    //have left and right side numbers 
                                    if(getOperand().getGivenIndexOfIntegerArrayIndex(indexOperand) == 
                                            getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)-ONE &&
                                           getOperand().getGivenIndexOfIntegerArrayIndex(indexOperand+ONE) == 
                                            getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)+ONE)
                                    {
                                        //Make Operation
                                        makeOperation(indexOperand,indexOperator, 
                                                Operator.DIVISION_SIGN);

                                        //do not throw Exception
                                        checkException = false;

                                        //do not destroyed Parenthes
                                        destroyedParenthes = false;

                                        //Return of the begin of the array
                                        indexParenthesis=ARRAY_LOWER_LIMIT;
                                        indexOperator=getOperator().getOperatorSign().length;
                                        indexOperand=getOperand().getIntegerArray().length;

                                        checkOperation =false;

                                        processPriority = false;
                                        
                                        ++expressionCounter;
                                        System.out.printf("%d: ",expressionCounter);  
                                        System.out.println(toString()); 
                                        
                                    }
                                }

                                if(checkException)
                                    throw new Exception();
                            }
                        }
                    }
                        
                        
                }
                    
                if(processPriority)
                {
                    // Evaluates the operators ADDITION and 
                    // SUBTRACTION in Parenthesis
                    for(int indexOperator=ARRAY_LOWER_LIMIT; 
                            indexOperator<getOperator().getOperatorSign().length; 
                            ++indexOperator)
                    {
                        //if operator is in the parenthes
                        if(getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)> 
                                lowerLimit &&
                            getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)
                                   < upperLimit) 
                        {
                            //if operator is ADDITION_SIGN
                            if(getOperator().getGivenIndexOfOperatorSign(indexOperator).
                                            equals(Operator.ADDITION_SIGN))
                            {
                                checkException = true;

                                //Check the all operand
                                for(int indexOperand=ARRAY_LOWER_LIMIT; 
                                    indexOperand<getOperand().getIntegerArray().length; ++indexOperand)
                                {                                
                                    //if MULTIPLICATION_SIGN 
                                    //have left and right side numbers 
                                    if(getOperand().getGivenIndexOfIntegerArrayIndex(indexOperand) == 
                                            getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)-ONE &&
                                        getOperand().getGivenIndexOfIntegerArrayIndex(indexOperand+ONE) == 
                                            getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)+ONE)
                                    {                            
                                        //Make Operation
                                        makeOperation(indexOperand,indexOperator,Operator.ADDITION_SIGN);

                                        //do not throw Exception
                                        checkException = false;

                                        //do not destroyed Parenthes
                                        destroyedParenthes = false;

                                        //Return of the begin of the array
                                        indexParenthesis=ARRAY_LOWER_LIMIT;
                                        indexOperator=getOperator().getOperatorSign().length;
                                        indexOperand=getOperand().getIntegerArray().length;

                                        checkOperation = false;    

                                        ++expressionCounter;
                                        System.out.printf("%d: ",expressionCounter);  
                                        System.out.println(toString()); 
                                    }
                                }

                                if(checkException)
                                    throw new Exception();
                            }

                            if(checkOperation)
                            {
                                //if operator is SUBTRACTION_SIGN
                                if(getOperator().getGivenIndexOfOperatorSign(indexOperator)
                                            .equals(Operator.SUBTRACTION_SIGN))
                                {
                                    //true Exception
                                    checkException = true;

                                    //Check the all operand
                                    for(int indexOperand=ARRAY_LOWER_LIMIT; 
                                    indexOperand<getOperand().getIntegerArray().length; ++indexOperand)
                                    {
                                        //if MULTIPLICATION_SIGN 
                                        //have left and right side numbers 
                                        if(getOperand().getGivenIndexOfIntegerArrayIndex(indexOperand) == 
                                                getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)-ONE &&
                                               getOperand().getGivenIndexOfIntegerArrayIndex(indexOperand+ONE) == 
                                                getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)+ONE)
                                        {
                                            //Make Operation
                                            makeOperation(indexOperand,indexOperator, Operator.SUBTRACTION_SIGN);

                                            //do not throw Exception
                                            checkException = false;

                                            //do not destroyed Parenthes
                                            destroyedParenthes = false;

                                            //Return of the begin of the array
                                            indexParenthesis=ARRAY_LOWER_LIMIT;
                                            indexOperator=getOperator().getOperatorSign().length;
                                            indexOperand=getOperand().getIntegerArray().length;

                                            checkOperation =false;

                                            ++expressionCounter;
                                            System.out.printf("%d: ",expressionCounter);  
                                            System.out.println(toString()); 
                                        }
                                    }

                                    if(checkException)
                                        throw new Exception();
                                }
                            }
                        }


                    }    
                }
                
                // Evaluates the operators MULTIPLICATION and 
                // DIVISION in Parenthesis
                for(int indexOperator=ARRAY_LOWER_LIMIT; 
                        indexOperator<getOperator().getOperatorSign().length; 
                        ++indexOperator)
                {
                    //if operator is in the parenthes
                    if(getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)> 
                            lowerLimit &&
                        getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)
                               < upperLimit) 
                    {
                        //if operator is MULTIPLICATION_SIGN
                        if(getOperator().getGivenIndexOfOperatorSign(indexOperator).
                                        equals(Operator.MULTIPLICATION_SIGN))
                        {
                            checkException = true;
                               
                            //Check the all operand
                            for(int indexOperand=ARRAY_LOWER_LIMIT; 
                                indexOperand<getOperand().getIntegerArray().length; ++indexOperand)
                            {                                
                                //if MULTIPLICATION_SIGN 
                                //have left and right side numbers 
                                if(getOperand().getGivenIndexOfIntegerArrayIndex(indexOperand) == 
                                        getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)-ONE &&
                                    getOperand().getGivenIndexOfIntegerArrayIndex(indexOperand+ONE) == 
                                        getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)+ONE)
                                {                            
                                    //Make Operation
                                    makeOperation(indexOperand,indexOperator,Operator.MULTIPLICATION_SIGN);
                                       
                                    //do not throw Exception
                                    checkException = false;
                                       
                                    //do not destroyed Parenthes
                                    destroyedParenthes = false;
                                       
                                    //Return of the begin of the array
                                    indexParenthesis=ARRAY_LOWER_LIMIT;
                                    indexOperator=getOperator().getOperatorSign().length;
                                    indexOperand=getOperand().getIntegerArray().length;
                                       
                                    checkOperation = false;
                                    
                                    ++expressionCounter;
                                    System.out.printf("%d: ",expressionCounter);  
                                    System.out.println(toString()); 
                                }
                            }
                               
                            if(checkException)
                                throw new Exception();
                        }
                           
                        if(checkOperation)
                        {
                            //if operator is DIVISION_SIGN
                            if(getOperator().getGivenIndexOfOperatorSign(indexOperator)
                                        .equals(Operator.DIVISION_SIGN))
                            {
                                //true Exception
                                checkException = true;

                                //Check the all operand
                                for(int indexOperand=ARRAY_LOWER_LIMIT; 
                                indexOperand<getOperand().getIntegerArray().length; ++indexOperand)
                                {
                                    //if MULTIPLICATION_SIGN 
                                    //have left and right side numbers 
                                    if(getOperand().getGivenIndexOfIntegerArrayIndex(indexOperand) == 
                                            getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)-ONE &&
                                           getOperand().getGivenIndexOfIntegerArrayIndex(indexOperand+ONE) == 
                                            getOperator().getGivenIndexOfOperatorSignIndex(indexOperator)+ONE)
                                    {
                                        //Make Operation
                                        makeOperation(indexOperand,indexOperator, Operator.DIVISION_SIGN);

                                        //do not throw Exception
                                        checkException = false;

                                        //do not destroyed Parenthes
                                        destroyedParenthes = false;

                                        //Return of the begin of the array
                                        indexParenthesis=ARRAY_LOWER_LIMIT;
                                        indexOperator=getOperator().getOperatorSign().length;
                                        indexOperand=getOperand().getIntegerArray().length;

                                        checkOperation =false;

                                        ++expressionCounter;
                                        System.out.printf("%d: ",expressionCounter);  
                                        System.out.println(toString()); 
                                        
                                    }
                                }

                                if(checkException)
                                    throw new Exception();
                            }
                        }
                    }
                        
                        
                }
                    
                    
                if(destroyedParenthes)
                {
                    //For Expression
                    tempExpressionElementsArray = new String [getExpressionElementsArray().length-TWO];
                        
                    //Make New Array Expression
                    int forExpression = ARRAY_LOWER_LIMIT;

                    while(forExpression < 
                        getParenthesis().getGivenIndexOfParenthesisSignIndex(indexParenthesis-ONE))
                    {
                        tempExpressionElementsArray[forExpression] = 
                            getGivenIndexOfExpressionElementsArray(forExpression);
                        ++forExpression;
                    }
                        
                    tempExpressionElementsArray[forExpression] = 
                        getGivenIndexOfExpressionElementsArray(forExpression+ONE);
                    ++forExpression;

                    while(forExpression < tempExpressionElementsArray.length)
                    {
                        tempExpressionElementsArray[forExpression] = 
                            getGivenIndexOfExpressionElementsArray(forExpression+TWO);
                        ++forExpression;
                    }
                        
                    //Return of the begin of the array
                    indexParenthesis=ARRAY_LOWER_LIMIT;
                        
                    // set Expression Elements Array
                    setExpressionElementsArrayForGivenArray(tempExpressionElementsArray);
                        
                    //Check Errors
                    checkErrors();
                }
         
            } 
        }
  
    return getGivenIndexOfExpressionElementsArray(ARRAY_LOWER_LIMIT);

    }// end method evaluates
    
    /**
     * Override to String for Expression Class
     * 
     * @return String.format
     */
    @Override
    public String toString()
    {   
        String newString = new String();
        
        for(int i=ARRAY_LOWER_LIMIT; i < getExpressionElementsArray().length-ONE ; ++i )
            newString += getGivenIndexOfExpressionElementsArray(i);
        
        return String.format(newString);
    }// end method toString
    
    /**
     * Override to Equals for Expression Class
     * 
     * @param otherExpression // Other Expression
     * @return // If equals with each other than return true, else return false
     */
    @Override
    public boolean equals(Object otherExpression)
    {
        //if otherPolynomial is null than return false
        if (otherExpression == null) 
            return false;
        
        //if otherPolynomial is this than return true
        else if (otherExpression == this)
            return true;
        
        //if otherPolynomial is not a Polynomial than return false
        else if (!(otherExpression instanceof Expression))
            return false;
        
        //Object otherPolynomial downcasting Polynomial class
        Expression expressionOtherExpression = (Expression) otherExpression;

        try {
            // if two result are equals than return true
            if(evaluates() ==  expressionOtherExpression.evaluates())
                return true;
        } catch (Exception ex) {
            System.err.println( "Unexpected Items for method equals: " 
                                + "\nThe program ended unsuccessfully");
                        exit(1);
        }

        //if not
        return false;
    }// end method PolynomialEquals
    
}
