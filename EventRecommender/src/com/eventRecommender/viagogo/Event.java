package com.eventRecommender.viagogo;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

//Event class 
//All events created will be objects of this
public class Event {
	static int count=0;
	int id;
	int xCoord;
	int yCoord;
	int numTickets;
	//List of tickets with different prices
	PriorityQueue<Float> tickets = new PriorityQueue<Float>();
	//Check for non duplicate coordinates- only for random seed generation testing
	static Set<Integer> xSet = new HashSet<Integer>();
	static Set<Integer> ySet = new HashSet<Integer>();
	
	
	public Event()
	{
		//Sets the unique ID
	    this.id=count++;	    
	}
	
	public void initializeSeeds(){
		//This is for random seed generation
		int max= 10,min=-10;
		Random rand = new Random();
		
		//Generates coordinates 
		//Checks if similar coordinates already exist
		boolean xyflag=true;
		while(xyflag){
			this.xCoord = rand.nextInt(max - min)  + min;
			this.yCoord = rand.nextInt(max - min)  + min;
			if (!(xSet.contains(this.xCoord) && ySet.contains(this.yCoord))){
				xyflag=false;
				xSet.add(this.xCoord);
				ySet.add(this.yCoord);
			}
		}
		

		
	    
	    //No of tickets is also random
	    this.numTickets = rand.nextInt(50) ;	
	    //Price for each ticket
	    for(int i=0;i<numTickets;i++){
	    	this.tickets.add(rand.nextFloat() * (500) + 1.0f);
	    	}    		
	}
	
	public void setCoords(int xCoord, int yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public int getNumTickets() {
		return numTickets;
	}

	public void setNumTickets(int numTickets) {
		this.numTickets = numTickets;
	}

	public String getCheapestTicket() {
		String price_ret = String.format("%.02f", this.tickets.peek());
		return price_ret ;
	}

	public float getDist(int x,int y){
		//get distance between this event and a location by Manhattan distance
		float result=0.0f;
		result=Math.abs(x-xCoord)+Math.abs(y-yCoord);				
		return result;		
	}
	
	
	

}
