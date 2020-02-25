// EasyCalculator class
// See EasyCalculatorTest.java

public class EasyCalculator {
    // Fields - State
    private double operand1;
    private double operand2;

    // parameterized constructor
    public EasyCalculator(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    // setters and getters
    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    // Methods - Behaviour
    public double addition() {
        return operand1 + operand2;
    }

    public double subtraction() {
        return operand1 - operand2;
    }

    public double multiplication() {
        return operand1 * operand2;
    }

    public double division() {
        return operand1 / operand2;
    }

    // toString method
    @Override
    public String toString() {
        return "EasyCalculator [operand1=" + operand1 + ", operand2=" + operand2 + "]";
    }

} // end EasyCalculator