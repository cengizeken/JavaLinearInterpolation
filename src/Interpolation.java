import org.mariuszgromada.math.mxparser.FunctionExtension;

public class Interpolation implements FunctionExtension {
    private double[] xValues;
    private double[] yValues;
    private double currentX;

    public Interpolation() {
        // Default constructor
    }

    public Interpolation(double[] xValues, double[] yValues) {
        if (xValues == null || yValues == null || xValues.length != yValues.length || xValues.length < 2) {
            throw new IllegalArgumentException("Invalid input data for interpolation");
        }
        this.xValues = xValues;
        this.yValues = yValues;
    }

    public void setValues(double[] xValues, double[] yValues) {
        if (xValues == null || yValues == null || xValues.length != yValues.length || xValues.length < 2) {
            throw new IllegalArgumentException("Invalid input data for interpolation");
        }
        this.xValues = xValues;
        this.yValues = yValues;
    }

    public void setCurrentX(double currentX) {
        this.currentX = currentX;
    }

    @Override
    public int getParametersNumber() {
        return 0; // No parameters directly provided
    }

    @Override
    public void setParameterValue(int argumentIndex, double argumentValue) {
        // Not applicable for this implementation
    }

    @Override
    public String getParameterName(int parameterIndex) {
        return ""; // Not applicable for this implementation
    }

    @Override
    public double calculate() {
        // For simplicity, assuming linear interpolation
        // If more complex interpolation is needed, modify accordingly
        double xi = currentX;
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < xValues.length - 1; i++) {
            if (xi >= xValues[i] && xi <= xValues[i + 1]) {
                index1 = i;
                index2 = i + 1;
                break;
            }
        }

        if (index1 != -1 && index2 != -1) {
            return ((xValues[index2] - xValues[index1]) / (yValues[index2] - yValues[index1])) * (xi - xValues[index1]) + yValues[index1];
        } else {
            throw new IllegalArgumentException("Input value is outside the range of x-values.");
        }
    }

    @Override
    public FunctionExtension clone() {
        return new Interpolation(xValues, yValues);
    }
}