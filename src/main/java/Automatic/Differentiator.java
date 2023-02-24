package Automatic;

public class Differentiator {

    private InitialValueProblem ivp;
    private Condition condition;
    private double stepsize;
    private double t;
    private Interval interval;

    public Differentiator() { this(null, null, 0.0, 0.0); }
    public Differentiator(InitialValueProblem ivp, Condition condition, double t, double stepsize) { this(ivp, condition, t, stepsize, null); }
    public Differentiator(InitialValueProblem ivp, Condition condition, double t, double stepsize, Interval interval) {
        this.ivp = ivp;
        this.condition = condition;
        this.t = t;
        this.stepsize = stepsize;
        this.interval = interval;
    }

    public InitialValueProblem getIvp() { return ivp; }
    public void setIvp(InitialValueProblem ivp) { this.ivp = ivp; }
    public Condition getCondition() { return condition; }
    public void setCondition(Condition condition) { this.condition = condition; }
    public double getT() { return t; }
    public void setT(double t) { this.t = t; }

    /* Custom Methods */
    public void displaySteps() {
        if(interval == null)
            for(double movement = this.condition.getT0(); movement < (this.t + 0.001); movement += this.stepsize)System.out.println(String.format("%.1f", movement));
        else
            for(double movement = interval.getLeftBound(); movement <= interval.getRightBound(); movement += this.stepsize)System.out.println(String.format("%.1f", movement));
    }

    public void takeSteps(boolean advanced) {
        System.out.println();
        if(advanced)
            advancedSteps(0.0, 0);
        else
            babySteps(0.0, 0);
    }

    public void babySteps(double nextStepValue, int i) {
        for(double movement = this.condition.getT0(); movement < this.t; movement += this.stepsize, i++) {
            System.out.println("t" + (i+1) + " = " + String.format("%.1f", movement + this.stepsize) + ", y(" + String.format("%.1f", movement + this.stepsize) + ") = y" + i + " + h * f(t" + i + ",y" +  i + ")");
            System.out.println("\t\t\t\t = " + String.format("%." + i + "f", i == 0 ? this.condition.getY0() : nextStepValue) + " + " + this.stepsize + "f(" + (i == 0 ? this.condition.getT0() : movement) + ", " + String.format("%." + i + "f", i == 0 ? this.condition.getY0() : nextStepValue) + ")");
            nextStepValue = (i == 0 ? this.condition.getY0() : nextStepValue) + stepsize * ivp.getY(movement, i == 0 ? this.condition.getY0() : nextStepValue);
            System.out.println("\t\t\t\t = " + String.format("%." + (i+1) + "f", nextStepValue));
        }
    }

    public void advancedSteps(double nextStepValue, int i) {
        double s1 = 0.0, s2 = 0.0, y = 0.0, t = 0.0;
        for(double movement = this.condition.getT0(); movement < this.t; movement += this.stepsize, i++) {
            y = i == 0 ? this.condition.getY0() : nextStepValue;
            t = i == 0 ? this.condition.getT0() : movement;
            s1 = ivp.getY(movement, y);
            s2 = ivp.getY(movement + this.stepsize, y + this.stepsize * s1);
            System.out.println("s1 = f(t" + i + ", y" + i + ") = f(" + t + ", " + str(i, y) + ") = " + str(i+2, s1));
            System.out.println("s2 = f(t" + i + " + h, y" + i + " + h * s1) = f(" + t + " + " + this.stepsize + ", " + str(i,y) + " + " + this.stepsize + " * " + str(i+2, s1) + ") = " + str(i+3, s2));
            System.out.println(" ------------------------------------------------------------------------ ");
            System.out.println("t" + (i+1) + " = " + String.format("%.1f", movement + this.stepsize) + ", y(" + String.format("%.1f", movement + this.stepsize) + ") = y" + i + " + h * (s1 + s2) / 2");
            System.out.println("\t\t\t\t = " + y + " + " + this.stepsize + " * (" + str(i+2, s1) + " + " + str(i+3, s2) + ") / 2");
            System.out.println("\t\t\t\t = " + y + " + " + this.stepsize + " * " + (s1 + s2) / 2.0);
            System.out.println("\t\t\t\t = " + y + " + " + str(i+3, this.stepsize * (s1 + s2) / 2.0) );
            System.out.println("\t\t\t\t = " + str(i+3, y + this.stepsize * (s1 + s2) / 2.0) );
            System.out.println();

            nextStepValue = y + stepsize * (s1 + s2) / 2.0;
        }
    }

    private static String str(int precision, double value) { return String.format("%." + precision + "f", value); }

    @Override public String toString() { return this.ivp.toString() + this.condition.toString() + "\nValue: " + this.t + "\nStepsize: " + this.stepsize; }
}
