package test.integrationtest.Level3;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.integrationtest.Tools.Tools;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	GraphingCalculatorTest.class,
	AdvancedGraphingCalculatorTest.class
})
public class LowLevelSuite {
	
	@BeforeClass
	public static void setUp(){
		Tools.initialize();
	}
}