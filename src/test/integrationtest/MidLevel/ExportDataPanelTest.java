package test.integrationtest.MidLevel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.main.Visualizer;
import com.maths.Calculator;

import abbot.finder.Matcher;
import abbot.finder.matchers.NameMatcher;
import abbot.tester.JButtonTester;
import abbot.tester.JFileChooserTester;
import abbot.tester.JTextComponentTester;
import junit.extensions.abbot.ComponentTestFixture;

import com.main.DigitTextField;
import com.main.ExportDataPanel;

import test.integrationtest.Tools.Tools;

public class ExportDataPanelTest extends ComponentTestFixture {
	private JTextComponentTester txttest;
	private JFileChooserTester filechoosertest;
	private JButtonTester btntest;
	private JTextField txtvaluesep;
	private JTextField txtdatasep;
	private JTextField txtfileactual;
	private JFileChooser filechooser;
	private JButton btnsave;
	private JButton btnexit;
	private JButton btngetfile;
	private ExportDataPanel exportpanel;
	private ArrayList<Component> components;
	private Calculator calc;
	
	public ExportDataPanelTest(String name) {super(name);}
	
	@Before
	public void setUp(){
		calc = new Calculator(Visualizer.HEIGHT,Visualizer.WIDTH);
	}
	
	public void initPanel(String function,Object obj) {
		System.out.println("0");
		calc.DISPLAYED_FUNCTION = function;
		exportpanel = new ExportDataPanel(obj);
		try{
			System.out.println("1");
			txtvaluesep = (JTextField) getFinder().find(exportpanel,new Matcher() {
				public boolean matches(Component c) {
          return c instanceof JTextField
              && ",".equals(((JTextField)c).getText());
				}
			});
			txtdatasep = (JTextField) getFinder().find(exportpanel,new Matcher() {
				public boolean matches(Component c) {
          return c instanceof JTextField
              && "".equals(((JTextField)c).getText())
              && (((JTextField)c).getWidth() < 250);
				}
			});
			txtfileactual = (JTextField) getFinder().find(exportpanel,new Matcher() {
				public boolean matches(Component c) {
          return c instanceof JTextField
              && "".equals(((JTextField)c).getText())
              && (((JTextField)c).getWidth() == 250);
				}
			});
			btnsave = (JButton) getFinder().find(exportpanel,new Matcher() {
				public boolean matches(Component c) {
          return c instanceof JButton
              && "Save".equals(((JButton)c).getText());
				}
			});
			btnexit = (JButton) getFinder().find(exportpanel,new Matcher() {
				public boolean matches(Component c) {
          return c instanceof JButton
              && "Exit".equals(((JButton)c).getText());
				}
			});
			btngetfile = (JButton) getFinder().find(exportpanel,new Matcher() {
				public boolean matches(Component c) {
          return c instanceof JButton
              && ">".equals(((JButton)c).getText());
				}
			});
			txttest = new JTextComponentTester();
			filechoosertest = new JFileChooserTester();
			btntest = new JButtonTester();
			System.out.println("2");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() {
		txttest = null;
		filechoosertest = null;
		btntest = null;
		txtvaluesep = null;
		txtdatasep = null;
		txtfileactual = null;
		filechooser = null;
		btnsave = null;
		btnexit = null;
		btngetfile = null;
		exportpanel = null;
		components = null;
		calc = null;
	}
	
	@Test
	public void testExportDataPanel() {
		System.out.println("0.1");
		initPanel("sin(x)",calc.getFunction());
		System.out.println("0.2");
		txttest.actionEnterText(txtvaluesep, "|");
		txttest.actionEnterText(txtdatasep, ",");
		txttest.actionEnterText(txtfileactual, Tools.actualbasedir+"\\IntegrationTest\\Level2\\ExportDataPanel\\testdata_1.txt");
		btntest.actionClick(btnsave);
		btntest.actionClick(btnexit);
	}
	
	/*if find file clicked
	 * filechooser = (JFileChooser) getFinder().find(exportpanel,new Matcher() {
				public boolean matches(Component c) {
          return c instanceof JFileChooser;
				}
			});
	 */
}
