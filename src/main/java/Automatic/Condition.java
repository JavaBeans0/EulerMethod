package Automatic;

public class Condition {

    private double t0;
    private double y0;

    public Condition() { this(0, 0); }
    public Condition(double t0, double y0) { this.t0 = t0; this.y0 = y0; }

    public double getT0() { return t0; }
    public void setT0(double t0) { this.t0 = t0; }
    public double getY0() { return y0; }
    public void setY0(double y0) { this.y0 = y0; }

    @Override public String toString() { return "y(" + this.t0 + ") = " + this.y0; }
}
