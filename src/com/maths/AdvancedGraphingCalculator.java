package com.maths;

import java.awt.Color;
import java.awt.Graphics2D;

import com.maths.MathTree.Unit;

public class AdvancedGraphingCalculator extends GraphingCalculator{

	
	private double[] dfun;
	private Color derivativelinecolor = Color.RED;
	
	public AdvancedGraphingCalculator(Graphics2D extgraphics2D, int WIDTH, int HEIGHT) throws IllegalArgumentException{
		super(extgraphics2D,WIDTH,HEIGHT);
	};
	
	public double df(double x){
		
			double total=0;
		
			
			double dx=0.001;
		    double i_2dx=500;
			MathTree.Unit oldunit = getUnitType();
		    //total=(calc.f(x+dx)-calc.f(x-dx))/(2*dx);
			setUnitType(Unit.RADIANS);
		    total=(f(x+dx,Unit.RADIANS)-f(x-dx,Unit.RADIANS))*i_2dx;
		    setUnitType(oldunit);
			return total;
	
	}
	
	public double SimpsonIntegral(){
		
		double total=0;
		
		double x1=a;
		double x2=b;
		
		int num=1000;
		
		double dx=(x2-x1)/num;
		double dx_6=dx/6.0;
		for(double x=x1;x<x2;x=x+dx){
		
		  //total+=dx*(calc.f(x)+calc.f(x+dx)+4*calc.f((x*2+dx)/2.0))/6.0;
		
		 total+=f(x,Unit.RADIANS)+f(x+dx,Unit.RADIANS)+4*f((x*2+dx)*0.5,Unit.RADIANS);
		}
		
		
		return total*dx_6;
	
	}
	
	
	public double trapeziumIntegral(){
		
		double total=0;
		
		double x1=a;
		double x2=b;
		
		int num=1000;
		
		double dx=(x2-x1)/num;
		double dx_2=dx/2;
		for(double x=x1;x<x2;x=x+dx){
		
		  //total+=dx*(calc.f(x+dx)-calc.f(x-dx))/2;	
			total+=(f(x+dx,Unit.RADIANS)+f(x,Unit.RADIANS));
		}
		
		return total*dx_2;
	
	}

	public double gaussIntegral() {
		
		double total=0;
		
		double x1=a;
		double x2=b;
		
		int num=1000;
		
		double dx=(x2-x1)/num;
		double dx_2=dx/2;
		
		double[] xrg={-Math.sqrt((35+2*Math.sqrt(70))/63.0),
				-Math.sqrt((35-2*Math.sqrt(70))/63.0),
				0,
				Math.sqrt((35-2*Math.sqrt(70))/63.0),
				Math.sqrt((35+2*Math.sqrt(70))/63.0)};
		
		double[] bg={(-455+161*Math.sqrt(70))/(450*Math.sqrt(70)),
				(455+161*Math.sqrt(70))/(450*Math.sqrt(70)),
				128.0/225.0,
				(455+161*Math.sqrt(70))/(450*Math.sqrt(70)),
				(-455+161*Math.sqrt(70))/(450*Math.sqrt(70))
		
		};
		for(double x=x1;x<x2;x=x+dx){
		
	       for(int j=0;j<xrg.length;j++){
	    	   
	    	   double xg=xrg[j]*(dx)*0.5+(2*x+dx)*0.5;
	    	   total+=bg[j]*f(xg,Unit.RADIANS);
	       }
		}
		
		return total*dx_2;
	}
	
	public void drawDerivative() {
		draw(Unit.RADIANS);
		int width = getGraphicWidth();
		int height = getGraphicHeight();
		getGraphics2D().setColor(derivativelinecolor);
		dx=(b-a)/n;//incremento d'intervallo
		
		if(recalculate)
			 dfun=calculateDerivativeFunction();
		
		//deltay=deltax=i*1.0/n;
		
			for(int k=0;k<n;k++)
			  {
			  
				double x=a+k*dx;
				double y=dfun[k];
				
				int cx=(int)(x/deltax)+x0;
				int cy=(int)(y/deltay)+y0;
			  	
				if(cy<height && cx<width && cx>=0 && cy>=0)
					getGraphics2D().drawOval(cx,height-cy,1,1);
			  } 
	}
	
	private double[] calculateDerivativeFunction() {
		double[] ret_fun = new double[n];
		
		
		for(int k=0;k<n;k++)
		{		  
			double x=a+k*dx;
			ret_fun[k]=df(x); 
		}
		return ret_fun;
	}

	public double[] getDfun() {
		return dfun;
	}

	public void setDfun(double[] dfun) {
		this.dfun = dfun;
	}

	public Color getDerivativelinecolor() {
		return derivativelinecolor;
	}

	public void setDerivativelinecolor(Color derivativelinecolor) {
		this.derivativelinecolor = derivativelinecolor;
	}
}
