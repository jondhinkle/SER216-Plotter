package test.integrationtest.Level3;

import static org.junit.Assert.*;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.main.Visualizer;
import com.maths.AdvancedGraphingCalculator;
import com.maths.GraphingCalculator;
import com.maths.MathTree.Unit;

import test.integrationtest.Tools.Tools;

public class AdvancedGraphingCalculatorTest {
	
	private AdvancedGraphingCalculator calc;
	private BufferedImage buf;
	public String testdir = "\\IntegrationTest\\GraphingCalculator\\Level1\\";
	
	@Before
	public void setUp(){
		buf = new BufferedImage(Visualizer.WIDTH,Visualizer.HEIGHT,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D)buf.getGraphics();
		calc = new AdvancedGraphingCalculator(g2d,Visualizer.WIDTH,Visualizer.HEIGHT);
	}
	
	@After
	public void tearDown(){
		calc = null;
	}
	
	@Test
	public void testDF() {
		calc.setFunctionString("4x^2");
		double dfreturn = calc.df(2);
		assertEquals(16.0,dfreturn,0.0001);
	}
	
	@Test(expected = NullPointerException.class)
	public void testDFNull() {
		calc.df(2);
		fail();
	}
	
	@Test
	public void testSimpsonIntegral() {
		calc.setFunctionString("(2*x^3)/(7+x)");
		double sireturn = calc.SimpsonIntegral();
		assertEquals(4.32099,sireturn,0.0001);
	}
	
	@Test
	public void testTrapeziumIntegral() {
		calc.setFunctionString("1+sin^3(x)");
		double sireturn = calc.SimpsonIntegral();
		assertEquals(4.18347,sireturn,0.0001);
	}
	
	@Test
	public void testDrawDerivative() {
		calc.setFunctionString("sin(x)");
		calc.drawDerivative();
		Tools.saveImageToFile(buf, testdir+"drawDerivative\\", "Actual.jpg");
	}
	
	@Test
	public void testDrawandDrawDerivative() {
		calc.setFunctionString("sin(x)");
		calc.draw(Unit.RADIANS);
		calc.drawDerivative();
		Tools.saveImageToFile(buf, testdir+"draw_and_drawDerivative\\", "Actual.jpg");
	}
	
}
