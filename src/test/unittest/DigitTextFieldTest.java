package test.unittest;

import com.main.DigitTextField;
import junit.extensions.abbot.*;
import abbot.tester.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class DigitTextFieldTest extends ComponentTestFixture {
	
	private JTextComponentTester tester;
	private DigitTextField textfield;
	
	public DigitTextFieldTest(String name) {super(name);}
	
	@Before
	public void setUp() {
		tester = new JTextComponentTester();
		textfield = new DigitTextField();
		showFrame(textfield);
	}
	
	@After
	public void tearDown() {
		tester = null;
		textfield = null;
	}
	
	@Test
	public void testInput() {
		tester.actionEnterText(textfield, "kdjsil234.12");
		assertEquals("234.12",textfield.getText());
		tester.actionEnterText(textfield, "kdjsil234.12%$@1*^\n");
		assertEquals("234.121",textfield.getText());
		tester.actionEnterText(textfield, "!@#$%6^&*()_+|}{:\\\"/<,5");
		assertEquals("65",textfield.getText());
		tester.actionEnterText(textfield,"123.24.5");
		assertEquals("123.245",textfield.getText());
	}
}