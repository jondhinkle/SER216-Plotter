package test;

import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/**
 * @author Jon
 *
 */
@RunWith(Suite.class)
@SuiteClasses({	
				DigitTextFieldTest.class,
				FunctionTextFieldTest.class
			 })

public class TestSuite {
	
}
