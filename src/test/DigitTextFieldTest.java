package test;

import com.main.DigitTextField;
import junit.extensions.abbot.*;
import abbot.tester.*;

import static org.junit.Assert.*;

import javax.swing.JComponent;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class DigitTextFieldTest extends ComponentTestFixture {
	
	private JTextComponentTester tester;
	private DigitTextField textfield;
	
	public DigitTextFieldTest(String name) {super(name);}
	
	public static void main(String[] args) {
		TestHelper.runTests(args, DigitTextFieldTest.class);
	}
	
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
		assertEquals(textfield.getText(),"234.12");
		tester.actionEnterText(textfield, "kdjsil234.12%$@1*^\n");
		assertEquals(textfield.getText(),"234.121");
		tester.actionEnterText(textfield, "!@#$%6^&*()_+|}{:\\\"/<,5");
		assertEquals(textfield.getText(),"65");
		tester.actionEnterText(textfield,"123.24.5");
		assertEquals(textfield.getText(),"123.245");
	}
}