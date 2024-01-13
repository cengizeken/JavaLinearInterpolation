import org.mariuszgromada.math.mxparser.*;
public class Main {
    public static void main(String[] args) {
        /*double[] xValues = {1, 2, 3, 4};
        double[] yValues = {10, 15, 20, 25};

        Interpolation interpolation = new Interpolation(xValues,yValues);
        interpolation.setCurrentX(2.5);
        // Creating extended function
        Function f = new Function("f", interpolation);
        interpolation.setCurrentX(2.5);
        mXparser.consolePrintln("f.calculate() = " + f.calculate() );

        // Using extended function in expression
        Expression e = new Expression("f(2,3)", f);
        mXparser.consolePrintln(e.getExpressionString() + " = " + e.calculate() );*/


        // Creating extended function
        Function f = new Function("f", new Addition());
        mXparser.consolePrintln("f.calculate(1,2) = " + f.calculate(1,2) );

        // Using extended function in expression
        Expression e = new Expression("f(2,3)", f);
        mXparser.consolePrintln(e.getExpressionString() + " = " + e.calculate() );


    }
}