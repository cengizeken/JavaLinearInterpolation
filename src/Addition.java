// JAVA: FunctionExtension interface implementation
// ...
import org.mariuszgromada.math.mxparser.*;

class Addition implements FunctionExtension {
    double x;
    double y;
    public Addition() {
        x = Double.NaN;
        y = Double.NaN;
    }
    public Addition(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public int getParametersNumber() {
        return 2;
    }
    public void setParameterValue(int argumentIndex, double argumentValue) {
        if (argumentIndex == 0) x = argumentValue;
        if (argumentIndex == 1) y = argumentValue;
    }
    public String getParameterName(int parameterIndex) {
        switch (parameterIndex) {
            case 0: return "x";
            case 1: return "y";
            default: return "";
        }
    }
    public double calculate() {
        return x+y;
    }
    public FunctionExtension clone() {
        return new Addition(x, y);
    }
}