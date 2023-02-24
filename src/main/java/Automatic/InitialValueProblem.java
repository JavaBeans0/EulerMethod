package Automatic;

public class InitialValueProblem {

    private double linearCoefficient;
    private double constantCoefficient;
    private double constant;

    public InitialValueProblem() {
        this(0, 0, 0);
    }

    public InitialValueProblem(double linearCoefficient, double constantCoefficient, double constant) {
        this.linearCoefficient = linearCoefficient;
        this.constantCoefficient = constantCoefficient;
        this.constant = constant;
    }

    public double getLinearCoefficient() { return linearCoefficient; }
    public void setLinearCoefficient(double linearCoefficient) { this.linearCoefficient = linearCoefficient; }
    public double getConstantCoefficient() { return constantCoefficient; }
    public void setConstantCoefficient(double constantCoefficient) { this.constantCoefficient = constantCoefficient; }
    public double getConstant() { return constant; }
    public void setConstant(double constant) { this.constant = constant; }

    @Override public String toString() { return "y'= " + (this.linearCoefficient == 0.0 ? "": process(this.linearCoefficient) + "y") + (this.constantCoefficient == 0.0 ? "" : " + " + process(this.constantCoefficient) + "t") + (this.constant == 0.0 ? "" : " + " + this.constant) + "\n"; }

    public double getY(double t0, double y0) { return (this.linearCoefficient * Math.pow(y0, 2)) + (this.constantCoefficient * t0) + this.constant; }
    private String process(double num) { return (num == 1.0 ? "": Math.floor(num) == (int) num ? Integer.toString((int)num) : Double.toString(num)); }
}
