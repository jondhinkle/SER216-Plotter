package com.main;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class DigitTextField extends JTextField{

	
	public DigitTextField(int cols) {
		super(cols);
	}
	
	public DigitTextField() {
			super();
		}
	
	protected Document createDefaultModel() {
		return new DigitDocument();
	}
	
	static class DigitDocument extends PlainDocument {
		
		public void insertString(int offs, String str, AttributeSet a) 
		throws BadLocationException {
			
			if (str == null) {
				return;
			}
			char[] upper = str.toCharArray();
			boolean isDigit=true;
			boolean additionalDecimal = false;
			
			for (int i = 0; i < upper.length; i++) {
				upper[i] = Character.toUpperCase(upper[i]);
				if(!Character.isDigit(upper[i]) && upper[i]!='.' && upper[i]!='-')
				{
					isDigit=false;
					break;
				}
				else{
					if(upper[i] == '.'){
						String text = super.getText(0, super.getLength());
						if(text.indexOf('.') != -1){
							additionalDecimal = true;
							break;
						}
					}
				}
			}
			if(isDigit && !additionalDecimal)
				super.insertString(offs, new String(upper), a);
		}
	}

}
