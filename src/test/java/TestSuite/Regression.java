package TestSuite;

import Automatic.TestDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class Regression {
    @BeforeTest public static void initiate() { TestDriver.setParameters(); }
    @Test(groups = "a") public static void testInputDisplay() { TestDriver.inputDisplay(); }
    @Test(groups = "b") public static void testDisplaySteps() { TestDriver.displaySteps(); }
    @Test(groups = "c", dependsOnGroups = "a") public static void testEulerMethod() { TestDriver.eulerMethod(); }
    @Test(groups = "c", dependsOnGroups = "a") public static void testImprovedEulerMethod() { TestDriver.improvedEulerMethod(); }
    @AfterTest public static void complete() { TestDriver.closeParameters(); }
}
