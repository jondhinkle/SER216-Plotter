package test.integrationtest.Level1;

import static org.junit.Assert.*;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.main.Visualizer;
import com.maths.AdvancedGraphingCalculator;
import com.maths.GraphingCalculator;

public class AdvancedGraphingCalculatorTest {
	
	private GraphingCalculator calc;
	
	@Before
	public void setUp(){
		BufferedImage buf = new BufferedImage(Visualizer.WIDTH,Visualizer.HEIGHT,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D)buf.getGraphics();
		calc = new GraphingCalculator(g2d,Visualizer.WIDTH,Visualizer.HEIGHT);
	}
	
	@After
	public void tearDown(){
		calc = null;
	}
	
	@Test
	public void testDF() {
		calc.DISPLAYED_FUNCTION = "4x^2";
		double dfreturn = AdvancedGraphingCalculator.df(2,calc);
		assertEquals(16.0,dfreturn,0.0001);
	}
	
	@Test(expected = NullPointerException.class)
	public void testDFNull() {
		AdvancedGraphingCalculator.df(2,null);
		fail();
	}
	
	@Test
	public void testSimpsonIntegral() {
		calc.DISPLAYED_FUNCTION = "(2*x^3)/(7+x)";
		double sireturn = AdvancedGraphingCalculator.SimpsonIntegral(calc);
		assertEquals(4.32099,sireturn,0.0001);
	}
	
	@Test
	public void testTrapeziumIntegral() {
		calc.DISPLAYED_FUNCTION = "1+sin^3(x)";
		double sireturn = AdvancedGraphingCalculator.SimpsonIntegral(calc);
		assertEquals(4.18347,sireturn,0.0001);
	}
	
}
