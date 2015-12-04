package test.integrationtest.LowLevel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.main.Visualizer;
import com.maths.Calculator;

import test.integrationtest.Tools.Tools;

public class CalculatorTest {
	
	public Calculator calc;
	public Graphics2D g2d;
	public BufferedImage buf;
	public String testdir = "\\IntegrationTest\\Calculator\\Level1\\";
	
	@Before
	public void setUp(){
		calc = new Calculator(Visualizer.WIDTH, Visualizer.HEIGHT);
		calc.a = -3;
		calc.b = 6;
		buf = new BufferedImage(Visualizer.WIDTH,Visualizer.HEIGHT,BufferedImage.TYPE_INT_RGB);
		g2d = (Graphics2D)buf.getGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0,0,Visualizer.WIDTH, Visualizer.HEIGHT);
	}
	
	@After
	public void tearDown() {
		calc = null;
		buf = null;
		g2d = null;
	}
	
	@Test
	public void testXAxis() {
		g2d.setColor(Color.RED);
		calc.drawX0axis(g2d, Visualizer.WIDTH, Visualizer.HEIGHT);
		Tools.saveImageToFile(buf, testdir+"drawX0axis\\", "Actual.jpg");
	}
	
	@Test
	public void testYAxis() {
		g2d.setColor(Color.RED);
		calc.drawY0axis(g2d, Visualizer.WIDTH, Visualizer.HEIGHT);
		Tools.saveImageToFile(buf, testdir+"drawY0axis\\", "Actual.jpg");
	}
	
	@Test
	public void testDraw() {
		g2d.setColor(Color.RED);
		calc.drawX0axis(g2d, Visualizer.WIDTH, Visualizer.HEIGHT);
		calc.drawY0axis(g2d, Visualizer.WIDTH, Visualizer.HEIGHT);
		g2d.setColor(Color.BLACK);
		calc.DISPLAYED_FUNCTION = "sin(x)";
		calc.draw(g2d, Visualizer.WIDTH, Visualizer.HEIGHT);
		Tools.saveImageToFile(buf, testdir+"draw\\", "Actual.jpg");
	}
	
	@Test
	public void testDrawDerivative() {
		g2d.setColor(Color.RED);
		calc.drawX0axis(g2d, Visualizer.WIDTH, Visualizer.HEIGHT);
		calc.drawY0axis(g2d, Visualizer.WIDTH, Visualizer.HEIGHT);
		g2d.setColor(Color.BLACK);
		calc.DISPLAYED_FUNCTION = "sin(x)";
		calc.drawDerivative(g2d, Visualizer.WIDTH, Visualizer.HEIGHT);
		Tools.saveImageToFile(buf, testdir+"drawDerivative\\", "Actual.jpg");
	}
	
	@Test
	public void testDrawPolar() {
		g2d.setColor(Color.RED);
		calc.drawX0axis(g2d, Visualizer.WIDTH, Visualizer.HEIGHT);
		calc.drawY0axis(g2d, Visualizer.WIDTH, Visualizer.HEIGHT);
		g2d.setColor(Color.BLACK);
		calc.DISPLAYED_FUNCTION = "teta-2";
		calc.drawPolar(g2d, Visualizer.WIDTH, Visualizer.HEIGHT);
		Tools.saveImageToFile(buf, testdir+"drawPolar\\", "Actual.jpg");
	}
	
	@Test
	public void testDraw3D() {
		calc.DISPLAYED_FUNCTION = "sin(x)+cos(y)";
		calc.draw3D(buf);
		Tools.saveImageToFile(buf, testdir+"draw3D\\", "Actual.jpg");
	}
	
}
