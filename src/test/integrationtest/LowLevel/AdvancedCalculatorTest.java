package test.integrationtest.LowLevel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.main.Visualizer;
import com.maths.AdvancedCalculator;
import com.maths.Calculator;

public class AdvancedCalculatorTest {
	
	private Calculator calc;
	
	@Before
	public void setUp(){
		calc = new Calculator(Visualizer.WIDTH,Visualizer.HEIGHT);
	}
	
	@After
	public void tearDown(){
		calc = null;
	}
	
	@Test
	public void testDF() {
		calc.DISPLAYED_FUNCTION = "4x^2";
		double dfreturn = AdvancedCalculator.df(2,calc);
		assertEquals(16.0,dfreturn,0.0001);
	}
	
	@Test(expected = NullPointerException.class)
	public void testDFNull() {
		AdvancedCalculator.df(2,null);
		fail();
	}
	
	@Test
	public void testSimpsonIntegral() {
		calc.DISPLAYED_FUNCTION = "(2*x^3)/(7+x)";
		double sireturn = AdvancedCalculator.SimpsonIntegral(calc);
		assertEquals(4.32099,sireturn,0.0001);
	}
	
	@Test
	public void testTrapeziumIntegral() {
		calc.DISPLAYED_FUNCTION = "1+sin^3(x)";
		double sireturn = AdvancedCalculator.SimpsonIntegral(calc);
		assertEquals(4.18347,sireturn,0.0001);
	}
	
}
