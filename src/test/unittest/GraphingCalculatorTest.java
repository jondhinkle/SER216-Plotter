package test.unittest;

import static org.junit.Assert.*;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.main.Visualizer;
import com.maths.GraphingCalculator;
import com.maths.MathTree.Unit;

public class GraphingCalculatorTest {
	
	GraphingCalculator calc;
	
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
	public void testInvertX(){
		calc.x0 = 173;
		calc.deltax = 2.3765;
		String inverted = calc.invertX(5);
		assertEquals("-399.25",inverted);
	}
	
	@Test
	public void testInvertY(){
		calc.y0 = 37;
		calc.deltay = 5.2143;
		String inverted = calc.invertY(91,7);
		assertEquals("-630.93",inverted);
	}
	
	@Test
	public void testZoom(){
		double dx = calc.deltax;
		calc.zoom(1);
		assertEquals(dx*0.5,calc.deltax,0.0001);
		calc.deltax = dx;
		calc.zoom(-1);
		assertEquals(dx*2,calc.deltax,0.0001);
	}
	
	@Test
	public void test2DF(){
		calc.setFunctionString("sin(tan(x))^2+7.0/1.3-sqrt(25)*cos(x)");
		double fresult = calc.f(2,Unit.DEGREES);
		assertEquals(0.3876,fresult,0.0001);
		fresult = calc.f(2,Unit.RADIANS);
		assertEquals(8.1331,fresult,0.0001);
	}
	
	@Test(expected = NumberFormatException.class)
	public void test2DFNull(){
		calc.setFunctionString("sin(x) +$&");
		calc.f(1,Unit.DEGREES);
	}
	
	@Test
	public void test3DF(){
		calc.setFunctionString("sin(x)^2+7/1.3-sqrt(25)+cos(y)");
		double fresult = calc.f(4,2,Unit.DEGREES);
		assertEquals(1.3888,fresult,0.0001);
		fresult = calc.f(4,2,Unit.RADIANS);
		assertEquals(0.5412,fresult,0.0001);
	}
	
	@Test(expected = NumberFormatException.class)
	public void test3DFNull(){
		calc.setFunctionString("sin(x) +$&y");
		calc.f(2,7,Unit.DEGREES);
	}

}