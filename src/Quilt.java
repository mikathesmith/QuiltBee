//Package quilting; 

import java.util.*;
import java.io.*; 
import java.awt.*;
import java.util.Random;

public class Quilt{
	private int x, y, width, height;
	private Color colour;
	 private int moveX=1;
	  private int moveY=1;
	  
	  public int randomRange(int low, int high){
		    Random generator = new Random();
		    return generator.nextInt(high-low+1) + low;
		  }
	
	public Quilt(){
		 width= randomRange(10,30);
		 height=width;
		 x=randomRange(0,400-width);
		 y=randomRange(0,400-height);
		    
		 colour= new Color(randomRange(0,255),randomRange(0,255),randomRange(0,255));   
	  }
	
	
	public void display(Graphics g){
	    g.setColor(colour);
	    g.fillOval(x,y,width,height);   
	  }
	
	public void move(){
	    colour= new Color(randomRange(0,255),randomRange(0,255),randomRange(0,255));
	    y+=moveY;
	    x+=moveX;
	    if(x>400-width||x<0){
	      moveX=-moveX;
	    }
	    if(y>400-height||y<0){
	      moveY=-moveY;
	    }
	    
	    if(width>15){
	      moveX=0;
	    }
	    
	    
	    
	  }
}