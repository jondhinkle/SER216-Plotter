package com.main;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Colorpanel extends JDialog implements ActionListener{

	
	private JPanel pan;
	private JButton save=null;
	private Properties p=null;
	int numPanels=5;
	ColorChoose[] selects=new ColorChoose[numPanels];
	private Component THIS;
	

	public Colorpanel(Properties p){
		
		init();
		
		this.p=p;
		int height=10+70+numPanels*60;
		
		setBounds(30,30,400,height);
		setTitle("Color panel");
		
		pan=new JPanel();
		pan.setLayout(null);
        pan.setBackground(Visualizer.GRAPH_COLOR);
        
        save=new JButton("Save");
        save.addActionListener(this);
        
        int r=10;
        
        selects[0]=new ColorChoose("WINDOW_COLOR",p.getProperty("WINDOW_COLOR"));
		selects[0].setBounds(10,r,350,50);
		pan.add(selects[0]);
		
		r+=60;
        
        selects[1]=new ColorChoose("GRAPH_COLOR",p.getProperty("GRAPH_COLOR"));
        selects[1].setBounds(10,r,350,50);
        pan.add(selects[1]);
        
        r+=60;
        
        selects[2]=new ColorChoose("AXIS_COLOR",p.getProperty("AXIS_COLOR"));
		selects[2].setBounds(10,r,350,50);
		pan.add(selects[2]);
		
        r+=60;
		
		selects[3]=new ColorChoose("LINE_COLOR",p.getProperty("LINE_COLOR"));
		selects[3].setBounds(10,r,350,50);
		pan.add(selects[3]);
		
		r+=60;
		
		selects[4]=new ColorChoose("DERIVATIVE_LINE_COLOR",p.getProperty("DERIVATIVE_LINE_COLOR"));
		selects[4].setBounds(10,r,350,50);
		pan.add(selects[4]);
		
		
		save.setBounds(10,r+50,80,20);
        pan.add(save);
        add(pan);
        setModal(true);
        setVisible(true);
       
		
	}
	
	private void init() {
		THIS=this;
	}

	public void actionPerformed(ActionEvent arg0) {
	 Object o=arg0.getSource();
	 
	 if(o==save) save();
		
	}

	private void save() {
		try {
			for(int i=0;i<selects.length;i++){
				
				String property=selects[i].getProperty();
				String value=selects[i].getValue();
				
				p.setProperty(property,value);
				p.store(new FileOutputStream("mathgraphics.properties"),null);
				this.dispose();
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	class ColorChoose extends JPanel {
		
		String property=null;
		String value=null;
		
		
		JPanel colorreppanel=null;
		JButton cho=null;
		JLabel lab=null;
		
		
		public ColorChoose(String property, String value) {
			
			setOpaque(false);
			this.property = property;
			this.value = value;
			
			setLayout(null);
			setOpaque(false);
			colorreppanel=new JPanel();
			colorreppanel.setBorder(BorderFactory.createLineBorder(Color.black));
			
			cho=new JButton(">");
			cho.addActionListener(
					new ActionListener(){

						public void actionPerformed(ActionEvent e) {
                          Color tcc = JColorChooser.showDialog(THIS,"Choose color",null);
                          if(tcc!=null) writeColor(tcc);

						}
					}
			);
			
			lab=new JLabel(property,JLabel.RIGHT);
			colorreppanel.setBackground(buildColor(value));
			lab.setBounds(0,0,150,20);
			colorreppanel.setBounds(160,0,100,20);
			cho.setBounds(290,0,50,20);
			
			add(lab);
			add(colorreppanel);
			add(cho);
			

		}
		
		private void writeColor(Color tcc) {
			value=decomposeColor(tcc);
			colorreppanel.setBackground(buildColor(value));
			
		}

		public String getProperty() {
			return property;
		}

		public void setProperty(String property) {
			this.property = property;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public ColorChoose(){
			
			super();
		}
		
		
	}
	
	public static String decomposeColor(Color tcc) {
		return tcc.getRed()+","+tcc.getGreen()+","+tcc.getBlue();
		
	}
	
	public static Color buildColor(String colorString) {
		
		if(colorString==null) throw new NullPointerException();
		Color tcc=null;
		String[] colorComponents = colorString.split(",");
		tcc=new Color(Integer.parseInt(colorComponents[0]),Integer.parseInt(colorComponents[1]),Integer.parseInt(colorComponents[2]));
		return tcc;
		
	}

}
