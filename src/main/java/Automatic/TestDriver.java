package Automatic;

import java.util.Properties;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestDriver {
    /* Data Fields accessible by whole package */
    protected static InputStream input;
    protected static Properties prop = new Properties();
    protected static Differentiator differentiator;
    /* Pre-condition to Test Exeuction */ public static void setParameters() {
        try {
            input = new FileInputStream("/Users/naimul7/JavaProjects/EulerMethod/src/main/java/config.properties");
            prop.load(input);
            differentiator = new Differentiator(new InitialValueProblem(property("linearCoefficient"), property("constantCoefficient"), property("constant")), new Condition(property("t0"), property("y0")), property("t"), property("stepsize"));
        } catch(FileNotFoundException fnfex) { fnfex.printStackTrace();
        } catch(IOException ioex) { ioex.printStackTrace(); }
    }
    /* Data Display Test */ public static void inputDisplay() { System.out.println(differentiator); }
    /* Post-condition to Test Execution */ public static void closeParameters() { try { input.close(); } catch(IOException ioex) { ioex.printStackTrace(); } }
    /* Steps Generation Test */ public static void displaySteps() { differentiator.displaySteps(); }
    /* Euler Method */ public static void eulerMethod() { differentiator.takeSteps(false); }
    /* Improved Euler Method */ public static void improvedEulerMethod() { differentiator.takeSteps(true); }
    /* Convenience Method */ private static double property(String str) { return Double.parseDouble(prop.getProperty(str)); }
}
