package test.unittest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.main.Visualizer;
import com.maths.Calculator;

public class CalculatorTest {
	
	Calculator calc;
	
	@Before
	public void setUp(){
		calc = new Calculator(Visualizer.WIDTH,Visualizer.HEIGHT);
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
		calc.DISPLAYED_FUNCTION = "sin(tan(x))^2+7/1.3-sqrt(25)*cos(x)";
		double fresult = calc.f(2);
		assertEquals(0.39146,fresult,0.0001);
	}
	
	@Test(expected = NumberFormatException.class)
	public void test2DFNull(){
		calc.DISPLAYED_FUNCTION = "sin(x) +$&";
		calc.f(1);
	}
	
	@Test
	public void test3DF(){
		calc.DISPLAYED_FUNCTION = "sin(tan(x))^2+7/1.3-sqrt(25)*cos(y)";
		double fresult = calc.f(4,2);
		assertEquals(0.38766,fresult,0.0001);
	}
	
	@Test(expected = NumberFormatException.class)
	public void test3DFNull(){
		calc.DISPLAYED_FUNCTION = "sin(x) +$&y";
		calc.f(2,7);
	}

}