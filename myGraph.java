package myPCG_Graph;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

import myPCG_Complex.myComplex;
import myPRJ_01.test;

public class myGraph extends JPanel {
	private static final long serialVersionUID = 1L;

	//R объявим список для хранения информации по всем точкам
	ArrayList<myPoint> points = new ArrayList<>();

    public myGraph() {}
    
    //R объявим класс для хранения информации по каждой точке
	public class myPoint {
		int x; int y; Color c; 
		public myPoint(int x_, int y_, Color c_) {
			x=x_; y=y_;	c=c_;
		}
	}
	
	public void setGraph(float amin_, float amax_, float bmin_, float bmax_) {
	    float da=(amax_-amin_)/(test.sizeGraphX-1);
	    float db=(bmax_-bmin_)/(test.sizeGraphY-1);
	    myComplex z = new myComplex();
	    myComplex c = new myComplex();

	    for( int h=0; h<test.sizeGraphX; h++)
	    	for( int w=0; w<test.sizeGraphY; w++) {
	    	    z.set(0.0f,  0.0f);
	    	    c.set(amin_+da*h, bmin_+db*w);
	    	    int k = 0;
	    	    //float re1, im1;
	    	    double norm;
	    	    do {
	    	    	/*
	    	    	re1 = z.re()*z.re() - z.im()*z.im() + c.re();
	    	        im1 = 2.0f*z.re()*z.im() + c.im();
	    	        norm = Math.sqrt( re1*re1 + im1*im1 );
	    	        z.set(re1, im1);
	    	        */
	    	        z.sqr(z, c);
	    	        norm = z.norm();
	    	        k++;
	    	   } while ( k<test.maxStep && norm<test.maxNorm );

		    	if( k<25)		
		    		points.add(new myPoint(h, w, new Color(Math.round(255-10*k),Math.round(255-10*k),Math.round(255-10*k))));
		    	else if(k<26)		
		    		points.add(new myPoint(h, w, new Color(255,255,255)));
		    	else if(k<27)		
		    		points.add(new myPoint(h, w, new Color(5,5,5)));
		    	else if(k<28)		
		    		points.add(new myPoint(h, w, new Color(190,5,5)));
		    	else if( k<29)		
		    		points.add(new myPoint(h, w, new Color(255,255,0)));
		    	else if( k<30)		
		    		points.add(new myPoint(h, w, new Color(0,0,0)));
		    	else if( k<32)		
		    		points.add(new myPoint(h, w, new Color(0,100,100)));
		    	else if( k<34)		
		    		points.add(new myPoint(h, w, new Color(0,0,0)));
		    	else if( k<36)		
		    		points.add(new myPoint(h, w, new Color(255,0,0)));
		    	else if( k<38)		
		    		points.add(new myPoint(h, w, new Color(50,0,0)));
		    	else if( k<39)		
		    		points.add(new myPoint(h, w, new Color(0,0,50)));
		    	else if( k<120)		
		    		points.add(new myPoint(h, w, new Color(0,0,0)));
		    	else if( k<140)		
		    		points.add(new myPoint(h, w, new Color(255,0,0)));
		    	else if( k<150)		
		    		points.add(new myPoint(h, w, new Color(255,255,k)));
		    	else if( k<test.maxStep)		
		    		points.add(new myPoint(h, w, new Color(0,255,Math.round(255/(test.maxStep/k)))));
		    	else 
		    		points.add(new myPoint(h, w, new Color(0,0,0)));
	    	}
	}
   
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        for(myPoint point : points) {
        	g.setColor(point.c);
        	g.drawOval(point.x, point.y, 1, 1);
        }
      }
}

