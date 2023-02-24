package Automatic;

public class Interval {
    /* Private data fields */
    private double leftBound;
    private double rightBound;
    public Interval() { this(0, 0); }
    public Interval(double leftBound, double rightBound) { this.rightBound = rightBound; this.leftBound = leftBound; }
    /* Getter Setter Methods */
    public double getLeftBound() { return this.leftBound; }
    public void setLeftBound(double leftBound) { this.leftBound = leftBound; }
    public double getRightBound() { return this.rightBound; }
    public void setY(double rightBound) { this.rightBound = rightBound; }

    @Override public String toString() { return "[" + this.leftBound + ", " + this.rightBound + "]"; }
}
