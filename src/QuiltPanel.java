//Package quilting; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
//import java.util.*; 

public class QuiltPanel extends JPanel{
	Quilt[] shapes= new Quilt[20];
	private int count;
	
	
	  private JButton addShape, start, stop; 
	  private JTextField showNum;
	  private JLabel countLabel;
	  Timer timer;
	  private final int DELAY=10;
	
	JPanel controlPanel = new JPanel(); 
	DrawingPanel drawPanel = new DrawingPanel();
	
	
	public static void main(String[]args){ 
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			//String layer = sc.nextLine(); 
			double scale = sc.nextDouble();
			Color colour = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt());
			//use listener code to create squares  
		}
		
		
	    JFrame quiltFrame = new JFrame();
	    quiltFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    quiltFrame.getContentPane().add(new QuiltPanel());
	    quiltFrame.pack();
	    quiltFrame.setVisible(true);
	    quiltFrame.setTitle("Quilt Panel");  
	 }
	
	public QuiltPanel(){
	 
	    addShape= new JButton("Add Shape");
	    start = new JButton("Start");
	    stop = new JButton("Stop");
	    showNum= new JTextField("0  ");
	    countLabel= new JLabel("Count: ");

	    
	    ButtonListener listener= new ButtonListener();
	    addShape.addActionListener(listener);
	    start.addActionListener(listener);
	    stop.addActionListener(listener);
	    timer= new Timer(DELAY, listener);
	    
	    add(controlPanel);
	    add(drawPanel);
	    controlPanel.setPreferredSize(new Dimension(100,400));
	    controlPanel.add(addShape);
	    controlPanel.add(start);
	    controlPanel.add(stop);
	    controlPanel.add(countLabel);
	    controlPanel.add(showNum); 
	  }
	
	private class ButtonListener implements ActionListener{   
	    public void actionPerformed(ActionEvent event){
	      Object source = event.getSource();
	      if(source==addShape){
	        if(count<shapes.length){
	          shapes[count]=new Quilt();
	          count++;   
	        }
	        showNum.setText(Integer.toString(count));
	      }      
	      repaint();
	    }   
	  }
	
	
	
	private class DrawingPanel extends JPanel{
	     /**Draws the frame in which the circles are drawn*/
	    public DrawingPanel(){ 
	      setPreferredSize(new Dimension(400,400));
	     // setBackground(Color.pin);      
	    }
	    
	    /**Calls the display method on each of the items in the array*/
	    public void paintComponent(Graphics g){
	      super.paintComponent(g); 
	      for(int i=0;i<count;i++){
	        shapes[i].display(g);
	      }
	    }
	}
	
	
	
	  
	
}