package test;

import com.main.FunctionTextField;
import junit.extensions.abbot.*;
import abbot.tester.*;

import static org.junit.Assert.*;

import javax.swing.JComponent;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class FunctionTextFieldTest extends ComponentTestFixture {
	
	private JTextComponentTester tester;
	private FunctionTextField textfield;
	
	public FunctionTextFieldTest(String name) {super(name);}
	
	public static void main(String[] args) {
		TestHelper.runTests(args, DigitTextFieldTest.class);
	}
	
	@Before
	public void setUp() {
		tester = new JTextComponentTester();
		textfield = new FunctionTextField();
		showFrame(textfield);
	}
	
	@After
	public void tearDown() {
		tester = null;
		textfield = null;
	}
	
	@Test
	public void testInputWithNonDigits() {
		tester.actionEnterText(textfield, "kdjsil234.12%$@1*^\nD");
		assertEquals(textfield.getText(),"kjsil234.12%$@1*^");
	}
}