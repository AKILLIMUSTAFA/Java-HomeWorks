
import static java.lang.System.exit;
import java.util.Scanner;
import tr.edu.gyte.CSE241.HW9.Mustafa.Akilli.Expression;
import tr.edu.gyte.CSE241.HW9.Mustafa.Akilli.Operand;
import tr.edu.gyte.CSE241.HW9.Mustafa.Akilli.Operator;
import tr.edu.gyte.CSE241.HW9.Mustafa.Akilli.Parenthesis;

/**
 * HW10_131044017_Mustafa_Akilli
 * 
 * File:   TestAllClasses.java
 * 
 * Description:
 * 
 * Test All Classes          
 * 
 * @author Mustafa_Akilli
 * @since Friday 7 January 2015, 22:12 by Mustafa_Akilli
 */
public class TestAllClasses {
    
    private final static int ARRAY_LOWER_LIMIT = 0; // for division
    private final static int ONE = 1;

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String newExpression; // new Expression

        Operator operator = new Operator(); // keep the operators
        Operand operand = new Operand(); // keep the integer operands only
        Parenthesis parenthesis = new Parenthesis();; // keep ( and )

        System.out.println("****************");
        System.out.println("Test Expression");
        
        Expression expression = new Expression(); // keep the operators
        
        
        System.out.println();
        System.out.println("****************");
        System.out.println("Test Operator");
        System.out.println("Give a Operator: ");
        
        newExpression =  scanner.nextLine();
        

        try// throw an exception from Operator and immediately catch it
        {
            operator.setOperatorSignAndSetOperatorSignIndex(newExpression, ONE);
            System.out.printf("\n%s",newExpression);
            System.out.println(" is a Operator\n");
        }// end try for Operator
        catch(Exception exceptionOperator )
        {
            System.err.println(" is not a Operator\n");
        }
        
        System.out.println("****************");
        System.out.println("Test Operand");
        System.out.println("Give a Operand: ");
        
        newExpression =  scanner.nextLine();

        try// throw an exception from Operator and immediately catch it
        {
            operand.setIntegerArrayAndIntegerArrayIndex(newExpression, ONE);
            System.out.printf("\n%s",newExpression);
            System.out.println(" is a Operand");
        }// end try for Operator
        catch(Exception exceptionOperand )
        {
            System.err.println(" is not a Operand\n");
        }

        
        System.out.println("****************");
        System.out.println("Test Parenthes");
        System.out.println("Give a Parenthes: ");
        
        newExpression =  scanner.nextLine();

        try// throw an exception from Operator and immediately catch it
        {
            parenthesis.setParenthesisSignAndParenthesisSignIndex(newExpression, ONE);
            System.out.printf("\n%s",newExpression);
            System.out.println(" is a Parenthes");
        }// end try for Operator
        catch(Exception exceptionOperand )
        {
            System.err.println(" is not a Parenthesis\n");
        }
        
    }// end method main
    
}// end class TestAllClasses
