package test.unittest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CalculatorTest.class,
	ColorpanelTest.class,
	DigitTextFieldTest.class,
	FunctionTextFieldTest.class
})
public class UnitTestSuite {
	
}