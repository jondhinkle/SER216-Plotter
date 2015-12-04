package test.integrationtest.Level1;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.main.Visualizer;
import com.maths.GraphingCalculator;

import test.integrationtest.Tools.Tools;

public class GraphingCalculatorTest {
	
	public GraphingCalculator calc;
	public Graphics2D g2d;
	public BufferedImage buf;
	public String testdir = "\\IntegrationTest\\GraphingCalculator\\Level1\\";
	
	@Before
	public void setUp(){
		buf = new BufferedImage(Visualizer.WIDTH,Visualizer.HEIGHT,BufferedImage.TYPE_INT_RGB);
		g2d = (Graphics2D)buf.getGraphics();
		calc = new GraphingCalculator(g2d,Visualizer.WIDTH, Visualizer.HEIGHT);
		calc.a = -3;
		calc.b = 6;
	}
	
	@After
	public void tearDown() {
		calc = null;
		buf = null;
		g2d = null;
	}
	
	@Test
	public void testDraw() {
		calc.DISPLAYED_FUNCTION = "sin(x)";
		calc.draw();
		Tools.saveImageToFile(buf, testdir+"draw\\", "Actual.jpg");
	}
	
	@Test
	public void testDrawDerivative() {
		calc.DISPLAYED_FUNCTION = "sin(x)";
		calc.drawDerivative(false);
		Tools.saveImageToFile(buf, testdir+"drawDerivative\\", "Actual.jpg");
	}
	
	@Test
	public void testDrawandDrawDerivative() {
		calc.DISPLAYED_FUNCTION = "sin(x)";
		calc.draw();
		calc.drawDerivative(true);
		Tools.saveImageToFile(buf, testdir+"draw_and_drawDerivative\\", "Actual.jpg");
	}
	
	@Test
	public void testDrawPolar() {
		calc.DISPLAYED_FUNCTION = "teta-2";
		calc.drawPolar();
		Tools.saveImageToFile(buf, testdir+"drawPolar\\", "Actual.jpg");
	}
	
	@Test
	public void testDraw3D() {
		calc.DISPLAYED_FUNCTION = "sin(x)+cos(y)";
		calc.draw3D();
		Tools.saveImageToFile(buf, testdir+"draw3D\\", "Actual.jpg");
	}
	
}
