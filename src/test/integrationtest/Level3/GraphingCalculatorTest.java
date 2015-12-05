package test.integrationtest.Level3;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.main.Visualizer;
import com.maths.GraphingCalculator;
import com.maths.MathTree;
import com.maths.MathTree.Unit;

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
	public void testDrawDeg() {
		calc.setFunctionString("sin(x)");
		calc.draw(Unit.DEGREES);
		Tools.saveImageToFile(buf, testdir+"draw\\deg\\", "Actual.jpg");
	}
	
	@Test
	public void testDrawRad() {
		calc.setFunctionString("sin(x)");
		calc.draw(Unit.RADIANS);
		Tools.saveImageToFile(buf, testdir+"draw\\rad\\", "Actual.jpg");
	}
	
	@Test
	public void testDrawPolar() {
		calc.setFunctionString("teta-2");
		calc.drawPolar();
		Tools.saveImageToFile(buf, testdir+"drawPolar\\", "Actual.jpg");
	}
	
	@Test
	public void testDraw3DRad() {
		calc.setFunctionString("sin(x)+cos(y)");
		calc.draw3D(Unit.RADIANS);
		Tools.saveImageToFile(buf, testdir+"draw3D\\rad\\", "Actual.jpg");
	}
	
	@Test
	public void testDraw3DDeg() {
		calc.setFunctionString("sin(x)+cos(y)");
		calc.draw3D(Unit.DEGREES);
		Tools.saveImageToFile(buf, testdir+"draw3D\\deg\\", "Actual.jpg");
	}
	
}
