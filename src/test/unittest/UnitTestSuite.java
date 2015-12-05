package test.unittest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.integrationtest.Tools.Tools;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	GraphingCalculatorTest.class,
	ColorpanelTest.class,
	DigitTextFieldTest.class,
	FunctionTextFieldTest.class
})
public class UnitTestSuite {
	
}
