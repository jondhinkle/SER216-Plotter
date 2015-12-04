package test.unittest;

import static org.junit.Assert.*;

import com.main.Colorpanel;
import java.awt.Color;
import org.junit.Test;

public class ColorpanelTest {

	@Test
	public void testDecomposeColor(){
		String color = com.main.Colorpanel.decomposeColor(new Color(200,100,50));
		assertEquals("200,100,50",color);
	}
	
	@Test(expected = NullPointerException.class)
	public void testDecomposeColorWithNull(){
		Colorpanel.decomposeColor(null);
	}
	
	@Test(expected = NumberFormatException.class)
	public void testBuildColorWithLetters(){
		Colorpanel.buildColor("100,200,abc");
	}
	
	@Test(expected = NullPointerException.class)
	public void testBuildColorWithNull(){
		Colorpanel.buildColor(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBuildColorWithNegativeNum(){
		Colorpanel.buildColor("127,60,-20");
	}
	
	@Test
	public void testBuildColor(){
		Color color = Colorpanel.buildColor("127,63,21");
		assertEquals(127,color.getRed());
		assertEquals(63,color.getGreen());
		assertEquals(21,color.getBlue());
	}
}
